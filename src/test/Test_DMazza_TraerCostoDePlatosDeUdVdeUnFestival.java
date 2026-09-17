package test;

import java.time.LocalDate;

import negocio.FestivalABM;

public class Test_DMazza_TraerCostoDePlatosDeUdVdeUnFestival {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FestivalABM abmFestival = new FestivalABM();
		
		System.out.println("\nTraer el costo total de platos de unidades de venta asociadas a 1 festival: \n");

		System.out.printf("El Festival '%s' obtuvo una ganancia de $%d de la venta de platos en sus unidades de ventas asociadas \n"
				, abmFestival.traerFestivalPorTemporadaNombreYFecha("primavera","Primavera Sound",LocalDate.of(2026, 11, 10), LocalDate.of(2026, 11, 20)).getNombre() ,
				abmFestival.traercostoTotalPlatosPorFestival("Primavera Sound")				);

	}

}
