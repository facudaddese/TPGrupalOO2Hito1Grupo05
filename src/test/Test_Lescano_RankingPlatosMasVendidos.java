package test;

import datos.Plato;
import datos.UnidadDeVenta;
import negocio.PlatoABM;
import negocio.UnidadDeVentaABM;

import java.util.List;

public class Test_Lescano_RankingPlatosMasVendidos {
    static void main(String[] args) {

        PlatoABM abmPlato = new PlatoABM();
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();
        UnidadDeVenta udv = abmUDV.traer(1);

        //Ranking de platos mas vendidos de una unidad de venta especifica - Malena Lescano
        System.out.println("\nRanking de platos mas vendidos de " + udv.getNombreComercial() +":");
        List<Object[]> rankingDePlatos = abmPlato.traerRankingPlatosMasVendidosDeUnaUDV(udv);
        for (Object[] obj : rankingDePlatos) {

            Plato plato = (Plato) obj[0];
            Long cantidad = (Long) obj[1];

            System.out.println(plato.getNombre() + " - " + cantidad + " total de unidades vendidas");
        }
    }
}
