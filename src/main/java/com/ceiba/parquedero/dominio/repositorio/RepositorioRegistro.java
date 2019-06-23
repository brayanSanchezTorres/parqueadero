package com.ceiba.parquedero.dominio.repositorio;

import java.util.Collection;

import com.ceiba.parquedero.dominio.modelo.Registro;

public interface RepositorioRegistro {

	Collection<Registro> listar();

	void crear(Registro registro);

	Registro actualizar(Registro registro);

	boolean obtenerRegistroPorPlaca(String placa);

}
