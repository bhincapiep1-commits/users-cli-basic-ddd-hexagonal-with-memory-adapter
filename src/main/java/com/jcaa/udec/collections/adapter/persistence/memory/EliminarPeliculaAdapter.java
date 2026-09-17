package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Pelicula;
import com.jcaa.udec.collections.domain.port.out.EliminarPeliculaPort;

import java.util.List;

public class EliminarPeliculaAdapter implements EliminarPeliculaPort {

    private final List<Pelicula> peliculas = PeliculasMemoria.obtenerPeliculas();

    @Override
    public void eliminarPorId(String id) {
        peliculas.removeIf(pelicula -> pelicula.getId().equals(id));
    }
}