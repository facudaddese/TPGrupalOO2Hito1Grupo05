package negocio;

import dao.PedidoDao;
import datos.Pedido;
import datos.UnidadDeVenta;

import java.time.LocalDate;

public class PedidoABM {

    PedidoDao dao = new PedidoDao();

    public Pedido traer(long idPedido) {
        return dao.traer(idPedido);
    }

    public int agregar(LocalDate fechaTransaccion, UnidadDeVenta unidadDeVenta) {
        Pedido p = new Pedido(fechaTransaccion, unidadDeVenta);
        return dao.agregar(p);
    }

    public void modificar(Pedido p) {
        dao.actualizar(p);
    }

    public Pedido traerPedidoEitemPedido(long idPedido) {
        return dao.traerPedidoEitemPedido(idPedido);
    }

}
