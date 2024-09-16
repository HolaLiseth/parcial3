package com.Parcial3.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Parcial3.app.variables.Profesor;

import com.Parcial3.app.variables.Ideasproyecto;

public interface ServiciosProfesor extends JpaRepository<Profesor, Integer>{
	
	Profesor findByCorreoAndContrasena(String correo, String contrasena);

	Optional<Ideasproyecto> findByCed(Profesor director);


}
