package test;

import datos.Costo;
import negocio.CostoABM;

public class TestAgregarCosto {
	public static void main(String[] args) {
		CostoABM abm = new CostoABM();
		Costo c = new Costo(1,2,3,4);
		try {
		    int ultimoCosto = abm.agregar(c);
		    System.out.println("Costo agregado, id: " + ultimoCosto);
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
		
		
		
		
	}
}
