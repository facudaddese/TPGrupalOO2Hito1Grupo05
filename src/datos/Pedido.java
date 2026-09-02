package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {

    private long idPedido;
    private LocalDate fechaTransaccion;
    private UnidadDeVenta unidadDeVenta;
    private Set<ItemPedido> listaItems;

    public Pedido() {
    }

    public Pedido(LocalDate fechaTransaccion, UnidadDeVenta unidadDeVenta) {
        this.fechaTransaccion = fechaTransaccion;
        this.unidadDeVenta = unidadDeVenta;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public UnidadDeVenta getUnidadDeVenta() {
        return unidadDeVenta;
    }

    public void setUnidadDeVenta(UnidadDeVenta unidadDeVenta) {
        this.unidadDeVenta = unidadDeVenta;
    }

    public Set<ItemPedido> getListaItems() {
        return listaItems;
    }

    public void setListaItems(Set<ItemPedido> listaItems) {
        this.listaItems = listaItems;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "unidadDeVenta=" + unidadDeVenta +
                ", fechaTransaccion=" + fechaTransaccion +
                ", idPedido=" + idPedido +
                '}';
    }
}
