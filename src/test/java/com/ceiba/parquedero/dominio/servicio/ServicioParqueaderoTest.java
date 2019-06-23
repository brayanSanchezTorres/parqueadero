package com.ceiba.parquedero.dominio.servicio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.parquedero.dominio.testdatabuilder.RegistroTestDataBuilder;
import com.ceiba.parquedero.dominio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.modelo.Vehiculo;
import com.ceiba.parquedero.dominio.repositorio.RepositorioParquedero;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;
import com.ceiba.parquedero.dominio.servicio.ServicioParqueadero;

public class ServicioParqueaderoTest {

	@Test
	public void validarConCostoExtraMoto() {
		// Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(2000).buil();
		RepositorioParquedero repositorioParquedero = Mockito.mock(RepositorioParquedero.class);
		RepositorioRegistro repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
		ServicioParqueadero servicioParqueadero = new ServicioParqueadero(repositorioRegistro, repositorioParquedero);
		// Act
		int costo = servicioParqueadero.costoExtraMoto(vehiculo);
		// Assert
		assertTrue(costo == 2000);
	}

	@Test
	public void validarSinCostoExtraMoto() {
		// Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(200).buil();
		RepositorioParquedero repositorioParquedero = Mockito.mock(RepositorioParquedero.class);
		RepositorioRegistro repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
		ServicioParqueadero servicioParqueadero = new ServicioParqueadero(repositorioRegistro, repositorioParquedero);
		// Act
		int costo = servicioParqueadero.costoExtraMoto(vehiculo);
		// Assert
		assertTrue(costo == 0);
	}

	@Test
	public void validarConAccesoPorPlacas() {
		// Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(200).buil();
		RepositorioParquedero repositorioParquedero = Mockito.mock(RepositorioParquedero.class);
		RepositorioRegistro repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
		ServicioParqueadero servicioParqueadero = new ServicioParqueadero(repositorioRegistro, repositorioParquedero);
		Calendar diaActual = new GregorianCalendar(2019, 5, 25, 20, 00);
		// Act
		boolean acceso = servicioParqueadero.accesoPorPlacas(vehiculo, diaActual);
		// Assert
		assertTrue(acceso);
	}

	@Test
	public void validarSinAccesoPorPlacas() {
		// Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(200).buil();
		RepositorioParquedero repositorioParquedero = Mockito.mock(RepositorioParquedero.class);
		RepositorioRegistro repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
		ServicioParqueadero servicioParqueadero = new ServicioParqueadero(repositorioRegistro, repositorioParquedero);
		Calendar diaActual = new GregorianCalendar(2019, 5, 24, 20, 00);
		// Act
		boolean acceso = servicioParqueadero.accesoPorPlacas(vehiculo, diaActual);
		// Assert
		assertFalse(acceso);
	}

	@Test
	public void validarCostoPorEstadiaCarro() {
		// Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("CARRO").buil();
		Calendar fechaActual = new GregorianCalendar(2019, 5, 24, 12, 00);
		Calendar fechaInicial = new GregorianCalendar(2019, 5, 24, 22, 00);
		Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).conFechaEntrada(fechaInicial).build();
		RepositorioParquedero repositorioParquedero = Mockito.mock(RepositorioParquedero.class);
		RepositorioRegistro repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
		ServicioParqueadero servicioParqueadero = new ServicioParqueadero(repositorioRegistro, repositorioParquedero);
		// Act
		int costo = servicioParqueadero.costoPorEstadia(registro, fechaActual);
		// Assert
		assertTrue(costo == 8000);
	}

	@Test
	public void validarCostoPorEstadiaMoto() {
		// Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conCilindraje(200).buil();
		Calendar fechaActual = new GregorianCalendar(2019, 5, 24, 12, 00);
		Calendar fechaInicial = new GregorianCalendar(2019, 5, 24, 22, 00);
		Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).conFechaEntrada(fechaInicial).build();
		RepositorioParquedero repositorioParquedero = Mockito.mock(RepositorioParquedero.class);
		RepositorioRegistro repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
		ServicioParqueadero servicioParqueadero = new ServicioParqueadero(repositorioRegistro, repositorioParquedero);
		// Act
		int costo = servicioParqueadero.costoPorEstadia(registro, fechaActual);
		// Assert
		assertTrue(costo == 4000);
	}

	@Test
	public void validarCostoPorEstadiaMotoConExtra() {
		// Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conCilindraje(600).buil();
		Calendar fechaActual = new GregorianCalendar(2019, 5, 24, 12, 00);
		Calendar fechaInicial = new GregorianCalendar(2019, 5, 24, 22, 00);
		Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).conFechaEntrada(fechaInicial).build();
		RepositorioParquedero repositorioParquedero = Mockito.mock(RepositorioParquedero.class);
		RepositorioRegistro repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
		ServicioParqueadero servicioParqueadero = new ServicioParqueadero(repositorioRegistro, repositorioParquedero);
		// Act
		int costo = servicioParqueadero.costoPorEstadia(registro, fechaActual);
		// Assert
		assertTrue(costo == 6000);
	}
}
