package com.ceiba.parquederoCeiba.dominio.servicio;

import com.ceiba.parquederoCeiba.dominio.modelo.Registro;
import com.ceiba.parquederoCeiba.dominio.repositorio.RepositorioRegistro;

public class ServicioActualizarRegistro {
	
	private RepositorioRegistro repositorioPelicula;
	
	public void ejecutar(Registro registro) {
		this.repositorioPelicula.actualizar(registro);
	}
}
