package com.ceiba.parquedero.aplicacion.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;

@Component
public class ManejadorListarRegistros {
	private final RepositorioRegistro repositorioRegistro;
	
	public ManejadorListarRegistros(RepositorioRegistro daoRegistro) {
		this.repositorioRegistro = daoRegistro;
	}
	
	public Collection<Registro> ejecutar(){
		return this.repositorioRegistro.listar();
	}
}
