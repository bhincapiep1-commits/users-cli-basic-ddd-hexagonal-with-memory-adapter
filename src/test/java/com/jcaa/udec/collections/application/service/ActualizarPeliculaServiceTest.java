package com.jcaa.udec.collections.application.service;

import com.jcaa.udec.collections.application.service.dto.command.CrearPeliculaComando;
import com.jcaa.udec.collections.adapter.persistence.memory.GuardarPeliculaAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.ObtenerPeliculasAdapter;
import com.jcaa.udec.collections.domain.core.model.Pelicula;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActualizarPeliculaServiceTest {

    @Test
    void debeActualizarUnaPelicula() {
        GuardarPeliculaAdapter guardarAdapter = new GuardarPeliculaAdapter();
        ObtenerPeliculasAdapter obtenerAdapter = new ObtenerPeliculasAdapter();

        Pelicula peliculaOriginal = Pelicula.builder()
                .id("P003")
                .titulo("Avatar")
                .genero("Ciencia ficción")
                .idiomaOriginal("Inglés")
                .subtitulosEspanol(true)
                .paisesOrigen("Estados Unidos")
                .anioProduccion(2009)
                .duracion(162)
                .clasificacionEdad("13+")
                .fechaEstreno("2009-12-18")
                .resumen("Una historia en el planeta Pandora.")
                .director("James Cameron")
                .elenco("Sam Worthington, Zoe Saldana")
                .build();

        guardarAdapter.guardar(peliculaOriginal);

        ActualizarPeliculaService service =
                new ActualizarPeliculaService(new com.jcaa.udec.collections.adapter.persistence.memory.ActualizarPeliculaAdapter());

        CrearPeliculaComando comando = new CrearPeliculaComando(
                "P003",
                "Avatar: El camino del agua",
                "Ciencia ficción",
                "Inglés",
                true,
                "Estados Unidos",
                2022,
                192,
                "13+",
                "2022-12-16",
                "La familia Sully enfrenta nuevas amenazas en Pandora.",
                "James Cameron",
                "Sam Worthington, Zoe Saldana"
        );

        service.actualizar(comando);

        Pelicula resultado = obtenerAdapter.buscarPorId("P003");

        assertEquals("Avatar: El camino del agua", resultado.getTitulo());
        assertEquals(192, resultado.getDuracion());
        assertEquals(2022, resultado.getAnioProduccion());
    }
}