package datos;

import java.util.Set;

public class FoodTruck extends UnidadDeVenta{

    private String patente;
    private boolean conexion;

    public FoodTruck(){

    }

    public FoodTruck(boolean activo, String nombreComercial, int superficie,String codigo, Festival festival, String patente, boolean conexion) {
        super(activo, nombreComercial, superficie,codigo, festival);
        this.patente = patente;
        this.conexion = conexion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public boolean isConexion() {
        return conexion;
    }

    public void setConexion(boolean conexion) {
        this.conexion = conexion;
    }

    @Override
    public String toString() {
        return "FoodTruck{" +
                "patente='" + patente + '\'' +
                ", conexion=" + conexion +
                '}';
    }
}
