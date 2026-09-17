package com.jcaa.udec.collections.domain.port.out;

import com.jcaa.udec.collections.domain.core.model.Pelicula;

import java.util.List;

public interface ObtenerPeliculasPort {

    List<Pelicula> obtenerTodos();

    Pelicula buscarPorId(String id);
}