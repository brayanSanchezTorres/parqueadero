package com.ceiba.parquedero.dominio.excepcion;

public class ExcepcionExistencia extends RuntimeException{

	private static final long serialVersionUID = 1l;
	
	public ExcepcionExistencia(String message) {
		super(message);
	}
}
