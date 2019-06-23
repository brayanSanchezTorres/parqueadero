package com.ceiba.parquedero.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.parquedero.dominio.servicio.ServicioActualizarRegistro;
import com.ceiba.parquedero.dominio.servicio.ServicioCrearRegistro;
import com.ceiba.parquedero.dominio.servicio.ServicioParqueadero;
import com.ceiba.parquedero.infraestructura.adaptador.repositorio.RepositorioParqueaderoEnMemoria;
import com.ceiba.parquedero.infraestructura.adaptador.repositorio.RepositorioRegistroEnMemoria;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearRegistro servicioCrearRegistro() {
		return new ServicioCrearRegistro(new RepositorioRegistroEnMemoria(),
				new ServicioParqueadero(new RepositorioRegistroEnMemoria(), new RepositorioParqueaderoEnMemoria()));
	}

	@Bean
	public ServicioActualizarRegistro servicioActualizarRegistro() {
		return new ServicioActualizarRegistro(new RepositorioRegistroEnMemoria(),
				new ServicioParqueadero(new RepositorioRegistroEnMemoria(), new RepositorioParqueaderoEnMemoria()));
	}

}
