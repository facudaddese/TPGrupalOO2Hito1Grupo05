package test;

import negocio.FestivalABM;

public class TestTraerFestivalyUnidadesDeVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FestivalABM abmFestival = new FestivalABM();
		
		//primero correr test agregar festival y dsp agregr unidad de venta . 
		// unidad de venta esta configurado como "lazy" - entonces lo traigo con getUnidadesDeVenta
		
		System.out.println("Traer festival por ID y sus unidades de ventas asociadas");
		//System.out.println(abmFestival.traerFestivalYUnidadDeVenta(1));
	    System.out.printf("\n%s", abmFestival.traerFestivalYUnidadDeVenta(1).getUnidadesDeVenta() );
		

	}

}
