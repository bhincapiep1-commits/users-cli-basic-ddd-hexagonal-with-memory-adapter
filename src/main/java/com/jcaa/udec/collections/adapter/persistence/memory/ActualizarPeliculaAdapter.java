package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Pelicula;
import com.jcaa.udec.collections.domain.port.out.ActualizarPeliculaPort;

import java.util.List;

public class ActualizarPeliculaAdapter implements ActualizarPeliculaPort {

    private final List<Pelicula> peliculas = PeliculasMemoria.obtenerPeliculas();

    @Override
    public void actualizar(Pelicula pelicula) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getId().equals(pelicula.getId())) {
                peliculas.set(i, pelicula);
                return;
            }
        }
    }
}