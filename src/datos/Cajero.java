package datos;

import java.time.LocalDate;

public class Cajero extends Staff {
    private String turno;

    public Cajero() {
    }

    public Cajero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, int sueldo, String turno) {
        super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldo);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "turno='" + turno + '\'' +
                '}';
    }
}
