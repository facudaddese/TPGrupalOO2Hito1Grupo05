package datos;

public class ItemPedido {

    private long idItemPedido;
    private Plato plato;
    private int cantidad;
    private Pedido pedido;

    public ItemPedido() {
    }
    public ItemPedido(Plato plato, int cantidad, Pedido pedido) {
        this.plato = plato;
        this.cantidad = cantidad;
        this.pedido = new Pedido();
    }
    public long getIdItemPedido() {
        return idItemPedido;
    }
    public void setIdItemPedido(long idItemPedido) {
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
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "idItemPedido=" + idItemPedido +
                ", plato=" + plato +
                ", cantidad=" + cantidad +
                '}';
    }
}
