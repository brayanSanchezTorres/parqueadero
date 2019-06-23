package com.ceiba.parquedero.aplicacion.respuestadto;

import java.util.Collection;

import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcionTipos;

public class Respuesta<Entidad> {

	private Entidad entidad;
	private Collection<Entidad> listaEntidad;
	private String mensaje;
	private ParqueaderoExcepcionTipos tipo;
	private Boolean estado;

	public Respuesta() {
		super();
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
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

	public Collection<Entidad> getListaEntidad() {
		return listaEntidad;
	}

	public void setListaEntidad(Collection<Entidad> listaEntidad) {
		this.listaEntidad = listaEntidad;
	}

	@Override
	public String toString() {
		return "Respuesta [entidad=" + entidad + ", listaEntidad=" + listaEntidad + ", mensaje=" + mensaje + ", tipo="
				+ tipo + ", estado=" + estado + "]";
	}

	
}
