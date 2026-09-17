package com.jcaa.udec.collections.application.service.ports.in;

import com.jcaa.udec.collections.application.service.dto.query.ObtenerPeliculaConsulta;
import com.jcaa.udec.collections.domain.core.model.Pelicula;

import java.util.List;

public interface ObtenerPeliculaUseCase {

    List<Pelicula> obtenerTodos();

    Pelicula obtenerPorId(ObtenerPeliculaConsulta consulta);
}