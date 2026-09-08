package negocio;

import dao.ItemPedidoDao;
import datos.ItemPedido;
import datos.Pedido;
import datos.Plato;

public class ItemPedidoABM {
    ItemPedidoDao dao = new ItemPedidoDao();

    public ItemPedido traer(int idItemPedido) {
        return dao.traer(idItemPedido);
    }

    public ItemPedido traerIPyPlato(int idItemPedido) {
        return dao.traerIPyPlato(idItemPedido);
    }

    public int agregar(Plato plato, int cantidad, Pedido pedido, long precio) throws Exception {
        ItemPedido ip = new ItemPedido(plato, cantidad, pedido, precio);
        return dao.agregar(ip);
    }

    public void modificar(ItemPedido ip) {
        dao.actualizar(ip);
    }
}
