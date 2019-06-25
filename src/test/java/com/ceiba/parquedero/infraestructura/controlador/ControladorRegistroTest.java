package com.ceiba.parquedero.infraestructura.controlador;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
public class ControladorRegistroTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks 
	private ControladorRegistro controladorRegistro;
	
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(controladorRegistro).build();
	}
	
	@Test
	public void getRegistro() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/registro/"))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andExpect(MockMvcResultMatchers.jsonPath("$.estado", Matchers.is(true)));
	}
	
	@Test
	public void getPrueba() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/registro/"))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andExpect(MockMvcResultMatchers.content().string("hola"));
	}
	
	
}
