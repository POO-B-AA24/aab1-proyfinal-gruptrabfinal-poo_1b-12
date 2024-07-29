package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Estudiante extends Usuario {
    public double notaExamen;
    public List<String> carrerasAceptadas;
    public Estudiante(String nombres, String apellidos, String cedula, String correoElectronico, String numeroTelefonico, String modalidad, String[] carrerasSeleccionadas, boolean discapacidad, int porcentajeDiscapacidad, boolean abanderadoEscolta, String tipoBachillerato, String correoInstitucional, String contrasena, double notaExamen) {
        super(nombres, apellidos, cedula, correoElectronico, numeroTelefonico, modalidad, carrerasSeleccionadas, discapacidad, porcentajeDiscapacidad, abanderadoEscolta, tipoBachillerato, correoInstitucional, contrasena);
        this.notaExamen = notaExamen;
        this.carrerasAceptadas = new ArrayList<>();
    }
    public double getNotaExamen() {
        return notaExamen;
    }
    public void setNotaExamen(double notaExamen) {
        this.notaExamen = notaExamen;
    }
    public List<String> getCarrerasAceptadas() {
        return carrerasAceptadas;
    }
    public void setCarrerasAceptadas(List<String> carrerasAceptadas) {
        this.carrerasAceptadas = carrerasAceptadas;
    }
    @Override
    public String toString() {
        return "Estudiante{" +
                "nombres='" + getNombres() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", cedula='" + getCedula() + '\'' +
                ", correoElectronico='" + getCorreoElectronico() + '\'' +
                ", numeroTelefonico='" + getNumeroTelefonico() + '\'' +
                ", modalidad='" + getModalidad() + '\'' +
                ", carrerasSeleccionadas=" + Arrays.toString(getCarrerasSeleccionadas()) +
                ", discapacidad=" + Discapacidad() +
                ", porcentajeDiscapacidad=" + getPorcentajeDiscapacidad() +
                ", abanderadoEscolta=" + AbanderadoEscolta() +
                ", tipoBachillerato='" + getTipoBachillerato() + '\'' +
                ", correoInstitucional='" + getCorreoInstitucional() + '\'' +
                ", contrasena='" + getContrasena() + '\'' +
                ", notaExamen=" + notaExamen +
                '}';
    }
}
