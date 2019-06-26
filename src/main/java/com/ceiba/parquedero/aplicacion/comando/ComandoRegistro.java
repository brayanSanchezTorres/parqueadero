package com.ceiba.parquedero.aplicacion.comando;

import java.util.Calendar;

public class ComandoRegistro {
	
	private ComandoVehiculo vehiculo;
	private Calendar fechaEntrada;
	private Calendar fechaSalida;
	private double costoEstadia;
	
	public ComandoVehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(ComandoVehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Calendar getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Calendar fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public Calendar getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public double getCostoEstadia() {
		return costoEstadia;
	}
	public void setCostoEstadia(double costoEstadia) {
		this.costoEstadia = costoEstadia;
	}

}
