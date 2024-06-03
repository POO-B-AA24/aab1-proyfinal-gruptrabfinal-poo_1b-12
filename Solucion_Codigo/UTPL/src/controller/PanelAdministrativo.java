package controller;

import java.util.List;
import model.Estudiante;
import model.EstudianteDAO;

public class PanelAdministrativo {
    private static EstudianteDAO estudianteDAO = new EstudianteDAO();

    public static void mostrarPostulantes() {
        List<Estudiante> postulantes = estudianteDAO.obtenerEstudiantes();
        System.out.println("Lista de postulantes inscritos:");
        for (Estudiante postulante : postulantes) {
            System.out.println("Nombre: " + postulante.getNombre() + " " + postulante.getApellido());
            System.out.println("Cédula: " + postulante.getCedula());
            System.out.println("Teléfono: " + postulante.getTelefono());
            System.out.println("Correo: " + postulante.getCorreo());

            System.out.print("Carreras: ");
            for (String carrera : postulante.getCarreras()) {
                System.out.print(carrera + " ");
            }
            System.out.println();

            // Mostrar si tiene discapacidad
            if (postulante.isDiscapacidad()) {
                System.out.println("Tiene discapacidad.");
            } else {
                System.out.println("No tiene discapacidad.");
            }

            // Mostrar si es abanderado
            if (postulante.isAbanderado()) {
                System.out.println("Es abanderado.");
            } else {
                System.out.println("No es abanderado.");
            }

            // Mostrar la nota
            System.out.println("Nota: " + postulante.getNota()); // Utilizar getNota() para mostrar la nota
            
            System.out.println("-----------------------------");
        }
    }

    public static void cargarPostulantesDesdeArchivo() {
        estudianteDAO.cargarEstudiantes();
    }

    public static void mostrarResultadosExamen() {
        ExamenesAdmisiones.mostrarResultadosExamen();
    }

    public static void mostrarDemandaCarreras() {
        ExamenesAdmisiones.mostrarDemandaCarreras();
    }
}
