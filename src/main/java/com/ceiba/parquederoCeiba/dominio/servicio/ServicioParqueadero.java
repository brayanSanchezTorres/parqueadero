package com.ceiba.parquederoCeiba.dominio.servicio;

import java.util.Calendar;

import com.ceiba.parquederoCeiba.dominio.modelo.Registro;
import com.ceiba.parquederoCeiba.dominio.modelo.Vehiculo;
import com.ceiba.parquederoCeiba.dominio.repositorio.RepositorioParquedero;

public class ServicioParqueadero {
	
	private RepositorioParquedero repositorioParquedero;
	
	public boolean hayPlazasDisponiblesMoto() {
		return repositorioParquedero.obtenerPlazaActualMoto() > repositorioParquedero.parqueadero().getCapacidadMotos(); 
	}
	
	public boolean hayPlazasDisponiblesCarro() {
		return repositorioParquedero.obtenerPlazaActualCarro() > repositorioParquedero.parqueadero().getCapacidadCarros();
	}
	
	public int costoExtraMoto(Vehiculo vehiculo) {
		return vehiculo.getCilindraje() > 500 ? 2000 : 0;
	}
	
	public boolean accesoPorPlacas(Vehiculo vehiculo, Calendar diaActual) {
		boolean placaIniciaConA = vehiculo.getPlaca().substring(0).startsWith("A");
		if(placaIniciaConA) {
			return diaActual.get(Calendar.DAY_OF_WEEK) < 3 ? false : true ;
		}else {
			return true;
		}
	}
	
	public int costoPorEstadia(Registro registro, Calendar fechaActual) {
		int costo = 0;
		if(registro.getVehiculo().getTipo().equals("CARRO")) {
			costo += calcularCostoDiasHora(8000, 1000, registro.getFechaEntrada(), fechaActual);
		}else {
			costo += calcularCostoDiasHora(4000, 500, registro.getFechaEntrada(), fechaActual);
			costo += costoExtraMoto(registro.getVehiculo());
		}
		return costo;
	}
	
	public int calcularCostoDiasHora(int valorDias, int valorHoras, Calendar fechaInicial, Calendar fechaActual) {
		long mili = 86400000;
		int horas;
		int dias;
		double diferenciasHoras = (double) fechaActual.getTimeInMillis() - fechaInicial.getTimeInMillis();
		diferenciasHoras = diferenciasHoras / mili;
		diferenciasHoras = diferenciasHoras*24;
		dias = (int) diferenciasHoras/24;
		horas = (int) diferenciasHoras%24;
		return dias==0 && horas==0 ? valorHoras : Math.abs(((valorDias*dias) + (valorHoras*horas)));
	}
	
}
