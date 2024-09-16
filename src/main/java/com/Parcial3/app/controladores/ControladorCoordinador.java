package com.Parcial3.app.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Parcial3.app.repository.ServiciosCoordinador;
import com.Parcial3.app.variables.Coordinador;

@Controller
public class ControladorCoordinador {

	@Autowired
	private ServiciosCoordinador ServiciosCoordinador;
	
	@GetMapping("/MostrarCoordinador.html")  
	public String listarCoordinador(Model model) {
		List<Coordinador> listaCoordinador = ServiciosCoordinador.findAll();
		model.addAttribute("listaCoordinador", listaCoordinador);
		
		return "MostrarCoordinador";
	}
	
	@GetMapping("/AgregarCoordinador.html")
	public String mostrarFormularioCoordinador (Model model) {
		model.addAttribute("Coordinador", new Coordinador());
			
		List<Coordinador> listaCoordinador = ServiciosCoordinador.findAll();
		model.addAttribute("listaCoordinador", listaCoordinador);
		
		return "AgregarCoordinador";
	}
	
	@PostMapping("/guardarCoordinador")
	public String guardarCoordinador (Coordinador Coordinador) {
		ServiciosCoordinador.save(Coordinador);
		return "redirect:/MostrarCoordinador.html";
	}
	
	@GetMapping("/Coordinador/editarCoordinador/{ced}")
	public String modificarCoordinador (@PathVariable("ced") Integer ced, Model model) {
		Coordinador listaCoordinador = ServiciosCoordinador.findById(ced).get();
		model.addAttribute("Coordinador", listaCoordinador);
		
		List<Coordinador> Coordinador = ServiciosCoordinador.findAll();
		model.addAttribute("listaCoordinador", Coordinador);
		
		return "AgregarCoordinador";
	}
	
	@GetMapping("/Coordinador/eliminarCoordinador/{ced}")
	public String eliminarCoordinador(@PathVariable("ced") Integer ced, Model model) {
		ServiciosCoordinador.deleteById(ced);
		return "redirect:/MostrarCoordinador.html";
	}	
}
