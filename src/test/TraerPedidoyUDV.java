package test;

import datos.Pedido;
import negocio.PedidoABM;

public class TraerPedidoyUDV {

    static void main(String[] args) {

        int idPedido = 1;

        PedidoABM abm = new PedidoABM();

        Pedido pedido = abm.traerPedidoYUnidadDeVenta(idPedido);
        System.out.printf("Traer pedido=%d\n", idPedido);
        System.out.printf("\n%s\n", pedido);
        System.out.printf("\nUnidad de venta encargada del pedido: %s", pedido.getUnidadDeVenta());
    }
}
