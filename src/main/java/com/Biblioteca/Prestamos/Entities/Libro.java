package com.Biblioteca.Prestamos.Entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="libro")
public class Libro {
    @Id
    @Column(unique = true, length = 30)
    private String isbn;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = false, length = 30)
    private String editorial;

    @Column(nullable = false, length = 30)
    private String autor;

    @Column(nullable = true)
    private int no_page;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Prestamo> prestamos;

//constructor vacio
    public Libro() {
    }
//    constructor con atributos

    public Libro(String isbn, String titulo, String editorial, String autor, int no_page) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
        this.no_page = no_page;
    }

//    Getters y Setters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNo_page() {
        return no_page;
    }

    public void setNo_page(int no_page) {
        this.no_page = no_page;
    }

//    Metodo toString

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", autor='" + autor + '\'' +
                ", no_page=" + no_page +
                '}';
    }
}

