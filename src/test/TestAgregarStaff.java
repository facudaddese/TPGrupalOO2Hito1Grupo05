package test;

import datos.Cocinero;
import datos.Cajero;
import negocio.StaffABM;

import java.time.LocalDate;

public class TestAgregarStaff {
    public static void main(String[] args) throws Exception {
        StaffABM abm = new StaffABM();

        Cocinero c = new Cocinero("Juan", "Pérez", 30111222, LocalDate.of(1990, 5, 10), LocalDate.of(2023, 1, 15), 350000, "Parrillero", 50000);
        abm.agregar(c);

        Cajero ca = new Cajero("Ana", "Gómez", 28555111, LocalDate.of(1995, 3, 20), LocalDate.of(2024, 2, 1), 300000, "mañana");
        abm.agregar(ca);

        /*
        - Lanza la exception "ya existe un integrante del Staff con el mismo DNI"
        Cajero caj = new Cajero("Ana", "Gómez", 28555111,
                LocalDate.of(1995, 3, 20),
                LocalDate.of(2024, 2, 1),
                300000, "mañana");
        abm.agregar(caj);
        */

        System.out.println("Datos insertados");
    }
}