package com.biblioteca.infraestructura.controllador;

import com.biblioteca.aplicacion.manejadores.prestamo.ManejadorGenerarPrestamo;
import com.biblioteca.aplicacion.manejadores.prestamo.ManejadorObtenerPrestamo;
import com.biblioteca.dominio.Prestamo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamos")
public class ControladorPrestamo {
    private final ManejadorObtenerPrestamo manejadorObtenerPrestamo;
    private final ManejadorGenerarPrestamo manejadorGenerarPrestamo;

    public ControladorPrestamo(ManejadorObtenerPrestamo manejadorObtenerPrestamo, ManejadorGenerarPrestamo manejadorGenerarPrestamo) {
        this.manejadorGenerarPrestamo = manejadorGenerarPrestamo;
        this.manejadorObtenerPrestamo = manejadorObtenerPrestamo;
    }

    @PostMapping("/{isbn}/{nombreCliente}")
    public void prestar(@PathVariable(name = "isbn") String isbn, @PathVariable(name = "nombreCliente") String nombreCliente) {
        this.manejadorGenerarPrestamo.ejecutar(isbn, nombreCliente);
    }

    @GetMapping("/{isbn}")
    public Prestamo obtenerLibroPrestadoPorIsbn(@PathVariable(name = "isbn") String isbn) {
        return this.manejadorObtenerPrestamo.ejecutar(isbn);
    }
}
