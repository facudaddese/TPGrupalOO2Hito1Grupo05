package datos;

import java.util.List;
import java.util.Set;

public class UnidadDeVenta {

    private int id;
    private String nombreComercial;
    private Staff responsable;
    private int superficie;
    private String codigo;
    //TODO: Una vez agregados los platos agregar la lista de platos a UnidadDeVenta
    //private Set<Plato> lstPlatos;
    private Set<Staff> lstStaff;
    private boolean activo;

    public UnidadDeVenta() {

    }

    public UnidadDeVenta(boolean activo, String nombreComercial, int superficie, Set<Staff> lstStaff, String codigo, Staff responsable) {
        this.activo = activo;
        this.nombreComercial = nombreComercial;
        this.superficie = superficie;
        this.lstStaff = lstStaff;
        this.codigo = codigo;
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public Staff getResponsable() {
        return responsable;
    }

    public void setResponsable(Staff responsable) {
        this.responsable = responsable;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Set<Staff> getLstStaff() {
        return lstStaff;
    }

    public void setLstStaff(Set<Staff> lstStaff) {
        this.lstStaff = lstStaff;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "UnidadDeVenta{" +
                "id=" + id +
                ", nombreComercial='" + nombreComercial + '\'' +
                ", responsable=" + responsable +
                ", superficie=" + superficie +
                ", codigo='" + codigo + '\'' +
                ", lstStaff=" + lstStaff +
                ", activo=" + activo +
                '}';
    }
}
