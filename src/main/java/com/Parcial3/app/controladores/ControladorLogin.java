package com.Parcial3.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Parcial3.app.repository.ServiciosAdministrador;
import com.Parcial3.app.repository.ServiciosCoordinador;
import com.Parcial3.app.repository.ServiciosEstudiantes;
import com.Parcial3.app.repository.ServiciosProfesor;
import com.Parcial3.app.repository.ServiciosIdeasproyecto;
import com.Parcial3.app.variables.Administrador;
import com.Parcial3.app.variables.Coordinador;
import com.Parcial3.app.variables.Profesor;
import com.Parcial3.app.variables.Ideasproyecto;
import com.Parcial3.app.variables.Estudiantes;

import java.util.List;

@Controller
public class ControladorLogin {

    @Autowired
    private ServiciosAdministrador administradorRepositorio;

    @Autowired
    private ServiciosCoordinador coordinadorRepositorio;

    @Autowired
    private ServiciosProfesor profesorRepositorio;
    
    @Autowired
    private ServiciosIdeasproyecto ideasproyectoRepositorio;
    
    @Autowired
    private ServiciosEstudiantes EstudiantesRepositorio;
    
    @GetMapping("/IndexPrincipal")
    public String IrIndexPrincipal(Model model) {
        return "index";
    }

    @GetMapping("/LoginAdministrador")
    public String irLoginAdministrador(Model model) {
        return "LoginAdministrador.html";
    }

    @GetMapping("/LoginCoordinador")
    public String IrLoginCoordinador(Model model) {
        return "LoginCoordinador.html";
    }

    @GetMapping("/LoginDirector")
    public String IrLoginDirector(Model model) {
        model.addAttribute("correo", "");
        model.addAttribute("contrasena", "");
        return "LoginDirector.html";
    }

    @GetMapping("/LoginEvaluador")
    public String IrLoginEvaluador(Model model) {
        return "LoginEvaluador.html";
    }

    @GetMapping("/LoginEstudiante")
    public String IrLoginEstudiante(Model model) {
        return "LoginEstudiante.html";
    }

    @GetMapping("/indexAdministrador")
    public String irIndexAdmin(Model model) {
        return "indexAdministrador.html";
    }
    
    @GetMapping("/indexEstudiante")
    public String IrindexEstudiante(Model model) {
        return "indexEstudiante";
    }
    
    @GetMapping("/indexCoordinador")
    public String IrindexCoordinador(Model model) {
        return "indexCoordinador";
    }

    @PostMapping("/indexAdministradorLogin")
    public String iniciarSesionAdmin(@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena, Model model) {
        Administrador administrador = administradorRepositorio.findByUsuarioAndContrasena(usuario, contrasena);
        if (administrador != null) {
            return "redirect:/indexAdministrador";
        } else {
            model.addAttribute("error", "Usuario y/o contraseÃ±a incorrectos. IntÃ©ntalo de nuevo.");
            return "LoginAdministrador";
        }
    }

    @PostMapping("/indexCoordinadorLogin")
    public String iniciarSesionCoordinador(@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena, Model model) {
        Coordinador coordinador = coordinadorRepositorio.findByUsuarioAndContrasena(usuario, contrasena);
        if (coordinador != null) {
            return "redirect:/indexCoordinador";
        } else {
            model.addAttribute("error", "Usuario y/o contrasena incorrectos. Intentalo de nuevo.");
            return "LoginCoordinador";
        }
    }

    @PostMapping("/indexDirectorLogin")
    public String iniciarSesionDirector(@RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena, Model model) {
        // Buscar si existe un profesor con el correo y contraseÃ±a proporcionados
        Profesor director = profesorRepositorio.findByCorreoAndContrasena(correo, contrasena);
        
        if (director != null) {
            // Verificar si el profesor es director de alguna idea de proyecto
            List<Ideasproyecto> ideasDelDirector = ideasproyectoRepositorio.findByDirector(director);
            
            if (!ideasDelDirector.isEmpty()) {
                // Si el profesor es director de alguna idea de proyecto, redirigir al Ã­ndice del director
                return "indexDirector.html";
            } else {
                // Si el profesor no es director de ninguna idea de proyecto, mostrar mensaje de error
                model.addAttribute("error", "No tienes ideas de proyecto asociadas. Contacta al administrador.");
                return "LoginDirector";
            }
        } else {
            // Si no se encuentra ningÃºn director con ese correo y contraseÃ±a, mostrar mensaje de error
            model.addAttribute("error", "Correo y/o contraseÃ±a incorrectos. IntÃ©ntalo de nuevo.");
            return "LoginDirector";
        }
    }
    
    @PostMapping("/indexEvaluadorLogin")
    public String iniciarSesionEvaluador(@RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena, Model model) {
        // Buscar si existe un profesor con el correo y contraseÃ±a proporcionados
        Profesor evaluador = profesorRepositorio.findByCorreoAndContrasena(correo, contrasena);
        
        if (evaluador != null) {
            // Verificar si el profesor es evaluador de alguna idea de proyecto
            List<Ideasproyecto> ideasDelEvaluador = ideasproyectoRepositorio.findByEvaluador(evaluador);
            
            if (!ideasDelEvaluador.isEmpty()) {
                // Si el profesor es evaluador de alguna idea de proyecto, redirigir al Ã­ndice del evaluador
                return "indexEvaluador.html";
            } else {
                // Si el profesor no es evaluador de ninguna idea de proyecto, mostrar mensaje de error
                model.addAttribute("error", "No tienes ideas de proyecto para evaluar. Contacta al administrador.");
                return "LoginEvaluador";
            }
        } else {
            // Si no se encuentra ningÃºn evaluador con ese correo y contraseÃ±a, mostrar mensaje de error
            model.addAttribute("error", "Correo y/o contraseÃ±a incorrectos. IntÃ©ntalo de nuevo.");
            return "LoginEvaluador";
        }
    }

    @PostMapping("/indexEstudianteLogin")
    public String iniciarSesionEstudiante(@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena, Model model) {
        Estudiantes estudiante = EstudiantesRepositorio.findByUsuarioAndContrasena(usuario, contrasena);
        if (estudiante != null) {
            return "redirect:/indexEstudiante";
        } else {
            model.addAttribute("error", "Usuario y/o contraseÃ±a incorrectos. IntÃ©ntalo de nuevo.");
            return "LoginEstudiante";
        }
    }


    @GetMapping("/indexEvaluador")
    public String IrindexEvaluador(Model model) {
        return "indexEvaluador.html";
    }

}
