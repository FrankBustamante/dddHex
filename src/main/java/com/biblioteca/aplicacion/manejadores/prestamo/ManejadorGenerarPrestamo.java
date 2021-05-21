package com.biblioteca.aplicacion.manejadores.prestamo;

import com.biblioteca.aplicacion.comando.ComandoPrestamo;
import com.biblioteca.aplicacion.fabrica.FabricaPrestamo;
import com.biblioteca.aplicacion.manejadores.libro.ManejadorObtenerLibro;
import com.biblioteca.dominio.Libro;
import com.biblioteca.dominio.Prestamo;
import com.biblioteca.dominio.excepcion.PrestamoException;
import com.biblioteca.dominio.servicio.bibliotecario.ServicioBibliotecario;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorGenerarPrestamo {
    private final ServicioBibliotecario servicioBibliotecario;
    private final ManejadorObtenerLibro manejadorObtenerLibro;
    private final FabricaPrestamo fabricaPrestamo;

    public static final String EL_LIBRO_NO_EXISTE = "El libro no existe";

    public ManejadorGenerarPrestamo(ServicioBibliotecario servicioBibliotecario, ManejadorObtenerLibro manejadorObtenerLibro, FabricaPrestamo fabricaPrestamo) {
        this.servicioBibliotecario = servicioBibliotecario;
        this.manejadorObtenerLibro = manejadorObtenerLibro;
        this.fabricaPrestamo = fabricaPrestamo;
    }

    @Transactional
    public void ejecutar(String isbn, String nombreCliente) {
        Libro libro = this.manejadorObtenerLibro.ejecutar(isbn);

        if(libro == null)throw new PrestamoException(EL_LIBRO_NO_EXISTE);

        Prestamo prestamo = this.fabricaPrestamo.crearPrestamo(new ComandoPrestamo(libro, nombreCliente));
        this.servicioBibliotecario.prestar(prestamo);
    }
}
