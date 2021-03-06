package com.biblioteca.dominio.servicio.libro;


import com.biblioteca.dominio.Libro;
import com.biblioteca.dominio.repositorio.RepositorioLibro;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearLibro {

    private final RepositorioLibro repositorioLibro;

    public ServicioCrearLibro(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public void ejecutar(Libro libro) {
        this.repositorioLibro.agregar(libro);
    }
}