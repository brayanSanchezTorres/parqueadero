package com.ceiba.parquedero.aplicacion.respuestadto;

import java.util.Collection;

import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcionTipos;

public class Respuesta<entidad> {

	private entidad entidad;
	private Collection<entidad> listaEntidad;
	private String mensaje;
	private ParqueaderoExcepcionTipos tipo;
	private Boolean estado;

	public Respuesta() {
		super();
	}

	public entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(entidad entidad) {
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

	public Collection<entidad> getListaEntidad() {
		return listaEntidad;
	}

	public void setListaEntidad(Collection<entidad> listaEntidad) {
		this.listaEntidad = listaEntidad;
	}
	
}
