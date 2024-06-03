package model;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private String correoInstitucional;
    private String contrasena;
    private List<String> carreras;
    private boolean cupo;
    private boolean discapacidad;
    private boolean abanderado;
    private double nota;

    public Estudiante(String nombre, String apellido, String cedula, String telefono, String correo, List<String> carreras, double nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.correoInstitucional = nombre.toLowerCase() + "." + apellido.toLowerCase() + "@utpl.edu.ec";
        this.contrasena = "12345";
        this.carreras = carreras;
        this.cupo = false; // Valor inicial por defecto
        this.discapacidad = false; // Valor inicial por defecto
        this.abanderado = false; // Valor inicial por defecto
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<String> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<String> carreras) {
        this.carreras = carreras;
    }

    public boolean isCupo() {
        return cupo;
    }

    public void setCupo(boolean cupo) {
        this.cupo = cupo;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public boolean isAbanderado() {
        return abanderado;
    }

    public void setAbanderado(boolean abanderado) {
        this.abanderado = abanderado;
    }

    public double getNota() {
        Random rand = new Random();
        return rand.nextInt(41) + 80; // Genera un número aleatorio entre 60 y 100
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
