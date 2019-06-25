package com.ceiba.parquedero.dominio.servicio;

import java.util.Calendar;

import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcion;
import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcionTipos;
import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.modelo.Vehiculo;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;

public class ServicioCrearRegistro {
	
	private RepositorioRegistro repositorioRegistro;
	private ServicioParqueadero servicioParqueadero;
	
	private static final String NO_HAY_ESPACIO_EN_EL_PARQUEADERO = "No hay espacio en el parqueadero";
	private static final String YA_EXISTE_EN_PARQUEADERO = "Este Vehiculo ya se encuentra en el parqueadero";
	private static final String ACCESO_NEGADO_POR_PLACAS = "Las placas que comienzan con A no pueden ingresar los lunes y domingos";
	
	public ServicioCrearRegistro(RepositorioRegistro repositorioRegistro, ServicioParqueadero servicioParqueadero) {
		this.repositorioRegistro = repositorioRegistro;
		this.servicioParqueadero = servicioParqueadero;
	}
	
	public void ejecutar(Registro registro) throws ParqueaderoExcepcion {
		this.validarAccesoPorPlacas(registro.getVehiculo(), registro.getFechaEntrada());
		this.validarPlazasdisponibles(registro.getVehiculo().getTipo());
		this.validarExistenciaPlacaSinSalida(registro.getVehiculo().getPlaca());
		this.repositorioRegistro.crear(registro);
		servicioParqueadero.aumentarPlazas(registro.getVehiculo().getTipo());
	}
	
	public void validarPlazasdisponibles(String tipo) throws ParqueaderoExcepcion {
		boolean noHayEspacio = servicioParqueadero.hayPlazasDisponible(tipo);
		if(noHayEspacio) {
			throw new ParqueaderoExcepcion(ParqueaderoExcepcionTipos.ESPACIOS_PLAZAS, NO_HAY_ESPACIO_EN_EL_PARQUEADERO);
		}
	}
	
	public void validarExistenciaPlacaSinSalida(String placa) throws ParqueaderoExcepcion {
		boolean estaEnParqueadero = servicioParqueadero.existeEnParqueadero(placa);
		if(estaEnParqueadero) {
			throw new ParqueaderoExcepcion(ParqueaderoExcepcionTipos.EXISTENCIA_PARQUEADERO, YA_EXISTE_EN_PARQUEADERO);
		}
	}
	
	public void validarAccesoPorPlacas(Vehiculo vehiculo, Calendar fechaEntrada) throws ParqueaderoExcepcion {
		boolean entradaParqueadero = this.servicioParqueadero.accesoPorPlacas(vehiculo, fechaEntrada);
		if(!entradaParqueadero) {
			throw new ParqueaderoExcepcion(ParqueaderoExcepcionTipos.ACCESO_PLACAS, ACCESO_NEGADO_POR_PLACAS);
		}
	}

}
