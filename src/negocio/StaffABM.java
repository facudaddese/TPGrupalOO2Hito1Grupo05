package negocio;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import dao.StaffDao;
import datos.Cajero;
import datos.Cocinero;
import datos.Staff;

public class StaffABM {

    StaffDao dao = new StaffDao();

    public Staff traer(long id) {
        return dao.traer(id);
    }

    public Staff traerPorDni(int dni) {
        return dao.traerPorDni(dni);
    }

    public int agregarCocinero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, int sueldo, String especialidadCulinaria, double plusPorCategoria) throws Exception {

        if (dao.traerPorDni(dni) != null)
            throw new Exception("ERROR: ya existe un integrante del Staff con el mismo DNI " + dni);

        Cocinero c = new Cocinero(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldo, especialidadCulinaria, plusPorCategoria);

        return dao.agregar(c);
    }

    public int agregarCajero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, int sueldo, String turno) throws Exception {

        if (dao.traerPorDni(dni) != null)
            throw new Exception("ERROR: ya existe un integrante del Staff con el mismo DNI " + dni);

        Cajero ca = new Cajero(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldo, turno);

        return dao.agregar(ca);
    }

    public void modificar(Staff s) throws Exception {
        Staff existe = dao.traerPorDni(s.getDni());
        if (existe != null && existe.getId() != s.getId()) {
            throw new Exception("ERROR: ya existe un integrante del Staff con el mismo DNI " + s.getDni());
        }

        dao.actualizar(s);
    }

    public void eliminar(long id) throws Exception {
        Staff s = dao.traer(id);
        if (s == null) {
            throw new Exception("ERROR: no existe personal con dicho DNI");
        }
        dao.eliminar(s);
    }

    public List<Staff> traer() {
        return dao.traer();
    }

}