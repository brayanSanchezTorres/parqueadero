package com.ceiba.parquedero.infraestructura.controlador;

import java.util.Collection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parquedero.aplicacion.comando.ComandoRegistro;
import com.ceiba.parquedero.aplicacion.comando.ComandoVehiculo;
import com.ceiba.parquedero.aplicacion.comando.manejador.ManejadorCrearRegistro;
import com.ceiba.parquedero.aplicacion.consulta.manejador.ManejadorListarRegistros;
import com.ceiba.parquedero.dominio.modelo.Registro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/registro/")
@Api(tags = {"controlador registro"})
public class ControladorRegistro {
	
	private final ManejadorListarRegistros manejadorListarRegistros;
	private final ManejadorCrearRegistro manejadorCrearRegistro;
	
	private ControladorRegistro(ManejadorListarRegistros manejadorListarRegistros, ManejadorCrearRegistro manejadorCrearRegistro) {
		this.manejadorCrearRegistro = manejadorCrearRegistro;
		this.manejadorListarRegistros = manejadorListarRegistros;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation("listar")
	public Collection<Registro> listar(){
		return this.manejadorListarRegistros.ejecutar();
	}
	
	@PostMapping
	@ApiOperation("crear")
	public void crear(@RequestBody ComandoRegistro comandoRegistro) {
		this.manejadorCrearRegistro.ejecutar(comandoRegistro);
	}
	
	@PutMapping
	@ApiOperation("prueba")
	public ComandoVehiculo regrea(@RequestBody ComandoVehiculo res) {
		res.setPlaca("cambio");
		return res;
	}

}
