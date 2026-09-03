package test;

import datos.ItemPedido;
import datos.Pedido;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;

public class TraerItemPedidoYPlato {
    static void main(String[] args) {
        int idIP = 1;

        ItemPedidoABM abm = new ItemPedidoABM();

        ItemPedido itp = abm.traerIPyPlato(idIP);
        System.out.printf("Traer Item pedido=%d\n", idIP);
        System.out.printf("\n%s\n", itp);
        System.out.printf("\n%s", itp.getPlato());
    }
}
