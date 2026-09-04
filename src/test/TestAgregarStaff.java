package test;

import java.time.LocalDate;

import datos.Cajero;
import datos.Cocinero;
import negocio.StaffABM;

public class TestAgregarStaff {
    public static void main(String[] args) throws Exception {
        StaffABM abm = new StaffABM();

        abm.agregarCocinero("Juan", "Pérez", 30111222, LocalDate.of(1990, 5, 10), LocalDate.of(2023, 1, 15), 350000, "Parrillero", 50000);

        abm.agregarCocinero("Facuno", "Diaz",14852741, LocalDate.of(1987, 4, 30), LocalDate.of(2026, 4, 10), 600000, "Cheff", 50000);

        abm.agregarCocinero("Santiago", "Sosa",57951753, LocalDate.of(1999, 1, 20), LocalDate.of(2020, 6, 19), 450000, "Mozo", 50000);

        abm.agregarCajero("Ana", "Gómez", 28555111, LocalDate.of(1995, 3, 20), LocalDate.of(2024, 2, 1), 300000, "mañana");

        abm.agregarCajero("Milagros", "Santos", 17481765, LocalDate.of(1985, 9, 5), LocalDate.of(2019, 10, 28), 900000, "mañana");

        /*
        - Lanza la exception "ya existe un integrante del Staff con el mismo DNI"
        abm.agregar("Juan", "Pérez", 30111222, LocalDate.of(1990, 5, 10), LocalDate.of(2023, 1, 15), 350000, "Parrillero", 50000);
        */

        System.out.println("Datos insertados");
    }
}