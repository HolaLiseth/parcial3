package com.Parcial3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Parcial3.app.variables.Estudiantes;

public interface ServiciosEstudiantes extends JpaRepository<Estudiantes, Integer>{

	Estudiantes findByUsuarioAndContrasena(String usuario, String contrasena);

}

