package com.ceiba.parquedero.dominio.servicio;

import com.ceiba.parquedero.dominio.excepcion.ExcepcionEspacio;
import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;
import com.ceiba.parquedero.dominio.servicio.ServicioParqueadero;

public class ServicioCrearRegistro {
	
	private RepositorioRegistro repositorioRegistro;
	private ServicioParqueadero servicioParqueadero;
	
	private static final String NO_HAY_ESPACIO_EN_EL_PARQUEADERO = "No hay espacio en el parqueadero";
	
	public ServicioCrearRegistro(RepositorioRegistro repositorioRegistro) {
		this.repositorioRegistro = repositorioRegistro;
	}
	
	public void ejecutar(Registro registro) {
		/*if(registro.getVehiculo().getTipo().equals("CARRO")) {
			validarPlazasDisponiblesMoto();
		}else {
			validarPlazasDisponiblesCarro();
		}*/
		this.repositorioRegistro.crear(registro);
	}
	
	public void validarPlazasDisponiblesMoto() {
		boolean espacio = servicioParqueadero.hayPlazasDisponiblesMoto();
		if(espacio) {
			throw new ExcepcionEspacio(NO_HAY_ESPACIO_EN_EL_PARQUEADERO);
		}
	}
	
	public void validarPlazasDisponiblesCarro() {
		boolean espacio = servicioParqueadero.hayPlazasDisponiblesMoto();
		if(espacio) {
			throw new ExcepcionEspacio(NO_HAY_ESPACIO_EN_EL_PARQUEADERO);
		}
	}

}
