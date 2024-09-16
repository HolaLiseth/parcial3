package com.Parcial3.app.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Parcial3.app.repository.ServiciosEstudiantes;
import com.Parcial3.app.variables.Estudiantes;

@Controller
public class ControladorEstudiantes {

	@Autowired
	private ServiciosEstudiantes ServiciosEstudiantes;
	
	@GetMapping("/MostrarAlumno.html")  
	public String listarEstudiantes(Model model) {
		List<Estudiantes> listaEstudiantes = ServiciosEstudiantes.findAll();
		model.addAttribute("listaEstudiantes", listaEstudiantes);
		
		return "MostrarAlumno";
	}
	
	@GetMapping("/AgregarAlumno.html")
	public String mostrarFormularioEstudiantes (Model model) {
		model.addAttribute("Estudiantes", new Estudiantes());
			
		List<Estudiantes> listaEstudiantes = ServiciosEstudiantes.findAll();
		model.addAttribute("listaEstudiantes", listaEstudiantes);
		
		return "AgregarAlumno";
	}
	
	@PostMapping("/guardarEstudiantes")
	public String guardarEstudiantes (Estudiantes Estudiantes) {
		ServiciosEstudiantes.save(Estudiantes);
		return "redirect:/MostrarAlumno.html";
	}
	
	@GetMapping("/Estudiantes/editarEstudiantes/{id}")
	public String modificarEstudiantes (@PathVariable("id") Integer id, Model model) {
		Estudiantes listaEstudiantes = ServiciosEstudiantes.findById(id).get();
		model.addAttribute("Estudiantes", listaEstudiantes);
		
		List<Estudiantes> Estudiantes = ServiciosEstudiantes.findAll();
		model.addAttribute("listaEstudiantes", Estudiantes);
		
		return "AgregarAlumno";
	}
	
	@GetMapping("/Estudiantes/eliminarEstudiantes/{id}")
	public String eliminarEstudiantes(@PathVariable("id") Integer id, Model model) {
		ServiciosEstudiantes.deleteById(id);
		return "redirect:/MostrarAlumno.html";
	}
	
}
