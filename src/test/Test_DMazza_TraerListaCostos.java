package test;

import negocio.CostoABM;

public class Test_DMazza_TraerListaCostos {
    public static void main(String[] args) {
        CostoABM abm = new CostoABM();
        System.out.println(abm.traer());
    }
}
