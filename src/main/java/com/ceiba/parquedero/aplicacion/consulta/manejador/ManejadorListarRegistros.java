package com.ceiba.parquedero.aplicacion.consulta.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.parquedero.aplicacion.respuestadto.Respuesta;
import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcionTipos;
import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;

@Component
public class ManejadorListarRegistros {
	private final RepositorioRegistro repositorioRegistro;

	public ManejadorListarRegistros(RepositorioRegistro daoRegistro) {
		this.repositorioRegistro = daoRegistro;
	}

	public Respuesta<Registro> ejecutar() {
		Respuesta<Registro> respuesta = new Respuesta<>();
		try {
			respuesta.setListaEntidad(this.repositorioRegistro.listar());
			respuesta.setEstado(true);
		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setEstado(false);
			respuesta.setTipo(ParqueaderoExcepcionTipos.GENERICO);
		}
		return respuesta;
	}
	
	public String retornarString() {
		return "hola";
	}
}
