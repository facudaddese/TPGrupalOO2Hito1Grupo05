package test;

import datos.Staff;
import datos.Cocinero;
import datos.Cajero;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

import java.time.LocalDate;
import java.util.List;

public class TestDaddese_Traer {
    public static void main(String[] args) {
        StaffABM abm = new StaffABM();
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();

        // Traer por id
        System.out.println("--- Traer por id ---");
        Staff porId = abm.traer(1);
        System.out.println(porId);

        // Traer por DNI
        System.out.println("--- Traer por DNI ---");
        Staff porDni = abm.traerPorDni(42575495);
        System.out.println(porDni);

        // Traer Staff completo
        System.out.println("--- Listado Staff ---");
        List<Staff> lista = abm.traer();
        lista.forEach(System.out::println);

        // Traer cocineros de un festival, entre fechas de nacimiento
        System.out.println("--- Cocineros de festival por rango de fecha ---");
        List<Staff> cocineros = abmUDV.traerCocinerosDeFestivalEntre(
                "Gourmet", LocalDate.of(1985, 4, 30), LocalDate.of(1995, 5, 10));
        cocineros.forEach(System.out::println);

        // Traer cajeros de un festival, por turno y sueldo
        System.out.println("--- Cajeros de festival por turno y sueldo ---");
        List<Staff> cajeros = abmUDV.traerCajerosDeFestivalPorTurnoYSueldo(
                "Gourmet", "noche", 1000000);
        cajeros.forEach(System.out::println);

        // Traer cajeros por turno, mayores de edad
        System.out.println("--- Cajeros por turno, mayores de edad ---");
        List<Cajero> cajerosPorTurno = abm.traerCajerosPorTurnoMayoresDeEdad("noche");
        cajerosPorTurno.forEach(System.out::println);

        // Traer cocineros por especialidad y sueldo > 100000
        System.out.println("--- Cocineros por especialidad, sueldo > 100000 ---");
        List<Cocinero> cocinerosPorEspecialidad = abm.traerCocinerosPorEspecialidadYSueldo("Parrillero", 100000);
        cocinerosPorEspecialidad.forEach(System.out::println);
    }
}