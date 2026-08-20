package datos;

import java.time.LocalDate;

public class Cocinero extends Staff {
    private String turno;

    public Cocinero() {
    }

    public Cocinero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, int sueldo, String turno) {
        super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldo);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
