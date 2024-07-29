package View;
import Model.*;
import Controller.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class UTPL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ListaCarreras.inicializarCarreras();
        int opcionPrincipal;
        int opcionSecundaria;
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Panel De inscribsion 
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        do {
            System.out.println("\n------------------------------");
            System.out.println("| Bienvenidos a Admisiones UTPL |");
            System.out.println("------------------------------");
            System.out.println("| 1) Nuevos Estudiantes        |");
            System.out.println("| 2) Iniciar sesion estudiantes|");
            System.out.println("| 3) Panel Administrativo      |");
            System.out.println("| 4) Salir                     |");
            System.out.println("------------------------------");
            System.out.print("Ingrese el numero de su eleccion: ");
            opcionPrincipal = scanner.nextInt();
            switch (opcionPrincipal) {
                case 1:
                    do {
                        System.out.println("\n---------------------------------------");
                        System.out.println("|         Panel Estudiantes           |");
                        System.out.println("---------------------------------------");
                        System.out.println("| 1) Carreras disponibles             |");
                        System.out.println("| 2) Proceso de matriculacion         |");
                        System.out.println("| 3) Fechas del examen de admision    |");
                        System.out.println("| 4) Informacion del postulante       |");
                        System.out.println("| 5) Volver al menu principal         |");
                        System.out.println("---------------------------------------");
                        System.out.print("Ingrese el número de su elección: ");
                        opcionSecundaria = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcionSecundaria) {
                            case 1:
                                System.out.println("------------------------------------");
                                System.out.println("|        Carreras disponibles      |");
                                System.out.println("------------------------------------");
                                System.out.println("|        Modalidad Presencial      |");
                                System.out.println("------------------------------------");
                                for (Carrera carrera : ListaCarreras.carrerasPresenciales) {
                                    System.out.println("Facultad: " + carrera.getNombreFacultad());
                                    for (String c : carrera.getCarreras()) {
                                        System.out.println("  - " + c);
                                    }
                                }
                                System.out.println("------------------------------------");
                                System.out.println("|          Modalidad Virtual       |");
                                System.out.println("------------------------------------");
                                for (Carrera carrera : ListaCarreras.carrerasVirtuales) {
                                    System.out.println("Facultad: " + carrera.getNombreFacultad());
                                    for (String c : carrera.getCarreras()) {
                                        System.out.println("  - " + c);
                                    }
                                }
                                System.out.println("------------------------------------");
                                System.out.println("|          Modalidad Abierta       |");
                                System.out.println("------------------------------------");
                                for (Carrera carrera : ListaCarreras.ModalidadAbierta) {
                                    System.out.println("Facultad: " + carrera.getNombreFacultad());
                                    for (String c : carrera.getCarreras()) {
                                        System.out.println("  - " + c);
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("------------------------------------");
                                System.out.println("|   UTPL PROCESO DE MATRICULACION  |");
                                System.out.println("------------------------------------");
                                System.out.print("Ingrese sus dos nombres: ");
                                String nombres = scanner.nextLine();
                                System.out.print("Ingrese sus dos apellidos: ");
                                String apellidos = scanner.nextLine();
                                System.out.print("Ingrese su número de cedula: ");
                                String cedula = scanner.nextLine();
                                System.out.print("Ingrese su correo electronico: ");
                                String correoElectronico = scanner.nextLine();
                                System.out.print("Ingrese su numero telefonico: ");
                                String numeroTelefonico = scanner.nextLine();
                                System.out.print("¿Tiene usted alguna discapacidad? (1) Sí, (2) No: ");
                                int opcionDiscapacidad = scanner.nextInt();
                                scanner.nextLine();
                                boolean discapacidad = opcionDiscapacidad == 1;
                                int porcentajeDiscapacidad = 0;
                                if (discapacidad) {
                                    System.out.print("Ingrese el porcentaje de discapacidad (0-100): ");
                                    porcentajeDiscapacidad = scanner.nextInt();
                                    scanner.nextLine();
                                }
                                System.out.print("¿Fue abanderado o escolta al graduarse? (1) Sí, (2) No: ");
                                int opcionAbanderadoEscolta = scanner.nextInt();
                                scanner.nextLine();
                                boolean abanderadoEscolta = opcionAbanderadoEscolta == 1;
                                System.out.println("Seleccione el tipo de ciencia en el que se graduo de bachiller:");
                                System.out.println("1. Bachiller en Artes");
                                System.out.println("2. Bachiller en Ciencias y Tecnología");
                                System.out.println("3. Bachiller en Humanidades y Ciencias Sociales");
                                System.out.print("Ingrese el numero correspondiente a su tipo de bachillerato: ");
                                int opcionBachillerato = scanner.nextInt();
                                scanner.nextLine();
                                String tipoBachillerato;
                                switch (opcionBachillerato) {
                                    case 1:
                                        tipoBachillerato = "Bachiller en Artes";
                                        break;
                                    case 2:
                                        tipoBachillerato = "Bachiller en Ciencias y Tecnologia";
                                        break;
                                    case 3:
                                        tipoBachillerato = "Bachiller en Humanidades y Ciencias Sociales";
                                        break;
                                    default:
                                        tipoBachillerato = "Desconocido";
                                        break;
                                }
                                System.out.print("Ingrese la modalidad de estudio (1) Presencial, (2) Virtual, (3) Abierta: ");
                                int opcionModalidad = scanner.nextInt();
                                scanner.nextLine();
                                String modalidad;
                                List<Carrera> carrerasDisponibles;
                                if (opcionModalidad == 1) {
                                    modalidad = "Presencial";
                                    carrerasDisponibles = ListaCarreras.carrerasPresenciales;
                                } else if (opcionModalidad == 2) {
                                    modalidad = "Virtual";
                                    carrerasDisponibles = ListaCarreras.carrerasVirtuales;
                                } else if (opcionModalidad == 3) {
                                    modalidad = "Abierta";
                                    carrerasDisponibles = ListaCarreras.ModalidadAbierta;
                                } else {
                                    modalidad = "Desconocido";
                                    System.out.println("Modalidad seleccionada no válida.");
                                    break;
                                }
                                System.out.println("\nFacultades disponibles para la modalidad " + modalidad + ":");
                                String[] facultadesDisponibles = new String[carrerasDisponibles.size()];
                                int numFacultades = 0;
                                for (Carrera carrera : carrerasDisponibles) {
                                    boolean alreadyListed = false;
                                    for (int i = 0; i < numFacultades; i++) {
                                        if (facultadesDisponibles[i].equals(carrera.getNombreFacultad())) {
                                            alreadyListed = true;
                                            break;
                                        }
                                    }
                                    if (!alreadyListed) {
                                        facultadesDisponibles[numFacultades++] = carrera.getNombreFacultad();
                                    }
                                }
                                for (int i = 0; i < numFacultades; i++) {
                                    System.out.println((i + 1) + ". Facultad de " + facultadesDisponibles[i]);
                                }
                                System.out.print("Ingrese el numero de facultades que desea seleccionar: ");
                                int numFacultadesSeleccionadas = scanner.nextInt();
                                scanner.nextLine();
                                String[] facultadesSeleccionadas = new String[numFacultadesSeleccionadas];
                                for (int i = 0; i < numFacultadesSeleccionadas; i++) {
                                    System.out.print("Ingrese el numero de la facultad " + (i + 1) + ": ");
                                    int numFacultad = scanner.nextInt();
                                    scanner.nextLine();
                                    if (numFacultad >= 1 && numFacultad <= numFacultades) {
                                        facultadesSeleccionadas[i] = facultadesDisponibles[numFacultad - 1];
                                    } else {
                                        System.out.println("Numero de facultad no válido.");
                                        i--;
                                    }
                                }
                                List<String> carrerasSeleccionadas = new ArrayList<>();
                                for (String facultad : facultadesSeleccionadas) {
                                    System.out.println("\nCarreras disponibles en la facultad de " + facultad + ":");
                                    String[] carrerasEnFacultad = new String[carrerasDisponibles.size()];
                                    int numCarreras = 0;
                                    for (Carrera carrera : carrerasDisponibles) {
                                        if (carrera.getNombreFacultad().equals(facultad)) {
                                            for (String nombreCarrera : carrera.getCarreras()) {
                                                carrerasEnFacultad[numCarreras++] = nombreCarrera;
                                            }
                                        }
                                    }
                                    for (int i = 0; i < numCarreras; i++) {
                                        System.out.println((i + 1) + ". " + carrerasEnFacultad[i]);
                                    }
                                    System.out.print("¿Cuantas carreras desea seleccionar de la facultad de " + facultad + "? ");
                                    int numCarrerasSeleccionar = scanner.nextInt();
                                    scanner.nextLine();
                                    for (int i = 0; i < numCarrerasSeleccionar; i++) {
                                        System.out.print("Seleccione el numero de la carrera " + (i + 1) + " que desea de la facultad de " + facultad + ": ");
                                        int carreraSeleccionada = scanner.nextInt();
                                        scanner.nextLine();
                                        if (carreraSeleccionada >= 1 && carreraSeleccionada <= numCarreras) {
                                            String carreraNombre = carrerasEnFacultad[carreraSeleccionada - 1];
                                            if (!carrerasSeleccionadas.contains(carreraNombre)) {
                                                carrerasSeleccionadas.add(carreraNombre);
                                            } else {
                                                System.out.println("La carrera " + carreraNombre + " ya ha sido seleccionada.");
                                                i--;
                                            }
                                        } else {
                                            System.out.println("Numero de carrera no válido.");
                                            i--;
                                        }
                                    }
                                }
                                String[] nombresSplit = nombres.split(" ");
                                String[] apellidosSplit = apellidos.split(" ");
                                String correoInstitucional = nombresSplit[0].toLowerCase() + "." + apellidosSplit[0].toLowerCase() + "@utpl.edu.ec";
                                String contrasena = cedula;
                                int notaExamen = random.nextInt(31) + 70;
                                Estudiante postulante = new Estudiante(nombres, apellidos, cedula, correoElectronico, numeroTelefonico, modalidad, carrerasSeleccionadas.toArray(new String[0]), discapacidad, porcentajeDiscapacidad, abanderadoEscolta, tipoBachillerato, correoInstitucional, contrasena, notaExamen);
                                ListaCarreras.getUsuario().add(postulante);
                                System.out.println("------------------------------------");
                                System.out.println("|    UTPL INSCRIPCION ESTUDIANTES    |");
                                System.out.println("------------------------------------");
                                System.out.println("¡Matricula completada con exito!");
                                System.out.println("Datos del postulante:");
                                System.out.println("Nombres: " + nombres);
                                System.out.println("Apellidos: " + apellidos);
                                System.out.println("Cedula: " + cedula);
                                System.out.println("Correo Electronico: " + correoElectronico);
                                System.out.println("Numero Telefonico: " + numeroTelefonico);
                                System.out.println("Modalidad de Estudio: " + modalidad);
                                System.out.println("Carreras Seleccionadas:");
                                for (String carrera : carrerasSeleccionadas) {
                                    System.out.println("  - " + carrera);
                                }
                                System.out.println("Discapacidad: " + (discapacidad ? "Sí, " + porcentajeDiscapacidad + "%" : "No"));
                                System.out.println("Abanderado o Escolta: " + (abanderadoEscolta ? "Sí" : "No"));
                                System.out.println("Tipo de Bachillerato: " + tipoBachillerato);
                                System.out.println("Correo institucional: " + correoInstitucional);
                                System.out.println("Contraseña: " + contrasena);
                                System.out.println("Preparate para la prueba de admision a la universidad, Bienvenido futuro estudiante");
                                break;
                            case 3:
                                System.out.println("Las fechas del examen de admision seran comunicadas a traves de su correo institucional.");
                                break;
                            case 4:
                                if (ListaCarreras.getUsuario().isEmpty()) {
                                    System.out.println("No hay Estudiante registrados.");
                                } else {
                                    System.out.println("------------------------------------");
                                    System.out.println("|Informacion del Postulante: |");
                                    System.out.println("------------------------------------");
                                    Usuario ultimoPostulante = ListaCarreras.getUsuario().get(ListaCarreras.getUsuario().size() - 1);
                                    System.out.println("Nombres: " + ultimoPostulante.getNombres());
                                    System.out.println("Apellidos: " + ultimoPostulante.getApellidos());
                                    System.out.println("Cedula: " + ultimoPostulante.getCedula());
                                    System.out.println("Correo Electronico: " + ultimoPostulante.getCorreoElectronico());
                                    System.out.println("Numero Telefonico: " + ultimoPostulante.getNumeroTelefonico());
                                    System.out.println("Modalidad de Estudio: " + ultimoPostulante.getModalidad());
                                    System.out.println("Carreras Seleccionadas:");
                                    for (String carrera : ultimoPostulante.getCarrerasSeleccionadas()) {
                                        System.out.println("  - " + carrera);
                                    }
                                    System.out.println("Discapacidad: " + (ultimoPostulante.Discapacidad() ? "Sí, " + ultimoPostulante.getPorcentajeDiscapacidad() + "%" : "No"));
                                    System.out.println("Abanderado o Escolta: " + (ultimoPostulante.AbanderadoEscolta() ? "Sí" : "No"));
                                    System.out.println("Tipo de Bachillerato: " + ultimoPostulante.getTipoBachillerato());
                                    System.out.println("Correo institucional: " + ultimoPostulante.getCorreoInstitucional());
                                    System.out.println("Contraseña: " + ultimoPostulante.getContrasena());
                                }
                                break;
                            case 5:
                                System.out.println("------------------------------------");
                                System.out.println("|  Volviendo al menú principal      |");
                                System.out.println("------------------------------------");
                                break;
                            default:
                                System.out.println("Opcion no valida. Por favor, intente nuevamente.");
                                break;
                        }
                    } while (opcionSecundaria != 5);
                    break;
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Panel Estudiantes 
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 2:
                    System.out.print("Ingrese su correo institucional: ");
                    String correoInstitucional = scanner.next();
                    System.out.print("Ingrese su contraseña: ");
                    String contrasena = scanner.next();

                    boolean estudianteEncontrado = false;
                    Usuario estudiante = null;

                    for (Usuario usuario : ListaCarreras.getUsuario()) {
                        if (usuario.getCorreoInstitucional().equals(correoInstitucional) && usuario.getContrasena().equals(contrasena)) {
                            estudianteEncontrado = true;
                            estudiante = usuario;
                            System.out.println("UTPL. Bienvenido Sr/a, " + usuario.getNombres() + " " + usuario.getApellidos() + ".");
                            break;
                        }
                    }
                    if (estudianteEncontrado) {
                        int opcionMenuEstudiante;
                        do {
                            System.out.println("\n---------------------------------------");
                            System.out.println("|             Menu de Estudiante       |");
                            System.out.println("---------------------------------------");
                            System.out.println("| 1) Informacion del Estudiante        |");
                            System.out.println("| 2) Bandeja De Entrada                |");
                            System.out.println("| 3) Informacion de asignacion de cupo |");
                            System.out.println("| 4) Volver al menu principal          |");
                            System.out.println("---------------------------------------");
                            System.out.print("Ingrese el numero de su eleccion: ");
                            opcionMenuEstudiante = scanner.nextInt();
                            switch (opcionMenuEstudiante) {
                                case 1:
                                    System.out.println("------------------------------------");
                                    System.out.println("|      Informacion de Inscripcion   |");
                                    System.out.println("------------------------------------");
                                    System.out.println("Nombres: " + estudiante.getNombres());
                                    System.out.println("Apellidos: " + estudiante.getApellidos());
                                    System.out.println("Cedula: " + estudiante.getCedula());
                                    System.out.println("Correo Electronico: " + estudiante.getCorreoElectronico());
                                    System.out.println("Numero Telefonico: " + estudiante.getNumeroTelefonico());
                                    System.out.println("Modalidad de Estudio: " + estudiante.getModalidad());
                                    System.out.println("Carreras Seleccionadas:");
                                    for (String carrera : estudiante.getCarrerasSeleccionadas()) {
                                        System.out.println("  - " + carrera);
                                    }
                                    System.out.println("Discapacidad: " + (estudiante.Discapacidad() ? "Sí, " + estudiante.getPorcentajeDiscapacidad() + "%" : "No"));
                                    System.out.println("Abanderado o Escolta: " + (estudiante.AbanderadoEscolta() ? "Sí" : "No"));
                                    System.out.println("Tipo de Bachillerato: " + estudiante.getTipoBachillerato());
                                    if (estudiante instanceof Estudiante) {
                                        Estudiante estudianteConNota = (Estudiante) estudiante;
                                        System.out.println("Nota del Examen: " + estudianteConNota.getNotaExamen());
                                    }
                                    break;
                                case 2:
                                    System.out.println("------------------------------------");
                                    System.out.println("|          Bandeja de Entrada      |");
                                    System.out.println("------------------------------------");
                                    if (estudiante instanceof Estudiante) {
                                        Estudiante estudianteConNota = (Estudiante) estudiante;
                                        double nota = estudianteConNota.getNotaExamen();
                                        List<String> carrerasAceptadas = new ArrayList<>();
                                        List<String> carrerasNoAceptadas = new ArrayList<>();
                                        for (String carrera : estudianteConNota.getCarrerasSeleccionadas()) {
                                            boolean aceptada = false;
                                            for (Carrera carreraItem : ListaCarreras.getCarreras()) {
                                                if (carreraItem.getCarreras().contains(carrera)) {
                                                    if (carreraItem.requierePruebaDeAdmision(carrera, (int) nota)) {
                                                        aceptada = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (aceptada) {
                                                System.out.println("Se le ha otorgado un cupo en la carrera: " + carrera);
                                            } else {
                                                System.out.println("No se le ha otorgado cupo en la carrera: " + carrera);
                                            }
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("------------------------------------");
                                    System.out.println("| Informacion de Asignacion de Cupo |");
                                    System.out.println("------------------------------------");
                                    if (estudiante instanceof Estudiante) {
                                        Estudiante estudianteConNota = (Estudiante) estudiante;
                                        double nota = estudianteConNota.getNotaExamen();
                                        List<String> carrerasAceptadas = new ArrayList<>();
                                        List<String> carrerasNoAceptadas = new ArrayList<>();
                                        for (String carrera : estudianteConNota.getCarrerasSeleccionadas()) {
                                            boolean aceptada = false;
                                            for (Carrera carreraItem : ListaCarreras.getCarreras()) {
                                                if (carreraItem.getCarreras().contains(carrera)) {
                                                    if (carreraItem.requierePruebaDeAdmision(carrera, (int) nota)) {
                                                        aceptada = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (aceptada) {
                                                carrerasAceptadas.add(carrera);
                                            } else {
                                                carrerasNoAceptadas.add(carrera);
                                            }
                                        }
                                        if (carrerasAceptadas.isEmpty()) {
                                            System.out.println("No se le ha otorgado cupo en ninguna de las carreras seleccionadas.");
                                        } else {
                                            System.out.println("Carreras en las que ha sido aceptado:");
                                            for (String carrera : carrerasAceptadas) {
                                                System.out.println("  - " + carrera);
                                            }
                                            System.out.println("\nCarreras en las que no ha sido aceptado:");
                                            for (String carrera : carrerasNoAceptadas) {
                                                System.out.println("  - " + carrera);
                                            }
                                            for (String carrera : carrerasAceptadas) {
                                                System.out.println("¿Desea aceptar la oferta para la carrera " + carrera + "? (1) Sí, (2) No");
                                                int opcion = scanner.nextInt();
                                                scanner.nextLine();
                                                if (opcion == 1) {
                                                    System.out.println("¡Felicidades! Ha aceptado el cupo para la carrera " + carrera + ".");
                                                } else if (opcion == 2) {
                                                    System.out.println("UTPL decide ser mas.");
                                                } else {
                                                    System.out.println("Opcion no valida. Porfavor ingrese un digito correcto");
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("No se encontró informacion del estudiante.");
                                    }
                                    break;
                                case 4:
                                    System.out.println("------------------------------------");
                                    System.out.println("|  Volviendo al menu principal      |");
                                    System.out.println("------------------------------------");
                                    break;
                                default:
                                    System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                                    break;
                            }
                        } while (opcionMenuEstudiante != 4);
                    } else {
                        System.out.println("Correo institucional o contrasena incorrectos. Por favor, intente de nuevo.");
                    }
                    break;

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Panel Administrativo
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 3:
                    do {
                        System.out.println("-------------------------------------------------");
                        System.out.println("|   Panel Administrativo                        |");
                        System.out.println("-------------------------------------------------");
                        System.out.println("| 1) Información de todos los estudiantes       |");
                        System.out.println("| 2) Resultados de aceptacion de cupo           |");
                        System.out.println("| 3) Carreras con mayor demanda y menor demanda |");
                        System.out.println("| 4) Salir                                      |");
                        System.out.println("-------------------------------------------------");
                        System.out.print("Ingrese el numero de su eleccion: ");
                        opcionSecundaria = scanner.nextInt();
                        switch (opcionSecundaria) {
                            case 1:
                                System.out.println("\nInformacion de todos los estudiantes:");
                                List<Usuario> usuarios = ListaCarreras.getUsuario();
                                if (usuarios.isEmpty()) {
                                    System.out.println("No hay estudiantes registrados.");
                                } else {
                                    for (Usuario usuario : usuarios) {
                                        System.out.println("Nombre: " + usuario.getNombres() + " " + usuario.getApellidos());
                                        System.out.println("Cedula: " + usuario.getCedula());
                                        System.out.println("Correo Electronico: " + usuario.getCorreoElectronico());
                                        System.out.println("Modalidad de Estudio: " + usuario.getModalidad());
                                        String[] carrerasSeleccionadas = usuario.getCarrerasSeleccionadas();
                                        System.out.println("Carreras Seleccionadas:");
                                        if (carrerasSeleccionadas != null && carrerasSeleccionadas.length > 0) {
                                            for (String carrera : carrerasSeleccionadas) {
                                                System.out.println("  - " + carrera);
                                            }
                                        } else {
                                            System.out.println("  No ha seleccionado ninguna carrera.");
                                        }
                                        System.out.println("------------------------------------");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("\nEstado de aceptación de cupos:");
                                List<Usuario> administrativo = ListaCarreras.getUsuario();
                                int aceptados = 0;
                                int rechazados = 0;
                                if (administrativo.isEmpty()) {
                                    System.out.println("No hay estudiantes registrados.");
                                } else {
                                    for (Usuario usuario : administrativo) {
                                        if (usuario instanceof Estudiante) {
                                            Estudiante Estudiantes = (Estudiante) usuario;
                                            if (Estudiantes.getNotaExamen() >= 70) {
                                                aceptados++;
                                                System.out.println("Nombre: " + Estudiantes.getNombres() + " " + Estudiantes.getApellidos());
                                            } else {
                                                rechazados++;
                                            }
                                        } else {
                                            System.out.println("Ningun estudiante esta inscrito ");
                                        }
                                    }
                                    System.out.println("Total de estudiantes aceptados: " + aceptados);
                                    System.out.println("Total de estudiantes rechazados: " + rechazados);
                                }
                                break;
                            case 3:
                                System.out.println("\nCarreras con mayor demanda y menor demanda:");
                                List<Usuario> adm = ListaCarreras.getUsuario();
                                if (adm.isEmpty()) {
                                    System.out.println("No hay estudiantes registrados.");
                                } else {
                                    List<String> todasCarreras = new ArrayList<>();
                                    List<Integer> conteoCarreras = new ArrayList<>();
                                    List<Estudiante> estudiantesAceptados = new ArrayList<>();
                                    System.out.println("\nEstudiantes inscritos:");
                                    for (Usuario usuario : adm) {
                                        if (usuario instanceof Estudiante) {
                                            Estudiante Estcupos = (Estudiante) usuario;
                                            System.out.println("Nombre: " + Estcupos.getNombres() + " " + Estcupos.getApellidos());
                                            System.out.println("Cédula: " + Estcupos.getCedula());
                                            System.out.println("Correo Electrónico: " + Estcupos.getCorreoElectronico());
                                            System.out.println("Modalidad de Estudio: " + Estcupos.getModalidad());
                                            System.out.println("Carreras Seleccionadas: " + Arrays.toString(Estcupos.getCarrerasSeleccionadas()));
                                            System.out.println("------------------------------------");
                                            if (Estcupos.getNotaExamen() >= 70) {
                                                estudiantesAceptados.add(Estcupos);
                                                for (String carreraSeleccionada : Estcupos.getCarrerasSeleccionadas()) {
                                                    int index = todasCarreras.indexOf(carreraSeleccionada);
                                                    if (index == -1) {
                                                        todasCarreras.add(carreraSeleccionada);
                                                        conteoCarreras.add(1);
                                                    } else {
                                                        conteoCarreras.set(index, conteoCarreras.get(index) + 1);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    System.out.println("\nEstudiantes que aceptaron el cupo:");
                                    for (Estudiante inscritos : estudiantesAceptados) {
                                        System.out.println("Nombre: " + inscritos.getNombres() + " " + inscritos.getApellidos());
                                        System.out.println("Cédula: " + inscritos.getCedula());
                                        System.out.println("Correo Electrónico: " + inscritos.getCorreoElectronico());
                                        System.out.println("Modalidad de Estudio: " + inscritos.getModalidad());
                                        System.out.println("Carreras Seleccionadas: " + Arrays.toString(inscritos.getCarrerasSeleccionadas()));
                                        System.out.println("------------------------------------");
                                    }
                                    for (int i = 0; i < conteoCarreras.size() - 1; i++) {
                                        for (int j = 0; j < conteoCarreras.size() - i - 1; j++) {
                                            if (conteoCarreras.get(j) < conteoCarreras.get(j + 1)) {
                                                int tempCount = conteoCarreras.get(j);
                                                conteoCarreras.set(j, conteoCarreras.get(j + 1));
                                                conteoCarreras.set(j + 1, tempCount);
                                                String tempCarrera = todasCarreras.get(j);
                                                todasCarreras.set(j, todasCarreras.get(j + 1));
                                                todasCarreras.set(j + 1, tempCarrera);
                                            }
                                        }
                                    }
                                    if (todasCarreras.isEmpty()) {
                                        System.out.println("No hay carreras con estudiantes aceptados.");
                                    } else {
                                        System.out.println("Carreras ordenadas por demanda:");
                                        for (int i = 0; i < todasCarreras.size(); i++) {
                                            System.out.println(todasCarreras.get(i) + ": " + conteoCarreras.get(i) + " estudiantes.");
                                        }
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("------------------------------------");
                                System.out.println("|  Volviendo al menú principal      |");
                                System.out.println("------------------------------------");
                                break;
                            default:
                                System.out.println("\nOpción no válida. Por favor, ingrese un número entre 1 y 4.");
                                break;
                        }
                    } while (opcionSecundaria != 4);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("\nOpción no válida. Por favor, ingrese un número entre 1 y 4.");
                    break;
            }
        } while (opcionPrincipal != 4);
        scanner.close();
    }
    
    public static Usuario iniciarSesion(List<Usuario> usuarios, String correo, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreoInstitucional().equals(correo) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }
    public static void InformacionEstudiantes(List<Usuario> usuarios, String archivo) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
        writer.println("Nombre,Cedula,Correo Electronico,Modalidad,Carreras Seleccionadas");
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) usuario;
                writer.print(estudiante.getNombres() + " " + estudiante.getApellidos() + ",");
                writer.print(estudiante.getCedula() + ",");
                writer.print(estudiante.getCorreoElectronico() + ",");
                writer.print(estudiante.getModalidad() + ",");
                String[] carrerasSeleccionadas = estudiante.getCarrerasSeleccionadas();
                if (carrerasSeleccionadas != null && carrerasSeleccionadas.length > 0) {
                    writer.print(String.join(";", carrerasSeleccionadas));
                }
                writer.println();
            }
        }
    } catch (IOException e) {
        System.out.println("Error al guardar el archivo: " + e.getMessage());
    }
}
public static void InformacionAsignacionCupo(List<Usuario> usuarios, String archivo) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
        writer.println("Nombre,Cedula,Correo Electronico,Modalidad,Carrera,Estado de Cupo");
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) usuario;
                double nota = estudiante.getNotaExamen();
                for (String carrera : estudiante.getCarrerasSeleccionadas()) {
                    boolean aceptada = false;
                    for (Carrera carreraItem : ListaCarreras.getCarreras()) {
                        if (carreraItem.getCarreras().contains(carrera)) {
                            if (carreraItem.requierePruebaDeAdmision(carrera, (int) nota)) {
                                aceptada = true;
                                break;
                            }
                        }
                    }
                    writer.print(estudiante.getNombres() + " " + estudiante.getApellidos() + ",");
                    writer.print(estudiante.getCedula() + ",");
                    writer.print(estudiante.getCorreoElectronico() + ",");
                    writer.print(estudiante.getModalidad() + ",");
                    writer.print(carrera + ",");
                    writer.println(aceptada ? "Aceptado" : "No Aceptado");
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Error al guardar el archivo: " + e.getMessage());
    }
}
}