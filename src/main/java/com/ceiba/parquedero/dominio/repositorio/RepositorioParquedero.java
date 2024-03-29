package com.ceiba.parquedero.dominio.repositorio;

import com.ceiba.parquedero.dominio.modelo.Parqueadero;

public interface RepositorioParquedero {
	
	Parqueadero parqueadero();
	
	int obtenerPlazaActualMoto();
	
	int obtenerPlazaActualCarro();
	
	int obtenerPlazaCarro();
	
	int obtenerPlazaMoto();
	
	void aumentarPlazasMoto();
	
	void aumentarPlazaCarro();
	
	void disminuirPlazasMoto();
	
	void disminuirPlazasCarro();
	
}
