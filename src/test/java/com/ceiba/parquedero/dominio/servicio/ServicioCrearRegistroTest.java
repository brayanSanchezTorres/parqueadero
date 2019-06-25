package com.ceiba.parquedero.dominio.servicio;

import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcion;
import com.ceiba.parquedero.dominio.modelo.Vehiculo;
import com.ceiba.parquedero.dominio.repositorio.RepositorioParquedero;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;
import com.ceiba.parquedero.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioCrearRegistroTest {
	
	@InjectMocks
	private ServicioCrearRegistro servicioCrearRegistro;

	@Mock
	private ServicioParqueadero servicioParqueadero;

	@Mock
	private RepositorioRegistro repositorioRegistro;

	@Mock
	private RepositorioParquedero repositorioParquedero;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = ParqueaderoExcepcion.class)
	public void validarExistenciaMoto() throws ParqueaderoExcepcion {
		when(servicioParqueadero.existeEnParqueadero("MOTO")).thenReturn(true);
		
		this.servicioCrearRegistro.validarExistenciaPlacaSinSalida("MOTO");
	}
	
	@Test(expected = ParqueaderoExcepcion.class)
	public void validarExistenciaCarro() throws ParqueaderoExcepcion {
		when(servicioParqueadero.existeEnParqueadero("CARRO")).thenReturn(true);

		this.servicioCrearRegistro.validarExistenciaPlacaSinSalida("CARRO");
	}
	
	@Test(expected = ParqueaderoExcepcion.class)
	public void validarPlazasDisponiblesCarro() throws ParqueaderoExcepcion {
		when(servicioParqueadero.hayPlazasDisponible("CARRO")).thenReturn(true);

		this.servicioCrearRegistro.validarPlazasdisponibles("CARRO");
	}
	
	@Test(expected = ParqueaderoExcepcion.class)
	public void validarPlazasDisponiblesMoto() throws ParqueaderoExcepcion {
		when(servicioParqueadero.hayPlazasDisponible("MOTO")).thenReturn(true);
	
		this.servicioCrearRegistro.validarPlazasdisponibles("MOTO");
	}
	
	@Test(expected = ParqueaderoExcepcion.class)
	public void validarAccesoPorPlacaMoto() throws ParqueaderoExcepcion {
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(200).buil();
		Calendar diaActual = new GregorianCalendar(2019, 5, 24, 20, 00);
		
		when(servicioParqueadero.accesoPorPlacas(vehiculo, diaActual)).thenReturn(false);
		
		this.servicioCrearRegistro.validarAccesoPorPlacas(vehiculo, diaActual);
	}
}
