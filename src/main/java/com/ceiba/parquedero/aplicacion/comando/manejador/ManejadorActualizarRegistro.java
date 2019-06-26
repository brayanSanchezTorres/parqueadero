package com.ceiba.parquedero.aplicacion.comando.manejador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ceiba.parquedero.aplicacion.comando.ComandoRegistro;
import com.ceiba.parquedero.aplicacion.consulta.manejador.ManejadorListarRegistros;
import com.ceiba.parquedero.aplicacion.respuestadto.Respuesta;
import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcion;
import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcionTipos;
import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.modelo.Vehiculo;
import com.ceiba.parquedero.dominio.servicio.ServicioActualizarRegistro;

@Component
public class ManejadorActualizarRegistro {

	private final ServicioActualizarRegistro servicioActualizarRegistro;
	
	private static final Logger LOGACTUALIZAR = LoggerFactory.getLogger(ManejadorListarRegistros.class);
	
	public ManejadorActualizarRegistro(ServicioActualizarRegistro servicioActualizarRegistro) {
		this.servicioActualizarRegistro = servicioActualizarRegistro;
	}

	public Respuesta<Registro> ejecutar(ComandoRegistro comandoRegistro) {
		Respuesta<Registro> respuesta = new Respuesta<>();
		
		try {
			Registro registro = this.servicioActualizarRegistro.ejecutar(new Registro(new Vehiculo(comandoRegistro.getVehiculo().getTipo(),
					comandoRegistro.getVehiculo().getPlaca(), comandoRegistro.getVehiculo().getCilindraje()),
					comandoRegistro.getFechaEntrada()));
			respuesta.setEstado(true);
			respuesta.setMensaje("Tarea Existosa");
			respuesta.setEntidad(registro);
		} catch (ParqueaderoExcepcion e) {
			LOGACTUALIZAR.error(e.getMessage(), e);
			respuesta.setEstado(false);
			respuesta.setMensaje(e.getMessage());
			respuesta.setTipo(e.getTipo());
		} catch (Exception e) {
			LOGACTUALIZAR.error(e.getMessage(), e);
			respuesta.setEstado(false);
			respuesta.setMensaje(e.getMessage());
			respuesta.setTipo(ParqueaderoExcepcionTipos.GENERICO);
		}
		
		return respuesta;
	}

}
