package com.catalinahernandez.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalinahernandez.modelos.Artista;
import com.catalinahernandez.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {
	@Autowired
	private final RepositorioArtistas repositorioArtista;
	
	public ServicioArtistas(RepositorioArtistas repositorioArtista) {
		super();
		this.repositorioArtista = repositorioArtista;
	}

	public List<Artista> obtenerTodosLosArtistas() {
		return repositorioArtista.findAll();
	}
	
	public Artista obtenerArtistaPorId(Long id) {
		return repositorioArtista.findById(id).orElse(null);
		/* Optional<Artista> artista = repositorioArtista.findById(id);
		return artista.orElse(null); */
	}
	
	public Artista agregarArtista(Artista artista) {
		return repositorioArtista.save(artista);
	}
}
