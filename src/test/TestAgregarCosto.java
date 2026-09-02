package test;

import datos.Costo;
import datos.Festival;
import negocio.CostoABM;
import negocio.FestivalABM;

public class TestAgregarCosto {
	public static void main(String[] args) {
		
		FestivalABM abmFestival = new FestivalABM();
		Festival festival = abmFestival.traer(1);
		System.out.println(festival);
		
		
		
		CostoABM abmCosto= new CostoABM();
		
		/*Costo c = new Costo(1,2,3,4);
		try {
		    int ultimoCosto = abm.agregar(c);
		    System.out.println("Costo agregado, id: " + ultimoCosto);
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		*/
		
		 abmCosto.agregar(3, 44, 30, 20, festival);

		
		
	}
}
