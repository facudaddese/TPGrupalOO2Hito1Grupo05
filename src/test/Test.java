package test;

import datos.Staff;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

import java.time.LocalDate;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        StaffABM abmStaff = new StaffABM();
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();

        //InicioTest - Facundo D'Addese
        //Agrego cocineros y cajeros
        abmStaff.agregarCocinero("Juan", "Pérez", 30111222, LocalDate.of(1990, 5, 10), LocalDate.of(2023, 1, 15), 350000, "Parrillero", 50000);
        abmStaff.agregarCocinero("Facuno", "Diaz", 14852741, LocalDate.of(1987, 4, 30), LocalDate.of(2026, 4, 10), 600000, "Cheff", 50000);
        abmStaff.agregarCocinero("Santiago", "Sosa", 57951753, LocalDate.of(1999, 1, 20), LocalDate.of(2020, 6, 19), 450000, "Mozo", 50000);
        abmStaff.agregarCajero("Ana", "Gómez", 28555111, LocalDate.of(1995, 3, 20), LocalDate.of(2024, 2, 1), 1300000, "mañana");
        abmStaff.agregarCajero("Milagros", "Santos", 17481765, LocalDate.of(1985, 9, 5), LocalDate.of(2019, 10, 28), 200000, "noche");
        abmStaff.agregarCajero("Adrian", "Martinez", 99761329, LocalDate.of(1992, 7, 7), LocalDate.of(2023, 12, 9), 900000, "noche");

        //Creo una lista para traer a todos los cocineros de un festival especifico entre un rango de fechas
        //La lista va a estar vacia hasta que se agreguen los cocineros a la unidad de venta del festival
        //ej:  abmUDV.asignarStaff(la unidad de venta correspondiente, 30111222);
        //Para eso hay que crear previamente la unidad de venta y el festival

        List<Staff> listaCocineros = abmUDV.traerCocinerosDeFestivalEntre("Gourmet", LocalDate.of(1985, 4, 30), LocalDate.of(1995, 5, 10));
        listaCocineros.forEach(System.out::println);

        //Creo una lista para traer a todos los cajeros de un turno en especifico, que cobren < 1.000.000
        //Mismo caso que antes, tiene que esta asignado al staff
        List<Staff> listaCajeros = abmUDV.traerCajerosDeFestivalPorTurnoYSueldo("Gourmet", "noche", 1000000);
        listaCajeros.forEach(System.out::println);
        // FinTest - Facundo D'Addese
    }
}
