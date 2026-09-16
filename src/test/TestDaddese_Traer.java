package test;

import datos.Staff;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

import java.time.LocalDate;
import java.util.List;

public class TestDaddese_Traer {
    public static void main(String[] args) {
        StaffABM abm = new StaffABM();
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();

        // 1. Traer por id
        System.out.println("--- Traer por id ---");
        Staff porId = abm.traer(1);
        System.out.println(porId);

        // 2. Traer por DNI
        System.out.println("--- Traer por DNI ---");
        Staff porDni = abm.traerPorDni(42575495);
        System.out.println(porDni);

        // 3. Traer Staff completo
        System.out.println("--- Listado Staff ---");
        List<Staff> lista = abm.traer();
        lista.forEach(System.out::println);

        // 4. Traer cocineros de un festival, entre fechas de nacimiento
        System.out.println("--- Cocineros de festival por rango de fecha ---");
        List<Staff> cocineros = abmUDV.traerCocinerosDeFestivalEntre(
                "Gourmet", LocalDate.of(1985, 4, 30), LocalDate.of(1995, 5, 10));
        cocineros.forEach(System.out::println);

        // 5. Traer cajeros de un festival, por turno y sueldo
        System.out.println("--- Cajeros de festival por turno y sueldo ---");
        List<Staff> cajeros = abmUDV.traerCajerosDeFestivalPorTurnoYSueldo(
                "Gourmet", "noche", 1000000);
        cajeros.forEach(System.out::println);
    }
}