package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {
    private static final String FILE_NAME = "estudiantes.txt";

    public void agregarEstudiante(Estudiante estudiante) {
        List<Estudiante> estudiantes = obtenerEstudiantes();
        estudiantes.add(estudiante);
        guardarEstudiantes(estudiantes);
    }
    
public List<Estudiante> obtenerEstudiantes() {
    List<Estudiante> estudiantes = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 6) { // Verificar si hay suficientes partes
                String nombre = parts[0];
                String apellido = parts[1];
                String cedula = parts[2];
                String telefono = parts[3];
                String correo = parts[4];
                String carrera = parts[5];
                double nota = 0.0; // Valor predeterminado para la nota
                if (parts.length >= 7) { // Verificar si hay una séptima parte para la nota
                    try {
                        nota = Double.parseDouble(parts[6]); // Parsear la nota desde el archivo
                    } catch (NumberFormatException e) {
                        // Manejar error al parsear la nota
                        System.err.println("Error al parsear la nota: " + e.getMessage());
                    }
                }

                // Crear una lista de carreras con la carrera actual
                List<String> carreras = new ArrayList<>();
                carreras.add(carrera);

                Estudiante estudiante = new Estudiante(nombre, apellido, cedula, telefono, correo, carreras, nota);
                estudiantes.add(estudiante);
            } else {
                // Manejar el caso de que la línea no tenga suficientes partes
                System.err.println("Error: línea inválida en el archivo.");
            }
        }
    } catch (IOException e) {
        System.err.println("Error al cargar estudiantes: " + e.getMessage());
    }
    return estudiantes;
}
    private void guardarEstudiantes(List<Estudiante> estudiantes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Estudiante estudiante : estudiantes) {
                bw.write(estudiante.getNombre() + "," + estudiante.getApellido() + "," + estudiante.getCedula() + ","
                        + estudiante.getTelefono() + "," + estudiante.getCorreo());

                // Imprimir las carreras separadas por comas
                for (String carrera : estudiante.getCarreras()) {
                    bw.write("," + carrera);
                }

                bw.write("," + estudiante.getNota()); // Escribir la nota en el archivo
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar estudiantes: " + e.getMessage());
        }
    }
    
    public Estudiante iniciarSesion(String correoInstitucional, String contrasena) {
        List<Estudiante> estudiantes = obtenerEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCorreoInstitucional().equals(correoInstitucional) && estudiante.getContrasena().equals(contrasena)) {
                return estudiante;
            }
        }
        return null;
    }
    
    public void cargarEstudiantes() {
        // Implementa la carga de estudiantes si es necesario
    }
}
