package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Pelicula;
import com.jcaa.udec.collections.domain.port.out.GuardarPeliculaPort;

import java.util.List;

public class GuardarPeliculaAdapter implements GuardarPeliculaPort {

    private final List<Pelicula> peliculas = PeliculasMemoria.obtenerPeliculas();

    @Override
    public void guardar(Pelicula pelicula) {
        peliculas.add(pelicula);
    }
}