package com.ceiba.parquedero.infraestructura.adaptador.repositorio;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.ceiba.parquedero.dominio.modelo.Registro;
import com.ceiba.parquedero.dominio.repositorio.RepositorioRegistro;

@Repository
public class RepositorioRegistroEnMemoria implements RepositorioRegistro {
	
	private static ConcurrentHashMap<String, Registro> registros;
	
	static {
		registros = new ConcurrentHashMap<>();
	}
	
	@Override
	public Collection<Registro> listar() {
		return getRegistros();
	}
	
	@Override
	public void crear(Registro registro) {
		registros.put(UUID.randomUUID().toString(),registro);
	}
	
	@Override
	public void actualizar(Registro registro) {
		
	}
	
	@Override
	public boolean hayPlazasDisponibles(Registro registro) {
		
		return true;
	}
	
	private static Collection<Registro> getRegistros() {
		return registros.values();
	}

}
