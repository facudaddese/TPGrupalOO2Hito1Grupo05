package test;

import java.time.LocalDate;

import datos.Festival;
import negocio.FestivalABM;

public class Test_DMazza_TraerUnidadesDeVentaDeFestival {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FestivalABM abmFestival = new FestivalABM();



		System.out.println("Traer lista de festivales exisentes ");
		System.out.println(abmFestival.traer());



		System.out.println("\nTraer todas las unidades de venta de un festival por filtros de festival: \n");

		System.out.printf("El Festival '%s' tiene asociada las Unidades de Venta: '%s'"
				, abmFestival.traerFestivalPorTemporadaNombreYFecha("primavera","Primavera Sound",LocalDate.of(2026, 11, 10), LocalDate.of(2026, 11, 20)).getNombre() 
				, abmFestival.traerUnidadesDeVentasPorFestival("Primavera Sound","primavera",LocalDate.of(2026, 11, 10), LocalDate.of(2026, 11, 20)) );


	}

}
