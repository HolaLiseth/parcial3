package com.Parcial3.app.variables;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "ideasproyecto")
public class Ideasproyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private LocalDate fecha_creacion;
    private LocalDate fecha_limite;
    private String calificadirector;
    private String calificaevaluador;
    private String url;

    @OneToOne
    @JoinColumn(name = "id_estudiante", nullable = true)
    @Nullable
    private Estudiantes estudiante;

    @ManyToOne
    @JoinColumn(name = "id_director")
    private Profesor director;

    @ManyToOne
    @JoinColumn(name = "id_evaluador")
    private Profesor evaluador;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDate getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(LocalDate fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public String getCalificadirector() {
        return calificadirector;
    }

    public void setCalificadirector(String calificadirector) {
        this.calificadirector = calificadirector;
    }

    public String getCalificaevaluador() {
        return calificaevaluador;
    }

    public void setCalificaevaluador(String calificaevaluador) {
        this.calificaevaluador = calificaevaluador;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiantes estudiante) {
        this.estudiante = estudiante;
    }

    public Profesor getDirector() {
        return director;
    }

    public void setDirector(Profesor director) {
        this.director = director;
    }

    public Profesor getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Profesor evaluador) {
        this.evaluador = evaluador;
    }
}
