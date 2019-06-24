package com.ceiba.parquedero.dominio.servicio;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ceiba.parquedero.dominio.excepcion.ParqueaderoExcepcion;
import com.ceiba.parquedero.dominio.repositorio.RepositorioParquedero;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;

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
}
