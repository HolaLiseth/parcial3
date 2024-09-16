package com.Parcial3.app.variables;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    private Integer ced;
    private String nombre;
    private String apellidos;
    private String correo;
    private String contrasena;

    @OneToMany(mappedBy = "director")
    private List<Ideasproyecto> director;

    // Getters and Setters
    public Integer getCed() {
        return ced;
    }

    public void setCed(Integer ced) {
        this.ced = ced;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Ideasproyecto> getDirector() {
        return director;
    }

    public void setDirector(List<Ideasproyecto> director) {
        this.director = director;
    }
}

