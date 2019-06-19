package com.ceiba.parquedero.dominio.testdatabuilder;

import com.ceiba.parquedero.dominio.modelo.Parqueadero;

public class ParqueaderoTestDataBuilder {
	
	private int capacidadCarros;
	private int capacidadMotos;
	private int capacidadCarrosActual;
	private int capacidadMotosActula;
	
	public ParqueaderoTestDataBuilder() {
		this.capacidadCarros = 20;
		this.capacidadMotos = 10;
		this.capacidadCarrosActual = 0;
		this.capacidadMotosActula = 0;
	}
	
	public ParqueaderoTestDataBuilder conCapacidadCarrosActual(int capacidadCarrosActual) {
		this.capacidadCarrosActual = capacidadCarrosActual;
		return this;
	}
	
	public ParqueaderoTestDataBuilder conCapacidadMotosActual(int capacidadMotosActual) {
		this.capacidadCarrosActual = capacidadMotosActual;
		return this;
	}
	
	public Parqueadero build() {
		return new Parqueadero(capacidadCarros, capacidadMotos, capacidadCarrosActual, capacidadMotosActula);
	}
	
}
