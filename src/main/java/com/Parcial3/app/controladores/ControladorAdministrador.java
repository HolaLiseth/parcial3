package com.Parcial3.app.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Parcial3.app.repository.ServiciosAdministrador;
import com.Parcial3.app.variables.Administrador;

@Controller
public class ControladorAdministrador {

	@Autowired
	private ServiciosAdministrador ServiciosAdministrador;
	
	@GetMapping("/verAdministrador.html")  
	public String listarAdministrador(Model model) {
		List<Administrador> listaAdministrador = ServiciosAdministrador.findAll();
		model.addAttribute("listaAdministrador", listaAdministrador);
		
		return "verAdministrador";
	}
	
	@GetMapping("/formAdministrador.html")
	public String mostrarFormularioAdministrador (Model model) {
		model.addAttribute("Administrador", new Administrador());
			
		List<Administrador> listaAdministrador = ServiciosAdministrador.findAll();
		model.addAttribute("listaAdministrador", listaAdministrador);
		
		return "formAdministrador";
	}
	
	@PostMapping("/guardarAdministrador")
	public String guardarAdministrador (Administrador Administrador) {
		ServiciosAdministrador.save(Administrador);
		return "redirect:/verAdministrador.html";
	}
	
	@GetMapping("/Administrador/editarAdministrador/{ced}")
	public String modificarAdministrador (@PathVariable("ced") Integer ced, Model model) {
		Administrador listaAdministrador = ServiciosAdministrador.findById(ced).get();
		model.addAttribute("Administrador", listaAdministrador);
		
		List<Administrador> Administrador = ServiciosAdministrador.findAll();
		model.addAttribute("listaAdministrador", Administrador);
		
		return "formAdministrador";
	}
	
	@GetMapping("/Administrador/eliminarAdministrador/{ced}")
	public String eliminarAdministrador(@PathVariable("ced") Integer ced, Model model) {
		ServiciosAdministrador.deleteById(ced);
		return "redirect:/verAdministrador.html";
	}
	
}

