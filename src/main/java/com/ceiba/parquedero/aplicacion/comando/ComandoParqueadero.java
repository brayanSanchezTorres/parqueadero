package com.ceiba.parquedero.aplicacion.comando;

public class ComandoParqueadero {
	
	private int capacidadCarros;
	private int capacidadMotos;
	private int capacidadCarrosActual;
	private int capacidadMotosActual;
	
	public ComandoParqueadero() {
		super();
	}
	
	public ComandoParqueadero(int capacidadCarros, int capacidadMotos, int capacidadCarrosActual,
			int capacidadMotosActual) {
		super();
		this.capacidadCarros = capacidadCarros;
		this.capacidadMotos = capacidadMotos;
		this.capacidadCarrosActual = capacidadCarrosActual;
		this.capacidadMotosActual = capacidadMotosActual;
	}

	public int getCapacidadCarros() {
		return capacidadCarros;
	}
	
	public void setCapacidadCarros(int capacidadCarros) {
		this.capacidadCarros = capacidadCarros;
	}
	
	public int getCapacidadMotos() {
		return capacidadMotos;
	}
	
	public void setCapacidadMotos(int capacidadMotos) {
		this.capacidadMotos = capacidadMotos;
	}
	public int getCapacidadCarrosActual() {
		return capacidadCarrosActual;
	}
	public void setCapacidadCarrosActual(int capacidadCarrosActual) {
		this.capacidadCarrosActual = capacidadCarrosActual;
	}
	public int getCapacidadMotosActual() {
		return capacidadMotosActual;
	}
	public void setCapacidadMotosActual(int capacidadMotosActual) {
		this.capacidadMotosActual = capacidadMotosActual;
	}
	
}
