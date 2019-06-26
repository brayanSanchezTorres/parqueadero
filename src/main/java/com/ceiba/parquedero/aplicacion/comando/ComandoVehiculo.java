package com.ceiba.parquedero.aplicacion.comando;

public class ComandoVehiculo {
	
	private String tipo;
	private String placa;
	private int cilindraje;
	
	public ComandoVehiculo() {
		super();
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	
}
