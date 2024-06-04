package controller;

import model.Estudiante;
import model.EstudianteDAO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaDeGestion {

    private static final String[][] CARRERAS_PRESENCIALES = {
        {"Facultad de las Ciencias de la Salud", "1. Enfermería", "2. Fisioterapia", "3. Medicina", "4. Nutrición y Dietética"},
        {"Ciencias Económicas y Empresariales", "5. Administración de Empresas", "6. Contabilidad y Auditoría", "7. Economía", "8. Finanzas", "9. Gastronomía"},
        {"Ciencias Exactas y Naturales", "10. Agropecuaria", "11. Alimentos", "12. Biología", "13. Ingeniería Ambiental", "14. Ingeniería Industrial", "15. Ingeniería Química", "16. Bioquímica y Farmacia"},
        {"Ciencias Sociales, Educación y Humanidades", "17. Artes Escénicas", "18. Artes Visuales", "19. Pedagogía de los Idiomas Nacionales y Extranjeros", "20. Psicopedagogía", "21. Psicología", "22. Psicología Clínica", "23. Ciencias Jurídicas y Políticas", "24. Derecho"},
        {"Ingenierías y Arquitecturas", "25. Computación", "26. Geología", "27. Telecomunicaciones", "28. Arquitectura", "29. Ingeniería Civil"},
        {"Postgrados Presenciales", "30. Ciencias Químicas", "31. MBA con mención en Innovación - Presencial", "32. Medicina Familiar y Comunitaria", "33. Química", "34. Análisis Biológico y Diagnóstico de Laboratorio"},
        {"Tecnologías", "35. Comunicación Estrategia y Marketing Digital", "36. Transformación Digital de Empresas"}
    };

    private static final String[][] CARRERAS_VIRTUALES = {
        {"Ciencias Económicas y Empresariales", "1. Administración de Empresas", "2. Administración Pública", "3. Contabilidad y Auditoría", "4. Economía", "5. Finanzas", "6. Turismo"},
        {"Ciencias Exactas y Naturales", "7. Agronegocios", "8. Gestión Ambiental", "9. Gestión de Riesgos y Desastres", "10. Seguridad y Salud Ocupacional"},
        {"Ciencias Sociales, Educación y Humanismo", "11. Comunicación", "12. Educación Básica", "13. Educación Inicial", "14. Pedagogía de la Lengua y la Literatura", "15. Pedagogía de la Química y Biología", "16. Pedagogía de las Matemáticas y Física"},
        {"Ciencias Jurídicas y Políticas", "17. Derecho"},
        {"Ingenierías y Arquitecturas", "18. Logística y Transporte", "19. Tecnologías de la Información"},
        {"Postgrados Virtuales", "20. Comunicación Estratégica mención Comunicación Digital", "21. Derecho Constitucional", "22. Derecho Penal mención Derecho Procesal Penal", "23. Gerencia de Instituciones de Salud", "24. Gestión de la Calidad y Auditoría en Salud", "25. MBA con mención en Innovación - Distancia", "26. Pedagogía de los Idiomas Nacionales y Extranjeros, mención Enseñanza de Inglés", "27. Pedagogía en las Artes"},
        {"Tecnologías Virtuales", "28. Comunicación Estrategia y Marketing Digital", "29. Transformación Digital de Empresas"}
    };

    private static List<Estudiante> estudiantes = new ArrayList<>();
    private static EstudianteDAO estudianteDAO = new EstudianteDAO();

    public static void presentarCarreras() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------");
        System.out.println("Seleccione la modalidad:");
        System.out.println("1) Presencial");
        System.out.println("2) Virtual");
        int modalidad;
        while (true) {
            modalidad = scanner.nextInt();
            if (modalidad == 1 || modalidad == 2) {
                break;
            } else {
                System.out.println("Opción inválida. Por favor, seleccione 1 o 2.\n");
            }
        }
        scanner.nextLine(); // Consume el salto de línea

        String[][] carrerasPorCategoria = (modalidad == 1) ? CARRERAS_PRESENCIALES : CARRERAS_VIRTUALES;
        String modalidadTexto = (modalidad == 1) ? "Presencial" : "Virtual";

        System.out.println("/nLista de Carreras por Categoría (" + modalidadTexto + "):");
        for (String[] categoria : carrerasPorCategoria) {
            System.out.println(categoria[0] + ":");
            for (int i = 1; i < categoria.length; i++) {
                System.out.println(" - " + categoria[i]);
            }
        }
    }
    public static void procesoMatriculacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-------------------------");
        System.out.println("Proceso de Matriculación:");
        presentarCarreras();

        System.out.print("¿Cuántas carreras desea seleccionar? ");
        int numCarreras;
        while (true) {
            try {
                numCarreras = scanner.nextInt();
                if (numCarreras <= 0) {
                    throw new IllegalArgumentException("Número inválido. Debe ser mayor que 0.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
        scanner.nextLine(); // Consume el salto de línea

        List<String> carrerasSeleccionadas = new ArrayList<>();
        for (int i = 0; i < numCarreras; i++) {
            System.out.print("Ingrese el número de la carrera que desea seleccionar (" + (i + 1) + "/" + numCarreras + "): ");
            String carreraSeleccionada = seleccionarCarrera(scanner);
            carrerasSeleccionadas.add(carreraSeleccionada);
        }

        System.out.println("Carreras seleccionadas:");
        for (String carrera : carrerasSeleccionadas) {
            System.out.println(" - " + carrera);
        }

        guardarInformacionPostulante(carrerasSeleccionadas);
    }

    private static String seleccionarCarrera(Scanner scanner) {
        String[][] todasCarreras = new String[CARRERAS_PRESENCIALES.length + CARRERAS_VIRTUALES.length][];
        System.arraycopy(CARRERAS_PRESENCIALES, 0, todasCarreras, 0, CARRERAS_PRESENCIALES.length);
        System.arraycopy(CARRERAS_VIRTUALES, 0, todasCarreras, CARRERAS_PRESENCIALES.length, CARRERAS_VIRTUALES.length);

        int numCarrera;
        while (true) {
            try {
                numCarrera = scanner.nextInt();
                if (numCarrera <= 0) {
                    throw new IllegalArgumentException("Número inválido. Debe ser mayor que 0.");
                }
                boolean carreraValida = false;
                String carreraSeleccionada = null;
                for (String[] categoria : todasCarreras) {
                    for (int i = 1; i < categoria.length; i++) {
                        if (Integer.parseInt(categoria[i].split("\\.")[0]) == numCarrera) {
                            carreraValida = true;
                            carreraSeleccionada = categoria[i].substring(3); // Remueve el número y el punto
                            break;
                        }
                    }
                    if (carreraValida) {
                        return carreraSeleccionada;
                    }
                }
                if (!carreraValida) {
                    throw new IllegalArgumentException("Número de carrera no válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }

    public static double generarNotaAleatoria() {
        return ExamenesAdmisiones.asignarNotaAleatoria();
    }

    public static void guardarInformacionPostulante(List<String> carrerasSeleccionadas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---------------------------");
        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = scanner.nextLine();
        String[] nombreParts = nombreCompleto.split(" ");
        if (nombreParts.length < 2) {
            System.out.println("Error: Ingrese su nombre completo (nombre y apellido).");
            return;
        }

        String nombre = nombreParts[0];
        String apellido = nombreParts[1];

        System.out.print("Ingrese su número de cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Ingrese su teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();

        // Generar nota aleatoria entre 30 y 100
        double nota = generarNotaAleatoria();

        Estudiante estudiante = new Estudiante(nombre, apellido, cedula, telefono, correo, carrerasSeleccionadas, nota);
        estudiantes.add(estudiante);
        // Verificar discapacidad
        System.out.print("¿Tiene alguna discapacidad? (1/Sí)(2/No): ");
        int tieneDiscapacidad = scanner.nextInt();
        boolean esDiscapacitado = false;
        int porcentajeDiscapacidad = 0;

        if (tieneDiscapacidad == 1) {
            System.out.print("¿Cuánto porcentaje de discapacidad tiene? ");
            while (true) {
                try {
                    porcentajeDiscapacidad = scanner.nextInt();
                    if (porcentajeDiscapacidad < 0 || porcentajeDiscapacidad > 100) {
                        throw new IllegalArgumentException("Porcentaje inválido. Debe ser entre 0 y 100.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un número válido.");
                    scanner.nextLine(); // Limpiar el buffer del scanner
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    scanner.nextLine(); // Limpiar el buffer del scanner
                }
            }
            scanner.nextLine(); // Consume el salto de línea

            if (porcentajeDiscapacidad > 35) {
                System.out.println("Se le otorga un cupo en cualquier carrera que elija.");
                estudiante.setCupo(true);
            } else {
                System.out.println("No se lo toma en cuenta para un cupo de Discapacidad.");
                estudiante.setCupo(false);
            }
            esDiscapacitado = true;
        }

        // Verificar si es abanderado o escolta
        System.out.print("¿Fue abanderado o escolta? (1/Sí, 2/No): ");
        int esAbanderadoRespuesta = scanner.nextInt();
        boolean esAbanderado = esAbanderadoRespuesta == 1;

        if (esDiscapacitado) {
            estudiante.setDiscapacidad(true);
        }
        if (esAbanderado) {
            estudiante.setAbanderado(true);
        }

        estudianteDAO.agregarEstudiante(estudiante);
        System.out.println("\n----------------------------------");
        System.out.println("Información guardada exitosamente.");
        System.out.println("Correo Institucional: " + estudiante.getCorreoInstitucional());
        System.out.println("Contraseña: " + estudiante.getContrasena());
    }

    public static void mostrarInformacionPostulante() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
            System.out.println("Cédula: " + estudiante.getCedula());
            System.out.println("Teléfono: " + estudiante.getTelefono());
            System.out.println("Correo: " + estudiante.getCorreo());
            System.out.println("Correo Institucional: " + estudiante.getCorreoInstitucional());
            for (String carrera : estudiante.getCarreras()) {
                System.out.println("Carrera: " + carrera);
            }
            if (estudiante.isDiscapacidad()) {
                System.out.println("Tiene discapacidad.");
            }
            if (estudiante.isAbanderado()) {
                System.out.println("Es abanderado o escolta.");
            }
            System.out.println("-----------------------------");
        }
    }

    public static void mostrarFechaExamen() {
        System.out.println("\n------------------------------------------------");
        System.out.println("La fecha del examen de admisión es el 05/06/2024.");
    }

    public static void iniciarSesionEstudiante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------------------------------");
        System.out.print("Ingrese su correo institucional: ");
        String correoInstitucional = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Estudiante estudianteEncontrado = null;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCorreoInstitucional().equals(correoInstitucional) && estudiante.getContrasena().equals(contrasena)) {
                estudianteEncontrado = estudiante;
                break;
            }
        }
        if (estudianteEncontrado != null) {
            System.out.println("Inicio de sesión exitoso.");
            MenuEstudiante.mostrarMenuEstudiante(estudianteEncontrado);
        } else {
            System.out.println("Credenciales incorrectas. Por favor, intente de nuevo.");
        }
    }
}
