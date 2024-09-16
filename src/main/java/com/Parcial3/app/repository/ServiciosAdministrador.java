package com.Parcial3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Parcial3.app.variables.Administrador;



public interface ServiciosAdministrador extends JpaRepository<Administrador, Integer>{

    Administrador findByUsuarioAndContrasena(String usuario, String contrasena);

}
