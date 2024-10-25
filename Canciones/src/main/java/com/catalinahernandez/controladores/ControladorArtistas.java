package com.catalinahernandez.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.catalinahernandez.modelos.Artista;
import com.catalinahernandez.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
	@Autowired
	ServicioArtistas servicioArtistas;
	
	@GetMapping("/artistas")
	public String desplegarArtistas(Model modeloArtista) {
		List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
		modeloArtista.addAttribute("artistas", artistas);
		return "artistas.jsp";
	}
	
	@GetMapping("/artistas/detalle/{idArtista}")
	public String desplegarDetalleArtista(@PathVariable Long idArtista , Model modeloArtista) {
		Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
		modeloArtista.addAttribute("artista", artista);
		return "detalleArtista.jsp";
	}
	
	@GetMapping("/artistas/formulario/agregar/{idArtista}")
	public String formularioAgregarArtista(@ModelAttribute Artista artista) {
		return "agregarArtista.jsp";
	}
	
	@PostMapping("/artistas/procesa/agregar")
	public String procesarAgregarArtista(@Valid @ModelAttribute Artista artista, BindingResult validacionArtista) {
		if(validacionArtista.hasErrors()) {
			return "agregarArtista.jsp";
		}
		servicioArtistas.agregarArtista(artista);
		return "redirect:/artistas";
	}
}
