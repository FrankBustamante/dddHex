package com.biblioteca.aplicacion.manejadores.libro;

import com.biblioteca.dominio.Libro;
import com.biblioteca.dominio.servicio.libro.ServicioObtenerLibro;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerLibro {

    private final ServicioObtenerLibro servicioObtenerProducto;

    public ManejadorObtenerLibro(ServicioObtenerLibro servicioObtenerProducto) {
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public Libro ejecutar(String isbn) {
        return this.servicioObtenerProducto.ejecutar(isbn);
    }
}
