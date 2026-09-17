package com.jcaa.udec.collections.domain.port.out;

import com.jcaa.udec.collections.domain.core.model.Pelicula;

public interface GuardarPeliculaPort {
    void guardar(Pelicula pelicula);
}