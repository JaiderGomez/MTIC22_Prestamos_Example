package com.Biblioteca.Prestamos.Controllers;

import com.Biblioteca.Prestamos.Entities.Libro;
import com.Biblioteca.Prestamos.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
public class LibroController {
    @Autowired
    LibroService servicio;

    @GetMapping("/libros")
    public ArrayList<Libro> consular(){
        return servicio.listarLibros();
    }

    @PostMapping("/libro")
    public String crearLibro(@RequestBody Libro newlibro){
        return servicio.crearLibro(newlibro);
    }

    @GetMapping("/libro/{id}")
    public Optional<Libro> bucarLibro(@PathVariable("id") String isbn){
        return servicio.bucarlibro(isbn);
    }

    @GetMapping("/libropor/{autor}")
    public ArrayList<Libro> buscarAutor(@PathVariable("autor") String autor){
        return servicio.buscarAutor(autor);
    }

    @PutMapping("/actualizarLibro")
    public String actualizar(@RequestBody Libro libro){
        return servicio.actualizarLibro(libro);
    }
//    Para actualizar por variable
    @PatchMapping("/actualizarEdi/{isbn}/{editorial}")
    public String actualizarEdit(@PathVariable("isbn") String isbn, @PathVariable("editorial") String neweditorial){
        return servicio.cambiarEditor(isbn,neweditorial);
    }

//    Eliminar Libro
    @DeleteMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable("id") String isbn){
        return servicio.eliminarLibro(isbn);
    }

    @PatchMapping("/actualizarCampo/{id}")
    public Libro actualizarCampo(@PathVariable("id") String isbn, @RequestBody Map<Object, Object> libroMap){
        return servicio.actualizarCampo(isbn, libroMap);
    }



}





