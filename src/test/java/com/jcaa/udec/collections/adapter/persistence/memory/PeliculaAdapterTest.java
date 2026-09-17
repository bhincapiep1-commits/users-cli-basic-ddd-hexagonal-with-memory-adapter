package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Pelicula;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeliculaAdapterTest {

    @Test
    void debeGuardarUnaPelicula() {
        Pelicula pelicula = Pelicula.builder()
                .titulo("Interestelar")
                .id("P001")
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

        GuardarPeliculaAdapter adapter = new GuardarPeliculaAdapter();

        adapter.guardar(pelicula);

        assertEquals(1, PeliculasMemoria.obtenerPeliculas().size());
        assertEquals("Interestelar", PeliculasMemoria.obtenerPeliculas().get(0).getTitulo());
    }
}