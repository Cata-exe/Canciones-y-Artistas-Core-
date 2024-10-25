package com.catalinahernandez.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catalinahernandez.modelos.Artista;
import com.catalinahernandez.modelos.Cancion;
import com.catalinahernandez.servicios.ServicioArtistas;
import com.catalinahernandez.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	@Autowired
	ServicioCanciones servicio;
	
	@Autowired
	ServicioArtistas servicioArtistas;
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model modelo) {
		List<Cancion> canciones = servicio.obtenerTodasLasCanciones();
		modelo.addAttribute("canciones", canciones);
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(@PathVariable Long idCancion , Model modelo) {
		Cancion cancion = servicio.obtenerCancionPorId(idCancion);
		modelo.addAttribute("cancion", cancion);
		return "detalleCancion.jsp";
	}
	
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(@ModelAttribute Cancion cancion, Model modeloArtista) {
		List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
		modeloArtista.addAttribute("artistas", artistas);
		return "agregarCancion.jsp";
	}
	
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute Cancion cancion, BindingResult validacion) {
		if(validacion.hasErrors()) {
			return "agregarCancion.jsp";
		}
		Artista artista = servicioArtistas.obtenerArtistaPorId(cancion.getArtista().getId());
		cancion.setArtista(artista);
		servicio.agregarCancion(cancion);
		return "redirect:/canciones";
	}
	
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@PathVariable Long idCancion , Model modelo) {
		Cancion cancion = servicio.obtenerCancionPorId(idCancion);
		modelo.addAttribute("cancion", cancion);
		return "editarCancion.jsp";
	}
	
	@PutMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@Valid @ModelAttribute Cancion cancionActual, BindingResult validacion,
			                            @PathVariable Long idCancion) {
		if(validacion.hasErrors()) {
			return "editarCancion.jsp";
		}
		cancionActual.setId(idCancion);
		servicio.actualizaCancion(cancionActual);
		return "redirect:/canciones";
	}
	
	@DeleteMapping("/canciones/eliminar/{idCancion}")
	public String procesarEliminarCancion(@PathVariable Long idCancion) { 
		servicio.eliminaCancion(idCancion);
		return "redirect:/canciones";
	}
}
