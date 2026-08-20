package datos;

import java.time.LocalDate;

public class Staff {
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private int sueldo;

    public Staff() {
    }

    public Staff(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, int sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public int getSueldo() {
        return sueldo;
    }

    //Setters
    protected void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    protected void setDni(int dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

}
