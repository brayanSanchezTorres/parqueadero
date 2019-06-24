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

public class ServicioActualizarRegistroTest {
	
	@InjectMocks
	private ServicioActualizarRegistro servicioActualizarRegistro;
	
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
	public void validarExistenciaEnParqueaderoCarro() throws ParqueaderoExcepcion {
		when(servicioParqueadero.existeEnParqueadero("CARRO")).thenReturn(false);

		this.servicioActualizarRegistro.validarExistenciaEnParqueadero("CARRO");
	}
	
	@Test(expected = ParqueaderoExcepcion.class)
	public void validarExistenciaEnParqueaderoMoto() throws ParqueaderoExcepcion {
		when(servicioParqueadero.existeEnParqueadero("MOTO")).thenReturn(false);

		this.servicioActualizarRegistro.validarExistenciaEnParqueadero("MOTO");
	}
	
	
}
