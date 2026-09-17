package com.jcaa.udec.collections.application.service;

import com.jcaa.udec.collections.application.service.ports.in.EliminarPeliculaUseCase;
import com.jcaa.udec.collections.domain.port.out.EliminarPeliculaPort;

public class EliminarPeliculaService implements EliminarPeliculaUseCase {

    private final EliminarPeliculaPort eliminarPeliculaPort;

    public EliminarPeliculaService(EliminarPeliculaPort eliminarPeliculaPort) {
        this.eliminarPeliculaPort = eliminarPeliculaPort;
    }

    @Override
    public void eliminarPorId(String id) {
        eliminarPeliculaPort.eliminarPorId(id);
    }
}