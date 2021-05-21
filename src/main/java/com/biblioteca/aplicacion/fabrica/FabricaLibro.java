package com.biblioteca.aplicacion.fabrica;

import com.biblioteca.aplicacion.comando.ComandoLibro;
import com.biblioteca.dominio.Libro;
import org.springframework.stereotype.Component;

@Component
public class FabricaLibro {
    public Libro crearLibro(ComandoLibro comandoLibro) {
        return new Libro(comandoLibro.getIsbn(), comandoLibro.getTitulo(), comandoLibro.getAnio());
    }
}
