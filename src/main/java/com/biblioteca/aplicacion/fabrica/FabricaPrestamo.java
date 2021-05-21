package com.biblioteca.aplicacion.fabrica;

import com.biblioteca.aplicacion.comando.ComandoPrestamo;
import com.biblioteca.dominio.Libro;
import com.biblioteca.dominio.Prestamo;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class FabricaPrestamo {

    public Prestamo crearPrestamo(ComandoPrestamo comandoPrestamo){
        Libro libro =  comandoPrestamo.getLibro();
        Date fechaActual = Calendar.getInstance().getTime();
        Date fechaMaxima = calcularFechaEntrega(libro.getIsbn(), fechaActual);
        return new Prestamo(fechaActual, libro, fechaMaxima, comandoPrestamo.getNombreCliente());
    }


    private Date calcularFechaEntrega(String isbn, Date fechaIni){
        int suma = 0;
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaIni);

        for(int i=0; i<isbn.length();i++){if(Character.isDigit(isbn.charAt(i))) suma += Integer.parseInt(String.valueOf(isbn.charAt(i)));}

        if(suma <= 30) return null;

        fecha.setTime(fechaIni);
        int dias = fecha.get(Calendar.DAY_OF_WEEK)==1 || fecha.get(Calendar.DAY_OF_WEEK)==6 ? 17 : 16;

        fecha.add(Calendar.DAY_OF_YEAR,dias);

        return fecha.getTime();
    }
}
