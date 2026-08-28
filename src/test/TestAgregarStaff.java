package test;

import java.time.LocalDate;

import datos.Cajero;
import datos.Cocinero;
import negocio.StaffABM;

public class TestAgregarStaff {
    public static void main(String[] args) throws Exception {
        StaffABM abm = new StaffABM();

        abm.agregar("Juan", "Pérez", 30111222, LocalDate.of(1990, 5, 10), LocalDate.of(2023, 1, 15), 350000, "Parrillero", 50000);

        abm.agregar("Ana", "Gómez", 28555111, LocalDate.of(1995, 3, 20), LocalDate.of(2024, 2, 1), 300000, "mañana");

        /*
        - Lanza la exception "ya existe un integrante del Staff con el mismo DNI"
        abm.agregar("Juan", "Pérez", 30111222, LocalDate.of(1990, 5, 10), LocalDate.of(2023, 1, 15), 350000, "Parrillero", 50000);
        */

        System.out.println("Datos insertados");
    }
}