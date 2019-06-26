package com.ceiba.parquedero.aplicacion.respuestadto;

import java.util.Collection;

import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcionTipos;

public class Respuesta<ENTIDAD> {

	private ENTIDAD entidad;
	private Collection<ENTIDAD> listaEntidad;
	private String mensaje;
	private ParqueaderoExcepcionTipos tipo;
	private Boolean estado;

	public Respuesta() {
		super();
	}

	public ENTIDAD getEntidad() {
		return entidad;
	}

	public void setEntidad(ENTIDAD entidad) {
		this.entidad = entidad;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ParqueaderoExcepcionTipos getTipo() {
		return tipo;
	}

	public void setTipo(ParqueaderoExcepcionTipos tipo) {
		this.tipo = tipo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Collection<ENTIDAD> getListaEntidad() {
		return listaEntidad;
	}

	public void setListaEntidad(Collection<ENTIDAD> listaEntidad) {
		this.listaEntidad = listaEntidad;
	}
	
}
