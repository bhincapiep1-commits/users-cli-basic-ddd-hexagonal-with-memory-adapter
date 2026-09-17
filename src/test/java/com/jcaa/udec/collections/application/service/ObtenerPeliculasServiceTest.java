package com.jcaa.udec.collections.application.service;

import com.jcaa.udec.collections.application.service.dto.query.ObtenerPeliculaConsulta;
import com.jcaa.udec.collections.adapter.persistence.memory.GuardarPeliculaAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.ObtenerPeliculasAdapter;
import com.jcaa.udec.collections.domain.core.model.Pelicula;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ObtenerPeliculasServiceTest {

    @Test
    void debeObtenerTodasLasPeliculas() {
        GuardarPeliculaAdapter guardarAdapter = new GuardarPeliculaAdapter();
        ObtenerPeliculasAdapter obtenerAdapter = new ObtenerPeliculasAdapter();

        Pelicula pelicula = Pelicula.builder()
                .id("P001")
                .titulo("Interestelar")
                .genero("Ciencia ficción")
                .idiomaOriginal("Inglés")
                .subtitulosEspanol(true)
                .paisesOrigen("Estados Unidos")
                .anioProduccion(2014)
                .duracion(169)
                .clasificacionEdad("13+")
                .fechaEstreno("2014-11-07")
                .resumen("Un grupo de astronautas viaja a través de un agujero de gusano.")
                .director("Christopher Nolan")
                .elenco("Matthew McConaughey, Anne Hathaway")
                .build();

        guardarAdapter.guardar(pelicula);

        ObtenerPeliculasService service = new ObtenerPeliculasService(obtenerAdapter);

        List<Pelicula> peliculas = service.obtenerTodos();

        assertNotNull(peliculas);
        assertEquals("Interestelar", peliculas.get(peliculas.size() - 1).getTitulo());
    }

    @Test
    void debeObtenerPeliculaPorId() {
        GuardarPeliculaAdapter guardarAdapter = new GuardarPeliculaAdapter();
        ObtenerPeliculasAdapter obtenerAdapter = new ObtenerPeliculasAdapter();

        Pelicula pelicula = Pelicula.builder()
                .id("P002")
                .titulo("Matrix")
                .genero("Ciencia ficción")
                .idiomaOriginal("Inglés")
                .subtitulosEspanol(true)
                .paisesOrigen("Estados Unidos")
                .anioProduccion(1999)
                .duracion(136)
                .clasificacionEdad("13+")
                .fechaEstreno("1999-06-11")
                .resumen("Un programador descubre una realidad simulada.")
                .director("Lana y Lilly Wachowski")
                .elenco("Keanu Reeves, Laurence Fishburne")
                .build();

        guardarAdapter.guardar(pelicula);

        ObtenerPeliculasService service = new ObtenerPeliculasService(obtenerAdapter);

        Pelicula resultado = service.obtenerPorId(
                new ObtenerPeliculaConsulta("P002")
        );

        assertNotNull(resultado);
        assertEquals("P002", resultado.getId());
        assertEquals("Matrix", resultado.getTitulo());
    }
}