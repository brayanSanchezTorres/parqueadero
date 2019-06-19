package com.ceiba.parquedero.dominio.servicio;

import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;

public class ServicioActualizarRegistro {
	
	private RepositorioRegistro repositorioPelicula;
	
	public void ejecutar(Registro registro) {
		this.repositorioPelicula.actualizar(registro);
	}
}
