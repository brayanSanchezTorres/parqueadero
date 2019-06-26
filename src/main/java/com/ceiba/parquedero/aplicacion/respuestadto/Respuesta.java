package com.ceiba.parquedero.aplicacion.respuestadto;

import java.util.Collection;

import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcionTipos;

public class Respuesta<T> {

	private T entidad;
	private Collection<T> listaEntidad;
	private String mensaje;
	private ParqueaderoExcepcionTipos tipo;
	private Boolean estado;

	public T getEntidad() {
		return entidad;
	}

	public void setEntidad(T entidad) {
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

	public Collection<T> getListaEntidad() {
		return listaEntidad;
	}

	public void setListaEntidad(Collection<T> listaEntidad) {
		this.listaEntidad = listaEntidad;
	}
	
}
