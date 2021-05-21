package com.biblioteca.dominio.servicio.libro;

import com.biblioteca.dominio.Libro;
import com.biblioteca.infraestructura.persistencia.repositorio.RepositorioLibroPersistente;
import org.springframework.stereotype.Component;

@Component
public class ServicioObtenerLibro {

    private final RepositorioLibroPersistente repositorioLibro;

    public ServicioObtenerLibro(RepositorioLibroPersistente repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public Libro ejecutar(String isbn) {
        return this.repositorioLibro.obtenerPorIsbn(isbn);
    }
}
