package com.Parcial3.app.variables;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador {
	//Variables
	@Id
    private Integer ced;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contrasena;
    
    @OneToMany
    @JoinColumn(name = "id_Administrador")
    private List<Coordinador>coordinador;
    
    @OneToMany
    @JoinColumn(name = "id_administrador")
    private List<Estudiantes>estudiantes;

    @OneToMany
    @JoinColumn(name = "id_admin")
    private List<Profesor>profesor;
  
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
