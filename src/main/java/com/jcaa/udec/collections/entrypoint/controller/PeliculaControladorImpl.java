package com.jcaa.udec.collections.entrypoint.controller;

import com.jcaa.udec.collections.application.service.dto.command.CrearPeliculaComando;
import com.jcaa.udec.collections.application.service.dto.query.ObtenerPeliculaConsulta;
import com.jcaa.udec.collections.application.service.ports.in.ActualizarPeliculaUseCase;
import com.jcaa.udec.collections.application.service.ports.in.AgregarPeliculaUseCase;
import com.jcaa.udec.collections.application.service.ports.in.EliminarPeliculaUseCase;
import com.jcaa.udec.collections.application.service.ports.in.ObtenerPeliculaUseCase;
import com.jcaa.udec.collections.domain.core.model.Pelicula;

import java.util.List;

public class PeliculaControladorImpl implements PeliculaControlador {

    private final AgregarPeliculaUseCase agregarPeliculaUseCase;
    private final ObtenerPeliculaUseCase obtenerPeliculaUseCase;
    private final ActualizarPeliculaUseCase actualizarPeliculaUseCase;
    private final EliminarPeliculaUseCase eliminarPeliculaUseCase;

    public PeliculaControladorImpl(
            AgregarPeliculaUseCase agregarPeliculaUseCase,
            ObtenerPeliculaUseCase obtenerPeliculaUseCase,
            ActualizarPeliculaUseCase actualizarPeliculaUseCase,
            EliminarPeliculaUseCase eliminarPeliculaUseCase) {

        this.agregarPeliculaUseCase = agregarPeliculaUseCase;
        this.obtenerPeliculaUseCase = obtenerPeliculaUseCase;
        this.actualizarPeliculaUseCase = actualizarPeliculaUseCase;
        this.eliminarPeliculaUseCase = eliminarPeliculaUseCase;
    }

    @Override
    public void agregar(CrearPeliculaComando comando) {
        agregarPeliculaUseCase.guardar(comando);
    }

    @Override
    public Pelicula buscarPorId(ObtenerPeliculaConsulta consulta) {
        return obtenerPeliculaUseCase.obtenerPorId(consulta);
    }

    @Override
    public List<Pelicula> mostrarTodos() {
        return obtenerPeliculaUseCase.obtenerTodos();
    }

    @Override
    public void actualizar(CrearPeliculaComando comando) {
        actualizarPeliculaUseCase.actualizar(comando);
    }

    @Override
    public void eliminarPorId(String id) {
        eliminarPeliculaUseCase.eliminarPorId(id);
    }
}