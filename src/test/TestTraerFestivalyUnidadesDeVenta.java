package test;

import negocio.FestivalABM;

public class TestTraerFestivalyUnidadesDeVenta {
    public static void main(String[] args) {
        FestivalABM abmFestival = new FestivalABM();

        System.out.println("Traer festival por ID y sus unidades de ventas asociadas");
        System.out.println(abmFestival.traerFestivalYUnidadDeVenta(1));
    }
}
