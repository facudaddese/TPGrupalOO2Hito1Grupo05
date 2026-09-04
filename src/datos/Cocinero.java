package datos;

import java.time.LocalDate;

public class Cocinero extends Staff {
    private String especialidadCulinaria;
    private double plusPorCategoria;

    public Cocinero() {
    }

    public Cocinero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, int sueldo, String especialidadCulinaria, double plusPorCategoria) {
        super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldo);
        this.especialidadCulinaria = especialidadCulinaria;
        this.plusPorCategoria = plusPorCategoria;
    }

    public double getPlusPorCategoria() {
        return plusPorCategoria;
    }

    public void setPlusPorCategoria(double plusPorCategoria) {
        this.plusPorCategoria = plusPorCategoria;
    }

    public String getEspecialidadCulinaria() {
        return especialidadCulinaria;
    }

    public void setEspecialidadCulinaria(String especialidadCulinaria) {
        this.especialidadCulinaria = especialidadCulinaria;
    }

    @Override
    public String toString() {
        return "Cocinero{" +
                "plusPorCategoria=" + plusPorCategoria +
                ", especialidadCulinaria='" + especialidadCulinaria + '\'' +
                "} " + super.toString();
    }
}
