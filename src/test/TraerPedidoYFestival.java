package test;

import datos.Pedido;
import negocio.PedidoABM;

public class TraerPedidoYFestival {
    static void main(String[] args) {

        int idPedido = 1;

        PedidoABM abm = new PedidoABM();

        Pedido pedido = abm.traerPedidoYFestival(idPedido);
        System.out.printf("Traer pedido=%d\n", idPedido);
        System.out.printf("\n%s\n", pedido);
        System.out.printf("\nFestival donde se realizo el pedido: %s", pedido.getFestival());
    }
}
