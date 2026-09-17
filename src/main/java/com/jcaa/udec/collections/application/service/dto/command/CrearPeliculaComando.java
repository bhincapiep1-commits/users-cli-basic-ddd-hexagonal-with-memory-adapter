package com.jcaa.udec.collections.application.service.dto.command;

public record CrearPeliculaComando(
        String id,
        String titulo,
        String genero,
        String idiomaOriginal,
        boolean subtitulosEspanol,
        String paisesOrigen,
        int anioProduccion,
        int duracion,
        String clasificacionEdad,
        String fechaEstreno,
        String resumen,
        String director,
        String elenco
) {}