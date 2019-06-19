package com.ceiba.parquedero.dominio.excepcion;

public class ExcepcionEspacio extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ExcepcionEspacio(String message) {
        super(message);
    }
	
}
