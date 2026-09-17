package com.jcaa.udec.collections.entrypoint.cli;

import com.jcaa.udec.collections.application.service.dto.command.CrearPeliculaComando;
import com.jcaa.udec.collections.application.service.dto.query.ObtenerPeliculaConsulta;
import com.jcaa.udec.collections.domain.core.exception.UsuarioInvalidoException;
import com.jcaa.udec.collections.domain.core.exception.UsuarioNoExisteException;
import com.jcaa.udec.collections.domain.core.exception.UsuarioYaExisteException;
import com.jcaa.udec.collections.domain.core.model.Pelicula;
import com.jcaa.udec.collections.domain.core.valueobject.Email;
import com.jcaa.udec.collections.domain.core.valueobject.NombreUsuario;
import com.jcaa.udec.collections.domain.core.valueobject.Password;
import com.jcaa.udec.collections.domain.core.valueobject.UsuarioId;
import com.jcaa.udec.collections.entrypoint.controller.PeliculaControlador;
import com.jcaa.udec.collections.entrypoint.controller.UsuarioControlador;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.RegistrarUsuarioPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.response.ObtenerUsuarioResponse;

import java.util.List;
import java.util.Scanner;

public class GuiCli {

    private static final int OPCION_AGREGAR_USUARIO = 1;
    private static final int OPCION_BUSCAR_USUARIO = 2;
    private static final int OPCION_MOSTRAR_USUARIOS = 3;
    private static final int OPCION_AGREGAR_PELICULA = 4;
    private static final int OPCION_BUSCAR_PELICULA = 5;
    private static final int OPCION_MOSTRAR_PELICULAS = 6;
    private static final int OPCION_ACTUALIZAR_PELICULA = 7;
    private static final int OPCION_ELIMINAR_PELICULA = 8;
    private static final int OPCION_SALIR = 9;

    private static final String TEXTO_TITULO =
            "** EJEMPLO DE USO DE LISTAS Y HEXAGONAL **";
    private static final String SEPARADOR = "- - - - - - - - - ";
    private static final String OPCIONES = "Opciones:";

    private static final String SOLICITUD_ID = "ID: ";
    private static final String SOLICITUD_PASSWORD = "PASSWORD: ";
    private static final String SOLICITUD_NOMBRE = "NOMBRE: ";
    private static final String SOLICITUD_EMAIL = "EMAIL: ";

    private static final String MENSAJE_OPCION_INVALIDA =
            "Opcion [%s] invalida";
    private static final String MENSAJE_ERROR = "ERROR: ";

    private static final String MARCA_ORDEN_BYTES = "\uFEFF";
    private static final String TEXTO_VACIO = "";

    private final UsuarioControlador usuarioControlador;
    private final PeliculaControlador peliculaControlador;
    private final Scanner entrada;

    public GuiCli(
            UsuarioControlador usuarioControlador,
            PeliculaControlador peliculaControlador) {
        this(usuarioControlador, peliculaControlador, new Scanner(System.in));
    }

    GuiCli(
            UsuarioControlador usuarioControlador,
            PeliculaControlador peliculaControlador,
            Scanner entrada) {
        this.usuarioControlador = usuarioControlador;
        this.peliculaControlador = peliculaControlador;
        this.entrada = entrada;
    }

    public int obtenerOpcionMenu() {
        do {
            mostrarMenu();
            String valorIngresado = limpiarEntrada(entrada.nextLine());

            try {
                int opcion = Integer.parseInt(valorIngresado);

                if (opcion >= OPCION_AGREGAR_USUARIO
                        && opcion <= OPCION_SALIR) {
                    return opcion;
                }
            } catch (NumberFormatException exception) {
                // Entrada invalida.
            }

            System.out.printf(MENSAJE_OPCION_INVALIDA + "%n", valorIngresado);
        } while (true);
    }

    public void ejecutarAccion() {
        boolean continuar = true;

        while (continuar) {
            int opcion = obtenerOpcionMenu();

            try {
                switch (opcion) {
                    case OPCION_AGREGAR_USUARIO -> registrarUsuario();
                    case OPCION_BUSCAR_USUARIO -> mostrarUsuarioPorId();
                    case OPCION_MOSTRAR_USUARIOS -> mostrarTodosLosUsuarios();
                    case OPCION_AGREGAR_PELICULA -> agregarPelicula();
                    case OPCION_BUSCAR_PELICULA -> buscarPelicula();
                    case OPCION_MOSTRAR_PELICULAS -> mostrarTodasLasPeliculas();
                    case OPCION_ACTUALIZAR_PELICULA -> actualizarPelicula();
                    case OPCION_ELIMINAR_PELICULA -> eliminarPelicula();
                    case OPCION_SALIR -> continuar = false;
                }
            } catch (UsuarioInvalidoException
                    | UsuarioNoExisteException
                    | UsuarioYaExisteException exception) {
                System.out.println(MENSAJE_ERROR + exception.getMessage());
            }
        }

        System.out.println("Esperamos tu regreso. Bye, Bye");
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println(TEXTO_TITULO);
        System.out.println(SEPARADOR);
        System.out.println(OPCIONES);
        System.out.println(SEPARADOR);
        System.out.println("1 - Agregar usuario");
        System.out.println("2 - Buscar usuario por Id");
        System.out.println("3 - Ver todos los usuarios");
        System.out.println("4 - Agregar pelicula");
        System.out.println("5 - Buscar pelicula por Id");
        System.out.println("6 - Ver todas las peliculas");
        System.out.println("7 - Actualizar pelicula");
        System.out.println("8 - Eliminar pelicula");
        System.out.println("9 - Salir");
        System.out.print("Ingrese el numero de la opcion: ");
    }

