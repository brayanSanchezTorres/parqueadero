package com.ceiba.parquedero.aplicacion.comando;

import java.util.Calendar;

import com.ceiba.parquedero.aplicacion.comando.ComandoVehiculo;

public class ComandoRegistro {
	
	private ComandoVehiculo vehiculo;
	private Calendar fechaEntrada;
	private Calendar fechaSalida;
	private double costoEstadia;
	
	public ComandoRegistro() {
		super();
	}
	
	public ComandoRegistro(ComandoVehiculo vehiculo, Calendar fechaEntrada) {
		super();
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = null;
		this.costoEstadia = 0;
	}
	
	public ComandoRegistro(ComandoVehiculo vehiculo, Calendar fechaEntrada, Calendar fechaSalida, double costoEstadia) {
		super();
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.costoEstadia = costoEstadia;
	}
	
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
