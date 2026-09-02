package datos;

public class Plato {

    private long idPlato;
    private String nombre;
    private long precio;
    private long costoProduccion;

    public Plato() {
    }

    public Plato(String nombre, long precio, long costoProduccion) {
        this.nombre = nombre;
        this.precio = precio;
        this.costoProduccion = costoProduccion;
    }

    public long getIdPlato() {
        return idPlato;
    }
    public void setIdPlato(long idPlato) {
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
    public void setPrecio(long precio) {
        this.precio = precio;
    }
    public long getCostoProduccion() {
        return costoProduccion;
    }
    public void setCostoProduccion(long costoProduccion) {
        this.costoProduccion = costoProduccion;
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
}
