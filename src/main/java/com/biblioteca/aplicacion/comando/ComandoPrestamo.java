package com.biblioteca.aplicacion.comando;

import com.biblioteca.dominio.Libro;

public class ComandoPrestamo {

    private Libro libro;
    private String nombreCliente;

    public ComandoPrestamo(Libro libro, String nombreCliente){
        this.libro = libro;
        this.nombreCliente = nombreCliente;
    }


    public Libro getLibro() {
        return libro;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
}
