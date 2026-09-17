package test;

import datos.Festival;
import datos.ItemPedido;
import datos.Pedido;
import negocio.FestivalABM;

import negocio.PedidoABM;

import java.util.List;

public class Test_Lescano_RankingPedidosDeFestival {
    static void main(String[] args) {

        FestivalABM festivalABM = new FestivalABM();
        PedidoABM abmPedido = new PedidoABM();

        Festival festival_primavera = festivalABM.traerFestivalPorNombre("Primavera Sound");

        List<Pedido> ranking = abmPedido.rankingPedidosMasCarosDeUnFestival(festival_primavera);
        System.out.println("\nRanking Pedidos Mas Caros De " + festival_primavera.getNombre() + ":");

        for (Pedido p : ranking) {
            System.out.println("> id: " + p.getIdPedido() + " - " + p.getFechaTransaccion() + " | Total: $" + p.getTotal());

            for(ItemPedido ip : p.getListaItems()) {
                System.out.println("   -> Plato: " + ip.getPlato().getNombre() + " | Cantidad: " + ip.getCantidad());
            }
        }
    }
}