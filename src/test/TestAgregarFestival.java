package test;

import java.time.LocalDate;

import datos.Costo;
import datos.Festival;
import negocio.CostoABM;
import negocio.FestivalABM;

public class TestAgregarFestival {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		// 27-8
		FestivalABM abm = new FestivalABM();
		Costo c = new Costo(4,5,6,2);
		int ultimoIdFestival = abm.agregar("Gourmet","verano", LocalDate.of(2026, 8, 22), LocalDate.now(), c);
	
		System.out.printf("Id Festival creado: %d", ultimoIdFestival);
		*/
		
		// ajuste 1-9: Se puede generar un festival sin costo ni unidad de venta, después se agrega.
		
		// 1. Festival solo, sin costo ni unidades
		FestivalABM abmFestival = new FestivalABM();
		int idFestival = abmFestival.agregar("Gourmet", "invierno", LocalDate.of(2026, 9, 1), LocalDate.now());

		// 2. Le agrego el costo al festival creado
		Festival festival = abmFestival.traer(idFestival);
		
		CostoABM abmCosto = new CostoABM();
		abmCosto.agregar(11, 2, 33, 44, festival);
		

	}
}
