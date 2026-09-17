package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Pelicula;
import com.jcaa.udec.collections.domain.port.out.ObtenerPeliculasPort;

import java.util.List;

public class ObtenerPeliculasAdapter implements ObtenerPeliculasPort {

    private final List<Pelicula> peliculas = PeliculasMemoria.obtenerPeliculas();

    @Override
    public List<Pelicula> obtenerTodos() {
        return peliculas;
    }

    @Override
    public Pelicula buscarPorId(String id) {
        return peliculas.stream()
                .filter(pelicula -> pelicula.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}