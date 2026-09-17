package datos;

import java.util.Set;

public class PuestoDesarmable extends UnidadDeVenta{

    private int cantidadCarpas;
    private float tiempoMontaje; //Representado en minutos

    public PuestoDesarmable() {

    }

    public PuestoDesarmable(boolean activo, String nombreComercial, int superficie,String codigo, Festival festival, int cantidadCarpas, float tiempoMontaje) {
        super(activo, nombreComercial, superficie,codigo, festival);
        this.cantidadCarpas = cantidadCarpas;
        this.tiempoMontaje = tiempoMontaje;
    }

    public int getCantidadCarpas() {
        return cantidadCarpas;
    }

    public void setCantidadCarpas(int cantidadCarpas) {
        this.cantidadCarpas = cantidadCarpas;
    }

    public float getTiempoMontaje() {
        return tiempoMontaje;
    }

    public void setTiempoMontaje(float tiempoMontaje) {
        this.tiempoMontaje = tiempoMontaje;
    }

    @Override
    public String toString() {
        return "PuestoDesarmable{" +
                "cantidadCarpas=" + cantidadCarpas +
                ", tiempoMontaje=" + tiempoMontaje +
                '}';
    }

}