    private void registrarUsuario() {
        usuarioControlador.registrar(capturarDatosUsuario());
        System.out.println("Usuario registrado correctamente.");
    }

    private void mostrarUsuarioPorId() {
        System.out.println(usuarioControlador.obtenerPorId(capturarId()));
    }

    private void mostrarTodosLosUsuarios() {
        ObtenerUsuarioResponse response = usuarioControlador.obtenerTodos();

        if (response.estaVacia()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        System.out.println(response);
    }

    private void agregarPelicula() {
        peliculaControlador.agregar(capturarDatosPelicula());
        System.out.println("Pelicula agregada correctamente.");
    }

    private void buscarPelicula() {
        String id = capturarId();
        Pelicula pelicula = peliculaControlador.buscarPorId(
                new ObtenerPeliculaConsulta(id));
        System.out.println(pelicula);
    }

    private void mostrarTodasLasPeliculas() {
        List<Pelicula> peliculas = peliculaControlador.mostrarTodos();

        if (peliculas.isEmpty()) {
            System.out.println("No hay peliculas registradas.");
            return;
        }

        peliculas.forEach(System.out::println);
    }

    private void actualizarPelicula() {
        peliculaControlador.actualizar(capturarDatosPelicula());
        System.out.println("Pelicula actualizada correctamente.");
    }

    private void eliminarPelicula() {
        String id = capturarId();
        peliculaControlador.eliminarPorId(id);
        System.out.println("Pelicula eliminada correctamente.");
    }

    private CrearPeliculaComando capturarDatosPelicula() {
        System.out.println();
        System.out.println("** INGRESE LOS DATOS DE LA PELICULA **");

        return new CrearPeliculaComando(
                capturarTexto("ID"),
                capturarTexto("TITULO"),
                capturarTexto("GENERO"),
                capturarTexto("IDIOMA ORIGINAL"),
                capturarBooleano(),
                capturarTexto("PAISES DE ORIGEN"),
                capturarEntero("AÑO DE PRODUCCION"),
                capturarEntero("DURACION"),
                capturarTexto("CLASIFICACION DE EDAD"),
                capturarTexto("FECHA DE ESTRENO"),
                capturarTexto("RESUMEN"),
                capturarTexto("DIRECTOR"),
                capturarTexto("ELENCO"));
    }

    private String capturarTexto(String campo) {
        System.out.print(campo + ": ");
        return limpiarEntrada(entrada.nextLine());
    }

    private boolean capturarBooleano() {
        System.out.print("SUBTITULOS EN ESPANOL (true/false): ");
        return Boolean.parseBoolean(limpiarEntrada(entrada.nextLine()));
    }

    private int capturarEntero(String campo) {
        while (true) {
            System.out.print(campo + ": ");

            try {
                return Integer.parseInt(
                        limpiarEntrada(entrada.nextLine()));
            } catch (NumberFormatException exception) {
                System.out.println("Debe ingresar un numero entero.");
            }
        }
    }

    private RegistrarUsuarioPeticion capturarDatosUsuario() {
        System.out.println();
        System.out.println("** INGRESE LOS DATOS DEL NUEVO USUARIO **");

        return new RegistrarUsuarioPeticion(
                capturarId(),
                capturarPassword(),
                capturarNombre(),
                capturarEmail());
    }

    private String capturarId() {
        do {
            System.out.print(SOLICITUD_ID);
            String id = limpiarEntrada(entrada.nextLine());

            if (esValido(() -> new UsuarioId(id))) {
                return id;
            }

            System.out.println("ID INVALIDO: debe ser un numero entero");
        } while (true);
    }

    private String capturarPassword() {
        do {
            System.out.print(SOLICITUD_PASSWORD);
            String password = entrada.nextLine();

            if (esValido(() -> new Password(password))) {
                return password;
            }

            System.out.println(
                    "PASSWORD INVALIDO: minimo 10 caracteres, "
                            + "con mayuscula, minuscula, numero y simbolo");
        } while (true);
    }

    private String capturarNombre() {
        do {
            System.out.print(SOLICITUD_NOMBRE);
            String nombre = limpiarEntrada(entrada.nextLine());

            if (esValido(() -> new NombreUsuario(nombre))) {
                return nombre;
            }

            System.out.println("NOMBRE INVALIDO: minimo 3 caracteres");
        } while (true);
    }

    private String capturarEmail() {
        do {
            System.out.print(SOLICITUD_EMAIL);
            String email = limpiarEntrada(entrada.nextLine());

            if (esValido(() -> new Email(email))) {
                return email;
            }

            System.out.println("EMAIL INVALIDO: ingrese un correo valido");
        } while (true);
    }

    private static String limpiarEntrada(String valor) {
        return valor.replace(MARCA_ORDEN_BYTES, TEXTO_VACIO).trim();
    }

    private static boolean esValido(Runnable validacion) {
        try {
            validacion.run();
            return true;
        } catch (UsuarioInvalidoException exception) {
            return false;
        }
    }
}