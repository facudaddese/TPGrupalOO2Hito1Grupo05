package test;


import negocio.FestivalABM;

public class Test_DMazza_modificarFestivalPorNombre {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FestivalABM abmFestival = new FestivalABM();
	
		try {
			System.out.println("\nFestival original: \n");
			System.out.println(abmFestival.traerFestivalPorNombre("Lollapalooza"));
			abmFestival.modificarFestivalPorNombre("Lollapalooza", "Lollapalooza! 27");
			
			System.out.println("\nCambio de nombre de festival: \n");
			System.out.println(abmFestival.traerFestivalPorNombre("Lollapalooza! 27"));
			
		}catch (Exception e) {
			System.out.println("******* Error en 'Modificar festival' *******\n " + e.getMessage());
			System.out.println("\n");
		}


		


	}

}
