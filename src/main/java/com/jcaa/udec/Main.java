package com.jcaa.udec;

import com.jcaa.udec.collections.adapter.persistence.memory.ActualizarPeliculaAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.EliminarPeliculaAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.GuardarPeliculaAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.GuardarUsuarioAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.ObtenerPeliculasAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.ObtenerUsuariosAdapter;
import com.jcaa.udec.collections.application.service.ActualizarPeliculaService;
import com.jcaa.udec.collections.application.service.AgregarPeliculaService;
import com.jcaa.udec.collections.application.service.AgregarUsuarioService;
import com.jcaa.udec.collections.application.service.EliminarPeliculaService;
import com.jcaa.udec.collections.application.service.ObtenerPeliculasService;
import com.jcaa.udec.collections.application.service.ObtenerUsuariosService;
import com.jcaa.udec.collections.application.service.ports.in.ActualizarPeliculaUseCase;
import com.jcaa.udec.collections.application.service.ports.in.AgregarPeliculaUseCase;
import com.jcaa.udec.collections.application.service.ports.in.AgregarUsuarioUseCase;
import com.jcaa.udec.collections.application.service.ports.in.EliminarPeliculaUseCase;
import com.jcaa.udec.collections.application.service.ports.in.ObtenerPeliculaUseCase;
import com.jcaa.udec.collections.application.service.ports.in.ObtenerUsuarioUseCase;
import com.jcaa.udec.collections.domain.port.out.ActualizarPeliculaPort;
import com.jcaa.udec.collections.domain.port.out.EliminarPeliculaPort;
import com.jcaa.udec.collections.domain.port.out.GuardarPeliculaPort;
import com.jcaa.udec.collections.domain.port.out.GuardarUsuarioPort;
import com.jcaa.udec.collections.domain.port.out.ObtenerPeliculasPort;
import com.jcaa.udec.collections.domain.port.out.ObtenerUsuariosPort;
import com.jcaa.udec.collections.entrypoint.cli.GuiCli;
import com.jcaa.udec.collections.entrypoint.controller.PeliculaControlador;
import com.jcaa.udec.collections.entrypoint.controller.PeliculaControladorImpl;
import com.jcaa.udec.collections.entrypoint.controller.UsuarioControlador;
import com.jcaa.udec.collections.entrypoint.controller.UsuarioControladorImpl;

public class Main {

    public static void main(String[] args) {

        GuardarUsuarioPort guardarUsuarioPort = new GuardarUsuarioAdapter();
        ObtenerUsuariosPort obtenerUsuariosPort = new ObtenerUsuariosAdapter();

        AgregarUsuarioUseCase agregarUsuarioUseCase =
                new AgregarUsuarioService(guardarUsuarioPort);

        ObtenerUsuarioUseCase obtenerUsuarioUseCase =
                new ObtenerUsuariosService(obtenerUsuariosPort);

        UsuarioControlador usuarioControlador =
                new UsuarioControladorImpl(
                        agregarUsuarioUseCase,
                        obtenerUsuarioUseCase);

        GuardarPeliculaPort guardarPeliculaPort =
                new GuardarPeliculaAdapter();

        ObtenerPeliculasPort obtenerPeliculasPort =
                new ObtenerPeliculasAdapter();

        ActualizarPeliculaPort actualizarPeliculaPort =
                new ActualizarPeliculaAdapter();

        EliminarPeliculaPort eliminarPeliculaPort =
                new EliminarPeliculaAdapter();

        AgregarPeliculaUseCase agregarPeliculaUseCase =
                new AgregarPeliculaService(guardarPeliculaPort);

        ObtenerPeliculaUseCase obtenerPeliculaUseCase =
                new ObtenerPeliculasService(obtenerPeliculasPort);

        ActualizarPeliculaUseCase actualizarPeliculaUseCase =
                new ActualizarPeliculaService(actualizarPeliculaPort);

        EliminarPeliculaUseCase eliminarPeliculaUseCase =
                new EliminarPeliculaService(eliminarPeliculaPort);

        PeliculaControlador peliculaControlador =
                new PeliculaControladorImpl(
                        agregarPeliculaUseCase,
                        obtenerPeliculaUseCase,
                        actualizarPeliculaUseCase,
                        eliminarPeliculaUseCase);

        GuiCli guiCli =
                new GuiCli(usuarioControlador, peliculaControlador);

        guiCli.ejecutarAccion();
    }
}
