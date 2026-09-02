package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {

    private int idPedido;
    private LocalDate fechaTransaccion;
    private UnidadDeVenta unidadDeVenta;
    private Set<ItemPedido> listaItems;
    private Festival festival;

    public Pedido() {
    }

    public Pedido(LocalDate fechaTransaccion, UnidadDeVenta unidadDeVenta, Festival festival) {
        this.fechaTransaccion = fechaTransaccion;
        this.unidadDeVenta = unidadDeVenta;
        this.festival = festival;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
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

    public Festival getFestival() {
        return festival;
    }
    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", fechaTransaccion=" + fechaTransaccion +
                ", unidadDeVenta=" + unidadDeVenta +
                ", festival=" + festival +
                '}';
    }
}
