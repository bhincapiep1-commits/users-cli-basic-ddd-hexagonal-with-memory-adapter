package com.jcaa.udec.collections.application.service;

import com.jcaa.udec.collections.application.service.dto.command.CrearPeliculaComando;
import com.jcaa.udec.collections.application.service.ports.in.AgregarPeliculaUseCase;
import com.jcaa.udec.collections.domain.core.model.Pelicula;
import com.jcaa.udec.collections.domain.port.out.GuardarPeliculaPort;

public class AgregarPeliculaService implements AgregarPeliculaUseCase {

    private final GuardarPeliculaPort guardarPeliculaPort;

    public AgregarPeliculaService(GuardarPeliculaPort guardarPeliculaPort) {
        this.guardarPeliculaPort = guardarPeliculaPort;
    }

    @Override
    public void guardar(CrearPeliculaComando comando) {
        Pelicula pelicula = Pelicula.builder()
                .titulo(comando.titulo())
                .id(comando.id())
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

        guardarPeliculaPort.guardar(pelicula);
    }
}