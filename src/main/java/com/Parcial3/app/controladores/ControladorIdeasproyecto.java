package com.Parcial3.app.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Parcial3.app.repository.ServiciosIdeasproyecto;
import com.Parcial3.app.repository.ServiciosProfesor;
import com.Parcial3.app.variables.Ideasproyecto;
import com.Parcial3.app.variables.Profesor;

@Controller
public class ControladorIdeasproyecto {

	@Autowired
	private ServiciosIdeasproyecto ServiciosIdeasproyecto;
	
	@Autowired
	private ServiciosProfesor ServiciosProfesor;
	
	@GetMapping("/MostrarAnteproyecto")  
	public String listarIdeasproyecto(Model model) {
		List<Ideasproyecto> listaIdeasproyecto = ServiciosIdeasproyecto.findAll();
		model.addAttribute("listaIdeasproyecto", listaIdeasproyecto);
		
		return "MostrarAnteproyecto";
	}
	
	@GetMapping("/InformeProyecto")
	public String mostrarFormularioIdeasproyecto(Model model) {
	    model.addAttribute("Ideasproyecto", new Ideasproyecto());
	    
	    List<Ideasproyecto> listaIdeasproyecto = ServiciosIdeasproyecto.findAll();
	    model.addAttribute("listaIdeasProyecto", listaIdeasproyecto);
	    
	    List<Profesor> listaProfesor = ServiciosProfesor.findAll();
	    model.addAttribute("profesores", listaProfesor); // Pasar la lista de profesores
	    
	    return "AgregarAntepro";
	}
	
	@PostMapping("/guardarIdeasproyecto")
	public String guardarIdeasproyecto (Ideasproyecto Ideasproyecto) {
	    if (Ideasproyecto.getId() != null) {
	        // Si la idea de proyecto tiene un ID, entonces ya existe en la base de datos y estamos actualizando
	        ServiciosIdeasproyecto.save(Ideasproyecto);
	    } else {
	        // Si la idea de proyecto no tiene un ID, entonces es nueva y la estamos agregando
	        ServiciosIdeasproyecto.save(Ideasproyecto);
	    }
	    return "redirect:/MostrarAnteproyecto";
	}
	
	@GetMapping("/Ideasproyecto/editarIdeasproyecto/{id}")
	public String modificarIdeasproyecto(@PathVariable("id") Integer id, Model model) {
	    // Obtener la idea de proyecto de la base de datos por su ID
	    Optional<Ideasproyecto> optionalIdeasproyecto = ServiciosIdeasproyecto.findById(id);
	    if (optionalIdeasproyecto.isPresent()) {
	        Ideasproyecto ideasproyecto = optionalIdeasproyecto.get();
	        
	        // Obtener los profesores correspondientes a los IDs almacenados en la idea de proyecto
	        Profesor director = ideasproyecto.getDirector();
	        Profesor evaluador = ideasproyecto.getEvaluador();
	        
	        // Agregar la idea de proyecto y los nombres del director y evaluador al modelo
	        model.addAttribute("Ideasproyecto", ideasproyecto);
	        model.addAttribute("directorNombre", director != null ? director.getNombre() : "Sin asignar");
	        model.addAttribute("evaluadorNombre", evaluador != null ? evaluador.getNombre() : "Sin asignar");
	    }
	    
	    // Obtener todas las ideas de proyecto para seleccionar el director y evaluador en el formulario
	    List<Ideasproyecto> ideasproyectoList = ServiciosIdeasproyecto.findAll();
	    model.addAttribute("listaIdeasproyecto", ideasproyectoList);
	    
	    // Obtener todos los profesores para seleccionar el nuevo director y evaluador en el formulario
	    List<Profesor> profesores = ServiciosProfesor.findAll();
	    model.addAttribute("profesores", profesores);
	    
	    return "AgregarAntepro";
	}



	
    @PostMapping("/Ideasproyecto/eliminar")
    public String eliminarIdeasproyecto(@RequestParam("id") Integer id) {
        ServiciosIdeasproyecto.deleteById(id);
        return "redirect:/MostrarAnteproyecto";
    }
    
	@GetMapping("/formProfesor.html")
	public String mostrarFormularioProfesor(Model model) {
	    model.addAttribute("profesor", new Profesor());
	    
	    List<Profesor> listaProfesor = ServiciosProfesor.findAll();
	    model.addAttribute("profesores", listaProfesor); // Cambio de nombre a "profesores"
	    
	    return "redirect:/MostrarAnteproyecto";
	}
	}
