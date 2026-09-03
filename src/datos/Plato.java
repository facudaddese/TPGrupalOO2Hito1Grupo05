package datos;

public class Plato {

    private int idPlato;
    private String nombre;
    private long precio;
    private long costoProduccion;

    public Plato() {
    }

    public Plato(String nombre, long precio, long costoProduccion) throws Exception {
        this.nombre = nombre;
        setPrecio(precio);
        setCostoProduccion(costoProduccion);
    }

    public int getIdPlato() {
        return idPlato;
    }
    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }
    public String getNombre() {return nombre;}
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
