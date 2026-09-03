package test;

import negocio.PlatoABM;

public class TestAgregarPlato {

    public static void main(String[] args) {
        PlatoABM abm = new PlatoABM();

        try {
            int ultimoId = abm.agregar("Ñoquis", 10000, 3000);
            System.out.println("Plato ultimo id:" + ultimoId);
            int ultimoId2 = abm.agregar("Milanesa Napolitana", 15000, 6000);
            System.out.println("Plato ultimo id:" + ultimoId2);

            int casoDeExcepcion = abm.agregar("Ñoquis", -10000, 0);
            System.out.println("Plato ultimo id:" + casoDeExcepcion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
