package com.ceiba.parquederoCeiba.dominio.excepcion;

public class ExcepcionEspacio extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ExcepcionEspacio(String message) {
        super(message);
    }
	
}
