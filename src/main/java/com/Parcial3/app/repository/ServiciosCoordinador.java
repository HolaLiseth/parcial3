package com.Parcial3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Parcial3.app.variables.Coordinador;


public interface ServiciosCoordinador extends JpaRepository<Coordinador, Integer>{

	Coordinador findByUsuarioAndContrasena(String usuario, String contrasena);

}

