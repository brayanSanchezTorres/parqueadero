package com.ceiba.parquedero.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parquedero.aplicacion.comando.ComandoRegistro;
import com.ceiba.parquedero.aplicacion.comando.manejador.ManejadorActualizarRegistro;
import com.ceiba.parquedero.aplicacion.comando.manejador.ManejadorCrearRegistro;
import com.ceiba.parquedero.aplicacion.consulta.manejador.ManejadorListarRegistros;
import com.ceiba.parquedero.aplicacion.respuestadto.Respuesta;
import com.ceiba.parquedero.dominio.modelo.Registro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/registro")
@Api(tags = { "controlador registro" })
public class ControladorRegistro {
	
	@Autowired
	private final ManejadorListarRegistros manejadorListarRegistros;
	
	@Autowired
	private final ManejadorCrearRegistro manejadorCrearRegistro;
	
	@Autowired
	private final ManejadorActualizarRegistro manejadorActualizarRegistro;
	
	
	public ControladorRegistro(ManejadorListarRegistros manejadorListarRegistros,
			ManejadorCrearRegistro manejadorCrearRegistro, ManejadorActualizarRegistro manejadorActualizarRegistro) {
		this.manejadorCrearRegistro = manejadorCrearRegistro;
		this.manejadorListarRegistros = manejadorListarRegistros;
		this.manejadorActualizarRegistro = manejadorActualizarRegistro;
	}
	
	@GetMapping
	@ApiOperation("listar")
	public Respuesta<Registro> listar() {
		return this.manejadorListarRegistros.ejecutar();
	}

	@PostMapping
	@ApiOperation("crear")
	public Respuesta<ComandoRegistro> crear(@RequestBody ComandoRegistro comandoRegistro) {
		return this.manejadorCrearRegistro.ejecutar(comandoRegistro);
		
	}

	@PutMapping
	@ApiOperation("actualizar")
	public Respuesta<Registro> actualizar(@RequestBody ComandoRegistro comandoRegistro) {
		return this.manejadorActualizarRegistro.ejecutar(comandoRegistro);
	}

}
