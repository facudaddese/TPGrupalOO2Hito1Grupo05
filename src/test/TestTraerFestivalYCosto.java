package test;

import datos.Festival;
import negocio.FestivalABM;

public class TestTraerFestivalYCosto {
    public static void main(String[] args) {
        FestivalABM abmFestival = new FestivalABM();

        int id = 6;
        Festival f = abmFestival.traerFestivalyCosto(id);
        System.out.printf("Festival y costo: %s", f);
    }
}
