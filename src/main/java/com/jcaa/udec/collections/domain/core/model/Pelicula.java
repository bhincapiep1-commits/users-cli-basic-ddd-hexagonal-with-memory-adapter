package com.jcaa.udec.collections.domain.core.model;

import lombok.Builder;

public class Pelicula {

    private final String id;
    private final String titulo;
    private final String genero;
    private final String idiomaOriginal;
    private final boolean subtitulosEspanol;
    private final String paisesOrigen;
    private final int anioProduccion;
    private final int duracion;
    private final String clasificacionEdad;
    private final String fechaEstreno;
    private final String resumen;
    private final String director;
    private final String elenco;

    @Builder
    public Pelicula(
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
            String elenco) {

        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.idiomaOriginal = idiomaOriginal;
        this.subtitulosEspanol = subtitulosEspanol;
        this.paisesOrigen = paisesOrigen;
        this.anioProduccion = anioProduccion;
        this.duracion = duracion;
        this.clasificacionEdad = clasificacionEdad;
        this.fechaEstreno = fechaEstreno;
        this.resumen = resumen;
        this.director = director;
        this.elenco = elenco;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public boolean isSubtitulosEspanol() {
        return subtitulosEspanol;
    }

    public String getPaisesOrigen() {
        return paisesOrigen;
    }

    public int getAnioProduccion() {
        return anioProduccion;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public String getResumen() {
        return resumen;
    }

    public String getDirector() {
        return director;
    }

    public String getElenco() {
        return elenco;
    }
}