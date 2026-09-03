package test;

import datos.Festival;
import datos.Pedido;
import negocio.FestivalABM;
import negocio.PedidoABM;

public class TraerPedidoYFestival {
    static void main(String[] args) {

        int idPedido = 1;

        PedidoABM abm = new PedidoABM();

        Pedido pedido = abm.traerPedidoYFestival(idPedido);
        System.out.printf("Traer pedido=%d\n", idPedido);
        System.out.printf("\n%s\n", pedido);

        FestivalABM fAbm = new FestivalABM();
        System.out.printf("\nFestival donde se realizo el pedido: %s", fAbm.traerFestivalYUnidadDeVenta(1));
    }
}
