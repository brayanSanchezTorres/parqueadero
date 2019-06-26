package com.ceiba.parquedero.aplicacion.comando.manejador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ceiba.parquedero.aplicacion.comando.ComandoRegistro;
import com.ceiba.parquedero.aplicacion.respuestadto.Respuesta;
import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcion;
import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.modelo.Vehiculo;
import com.ceiba.parquedero.dominio.servicio.ServicioCrearRegistro;

@Component
public class ManejadorCrearRegistro {

	private final ServicioCrearRegistro servicioCrearRegistro;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorCrearRegistro.class);

	public ManejadorCrearRegistro(ServicioCrearRegistro servicioCrearRegistro) {
		this.servicioCrearRegistro = servicioCrearRegistro;
	}

	public Respuesta<ComandoRegistro> ejecutar(ComandoRegistro comandoRegistro) {
		Respuesta<ComandoRegistro> respuesta = new Respuesta<>();
		try {
			this.servicioCrearRegistro.ejecutar(new Registro(new Vehiculo(comandoRegistro.getVehiculo().getTipo(),
					comandoRegistro.getVehiculo().getPlaca(), comandoRegistro.getVehiculo().getCilindraje()),
					comandoRegistro.getFechaEntrada()));
			respuesta.setEntidad(comandoRegistro);
			respuesta.setEstado(true);
			respuesta.setMensaje("Tarea Existosa");
		} catch (ParqueaderoExcepcion e) {
			LOGGER.error(e.getMessage(), e);
			respuesta.setEstado(false);
			respuesta.setMensaje(e.getMessage());
			respuesta.setTipo(e.getTipo());
		} 
		return respuesta;
	}

}
