package test;

import datos.Festival;
import datos.Plato;
import datos.Staff;
import negocio.FestivalABM;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TestAgregarUnidadDeVenta {
    public static void main(String[] args) throws Exception {
        UnidadDeVentaABM abm = new UnidadDeVentaABM();

        //Creamos Sets vacios para poder dar de alta una unidad de venta

        //[DM 1.9.26] Una unidad de venta SIEMPRE pertenece a un festival, asi que traigo uno existente (primero correr testAgregarFestival)
        FestivalABM festivalABM = new FestivalABM();
        Festival festival = festivalABM.traerFestivalyCosto(1);

        //[DM 1.9.26] Se crean las unidades pasandoles el festival al que pertenecen

        abm.agregarPuestoDes(true, "Kiddo's", 30, "PUESTO-001", festival, 2, 70.0f);

        abm.agregarFoodTruck(true, "Pancheria", 20, "PUESTO-002", festival, "ABC123", true);

        System.out.println("Datos Insertados");
    }
}
