package Model;

import Controller.Usuario;
import Controller.*;
import java.util.ArrayList;
import java.util.List;

public class ListaCarreras {
    public static List<Carrera> carrerasPresenciales = new ArrayList<>();
    public static List<Carrera> carrerasVirtuales = new ArrayList<>();
    public static List<Carrera> ModalidadAbierta = new ArrayList<>();
    public static List<Usuario> usuario = new ArrayList<>();
    public static List<Estudiante> estudiantes = new ArrayList<>();

    public static void inicializarCarreras() {
        carrerasPresenciales.add(new CarreraPresencial("Facultad de las Ciencias de la Salud", new String[]{"Enfermería", "Fisioterapia", "Medicina", "Nutrición y Dietética"}));
        carrerasPresenciales.add(new CarreraPresencial("Ciencias Económicas y Empresariales", new String[]{"Administración de Empresas", "Contabilidad y Auditoría", "Economía", "Finanzas", "Gastronomía"}));
        carrerasPresenciales.add(new CarreraPresencial("Ciencias Exactas y Naturales", new String[]{"Agropecuaria", "Alimentos", "Biología", "Ingeniería Ambiental", "Ingeniería Industrial", "Ingeniería Informática"}));
        carrerasPresenciales.add(new CarreraPresencial("Ciencias Sociales, Educación y Humanidades", new String[]{"Artes Escénicas", "Artes Visuales", "Pedagogía de los Idiomas Nacionales y Extranjeros"}));
        carrerasPresenciales.add(new CarreraPresencial("Ingenierías y Arquitecturas", new String[]{"Computación", "Geología", "Telecomunicaciones", "Arquitectura", "Ingeniería Civil"}));
        carrerasPresenciales.add(new CarreraPresencial("Postgrados Presenciales", new String[]{"Ciencias Químicas", "MBA con mención en Innovación - Presencial", "Medicina Familiar y Comunitaria", "Química Aplicada"}));
        carrerasPresenciales.add(new CarreraPresencial("Tecnologías", new String[]{"Comunicación Estrategia y Marketing Digital", "Transformación Digital de Empresas"}));
        
        carrerasVirtuales.add(new CarreraVirtual("Ciencias Económicas y Empresariales", new String[]{"Administración de Empresas", "Administración Pública", "Contabilidad y Auditoría", "Economía", "Finanzas"}));
        carrerasVirtuales.add(new CarreraVirtual("Ciencias Exactas y Naturales", new String[]{"Agronegocios", "Ciencias Ambientales", "Gestión Ambiental", "Gestión de Riesgos y Desastres", "Seguridad y Salud Ocupacional"}));
        carrerasVirtuales.add(new CarreraVirtual("Ciencias Sociales, Educación y Humanismo", new String[]{"Comunicación", "Educación Básica", "Educación Inicial", "Pedagogía de la Lengua y la Literatura", "Pedagogía de los Idiomas Nacionales y Extranjeros"}));
        carrerasVirtuales.add(new CarreraVirtual("Ciencias Jurídicas y Políticas", new String[]{"Derecho", "Derecho Constitucional", "Derecho Penal mención Derecho Procesal Penal", "Derecho Internacional y Derechos Humanos", "Criminología y Criminalística"}));
        carrerasVirtuales.add(new CarreraVirtual("Ingenierías y Arquitecturas", new String[]{"Ingeniería Informática", "Logística y Transporte", "Tecnologías de la Información"}));
        carrerasVirtuales.add(new CarreraVirtual("Postgrados Virtuales", new String[]{"Educación Virtual", "Gestión del Talento Humano"}));
        carrerasVirtuales.add(new CarreraVirtual("Tecnologías", new String[]{"Comunicación Estrategia y Marketing Digital", "Transformación Digital de Empresas"}));
        
        ModalidadAbierta.add(new ModalidadAbierta("Modalidad Abierta", new String[]{"Telecomunicaciones", "Psicología"}));
    }
    public static void agregarPostulante(Usuario usuario) {
        ListaCarreras.usuario.add(usuario);
        if (usuario instanceof Estudiante) {
            estudiantes.add((Estudiante) usuario);
        }
    }
    public static List<Usuario> getUsuario() {
        return usuario;
    }
    public static List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public static Carrera getCarreraPorNombre(String nombre) {
        for (Carrera carrera : carrerasPresenciales) {
            if (carrera.getCarreras().contains(nombre)) {
                return carrera;
            }
        }
        for (Carrera carrera : carrerasVirtuales) {
            if (carrera.getCarreras().contains(nombre)) {
                return carrera;
            }
        }
        for (Carrera carrera : ModalidadAbierta) {
            if (carrera.getCarreras().contains(nombre)) {
                return carrera;
            }
        }
        return null;
    }
    public static Carrera getCarrera(String modalidad, String nombreCarrera) {
        switch (modalidad) {
            case "Presencial":
                for (Carrera carrera : carrerasPresenciales) {
                    if (carrera.getCarreras().contains(nombreCarrera)) {
                        return carrera;
                    }
                }
                break;
            case "Virtual":
                for (Carrera carrera : carrerasVirtuales) {
                    if (carrera.getCarreras().contains(nombreCarrera)) {
                        return carrera;
                    }
                }
                break;
            case "Abierta":
                for (Carrera carrera : ModalidadAbierta) {
                    if (carrera.getCarreras().contains(nombreCarrera)) {
                        return carrera;
                    }
                }
                break;
        }
        return null;
    }
    public static List<Carrera> getCarreras() {
        List<Carrera> todasLasCarreras = new ArrayList<>();
        todasLasCarreras.addAll(carrerasPresenciales);
        todasLasCarreras.addAll(carrerasVirtuales);
        todasLasCarreras.addAll(ModalidadAbierta);
        return todasLasCarreras;
    }

}