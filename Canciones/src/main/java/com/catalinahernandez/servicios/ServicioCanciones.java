package com.catalinahernandez.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalinahernandez.modelos.Cancion;
import com.catalinahernandez.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
	@Autowired
	private final RepositorioCanciones repositorio;
	
	public ServicioCanciones(RepositorioCanciones repositorio) {
		super();
		this.repositorio = repositorio;
	}

	public List<Cancion> obtenerTodasLasCanciones() {
		return repositorio.findAll();
	}
	
	public Cancion obtenerCancionPorId(Long id) {
		Optional<Cancion> cancion = repositorio.findById(id);
		return cancion.orElse(null);
	}
	
	public Cancion agregarCancion(Cancion cancion) {
		return repositorio.save(cancion);
	}
	
	public Cancion actualizaCancion(Cancion cancionActual) {
		return repositorio.save(cancionActual);
	}
	
	public void eliminaCancion(Long idCancion) {
		repositorio.deleteById(idCancion);
	}
}
