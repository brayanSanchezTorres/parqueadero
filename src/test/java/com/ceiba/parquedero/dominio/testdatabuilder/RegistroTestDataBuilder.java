package com.ceiba.parquedero.dominio.testdatabuilder;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.modelo.Vehiculo;

public class RegistroTestDataBuilder {
	
	private Vehiculo vehiculo;
	private Calendar fechaEntrada;
	private Calendar fechaSalida;
	private double costoEstadia;
	
	public RegistroTestDataBuilder() {
		super();
		this.vehiculo = new Vehiculo("CARRO", "A50", 500);
		this.fechaEntrada = new GregorianCalendar(2019, 6, 24, 20, 00);
		this.fechaSalida = null;
		this.costoEstadia = 0;
	}
	
	public RegistroTestDataBuilder conVehiculo(Vehiculo vehiculo){
		this.vehiculo = vehiculo;
		return this;
	}
	
	public RegistroTestDataBuilder conFechaEntrada(Calendar fechaEntrada){
		this.fechaEntrada = fechaEntrada;
		return this;
	}
	
	public RegistroTestDataBuilder conFechaSalida(Calendar fechaSalida){
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public RegistroTestDataBuilder conCosto(double costoEstadia){
		this.costoEstadia = costoEstadia;
		return this;
	}
	
	public Registro build() {
		return new Registro(vehiculo,fechaEntrada,fechaSalida,costoEstadia);
	}
	
}
