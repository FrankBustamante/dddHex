package com.biblioteca.infraestructura.persistencia.repositorio.jpa;

import com.biblioteca.infraestructura.persistencia.entidad.LibroEntity;

public interface RepositorioLibroJPA {

    /**
     * Permite obtener un libro entity por un isbn
     *
     * @param isbn
     * @return
     */
    LibroEntity obtenerLibroEntityPorIsbn(String isbn);

}
