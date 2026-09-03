package test;

import datos.Pedido;
import datos.Plato;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;
import negocio.PlatoABM;

public class TestAgregarItemPedido {
    static void main(String[] args) throws Exception {
        ItemPedidoABM ipAbm = new ItemPedidoABM();
        PlatoABM plAbm = new PlatoABM();
        PedidoABM pAbm = new PedidoABM();

        int idPedido = 1;
        int idPlato = 1;
        Plato plato = plAbm.traer(idPlato);
        Pedido pedido = pAbm.traer(idPedido);

        System.out.println("idPedido = " + pedido.getIdPedido());

        int ultimoId = ipAbm.agregar(plato,2,pedido);
        System.out.println("Item ultimo id:" + ultimoId);

    }
}
