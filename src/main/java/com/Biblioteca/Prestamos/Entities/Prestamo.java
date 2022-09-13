package com.Biblioteca.Prestamos.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="prestamo")
public class Prestamo {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pretamo;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)//fetch recorre los datos del estudiante
    @JoinColumn(name="documento", referencedColumnName = "documento", nullable = false)
    @JsonIgnore
    private Estudiante estudiante;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="isbn", referencedColumnName = "isbn", nullable = false)
    @JsonIgnore
    private Libro libro;


    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;

//    Generar fecha actual de forma automatica
    @PrePersist
    public void prePersist(){
        this.fecha = new Date();
    }

    public Prestamo() {
    }

    public Prestamo(int id_pretamo, Estudiante estudiante, Libro libro, Date fecha) {
        this.id_pretamo = id_pretamo;
        this.estudiante = estudiante;
        this.libro = libro;
        this.fecha = fecha;
    }

    public int getId_pretamo() {
        return id_pretamo;
    }

    public void setId_pretamo(int id_pretamo) {
        this.id_pretamo = id_pretamo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id_pretamo=" + id_pretamo +
                ", estudiante='" + estudiante + '\'' +
                ", libro='" + libro + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}


