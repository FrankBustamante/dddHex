package com.biblioteca.dominio.repositorio;


import com.biblioteca.dominio.Libro;

public interface RepositorioLibro {

    /**
     * Permite obtener un libro dado un isbn
     *
     * @param isbn
     * @return Libro
     */
    Libro obtenerPorIsbn(String isbn);

    /**
     * Permite agregar un libro al repositorio
     *
     * @param libro
     */
    void agregar(Libro libro);

}