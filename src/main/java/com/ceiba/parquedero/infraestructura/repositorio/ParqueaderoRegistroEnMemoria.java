package com.ceiba.parquedero.infraestructura.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.parquedero.dominio.modelo.Parqueadero;
import com.ceiba.parquedero.dominio.repositorio.RepositorioParquedero;

@Repository
public class ParqueaderoRegistroEnMemoria implements RepositorioParquedero {
	
	private static Parqueadero parqueadero;
	
	static {
		parqueadero = new Parqueadero(20, 10, 20, 0);
	}
	
	@Override
	public Parqueadero parqueadero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int obtenerPlazaActualMoto() {
		return parqueadero.getCapacidadMotosActual();
	}

	@Override
	public int obtenerPlazaActualCarro() {
		return parqueadero.getCapacidadCarrosActual();
	}

	@Override
	public void aumentarPlazasMoto() {
		parqueadero.setCapacidadMotosActula(parqueadero.getCapacidadMotosActual()+1);
	}

	@Override
	public void aumentarPlazaCarro() {
		parqueadero.setCapacidadCarrosActual(parqueadero.getCapacidadCarrosActual()+1);
	}

	@Override
	public void disminuirPlazasMoto() {
		parqueadero.setCapacidadMotosActula(parqueadero.getCapacidadMotosActual()-1);
		
	}

	@Override
	public void disminuirPlazasCarro() {
		parqueadero.setCapacidadCarrosActual(parqueadero.getCapacidadCarrosActual()-1);
	}

}
