package Controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Usuario {
    public String nombres;
    public  String apellidos;
    public  String cedula;
    public  String correoElectronico;
    public  String numeroTelefonico;
    public  String modalidad;
    public  String[] carrerasSeleccionadas;
    public  boolean discapacidad;
    public  int porcentajeDiscapacidad;
    public  boolean abanderadoEscolta;
    public  String tipoBachillerato;
    public  String correoInstitucional;
    public  String contrasena;
    public Usuario(String nombres, String apellidos, String cedula, String correoElectronico, String numeroTelefonico, String modalidad, String[] carrerasSeleccionadas, boolean discapacidad, int porcentajeDiscapacidad, boolean abanderadoEscolta, String tipoBachillerato, String correoInstitucional, String contrasena) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.numeroTelefonico = numeroTelefonico;
        this.modalidad = modalidad;
        this.carrerasSeleccionadas = carrerasSeleccionadas;
        this.discapacidad = discapacidad;
        this.porcentajeDiscapacidad = porcentajeDiscapacidad;
        this.abanderadoEscolta = abanderadoEscolta;
        this.tipoBachillerato = tipoBachillerato;
        this.correoInstitucional = correoInstitucional;
        this.contrasena = contrasena;
    }
    public String getCorreoInstitucional() {
        return correoInstitucional;
    }
    public String getContrasena() {
        return contrasena;
    }
    public String getNombres() {
        return nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getCedula() {
        return cedula;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }
    public String getModalidad() {
        return modalidad;
    }
    public String[] getCarrerasSeleccionadas() {
        return carrerasSeleccionadas;
    }
    public boolean Discapacidad() {
        return discapacidad;
    }
    public int getPorcentajeDiscapacidad() {
        return porcentajeDiscapacidad;
    }
    public boolean AbanderadoEscolta() {
        return abanderadoEscolta;
    }
    public String getTipoBachillerato() {
        return tipoBachillerato;
    }
    @Override
    public String toString() {
        return "Postulante{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", numeroTelefonico='" + numeroTelefonico + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", carrerasSeleccionadas=" + Arrays.toString(carrerasSeleccionadas) +
                ", discapacidad=" + discapacidad +
                ", porcentajeDiscapacidad=" + porcentajeDiscapacidad +
                ", abanderadoEscolta=" + abanderadoEscolta +
                ", tipoBachillerato='" + tipoBachillerato + '\'' +
                ", correoInstitucional='" + correoInstitucional + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}

