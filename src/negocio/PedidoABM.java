package negocio;

import dao.PedidoDao;
import datos.Festival;
import datos.Pedido;
import datos.UnidadDeVenta;

import java.time.LocalDate;

public class PedidoABM {
    PedidoDao dao = new PedidoDao();

    public Pedido traer(int idPedido) {
        return dao.traer(idPedido);
    }

    public Pedido traerPedidoYUnidadDeVenta(int idPedido) {
        return dao.traerPedidoYUnidadDeVenta(idPedido);
    }

    public Pedido traerPedidoYFestival(int idPedido) {
        return dao.traerPedidoYFestival(idPedido);
    }

    public int agregar(LocalDate fechaTransaccion, UnidadDeVenta unidadDeVenta, Festival festival) {
        Pedido p = new Pedido(fechaTransaccion, unidadDeVenta, festival);
        return dao.agregar(p);
    }

    public void modificar(Pedido p) {
        dao.actualizar(p);
    }

    public Pedido traerPedidoEitemPedido(int idPedido) {
        return dao.traerPedidoEitemPedido(idPedido);
    }
}
