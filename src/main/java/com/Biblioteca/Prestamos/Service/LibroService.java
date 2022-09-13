package com.Biblioteca.Prestamos.Service;

import com.Biblioteca.Prestamos.Entities.Libro;
import com.Biblioteca.Prestamos.Repository.LibroReposito;
import org.apache.el.util.ReflectionUtil;
import org.aspectj.util.Reflection;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Service
public class LibroService {
    private LibroReposito repository;

    public LibroService(LibroReposito repository) {
        this.repository = repository;
    }


//    Consultar todos los libros
    public ArrayList<Libro> listarLibros(){
        return (ArrayList<Libro>) repository.findAll();
    }

//    crear un nuevo libro
    public String crearLibro(Libro newLibro){
        String libro = newLibro.getIsbn();
        String mensaje;
        if (bucarlibro(libro).isPresent()){
            mensaje = "Libro Ya existe";
        }else{repository.save(newLibro); mensaje = "Libro Registrado con exito";}
        return mensaje;
    }

    //Metodo para consultar un libro

    public Optional<Libro> bucarlibro(String isbn){
        return repository.findById(isbn);

    }

    //Metodo para consultar un libro por autor

    public ArrayList<Libro> buscarAutor(String autor){
        return repository.findByAutor(autor);
    }


//    Metodo para Actualizar libro

    public String actualizarLibro(Libro libro){
        if(bucarlibro(libro.getIsbn()).isPresent()){
            repository.save(libro);
            return "Libro Actualizado correctamente";


        }else{return "Libro no existe";}


    }

//    Actualizar editorial
    public String cambiarEditor(String isbn, String newEditor){
        if(bucarlibro(isbn).isPresent()){
            Libro libro = repository.findById(isbn).get();
            libro.setEditorial(newEditor);
            repository.save(libro);
            return "Editorial Actualizada correctamente";

        }else{return "Libro no existe";}}

//        Eliminar Libro
    public String eliminarLibro(String isbn) {
        if (bucarlibro(isbn).isPresent()) {
            repository.deleteById(isbn);
            return "Libro Eliminado";
        }else {return "Libro no existe";}
    }


//    Actualizar libro cualquier campo
    public Libro actualizarCampo(String isbn, Map<Object, Object> libroMap){
        Libro libro = repository.findById(isbn).get();
        libroMap.forEach((key,value)->{
            Field campo= ReflectionUtils.findField(Libro.class,(String) key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, libro, value);
        });
        return repository.save(libro);

    }
}
