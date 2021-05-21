package com.biblioteca.dominio.servicio.prestamo;

import com.biblioteca.dominio.Prestamo;
import com.biblioteca.dominio.excepcion.PrestamoException;
import com.biblioteca.dominio.repositorio.RepositorioPrestamo;
import org.springframework.stereotype.Component;

@Component
public class ServicioObtenerPrestamo {
    private final RepositorioPrestamo repositorioPrestamo;

    public ServicioObtenerPrestamo(RepositorioPrestamo repositorioPrestamo) {
        this.repositorioPrestamo = repositorioPrestamo;
    }

    public Prestamo ejecutar(String isbn) {
        Prestamo prestamo = this.repositorioPrestamo.obtener(isbn);
        if(prestamo == null)throw new PrestamoException("Prestamo no existe.");
        return prestamo;
    }
}
