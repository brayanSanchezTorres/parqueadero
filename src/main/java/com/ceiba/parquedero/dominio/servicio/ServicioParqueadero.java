package com.ceiba.parquedero.dominio.servicio;

import java.util.Calendar;

import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.modelo.Vehiculo;
import com.ceiba.parquedero.dominio.repositorio.RepositorioParquedero;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;

public class ServicioParqueadero {

	private RepositorioParquedero repositorioParquedero;
	private RepositorioRegistro repositorioRegistro;
	private static String carro = "CARRO";
	private static String moto = "MOTO";

	public ServicioParqueadero(RepositorioRegistro repositorioRegistro, RepositorioParquedero repositorioParquedero) {
		this.repositorioParquedero = repositorioParquedero;
		this.repositorioRegistro = repositorioRegistro;
	}

	public boolean hayPlazasDisponible(String tipo) {
		boolean respuesta = false;
		if (tipo.equals(carro)) {
			respuesta = repositorioParquedero.obtenerPlazaActualCarro() > repositorioParquedero.obtenerPlazaCarro();
		} else if (tipo.equals(moto)) {
			respuesta = repositorioParquedero.obtenerPlazaActualMoto() > repositorioParquedero.obtenerPlazaMoto();
		}
		return respuesta;
	}

	public void aumentarPlazas(String tipo) {
		if (tipo.equals(carro)) {
			repositorioParquedero.aumentarPlazaCarro();
		} else if (tipo.equals(moto)) {
			repositorioParquedero.aumentarPlazasMoto();
		}
	}

	public void disminuirPlazas(String tipo) {
		if (tipo.equals(carro)) {
			repositorioParquedero.disminuirPlazasCarro();
		} else if (tipo.equals(moto)) {
			repositorioParquedero.disminuirPlazasMoto();
		}
	}

	public boolean existeEnParqueadero(String placa) {
		return repositorioRegistro.obtenerRegistroPorPlaca(placa);
	}

	public int costoExtraMoto(Vehiculo vehiculo) {
		return vehiculo.getCilindraje() > 500 ? 2000 : 0;
	}

	public boolean accesoPorPlacas(Vehiculo vehiculo, Calendar diaActual) {
		boolean placaIniciaConA = vehiculo.getPlaca().substring(0).startsWith("A");
		if (placaIniciaConA) {
			return diaActual.get(Calendar.DAY_OF_WEEK) < 3 ? false : true;
		} else {
			return true;
		}
	}

	public int costoPorEstadia(Registro registro, Calendar fechaActual) {
		int costo = 0;
		if (registro.getVehiculo().getTipo().equals(carro)) {
			costo += calcularCostoDiasHora(8000, 1000, registro.getFechaEntrada(), fechaActual);
		} else if(registro.getVehiculo().getTipo().equals(moto)) {
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
		diferenciasHoras = diferenciasHoras * 24;
		dias = Math.abs((int) diferenciasHoras / 24);
		horas = Math.abs((int) diferenciasHoras % 24);
		int costoHoras = horas >= 9 ? valorDias : valorHoras * horas;
		return dias == 0 && horas == 0 ? valorHoras : (valorDias * dias) + (costoHoras);
	}

}
