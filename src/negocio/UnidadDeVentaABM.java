package negocio;

import dao.UnidadDeVentaDao;
import datos.*;

import java.util.List;
import java.util.Set;

public class UnidadDeVentaABM {

    private UnidadDeVentaDao dao = UnidadDeVentaDao.getInstance();

    public UnidadDeVenta traer(int id){
        return dao.traer(id);
    }

    public int agregarPuestoDes(boolean activo, String nombreComercial, int superficie, Set<Staff> lstStaff, Set<Plato> lstPlatos, String codigo, Staff responsable, Festival festival, int cantidadCarpas, float tiempoMontaje) throws Exception {

        if(dao.traerPorCodigo(codigo) != null){
            throw new Exception("ERROR: ya existe un puesto con el mismo codigo " + codigo);
        }

        PuestoDesarmable p = new PuestoDesarmable(activo, nombreComercial, superficie, lstStaff, lstPlatos, codigo, responsable, festival, cantidadCarpas, tiempoMontaje);

        return dao.agregar(p);
    }

    public int agregarFoodTruck(boolean activo, String nombreComercial, int superficie, Set<Staff> lstStaff, Set<Plato> lstPlatos,String codigo, Staff responsable, Festival festival, String patente, boolean conexion) throws Exception {

        if(dao.traerPorCodigo(codigo) != null) throw new Exception("ERROR: ya existe una unidad de venta con este codigo " + codigo);

        FoodTruck f = new FoodTruck(activo, nombreComercial, superficie, lstStaff, lstPlatos, codigo, responsable, festival, patente, conexion);

        return dao.agregar(f);
    }

    public void modificar(UnidadDeVenta u) throws Exception{
        UnidadDeVenta existe = dao.traerPorCodigo(u.getCodigo());

        if(existe != null && existe.getId() != u.getId()){
            throw  new Exception("ERROR: Ya existe una unidad de venta con el mismo codigo " + u.getCodigo());
        }

        dao.actualizar(u);

    }

    public void eliminar(String codigo) throws Exception{

        UnidadDeVenta u = dao.traerPorCodigo(codigo);
        if(u == null){
            throw new Exception("ERROR: No existe una unidad de venta con dicho codigo");
        }
        dao.eliminar(u);


    }

    public List<UnidadDeVenta> traer(){
        return dao.traer();
    }

}
