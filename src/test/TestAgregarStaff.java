package test;

import datos.Cocinero;
import datos.Cajero;
import dao.StaffDao;

import java.time.LocalDate;

public class TestAgregarStaff {
    public static void main(String[] args) {
        StaffDao dao = new StaffDao();

        Cocinero c = new Cocinero("Juan", "Pérez", 30111222,
                LocalDate.of(1990, 5, 10),
                LocalDate.of(2023, 1, 15),
                350000, "Parrillero", 50000);
        dao.agregar(c);

        Cajero ca = new Cajero("Ana", "Gómez", 28555111,
                LocalDate.of(1995, 3, 20),
                LocalDate.of(2024, 2, 1),
                300000, "mañana");
        dao.agregar(ca);

        System.out.println("Datos insertados");
    }
}