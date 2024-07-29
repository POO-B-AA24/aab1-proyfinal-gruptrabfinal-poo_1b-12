package Model;

import java.util.ArrayList;
import java.util.List;
import Controller.*;

public abstract class Carrera {
    public String nombreFacultad;
    public List<String> carreras;

    public Carrera(String nombreFacultad, String[] carreras) {
        this.nombreFacultad = nombreFacultad;
        this.carreras = new ArrayList<>();
        for (String carrera : carreras) {
            this.carreras.add(carrera);
        }
    }
    public String getNombreFacultad() {
        return nombreFacultad;
    }
    public List<String> getCarreras() {
        return carreras;
    }
    public abstract boolean requierePruebaDeAdmision(String carrera);
    public abstract boolean requierePruebaDeAdmision(String carrera, int nota);
    public abstract boolean requierePruebaDeDiagnostico(String carrera);
}
class CarreraPresencial extends Carrera {
    public CarreraPresencial(String nombreFacultad, String[] carreras) {
        super(nombreFacultad, carreras);
    }
    @Override
    public boolean requierePruebaDeAdmision(String carrera) {
        String[] facultadesConPruebaDeAdmision = {
            "Facultad de las Ciencias de la Salud",
            "Ciencias Económicas y Empresariales",
            "Ciencias Exactas y Naturales",
            "Ciencias Sociales, Educación y Humanidades"
        };
        for (String facultad : facultadesConPruebaDeAdmision) {
            if (this.getNombreFacultad().equals(facultad)) {
                return this.getCarreras().contains(carrera);
            }
        }
        return false;
    }
    @Override
    public boolean requierePruebaDeAdmision(String carrera, int nota) {
        return nota >= 70 && requierePruebaDeAdmision(carrera);
    }
    @Override
    public boolean requierePruebaDeDiagnostico(String carrera) {
        String[] facultadesConPruebaDeDiagnostico = {
            "Ingenierías y Arquitecturas",
            "Postgrados Presenciales",
            "Tecnologías"
        };
        for (String facultad : facultadesConPruebaDeDiagnostico) {
            if (this.getNombreFacultad().equals(facultad)) {
                return this.getCarreras().contains(carrera);
            }
        }
        return false;
    }
}
class CarreraVirtual extends Carrera {
    public CarreraVirtual(String nombreFacultad, String[] carreras) {
        super(nombreFacultad, carreras);
    }
   @Override
    public boolean requierePruebaDeAdmision(String carrera) {
        String[] facultadesConPruebaDeAdmision = {
            "Facultad de las Ciencias de la Salud",
            "Ciencias Económicas y Empresariales",
            "Ciencias Exactas y Naturales",
            "Ciencias Sociales, Educación y Humanidades"
        };
        for (String facultad : facultadesConPruebaDeAdmision) {
            if (this.getNombreFacultad().equals(facultad)) {
                return this.getCarreras().contains(carrera);
            }
        }
        return false;
    }
    @Override
    public boolean requierePruebaDeAdmision(String carrera, int nota) {
        return nota >= 70 && requierePruebaDeAdmision(carrera);
    }
    @Override
    public boolean requierePruebaDeDiagnostico(String carrera) {
        String[] facultadesConPruebaDeDiagnostico = {
            "Ingenierías y Arquitecturas",
            "Postgrados Presenciales",
            "Tecnologías"
        };
        for (String facultad : facultadesConPruebaDeDiagnostico) {
            if (this.getNombreFacultad().equals(facultad)) {
                return this.getCarreras().contains(carrera);
            }
        }
        return false;
    }
}
class ModalidadAbierta extends Carrera {
    public ModalidadAbierta(String nombreFacultad, String[] carreras) {
        super(nombreFacultad, carreras);
    }
    @Override
    public boolean requierePruebaDeAdmision(String carrera) {
        String[] facultadesConPruebaDeAdmision = {
            "Facultad de las Ciencias de la Salud",
            "Ciencias Económicas y Empresariales",
            "Ciencias Exactas y Naturales",
            "Ciencias Sociales, Educación y Humanidades"
        };
        for (String facultad : facultadesConPruebaDeAdmision) {
            if (this.getNombreFacultad().equals(facultad)) {
                return this.getCarreras().contains(carrera);
            }
        }
        return true;
    }
    @Override
    public boolean requierePruebaDeAdmision(String carrera, int nota) {
        return nota >= 70 && requierePruebaDeAdmision(carrera);
    }
    @Override
    public boolean requierePruebaDeDiagnostico(String carrera) {
        String[] facultadesConPruebaDeDiagnostico = {
            "Ingenierías y Arquitecturas",
            "Postgrados Presenciales",
            "Tecnologías"
        };
        for (String facultad : facultadesConPruebaDeDiagnostico) {
            if (this.getNombreFacultad().equals(facultad)) {
                return this.getCarreras().contains(carrera);
            }
        }
        return true;
    }
}
