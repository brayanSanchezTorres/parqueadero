package com.ceiba.parquedero.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.parquedero.dominio.servicio.ServicioCrearRegistro;
import com.ceiba.parquedero.infraestructura.adaptador.repositorio.RepositorioRegistroEnMemoria;

@Configuration
public class BeanServicio {
	
	@Bean
	public ServicioCrearRegistro servicioCrearRegistro() {
		return new ServicioCrearRegistro(new RepositorioRegistroEnMemoria());
	}

}
