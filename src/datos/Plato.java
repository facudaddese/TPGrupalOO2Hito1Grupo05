package datos;

import java.util.Objects;
import java.util.Set;

public class Plato {

    private int idPlato;
    private String nombre;
    private long precio;
    private long costoProduccion;
    private UnidadDeVenta unidadDeVenta;
    private Set<ItemPedido> listaItems;

    public Plato() {
    }

    public Plato(String nombre, long precio, long costoProduccion, UnidadDeVenta unidadDeVenta) throws Exception {
        this.nombre = nombre;
        setPrecio(precio);
        setCostoProduccion(costoProduccion);
        this.unidadDeVenta = unidadDeVenta;
    }

    public int getIdPlato() {
        return idPlato;
    }

    protected void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) throws Exception {
        if (precio < 0) {
            throw new Exception("Precio no puede ser menor a 0!");
        }
        this.precio = precio;
    }

    public long getCostoProduccion() {
        return costoProduccion;
    }

    public void setCostoProduccion(long costoProduccion) throws Exception {
        if (costoProduccion < 0) {
            throw new Exception("Costo no puede ser menor a 0!");
        }
        this.costoProduccion = costoProduccion;
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
        return "Plato{" +
                "idPlato=" + idPlato +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", costoProduccion=" + costoProduccion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Plato plato = (Plato) o;
        return getPrecio() == plato.getPrecio() && getCostoProduccion() == plato.getCostoProduccion() && Objects.equals(getNombre(), plato.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getPrecio(), getCostoProduccion());
    }
}

