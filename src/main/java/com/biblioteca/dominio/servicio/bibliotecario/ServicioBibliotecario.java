package com.biblioteca.dominio.servicio.bibliotecario;

import com.biblioteca.dominio.Prestamo;
import com.biblioteca.dominio.excepcion.PrestamoException;
import com.biblioteca.dominio.repositorio.RepositorioLibro;
import com.biblioteca.dominio.repositorio.RepositorioPrestamo;

public class ServicioBibliotecario {

    public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";
    public static final String LIBRO_PALIMDROMO = "los libros palíndromos solo se pueden utilizar en la biblioteca.";

    private final RepositorioLibro repositorioLibro;
    private final RepositorioPrestamo repositorioPrestamo;

    public ServicioBibliotecario(RepositorioLibro repositorioLibro, RepositorioPrestamo repositorioPrestamo) {
        this.repositorioLibro = repositorioLibro;
        this.repositorioPrestamo = repositorioPrestamo;
    }

    public void prestar(Prestamo prestamo) {
        if(this.esPrestado(prestamo.getLibro().getIsbn()))throw new PrestamoException(EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE);
        if(this.esPalindromo(prestamo.getLibro().getIsbn()))throw new PrestamoException(LIBRO_PALIMDROMO);

        this.repositorioPrestamo.agregar(prestamo);
    }

    public boolean esPrestado(String isbn) {
        return this.repositorioPrestamo.obtenerLibroPrestadoPorIsbn(isbn) != null;
    }

    private boolean esPalindromo(String isbn){
        String newIsbn = "";
        for(int i=isbn.length()-1; i>=0;i--){ newIsbn += isbn.charAt(i); }
        return newIsbn.equals(isbn);
    }
}
