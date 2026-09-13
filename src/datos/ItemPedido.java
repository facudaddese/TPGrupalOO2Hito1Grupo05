package datos;

import java.util.Objects;

public class ItemPedido {

    private int idItemPedido;
    private Plato plato;
    private int cantidad;
    private Pedido pedido;
    private long precio;

    public ItemPedido() {
    }
    public ItemPedido(Plato plato, int cantidad, Pedido pedido) throws Exception {
        this.plato = plato;
        setCantidad(cantidad);
        this.pedido = pedido;
        this.precio = plato.getPrecio();
    }
    public int getIdItemPedido() {
        return idItemPedido;
    }
    protected void setIdItemPedido(int idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public Plato getPlato() {
        return plato;
    }
    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) throws Exception {
        if(cantidad <= 0) {
            throw new Exception("Cantidad debe ser mayor a 0");
        }
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public long getPrecio() {
        return precio;
    }
    public void setPrecio(long precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "idItemPedido=" + idItemPedido +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return getCantidad() == that.getCantidad() && Objects.equals(getPlato(), that.getPlato()) && Objects.equals(getPedido(), that.getPedido());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlato(), getCantidad(), getPedido());
    }

    public long getSubtotal() {
        return cantidad * precio;
    }
}
