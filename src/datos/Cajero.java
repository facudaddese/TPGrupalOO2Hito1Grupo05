package datos;

import java.time.LocalDate;

public class Cajero extends Staff {
    private String especialidad;

    public Cajero() {
    }

    public Cajero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, int sueldo, String especialidad) {
        super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
