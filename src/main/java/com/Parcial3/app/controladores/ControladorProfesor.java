package com.Parcial3.app.controladores;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Parcial3.app.repository.ServiciosProfesor;
import com.Parcial3.app.variables.Profesor;

@Controller
public class ControladorProfesor {

	@Autowired
	private ServiciosProfesor ServiciosProfesor;
	
	@GetMapping("/GestionarPro.html")  
	public String indexDirector(Model model) {
		
		return "GestionarPro.html";
	}
	
	@GetMapping("/indexAdministrador.html")  
	public String indexAdministrador(Model model) {
		
		return "indexAdministrador.html";
	}
	
	@GetMapping("/MostrarProfesor.html")  
	public String listarProfesor(Model model) {
		List<Profesor> listaProfesor = ServiciosProfesor.findAll();
		model.addAttribute("listaProfesor", listaProfesor);
		
		return "MostrarProfesor";
	}
	
	@GetMapping("/AgregarProfesor.html")
	public String mostrarFormularioProfesor (Model model) {
		model.addAttribute("Profesor", new Profesor());
			
		List<Profesor> listaProfesor = ServiciosProfesor.findAll();
		model.addAttribute("listaProfesor", listaProfesor);
		
		return "AgregarProfesor";
	}
	
	@PostMapping("/guardarProfesor")
	public String guardarProfesor (Profesor Profesor) {
		ServiciosProfesor.save(Profesor);
		return "redirect:/MostrarProfesor.html";
	}
	
	@GetMapping("/Profesor/editarProfesor/{ced}")
	public String modificarProfesor (@PathVariable("ced") Integer ced, Model model) {
		Profesor listaProfesor = ServiciosProfesor.findById(ced).get();
		model.addAttribute("Profesor", listaProfesor);
		
		List<Profesor> Profesor = ServiciosProfesor.findAll();
		model.addAttribute("listaProfesor", Profesor);
		
		return "AgregarProfesor";
	}
	
	@GetMapping("/Profesor/eliminarProfesor/{ced}")
	public String eliminarProfesor(@PathVariable("ced") Integer ced, Model model) {
		ServiciosProfesor.deleteById(ced);
		return "redirect:/MostrarProfesor.html";
	}
}
