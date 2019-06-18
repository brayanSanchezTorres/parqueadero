package com.ceiba.parquederoCeiba.dominio.repositorio;

import java.util.Collection;

import com.ceiba.parquederoCeiba.dominio.modelo.Registro;

public interface RepositorioRegistro {
	
	Collection<Registro> listar();
	
	void crear(Registro registro);
	
	void actualizar(Registro registro);
	
	boolean hayPlazasDisponibles(Registro registro);

}
