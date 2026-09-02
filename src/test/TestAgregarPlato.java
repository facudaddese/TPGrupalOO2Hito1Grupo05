package test;

import negocio.PlatoABM;

public class TestAgregarPlato {

    static void main(String[] args) {
        PlatoABM abm = new PlatoABM();

        long ultimoId = abm.agregar("Ñoquis", 10000, 3000);
        System.out.println("Plato ultimo id:" +ultimoId);

    }
}
