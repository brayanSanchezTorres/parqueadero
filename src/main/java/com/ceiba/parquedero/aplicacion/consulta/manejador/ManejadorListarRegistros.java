package com.ceiba.parquedero.aplicacion.consulta.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.parquedero.aplicacion.respuestadto.Respuesta;
import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcion;
import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcionTipos;
import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;

@Component
public class ManejadorListarRegistros {
	private final RepositorioRegistro repositorioRegistro;

	public ManejadorListarRegistros(RepositorioRegistro daoRegistro) {
		this.repositorioRegistro = daoRegistro;
	}

	public Respuesta<Registro> ejecutar() throws ParqueaderoExcepcion {
		Respuesta<Registro> respuesta = new Respuesta<>();
		try {
			respuesta.setListaEntidad(this.repositorioRegistro.listar());
			respuesta.setEstado(true);
		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setEstado(false);
			respuesta.setTipo(ParqueaderoExcepcionTipos.GENERICO);
			throw new ParqueaderoExcepcion(ParqueaderoExcepcionTipos.GENERICO, "ERROR NO PREVISTO"); 
		}
		return respuesta;
	}
}
