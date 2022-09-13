package com.Biblioteca.Prestamos.Repository;

import com.Biblioteca.Prestamos.Entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface LibroReposito extends JpaRepository<Libro, String> {
    ArrayList<Libro> findByAutor(String autor);

}
