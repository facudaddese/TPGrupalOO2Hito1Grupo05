package negocio;

import dao.UnidadDeVentaDao;
import datos.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class UnidadDeVentaABM {
    private UnidadDeVentaDao dao = UnidadDeVentaDao.getInstance();

    public UnidadDeVenta traer(int id) {
        return dao.traer(id);
    }

    public UnidadDeVenta traerPorCodigo(String codigoUDV){return dao.traerPorCodigo(codigoUDV);}

    public int agregarPuestoDes(boolean activo, String nombreComercial, int superficie, String codigo, Festival festival, int cantidadCarpas, float tiempoMontaje) throws Exception {

        if(festival == null){
            throw new Exception("ERROR: La unidad de venta debe permanecer a un festival");
        }

        if (dao.traerPorCodigo(codigo) != null) {
            throw new Exception("ERROR: ya existe un puesto con el mismo codigo " + codigo);
        }

        PuestoDesarmable p = new PuestoDesarmable(activo, nombreComercial, superficie, codigo, festival, cantidadCarpas, tiempoMontaje);

        return dao.agregar(p);
    }

    public int agregarFoodTruck(boolean activo, String nombreComercial, int superficie, String codigo, Festival festival, String patente, boolean conexion) throws Exception {

        if(festival == null){
            throw new Exception("ERROR: La unidad de venta debe permanecer a un festival");
        }

        if (dao.traerPorCodigo(codigo) != null)
            throw new Exception("ERROR: ya existe una unidad de venta con este codigo " + codigo);

        FoodTruck f = new FoodTruck(activo, nombreComercial, superficie, codigo, festival, patente, conexion);

        return dao.agregar(f);
    }

    public boolean asignarStaff(String codigoUnidad, Staff staff) throws Exception {
        UnidadDeVenta existe = dao.traerPorCodigoYStaff(codigoUnidad);
        if (existe == null) {
            throw new Exception("ERROR: No existe la unidad de venta indicada");
        }

        if (staff == null) {
            throw new Exception("ERROR: El miembro del staff indicado no existe");
        }

        boolean agregado = existe.agregarStaff(staff);

        if (!agregado) {
            throw new Exception("ERROR: El personal ya se encuentra asignado a esta unidad");
        }

        dao.actualizar(existe);

        return true;
    }

    public boolean asignarPlato(String codigoUnidad, Plato plato) throws Exception {
        UnidadDeVenta existe = dao.traerPorCodigoYPlato(codigoUnidad);
        if (existe == null) {
            throw new Exception("ERROR: No existe la unidad de venta indicada");
        }

        if (plato == null) {
            throw new Exception("ERROR: El plato indicado no existe.");
        }

        boolean agregado = existe.agregarPlato(plato);
        if (!agregado) {
            throw new Exception("ERROR: El plato ya se encuentra asignado a esta unidad");

        }
        dao.actualizar(existe);

        return true;
    }



    public void modificar(UnidadDeVenta u) throws Exception {
        UnidadDeVenta existe = dao.traerPorCodigo(u.getCodigo());

        if (existe != null && existe.getId() != u.getId()) {
            throw new Exception("ERROR: Ya existe una unidad de venta con el mismo codigo " + u.getCodigo());
        }

        dao.actualizar(u);
    }

    public void eliminar(String codigo) throws Exception {
        UnidadDeVenta u = dao.traerPorCodigo(codigo);
        if (u == null) {
            throw new Exception("ERROR: No existe una unidad de venta con dicho codigo");
        }
        dao.eliminar(u);
    }

    public List<UnidadDeVenta> traer() {
        return dao.traer();
    }

    public List<Staff> traerCocinerosDeFestivalEntre(String nombreFestival, LocalDate fechaDesde, LocalDate fechaHasta) {
        return dao.traerCocinerosDeFestivalEntre(nombreFestival, fechaDesde, fechaHasta);
    }

    public List<Staff> traerCajerosDeFestivalPorTurnoYSueldo(String nombreFestival, String turno, int sueldo) {
        return dao.traerCajerosDeFestivalPorTurnoYSueldo(nombreFestival, turno, sueldo);
    }

    public boolean asignarResponsable(String codigoUnidad, Staff staff) throws Exception{
        UnidadDeVenta unidad = dao.traerPorCodigo(codigoUnidad);
        if(unidad == null){
            throw  new Exception("ERROR: No existe unidad de venta con ese codigo");
        }
        if(staff == null){
            throw new Exception("ERROR: El miembro del staff no existe");
        }
        unidad.setResponsable(staff);
        dao.actualizar(unidad);
        return true;
    }

    public List<UnidadDeVenta> traerPorRangoFechasFestival(LocalDate desde, LocalDate hasta) throws Exception{
        if(desde == null || hasta == null){
            throw new Exception("ERROR: Las fechas no pueden ser nulas");
        }
        if(desde.isAfter(hasta)){
            throw new Exception("ERROR: La fecha 'desde' no puede ser posterior a la fecha 'hasta' ");
        }
        return dao.traerPorRangoFechasFestival(desde, hasta);
    }

    public List<Object[]> traerUnidadesConVentasSuperioresA(double montoObjetivo)throws Exception{
        if(montoObjetivo < 0){
            throw new Exception("ERROR: El monto objetivo no puede ser menor que cero");
        }
        return dao.traerUnidadesConVentasSuperioresA(montoObjetivo);
    }

    public void cambiarResponsable(String codigoUDV, Staff nuevoResponsable)throws Exception{
        if(codigoUDV == null || codigoUDV.trim().isEmpty()){
            throw new Exception("ERROR: El codigo de la unidad de venta no puede estar vacio");
        }
        if(nuevoResponsable == null){
            throw new Exception("ERROR: Debe especificar un nuevo responsable valido");
        }

        UnidadDeVenta u = dao.traerPorCodigo(codigoUDV);
        if(u == null){
            throw new Exception("ERROR: No existe la unidad de venta con el codigo especificado");
        }

        if(u.getResponsable() != null && u.getResponsable().getDni() == nuevoResponsable.getDni()){
            throw new Exception("ERROR: El empleado especificado ya existe como responsable actual de esta unidad");
        }

        u.setResponsable(nuevoResponsable);
        dao.actualizar(u);

    }

    public UnidadDeVenta traerPorCodigoYStaff(String codigo) throws Exception {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new Exception("ERROR: El código de la unidad de venta no puede estar vacío.");
        }
        return dao.traerPorCodigoYStaff(codigo);
    }

    public void desvincularStaff(String codigoUDV, Staff staff)throws Exception{
        if(codigoUDV == null || codigoUDV.trim().isEmpty()){
            throw new Exception("ERROR: El codigo de la unidad de venta no puede estar vacio");
        }
        if(staff == null){
            throw new Exception("ERROR: El Staff no puede ser nulo");
        }
        UnidadDeVenta u = dao.traerPorCodigoYStaff(codigoUDV);
        if(u == null){
            throw new Exception("ERROR: No existe una unidad asociada ese codigo");
        }
        if(u.getResponsable() != null && u.getResponsable().getDni() == staff.getDni()){
            throw new Exception("ERROR: No se puede desvincular al empleado porque es el responsable");
        }

        dao.desvincularStaff(u, staff);
    }

}
