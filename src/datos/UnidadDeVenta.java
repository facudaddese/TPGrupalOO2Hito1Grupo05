package datos;

import java.util.HashSet;
import java.util.Set;

public class UnidadDeVenta {

    private int id;
    private String nombreComercial;
    private Staff responsable;
    private int superficie;
    private String codigo;
    private Set<Plato> lstPlatos;
    private Set<Staff> lstStaff;
    private Set<Pedido> lstPedidos;
    private boolean activo;
    private Festival festival;  //1.9 DM:  se agrega relación 1 Festival - N Unidades de venta 

    public UnidadDeVenta() {

    }

    public UnidadDeVenta(boolean activo, String nombreComercial, int superficie,  String codigo,  Festival festival) {
        this.activo = activo;
        this.nombreComercial = nombreComercial;
        this.superficie = superficie;
        this.lstStaff = new HashSet<>();
        this.lstPlatos = new HashSet<>();
        this.lstPedidos = new HashSet<>();
        this.codigo = codigo;
        this.responsable = null;
        this.festival = festival;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
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

    public Set<Plato> getLstPlatos() {
        return lstPlatos;
    }

    public void setLstPlatos(Set<Plato> lstPlatos){
        this.lstPlatos = lstPlatos;
    }

    public Set<Staff> getLstStaff() {
        return lstStaff;
    }

    public Set<Pedido> getLstPedidos() {
        return lstPedidos;
    }

    public void setLstPedidos(Set<Pedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
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

    
    public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	@Override
    public String toString() {
        return "UnidadDeVenta{" +
                "id=" + id +
                ", nombreComercial='" + nombreComercial + '\'' +
                ", responsable=" + responsable +
                ", superficie=" + superficie +
                ", codigo='" + codigo + '\'' +
                ", lstPlatos=" + lstPlatos +
                ", lstStaff=" + lstStaff +
                ", lstPedidos=" + lstPedidos +
                ", activo=" + activo +
                '}';
    }

    public boolean agregarStaff(Staff staff){
        if(staff == null){
            return false;
        }
        if(this.lstStaff == null){
            this.lstStaff = new HashSet<>();
        }

        for(Staff s : this.lstStaff){
            if(s.getDni() == staff.getDni()){
                return false;
            }
        }

        return this.lstStaff.add(staff);
    }

    public boolean agregarPlato(Plato plato){

        if(plato == null){
            return false;
        }
        if(this.lstPlatos == null){
            this.lstPlatos = new HashSet<>();
        }
        for(Plato p : this.lstPlatos){
            if(p.getIdPlato() == plato.getIdPlato()){
                return false;
            }
        }

        return this.lstPlatos.add(plato);

    }

    public boolean agregarPedido(Pedido pedido){

        if(pedido == null){
            return false;
        }
        if(this.lstPedidos==null){
            this.lstPedidos = new HashSet<>();
        }
        for(Pedido p : this.lstPedidos){
            if(p.getIdPedido() != 0 && p.getIdPedido() == pedido.getIdPedido()){
                return false;
            }
        }

        return this.lstPedidos.add(pedido);

    }

}
