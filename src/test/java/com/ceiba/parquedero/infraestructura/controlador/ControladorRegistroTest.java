package com.ceiba.parquedero.infraestructura.controlador;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControladorRegistroTest {
	
	private MockMvc mockMvc;
	private String json = "{\"vehiculo\":{\"tipo\":\"MOTO\",\"placa\":\"ABC2\",\"cilindraje\":2000},\"fechaEntrada\":\"2019-06-25T03:00:00.000+0000\"}";
	
	@Autowired
	private ControladorRegistro controladorRegistro;
	
	@Before 
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controladorRegistro).build();
	}
	
	@Test
	public void testGetRegistros() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/registro"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.estado", Matchers.is(true)));
	}
	
	@Test
	public void testCrearRegistros() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/registro")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.estado", Matchers.is(true)));
	}
	
	@Test
	public void testActualizarRegistros() throws Exception {		
		testCrearRegistros();
		
		mockMvc.perform(MockMvcRequestBuilders.put("/registro")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.estado", Matchers.is(true)));
	}
	
	@Test
	public void testActualizarRegistroFallo() throws Exception {
		String jsonDiferente = "{\"vehiculo\":{\"tipo\":\"MOTO\",\"placa\":\"ABC3\",\"cilindraje\":2000},\"fechaEntrada\":\"2019-06-25T03:00:00.000+0000\"}";
		
		mockMvc.perform(MockMvcRequestBuilders.put("/registro")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonDiferente))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.estado", Matchers.is(false)));
	}
}
