package com.Parcial3.app.variables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coordinador")
public class Coordinador {
	//Variables
	@Id
    private Integer ced;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contrasena;
    
    //Getters and Setters
	public Integer getCed() {
		return ced;
	}
	public void setCed(Integer ced) {
		this.ced = ced;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}