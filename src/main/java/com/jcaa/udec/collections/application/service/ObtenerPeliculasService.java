package com.jcaa.udec.collections.application.service;

import com.jcaa.udec.collections.application.service.dto.query.ObtenerPeliculaConsulta;
import com.jcaa.udec.collections.application.service.ports.in.ObtenerPeliculaUseCase;
import com.jcaa.udec.collections.domain.core.model.Pelicula;
import com.jcaa.udec.collections.domain.port.out.ObtenerPeliculasPort;

import java.util.List;

public class ObtenerPeliculasService implements ObtenerPeliculaUseCase {

    private final ObtenerPeliculasPort obtenerPeliculasPort;

    public ObtenerPeliculasService(ObtenerPeliculasPort obtenerPeliculasPort) {
        this.obtenerPeliculasPort = obtenerPeliculasPort;
    }

    @Override
    public List<Pelicula> obtenerTodos() {
        return obtenerPeliculasPort.obtenerTodos();
    }

    @Override
    public Pelicula obtenerPorId(ObtenerPeliculaConsulta consulta) {
        return obtenerPeliculasPort.buscarPorId(consulta.id());
    }
}