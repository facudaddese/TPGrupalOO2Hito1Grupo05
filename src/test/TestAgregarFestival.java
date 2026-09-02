package test;

import java.time.LocalDate;

import datos.Costo;
import negocio.FestivalABM;

public class TestAgregarFestival {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FestivalABM abm = new FestivalABM();
		Costo c = new Costo(4,5,6,2);
		int ultimoIdFestival = abm.agregar("Gourmet","verano", LocalDate.of(2026, 8, 22), LocalDate.now(), c);
	
		System.out.printf("Id Festival creado: %d", ultimoIdFestival);

	}
}
