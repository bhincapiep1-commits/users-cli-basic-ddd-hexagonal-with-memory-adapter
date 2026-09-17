package com.jcaa.udec.collections.entrypoint.controller;

import com.jcaa.udec.collections.application.service.ports.in.EliminarPeliculaUseCase;

public class PeliculaControladorImpl implements PeliculaControlador {

    private final EliminarPeliculaUseCase eliminarPeliculaUseCase;

    public PeliculaControladorImpl(EliminarPeliculaUseCase eliminarPeliculaUseCase) {
        this.eliminarPeliculaUseCase = eliminarPeliculaUseCase;
    }

    @Override
    public void eliminarPorId(String id) {
        eliminarPeliculaUseCase.eliminarPorId(id);
    }
}