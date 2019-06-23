package com.ceiba.parquedero.dominio.excepcion;

public class ParqueaderoExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	private ParqueaderoExcepcionTipos tipo;

	public ParqueaderoExcepcion(ParqueaderoExcepcionTipos tipo) {
		super();
		this.tipo = tipo;
	}

	public ParqueaderoExcepcion(ParqueaderoExcepcionTipos tipo, String mensaje) {
		super(mensaje);
		this.tipo = tipo;
	}

	public ParqueaderoExcepcion(ParqueaderoExcepcionTipos tipo, String mensaje, Throwable cause) {
		super(mensaje, cause);
		this.tipo = tipo;
	}

	public ParqueaderoExcepcionTipos getTipo() {
		return tipo;
	}

}
