package com.ceiba.parquedero.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.parquedero.aplicacion.comando.ComandoRegistro;
import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.modelo.Vehiculo;
import com.ceiba.parquedero.dominio.servicio.ServicioCrearRegistro;


@Component
public class ManejadorCrearRegistro {
	
	private final ServicioCrearRegistro servicioCrearRegistro;
	
	public ManejadorCrearRegistro(ServicioCrearRegistro servicioCrearRegistro) {
		this.servicioCrearRegistro = servicioCrearRegistro;
	}
	
	public void ejecutar(ComandoRegistro comandoRegistro) {
		this.servicioCrearRegistro.ejecutar(new Registro(new Vehiculo(comandoRegistro.getVehiculo().getTipo(),comandoRegistro.getVehiculo().getPlaca(),comandoRegistro.getVehiculo().getCilindraje()), comandoRegistro.getFechaEntrada(), comandoRegistro.getFechaSalida(), comandoRegistro.getCostoEstadia()));
	}
	
}
