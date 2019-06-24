package com.ceiba.parquedero.dominio.servicio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ceiba.parquedero.dominio.repositorio.RepositorioParquedero;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;

public class ServicioCrearRegistroTest {
	
	private static final String EXISTENCIA_RESPUESTA_ESPERADA = "Este Vehiculo ya se encuentra en el parqueadero";
	private static final String ESPACIO_RESPUESTA_ESPERADA = "No hay espacio en el parqueadero";
	
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

	@Test
	public void validarExistenciaMoto() {
		when(servicioParqueadero.existeEnParqueadero("MOTO")).thenReturn(true);
		try {
			this.servicioCrearRegistro.validarExistenciaPlacaSinSalida("MOTO");
		} catch (Exception e) {
			assertEquals(EXISTENCIA_RESPUESTA_ESPERADA, e.getMessage());
		}
	}
	
	@Test
	public void validarExistenciaCarro() {
		when(servicioParqueadero.existeEnParqueadero("CARRO")).thenReturn(true);
		try {
			this.servicioCrearRegistro.validarExistenciaPlacaSinSalida("CARRO");
		} catch (Exception e) {
			assertEquals(EXISTENCIA_RESPUESTA_ESPERADA, e.getMessage());
		}
	}
	
	
}
