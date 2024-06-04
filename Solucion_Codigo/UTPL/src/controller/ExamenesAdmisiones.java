package controller;

import model.Estudiante;
import model.EstudianteDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExamenesAdmisiones {

    private static EstudianteDAO estudianteDAO = new EstudianteDAO();

    public static void asignarNotasAleatorias() {
        List<Estudiante> estudiantes = estudianteDAO.obtenerEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            double nota = estudiante.getNota(); // Obtener la nota del estudiante
            estudiante.setNota(nota); // Agregar la nota al estudiante
        }
    }
    public static void mostrarResultadosExamen() {
        List<Estudiante> estudiantes = estudianteDAO.obtenerEstudiantes();
        System.out.println("Resultados del Examen de Admisión:");
        for (Estudiante estudiante : estudiantes) {
            Double nota = estudiante.getNota(); // Obtener la nota del estudiante
            System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
            System.out.println("Cédula: " + estudiante.getCedula());
            System.out.println("Nota del examen: " + (nota != null ? nota : "No asignada"));
            System.out.println("-----------------------------");
        }
    }

    public static void mostrarDemandaCarreras() {
        List<Estudiante> estudiantes = estudianteDAO.obtenerEstudiantes();
        List<String> todasCarreras = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            todasCarreras.addAll(estudiante.getCarreras());
        }
        if (todasCarreras.isEmpty()) {
            System.out.println("No hay carreras seleccionadas.");
            return;
        }
        int[] demanda = new int[todasCarreras.size()];
        String[] carreras = todasCarreras.toArray(new String[0]);
        for (Estudiante estudiante : estudiantes) {
            for (String carrera : estudiante.getCarreras()) {
                for (int i = 0; i < carreras.length; i++) {
                    if (carreras[i].equals(carrera)) {
                        demanda[i]++;
                    }
                }
            }
        }
        int maxDemanda = Integer.MIN_VALUE;
        int minDemanda = Integer.MAX_VALUE;
        String carreraMaxDemanda = "";
        String carreraMinDemanda = "";
        for (int i = 0; i < demanda.length; i++) {
            if (demanda[i] > maxDemanda) {
                maxDemanda = demanda[i];
                carreraMaxDemanda = carreras[i];
            }
            if (demanda[i] < minDemanda) {
                minDemanda = demanda[i];
                carreraMinDemanda = carreras[i];
            }
        }
        System.out.println("Carrera con mayor demanda: " + carreraMaxDemanda + " (" + maxDemanda + " estudiantes)");
        System.out.println("Carrera con menor demanda: " + carreraMinDemanda + " (" + minDemanda + " estudiantes)");
    }

    public static int asignarNotaAleatoria() {
        Random rand = new Random();
        return rand.nextInt(41) + 60; // Genera un número aleatorio entre 60 y 100
    }

    public static void mostrarResultadoExamen() {
        System.out.println("Resultados del Examen de Admisión:");
        List<Estudiante> estudiantes = estudianteDAO.obtenerEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            int nota = asignarNotaAleatoria();
            System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
            System.out.println("Cédula: " + estudiante.getCedula());
            System.out.println("Nota del examen: " + nota);
            System.out.println("-----------------------------");
        }
    }

    public static void asignacionCupo() {
        List<Estudiante> estudiantes = estudianteDAO.obtenerEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            int nota = (int) estudiante.getNota();
            if (nota >= 70) {
                System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + " tiene asignado un cupo.");
            } else {
                System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + " no tiene asignado un cupo.");
            }
        }
    }
}
