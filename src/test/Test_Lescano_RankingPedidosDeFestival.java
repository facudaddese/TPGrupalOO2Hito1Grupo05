package test;

import datos.Festival;
import datos.Pedido;
import negocio.FestivalABM;
import negocio.PedidoABM;

import java.util.List;

public class Test_Lescano_RankingPedidosDeFestival {
    static void main(String[] args) {

        FestivalABM festivalABM = new FestivalABM();
        PedidoABM abmPedido = new PedidoABM();
        Festival festival_primavera = festivalABM.traerFestivalPorNombre("Primavera Sound");

        List<Object[]> ranking = abmPedido.rankingPedidosMasCarosDeUnFestival(festival_primavera);
        System.out.println("\nRanking Pedidos Mas Caros De " + festival_primavera.getNombre() + ":");
        for (Object[] fila  : ranking) {
            Pedido p = (Pedido) fila[0];
            Long total = (Long) fila[1];

            System.out.println("> id: " + p.getIdPedido() + " - " + p.getFechaTransaccion());
            System.out.println("total ---> " + total);

        }
    }
}