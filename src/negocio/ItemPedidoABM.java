package negocio;

import dao.ItemPedidoDao;
import datos.ItemPedido;
import datos.Pedido;
import datos.Plato;

public class ItemPedidoABM {

    ItemPedidoDao dao = new ItemPedidoDao();

    public ItemPedido traer(long idPlato) {
        return dao.traer(idPlato);
    }

    public int agregar(Plato plato, int cantidad, Pedido pedido) {
        ItemPedido ip = new ItemPedido(plato, cantidad, pedido);
        return dao.agregar(ip);
    }

    public void modificar(ItemPedido ip) {
        dao.actualizar(ip);
    }

}
