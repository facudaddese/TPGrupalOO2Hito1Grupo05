package test;

import negocio.CostoABM;

public class TestListarCostos {
    public static void main(String[] args) {
        CostoABM abm = new CostoABM();
        System.out.println(abm.traer());
    }
}
