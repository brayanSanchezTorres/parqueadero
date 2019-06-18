package com.ceiba.parquederoCeiba.dominio.repositorio;

import com.ceiba.parquederoCeiba.dominio.modelo.Parqueadero;

public interface RepositorioParquedero {
	
	Parqueadero parqueadero();
	
	int obtenerPlazaActualMoto();
	
	int obtenerPlazaActualCarro();
	
	void aumentarPlazasMoto();
	
	void aumentarPlazaCarro();
	
	void disminuirPlazasMoto();
	
	void disminuirPlazasCarro();
	
}
