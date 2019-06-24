package com.ceiba.parquedero.dominio.servicio;

import static org.mockito.Mockito.when;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ceiba.parquedero.dominio.testdatabuilder.RegistroTestDataBuilder;
import com.ceiba.parquedero.dominio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.modelo.Vehiculo;
import com.ceiba.parquedero.dominio.repositorio.RepositorioParquedero;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;
import com.ceiba.parquedero.dominio.servicio.ServicioParqueadero;

@RunWith(MockitoJUnitRunner.class)
public class ServicioParqueaderoTest {
	
	@InjectMocks
	private ServicioParqueadero servicioParqueadero;
	
	@Mock
	private RepositorioRegistro repositorioRegistro;
	
	@Mock
	private RepositorioParquedero repositorioParquedero;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void validarEspacioDisponibleCarro() {
		when(repositorioParquedero.obtenerPlazaActualCarro()).thenReturn(1);
		when(repositorioParquedero.obtenerPlazaCarro()).thenReturn(20);
		
		boolean hayEspacioCarro = this.servicioParqueadero.hayPlazasDisponible("CARRO");
		
		assertTrue(hayEspacioCarro);
	}
	
	@Test
	public void validarEspacioDisponibleMoto() {
		when(repositorioParquedero.obtenerPlazaActualMoto()).thenReturn(0);
		when(repositorioParquedero.obtenerPlazaMoto()).thenReturn(10);
		
		boolean hayEspacioMoto = this.servicioParqueadero.hayPlazasDisponible("MOTO");
		
		assertTrue(hayEspacioMoto);
	}
	
	@Test
	public void validarConCostoExtraMoto() {
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(2000).buil();

		int costo = this.servicioParqueadero.costoExtraMoto(vehiculo);

		assertTrue(costo == 2000);
	}

	@Test
	public void validarSinCostoExtraMoto() {
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(200).buil();
	
		int costo = this.servicioParqueadero.costoExtraMoto(vehiculo);
		
		assertTrue(costo == 0);
	}

	@Test
	public void validarConAccesoPorPlacas() {
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(200).buil();
		Calendar diaActual = new GregorianCalendar(2019, 5, 25, 20, 00);

		boolean acceso = this.servicioParqueadero.accesoPorPlacas(vehiculo, diaActual);

		assertTrue(acceso);
	}

	@Test
	public void validarSinAccesoPorPlacas() {
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(200).buil();
		Calendar diaActual = new GregorianCalendar(2019, 5, 24, 20, 00);

		boolean acceso = this.servicioParqueadero.accesoPorPlacas(vehiculo, diaActual);

		assertFalse(acceso);
	}

	@Test
	public void validarCostoPorEstadiaCarro() {

		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("CARRO").buil();
		Calendar fechaActual = new GregorianCalendar(2019, 5, 24, 12, 00);
		Calendar fechaInicial = new GregorianCalendar(2019, 5, 24, 22, 00);
		Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).conFechaEntrada(fechaInicial).build();

		int costo = this.servicioParqueadero.costoPorEstadia(registro, fechaActual);

		assertTrue(costo == 8000);
	}

	@Test
	public void validarCostoPorEstadiaMoto() {
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conCilindraje(200).buil();
		Calendar fechaActual = new GregorianCalendar(2019, 5, 24, 12, 00);
		Calendar fechaInicial = new GregorianCalendar(2019, 5, 24, 22, 00);
		Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).conFechaEntrada(fechaInicial).build();

		int costo = this.servicioParqueadero.costoPorEstadia(registro, fechaActual);

		assertTrue(costo == 4000);
	}

	@Test
	public void validarCostoPorEstadiaMotoConExtra() {
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conCilindraje(600).buil();
		Calendar fechaActual = new GregorianCalendar(2019, 5, 24, 12, 00);
		Calendar fechaInicial = new GregorianCalendar(2019, 5, 24, 22, 00);
		Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).conFechaEntrada(fechaInicial).build();

		int costo = this.servicioParqueadero.costoPorEstadia(registro, fechaActual);

		assertTrue(costo == 6000);
	}

}
