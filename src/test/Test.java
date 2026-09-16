package test;

import datos.*;
import negocio.*;

import java.time.LocalDate;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        StaffABM abmStaff = new StaffABM();
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();
        FestivalABM festivalABM = new FestivalABM();
        PlatoABM abmPlato = new PlatoABM();
        CostoABM abmCosto = new CostoABM();
        PedidoABM abmPedido = new PedidoABM();
        ItemPedidoABM abmItemPedido = new ItemPedidoABM();

        Festival festival_primavera = null, festival_verano = null, festival_otonio = null;


        // ************* Inicio TEST Daira Mazza ************************

        //Agregar festival
        try {
        	festivalABM.agregar("Primavera Sound", "primavera", LocalDate.of(2026, 11, 10), LocalDate.of(2026, 11, 20));
            festivalABM.agregar("Fiesta BA", "verano", LocalDate.of(2026, 12, 25), LocalDate.of(2026, 12, 29));
            festivalABM.agregar("Lollapalooza", "otonio", LocalDate.of(2027, 03, 12), LocalDate.of(2027, 03, 14));
            festivalABM.agregar("Lollapalooza", "otonio", LocalDate.of(2027, 03, 12), LocalDate.of(2027, 03, 14));
		} catch (Exception e) {
			System.out.println("******* Error en 'Agregar festival' *******\n " + e.getMessage());
			System.out.println("\n");
		}


        //  Recuperar festivales y asignarles costo
        try {
        	festival_primavera = festivalABM.traerFestivalPorNombre("Primavera Sound");
        	festival_verano = festivalABM.traerFestivalPorFechaInicioFin(LocalDate.of(2026, 12, 25), LocalDate.of(2026, 12, 29));
        	festival_otonio = festivalABM.traerFestivalPorTemporadaNombreYFecha("otonio","Lollapalooza",LocalDate.of(2027, 3, 12), LocalDate.of(2027, 3, 14) );

        	abmCosto.agregar(10, 12, 14, 16, festival_primavera);
            abmCosto.agregar(11, 13, 15, 17, festival_verano );
            abmCosto.agregar(32, 34, 36, 38, festival_otonio);

		} catch (Exception e) {
			System.out.println("******* Error en 'Agregar costo' *******\n " + e.getMessage());
			System.out.println("\n");
		}

     // ************************ Fin TEST Daira Mazza ************************

        ///Test para agregar unidades de venta (Lautaro Gonzalez)
        try {
            abmUDV.agregarPuestoDes(true, "Kiddo's", 30, "PUESTO-001", festival_primavera, 2, 70.0f);
            abmUDV.agregarFoodTruck(true, "Pancheria", 20, "PUESTO-002", festival_primavera, "ABC123", true);
            abmUDV.agregarFoodTruck(true, "Beer & Drinks Van", 25, "PUESTO-004", festival_primavera, "XYZ789", false);
            abmUDV.agregarPuestoDes(true, "La Parrilla de Don Julio", 50, "PUESTO-003", festival_verano, 3, 110.0f);
            System.out.println("Unidades de venta agregadas correctamente.");
        } catch (Exception e) {
            System.out.println("Aviso unidades: " + e.getMessage());
        }

        //InicioTest - Facundo D'Addese
        //Agrego cocineros y cajeros
        abmStaff.agregarCocinero("Juan", "Pérez", 30111222, LocalDate.of(1990, 5, 10), LocalDate.of(2023, 1, 15), 350000, "Parrillero", 50000);
        abmStaff.agregarCocinero("Facuno", "Diaz", 14852741, LocalDate.of(1987, 4, 30), LocalDate.of(2026, 4, 10), 600000, "Cheff", 50000);
        abmStaff.agregarCocinero("Santiago", "Sosa", 57951753, LocalDate.of(1999, 1, 20), LocalDate.of(2020, 6, 19), 450000, "Mozo", 50000);
        abmStaff.agregarCajero("Ana", "Gómez", 28555111, LocalDate.of(1995, 3, 20), LocalDate.of(2024, 2, 1), 1300000, "mañana");
        abmStaff.agregarCajero("Milagros", "Santos", 17481765, LocalDate.of(1985, 9, 5), LocalDate.of(2019, 10, 28), 200000, "noche");
        abmStaff.agregarCajero("Adrian", "Martinez", 99761329, LocalDate.of(1992, 7, 7), LocalDate.of(2023, 12, 9), 900000, "noche");

        ///Asignamos Staff a unidades de venta (Lautaro Gonzalez)
        Staff cocineroPerez = abmStaff.traerPorDni(30111222);
        Staff cocineroDiaz = abmStaff.traerPorDni(14852741);
        Staff cocineroSosa = abmStaff.traerPorDni(57951753);
        Staff cajeraGomez = abmStaff.traerPorDni(28555111);
        Staff cajeraSantos = abmStaff.traerPorDni(17481765);
        Staff cajeroMartinez = abmStaff.traerPorDni(99761329);

        try {
            System.out.println("\n--- TEST: Asignacion de Staff ---");
            abmUDV.asignarStaff("PUESTO-001", cocineroPerez);
            abmUDV.asignarStaff("PUESTO-001", cajeraGomez);

            abmUDV.asignarStaff("PUESTO-002", cocineroDiaz);
            abmUDV.asignarStaff("PUESTO-002", cajeraSantos);

            abmUDV.asignarStaff("PUESTO-003", cocineroSosa);
            abmUDV.asignarStaff("PUESTO-003", cajeroMartinez);

            abmUDV.asignarStaff("PUESTO-004", cocineroDiaz);
            System.out.println("Personal asignado con éxito.");
        } catch (Exception e) {
            System.out.println("Fallo en asignación de staff: " + e.getMessage());
        }

        ///Asignamos responsables a las unidades de venta (Lautaro Gonzalez)
        try{
            System.out.println("\n---TEST: Asignacion de Responsables ---");
            abmUDV.asignarResponsable("PUESTO-001", cocineroPerez);
            abmUDV.asignarResponsable("PUESTO-002", cocineroDiaz);
            abmUDV.asignarResponsable("PUESTO-003", cocineroSosa);
            abmUDV.asignarResponsable("PUESTO-004", cajeroMartinez);

            System.out.println("Responsables asignados con exito");

        }catch (Exception e){
            System.out.println("Fallo al asignar responsable: " + e.getMessage());
        }


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

        //Test agregar Platos - Malena Lescano

        UnidadDeVenta udv = abmUDV.traer(1);
        UnidadDeVenta udv2 = abmUDV.traer(2);


        abmPlato.agregar("Milanesa Simple", 10000, 3000, udv);
        abmPlato.agregar("Milanesa Napolitana", 15000, 6000, udv);
        abmPlato.agregar("Milanesa A Caballo", 15000, 6000, udv);
        abmPlato.agregar("Ravioles", 9000, 3500, udv);
        abmPlato.agregar("Sorrentinos", 12000, 5000, udv);
        abmPlato.agregar("Lasagna", 14000, 5500, udv);

        abmPlato.agregar("Pizza Muzarella", 11000, 4000, udv2);
        abmPlato.agregar("Pizza Napolitana", 13000, 5000, udv2);
        abmPlato.agregar("Pizza Especial", 16000, 7000, udv2);
        abmPlato.agregar("Empanadas", 8000, 3000, udv2);
        abmPlato.agregar("Hamburguesa Completa", 12500, 5000, udv2);
        abmPlato.agregar("Hamburguesa Doble", 18000, 7500, udv2);

        try {
            // Caso de excepción
            System.out.println("Caso de excepcion: ");
            abmPlato.agregar("Ñoquis", -10000, 0, udv2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- TEST: Agregar Pedidos e ItemPedido ---");

        //Test agregar Pedido - Malena Lescano
        abmPedido.agregar(LocalDate.of(2026,9,1),udv,festival_primavera);
        abmPedido.agregar(LocalDate.of(2026,9,4),udv,festival_primavera);
        abmPedido.agregar(LocalDate.of(2026,9,11),udv,festival_primavera);
        abmPedido.agregar(LocalDate.of(2026,9,10),udv,festival_primavera);

        //Test agregar ItemPedido - Malena Lescano
        abmItemPedido.agregar(abmPlato.traerPlatoYUnidadDeVenta("Milanesa Simple"),3,abmPedido.traerPedidoYUnidadDeVenta(1));
        abmItemPedido.agregar(abmPlato.traerPlatoYUnidadDeVenta("Sorrentinos"),1,abmPedido.traerPedidoYUnidadDeVenta(1));
        abmItemPedido.agregar(abmPlato.traerPlatoYUnidadDeVenta("Milanesa A Caballo"),2,abmPedido.traerPedidoYUnidadDeVenta(2));
        abmItemPedido.agregar(abmPlato.traerPlatoYUnidadDeVenta("Milanesa A Caballo"),1,abmPedido.traerPedidoYUnidadDeVenta(4));

        try {
            //Caso de excepcion, este plato no pertenece a udv, pertenece a udv2
            abmItemPedido.agregar(abmPlato.traerPlatoYUnidadDeVenta("Pizza Especial"),1,abmPedido.traerPedidoYUnidadDeVenta(1));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ///Asignamos platos a unidades de venta (Lautaro Gonzalez)

        Plato plato1 = abmPlato.traerPorNombre("Milanesa Simple");
        Plato plato2 = abmPlato.traerPorNombre("Ravioles");

        try {
            System.out.println("\n--- TEST: Asignacion de Platos ---");
            abmUDV.asignarPlato("PUESTO-001", plato1);
            abmUDV.asignarPlato("PUESTO-002", plato2);
            System.out.println("Platos agregados con éxito.");
        } catch (Exception e) {
            System.out.println("Fallo inesperado: " + e.getMessage());
        }

        //Test traer platos que contengan el texto pasado por parametro en el nombre - Malena Lescano
        System.out.println("\n--- TEST: Traer Platos ---");
        System.out.println("\nPlatos que contengan 'Mila' en su nombre:");
        List<Plato> platosConNombre = abmPlato.traerPlatosPorTexto("Mila");
        platosConNombre.forEach(System.out::println);


        //Ranking de platos mas vendidos de una unidad de venta especifica - Malena Lescano
        System.out.println("\nRanking de platos mas vendidos de " + udv.getNombreComercial() +":");
        List<Object[]> rankingDePlatos = abmPlato.traerRankingPlatosMasVendidosDeUnaUDV(udv);
        for (Object[] obj : rankingDePlatos) {

            Plato plato = (Plato) obj[0];
            Long cantidad = (Long) obj[1];

            System.out.println(plato.getNombre() + " - " + cantidad + " total de unidades vendidas");
        }

        //Test traer pedidos realizados entre rango de fechas de una UDV especifica - Malena Lescano
        System.out.println("\n--- TEST: Traer Pedidos ---");
        LocalDate inicio = LocalDate.of(2026,9,1);
        LocalDate fin = LocalDate.of(2026,9,10);
        System.out.println("\nPedidos entre " + inicio + " y " + fin + " de " + udv.getNombreComercial());

        List<Object[]> resultados = abmPedido.traerPedidosRealizadosEntreFechasDeUnaUDV(inicio, fin, udv);

        for (Object[] fila : resultados) {
            Pedido p = (Pedido) fila[0];
            ItemPedido ip = (ItemPedido) fila[1];

            System.out.println("=================================================");
            System.out.println("Pedido ID: " + p.getIdPedido() + " | Fecha: " + p.getFechaTransaccion());
            System.out.println("  -> Plato: " + abmPlato.traer(ip.getPlato().getIdPlato()) + ", cantidad: " + ip.getCantidad());
        }



    }
}
