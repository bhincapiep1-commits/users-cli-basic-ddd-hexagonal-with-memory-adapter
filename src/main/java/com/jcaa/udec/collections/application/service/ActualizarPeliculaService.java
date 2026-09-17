package com.jcaa.udec.collections.application.service;

import com.jcaa.udec.collections.application.service.dto.command.CrearPeliculaComando;
import com.jcaa.udec.collections.application.service.ports.in.ActualizarPeliculaUseCase;
import com.jcaa.udec.collections.domain.core.model.Pelicula;
import com.jcaa.udec.collections.domain.port.out.ActualizarPeliculaPort;

public class ActualizarPeliculaService implements ActualizarPeliculaUseCase {

    private final ActualizarPeliculaPort actualizarPeliculaPort;

    public ActualizarPeliculaService(ActualizarPeliculaPort actualizarPeliculaPort) {
        this.actualizarPeliculaPort = actualizarPeliculaPort;
    }

    @Override
    public void actualizar(CrearPeliculaComando comando) {
        Pelicula pelicula = Pelicula.builder()
                .id(comando.id())
                .titulo(comando.titulo())
                .genero(comando.genero())
                .idiomaOriginal(comando.idiomaOriginal())
                .subtitulosEspanol(comando.subtitulosEspanol())
                .paisesOrigen(comando.paisesOrigen())
                .anioProduccion(comando.anioProduccion())
                .duracion(comando.duracion())
                .clasificacionEdad(comando.clasificacionEdad())
                .fechaEstreno(comando.fechaEstreno())
                .resumen(comando.resumen())
                .director(comando.director())
                .elenco(comando.elenco())
                .build();

        actualizarPeliculaPort.actualizar(pelicula);
    }
}