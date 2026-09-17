package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

final class PeliculasMemoria {
    private static final List<Pelicula> PELICULAS = new ArrayList<>();

    private PeliculasMemoria() {
    }

    static List<Pelicula> obtenerPeliculas() {
        return PELICULAS;
    }
}