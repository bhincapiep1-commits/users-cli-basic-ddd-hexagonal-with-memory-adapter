package com.jcaa.udec.collections.application.service.ports.in;

import com.jcaa.udec.collections.application.service.dto.command.CrearPeliculaComando;

public interface AgregarPeliculaUseCase {
    void guardar(CrearPeliculaComando comando);
}