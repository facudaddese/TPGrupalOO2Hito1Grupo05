package test;

import java.time.LocalDate;

import negocio.FestivalABM;

public class Test_DMazza_TraerSueldoPromedioDelStaffDeUnFestival {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FestivalABM abmFestival = new FestivalABM();

		System.out.println("\nTraer el sueldo promedio del staff de 1 festival: \n");

		System.out.printf("En el Festival '%s' el sueldo promedio del staff es de  $%.2f%n \n"
				, abmFestival.traerFestivalPorTemporadaNombreYFecha("primavera","Primavera Sound",LocalDate.of(2026, 11, 10), LocalDate.of(2026, 11, 20)).getNombre() ,
				abmFestival.traerSueldoPromedioStaffDeFestival("Primavera Sound")				);
	}

}
