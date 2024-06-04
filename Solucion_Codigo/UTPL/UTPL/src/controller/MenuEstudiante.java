package controller;

import model.Estudiante;


import java.util.Scanner;

public class MenuEstudiante {
    public static void mostrarMenuEstudiante(Estudiante estudiante) {
        Scanner scanner = new Scanner(System.in);
        int opcionSecundaria;
        do {
            System.out.println("\n--- Menú de Estudiante ---");
            System.out.println("1) Información de Inscripción");
            System.out.println("2) Resultado del Examen");
            System.out.println("3) Asignación de Cupo");
            System.out.println("4) Salir del sistema ");
            System.out.print("Ingrese el número de su elección: ");

            opcionSecundaria = scanner.nextInt();

            switch (opcionSecundaria) {
                case 1:
                    SistemaDeGestion.mostrarInformacionPostulante();
                    break;
                case 2:
                    System.out.println("Este es el Resultado del examen");
                    ExamenesAdmisiones.mostrarResultadoExamen();
                    break;
                case 3:
                    System.out.println("Asignación de cupo:");
                    ExamenesAdmisiones.asignacionCupo();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema y volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 4.");
                    break;
            }
        } while (opcionSecundaria != 4);
    }
}