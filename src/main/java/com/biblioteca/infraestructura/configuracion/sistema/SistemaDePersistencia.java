package com.biblioteca.infraestructura.configuracion.sistema;

import com.biblioteca.dominio.repositorio.RepositorioLibro;
import com.biblioteca.dominio.repositorio.RepositorioPrestamo;
import com.biblioteca.infraestructura.configuracion.conexion.ConexionJPA;
import com.biblioteca.infraestructura.persistencia.repositorio.RepositorioLibroPersistente;
import com.biblioteca.infraestructura.persistencia.repositorio.RepositorioPrestamoPersistente;

import javax.persistence.EntityManager;

public class SistemaDePersistencia {

    private final EntityManager entityManager;

    public SistemaDePersistencia() {
        this.entityManager = new ConexionJPA().createEntityManager();
    }

    public RepositorioLibro obtenerRepositorioLibros() {
        return new RepositorioLibroPersistente(entityManager);
    }

    public RepositorioPrestamo obtenerRepositorioPrestamos() {
        return new RepositorioPrestamoPersistente(entityManager, this.obtenerRepositorioLibros());
    }

    public void iniciar() {
        entityManager.getTransaction().begin();
    }

    public void terminar() {
        entityManager.getTransaction().commit();
    }
}
