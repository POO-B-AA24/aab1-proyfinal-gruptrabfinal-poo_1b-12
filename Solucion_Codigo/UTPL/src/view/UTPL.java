package view;

import controller.*;
import java.util.Scanner;

public class UTPL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PanelAdministrativo.cargarPostulantesDesdeArchivo();
        ExamenesAdmisiones.asignarNotasAleatorias();

        int opcionPrincipal;
        int opcionSecundaria;
        do {
            System.out.println("\n------------------------------");
            System.out.println("|Bienvenidos a Admisiones UTPL|");
            System.out.println("\n----------------------------|");
            System.out.println("|1) Nuevos Estudiantes        |");
            System.out.println("|2) Personal administrativo   |");
            System.out.println("|3) Iniciar sesión estudiantes|");
            System.out.println("|4) Salir                     |");
            System.out.println("\n------------------------------");
            System.out.print("Ingrese el número de su elección: ");

            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    do {
                        System.out.println("\n---------------------------------------");
                        System.out.println("|         Panel Estudiantes             |");
                        System.out.println("\n---------------------------------------");
                        System.out.println("|1) Catálogo de las carreras disponibles|");
                        System.out.println("|2) Proceso de matriculación            |");
                        System.out.println("|3) Fechas del examen de admisión       |");
                        System.out.println("|4) Información del postulante          |");
                        System.out.println("|5) Volver al menú principal            |");
                        System.out.println("\n---------------------------------------");
                        System.out.print("Ingrese el número de su elección: ");

                        opcionSecundaria = scanner.nextInt();

                        switch (opcionSecundaria) {
                            case 1:
                                SistemaDeGestion.presentarCarreras();
                                break;
                            case 2:
                                SistemaDeGestion.procesoMatriculacion();
                                break;
                            case 3:
                                SistemaDeGestion.mostrarFechaExamen();
                                break;
                            case 4:
                                SistemaDeGestion.mostrarInformacionPostulante();
                                break;
                            case 5:
                                System.out.println("\nVolviendo al Panel UTPL");
                                break;
                            default:
                                System.out.println("\nOpción no válida. Por favor, ingrese un número entre 1-5.");
                                break;
                        }
                    } while (opcionSecundaria != 5);
                    break;
                case 2:
                    do {
                        System.out.println("\n----------------------------------------------");
                        System.out.println("|   Panel  Administrativo                      |");
                        System.out.println("\n----------------------------------------------");
                        System.out.println("|1) Inscripciones de los estudiantes           |");
                        System.out.println("|2) Resultado del examen de admisión           |");
                        System.out.println("|3) Carreras con mayor demanda y menor demanda |");
                        System.out.println("|4) Salir                                      |");
                        System.out.println("\n----------------------------------------------");
                        System.out.print("Ingrese el número de su elección: ");

                        opcionSecundaria = scanner.nextInt();

                        switch (opcionSecundaria) {
                            case 1:
                                PanelAdministrativo.mostrarPostulantes();
                                break;
                            case 2:
                                PanelAdministrativo.mostrarResultadosExamen();
                                break;
                            case 3:
                                PanelAdministrativo.mostrarDemandaCarreras();
                                break;
                            case 4:
                                System.out.println("\nSaliendo del menú de personal administrativo");
                                break;
                            default:
                                System.out.println("\nOpción no válida. Por favor, ingrese un número entre 1 y 4.");
                                break;
                        }
                    } while (opcionSecundaria != 4);
                    break;
                case 3:
                    SistemaDeGestion.iniciarSesionEstudiante();
                    break;
                case 4:
                    System.out.println("-------------------------------------------");
                    System.out.println("Saliendo del sistema. UTPL decide ser más.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número entre 1-4.");
                    break;
            }
        } while (opcionPrincipal != 4);
    }
}