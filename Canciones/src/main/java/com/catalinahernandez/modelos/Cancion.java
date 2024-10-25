package com.catalinahernandez.modelos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "canciones")
public class Cancion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotBlank
	@Size(min = 5, message = "Al menos 5 caracteres de longitud")
	private String titulo;
	
	/* @Column
	@NotBlank
	@Size(min = 3, message = "Al menos 3 caracteres de longitud")
	private String artista;
	*/
	
	@ManyToOne
	@JoinColumn(name="id_artista")
	private Artista artista;
	
	@Column
	@NotBlank
	@Size(min = 3, message = "Al menos 3 caracteres de longitud")
	private String album;
	
	@Column
	@NotBlank
	@Size(min = 3, message = "Al menos 3 caracteres de longitud")
	private String genero;
	
	@Column
	@NotBlank
	@Size(min = 3, message = "Al menos 3 caracteres de longitud")
	private String idioma;
	
	@Column
	private LocalDateTime fechaCreacion;
	
	@Column
	private LocalDateTime fechaActualizacion;
	
	public Cancion() {
		super();
		this.id = 0l;
		this.titulo = "";
		this.artista = new Artista();
		this.album = "";
		this.genero = "";
		this.idioma = "";
		this.fechaCreacion = LocalDateTime.now();
		this.fechaActualizacion = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	@PrePersist
	protected void onCreate() {
		fechaCreacion = LocalDateTime.now();
		fechaActualizacion = LocalDateTime.now();
	}
	
	@PreUpdate
	protected void onUpdate() {
		fechaActualizacion = LocalDateTime.now();
	}
}
