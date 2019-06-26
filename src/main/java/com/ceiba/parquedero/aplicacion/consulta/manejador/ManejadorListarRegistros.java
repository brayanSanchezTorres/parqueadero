package com.ceiba.parquedero.aplicacion.consulta.manejador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ceiba.parquedero.aplicacion.respuestadto.Respuesta;
import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcionTipos;
import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;

@Component
public class ManejadorListarRegistros {
	private final RepositorioRegistro repositorioRegistro;
	
	private static final Logger LOGLISTAR = LoggerFactory.getLogger(ManejadorListarRegistros.class);

	public ManejadorListarRegistros(RepositorioRegistro daoRegistro) {
		this.repositorioRegistro = daoRegistro;
	}

	public Respuesta<Registro> ejecutar() {
		Respuesta<Registro> respuesta = new Respuesta<>();
		try {
			respuesta.setListaEntidad(this.repositorioRegistro.listar());
			respuesta.setEstado(true);
		} catch (Exception e) {
			LOGLISTAR.error(e.getMessage(), e);
			respuesta.setMensaje(e.getMessage());
			respuesta.setEstado(false);
			respuesta.setTipo(ParqueaderoExcepcionTipos.GENERICO);
		}
		return respuesta;
	}
}
