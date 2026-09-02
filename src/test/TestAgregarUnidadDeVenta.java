package test;

import datos.Plato;
import datos.Staff;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

import java.util.HashSet;
import java.util.Set;

public class TestAgregarUnidadDeVenta {
    public static void main(String[] args) throws Exception{
        UnidadDeVentaABM abm = new  UnidadDeVentaABM();

        //Creamos Sets vacios para poder dar de alta una unidad de venta

        Set<Staff> staffInicial = new HashSet<>();
        Set<Plato> platosIniciales = new HashSet<>();
        StaffABM staffABM = new StaffABM();
        Staff responsable = staffABM.traer(1);
        Staff responsable2 = staffABM.traer(2);

        abm.agregarPuestoDes( true, "Kiddo's", 30, staffInicial, platosIniciales, "PUESTO-001", responsable, 2, 70.0f);

        abm.agregarFoodTruck(true, "Pancheria", 20, staffInicial, platosIniciales, "PUESTO-002", responsable2, "ABC123", true);

        System.out.println("Datos Insertados");

    }
}
