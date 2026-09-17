package com.jcaa.udec.collections.entrypoint.controller;

import com.jcaa.udec.collections.application.service.dto.command.CrearPeliculaComando;
import com.jcaa.udec.collections.application.service.dto.query.ObtenerPeliculaConsulta;
import com.jcaa.udec.collections.domain.core.model.Pelicula;

import java.util.List;

public interface PeliculaControlador {

    void agregar(CrearPeliculaComando comando);

    Pelicula buscarPorId(ObtenerPeliculaConsulta consulta);

    List<Pelicula> mostrarTodos();

    void actualizar(CrearPeliculaComando comando);

    void eliminarPorId(String id);
}