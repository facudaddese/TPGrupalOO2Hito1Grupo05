package negocio;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import dao.StaffDao;
import datos.Cajero;
import datos.Cocinero;
import datos.Costo;
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

    public void eliminarCocinero(int dni) throws Exception {
        if (dao.traerPorDni(dni) == null)
            throw new Exception("ERROR: no existe el cocinero con DNI " + dni);

        if (!(dao.traerPorDni(dni) instanceof Cocinero))
            throw new Exception("ERROR: el DNI " + dni + " no corresponde a un cocinero");

        dao.eliminar(dao.traerPorDni(dni));
    }

    public void actualizarCocinero(int dni, String nuevaEspecialidad) throws Exception {
        if (dao.traerPorDni(dni) == null)
            throw new Exception("ERROR: no existe el cocinero con DNI " + dni);

        if (!(dao.traerPorDni(dni) instanceof Cocinero))
            throw new Exception("ERROR: el DNI " + dni + " no corresponde a un cocinero");

        Cocinero co = (Cocinero) dao.traerPorDni(dni);
        co.setEspecialidadCulinaria(nuevaEspecialidad);

        dao.actualizar(dao.traerPorDni(dni));
    }

    public int agregarCajero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, int sueldo, String turno) throws Exception {
        if (dao.traerPorDni(dni) != null)
            throw new Exception("ERROR: ya existe un integrante del Staff con el mismo DNI " + dni);

        Cajero ca = new Cajero(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldo, turno);

        return dao.agregar(ca);
    }

    public void eliminarCajero(int dni) throws Exception {
        if (dao.traerPorDni(dni) == null)
            throw new Exception("ERROR: no existe el cajero con DNI " + dni);

        if (!(dao.traerPorDni(dni) instanceof Cajero))
            throw new Exception("ERROR: el DNI " + dni + " no corresponde a un cajero");

        dao.eliminar(dao.traerPorDni(dni));
    }

    public void actualizarCajero(int dni, String nuevoTurno) throws Exception {
        if (dao.traerPorDni(dni) == null)
            throw new Exception("ERROR: no existe el cajero con DNI " + dni);

        if (!(dao.traerPorDni(dni) instanceof Cajero))
            throw new Exception("ERROR: el DNI " + dni + " no corresponde a un cajero");

        Cajero ca = (Cajero) dao.traerPorDni((dni));
        ca.setTurno(nuevoTurno);

        dao.actualizar(ca);
    }

    public List<Cajero> traerCajerosPorTurnoMayoresDeEdad(String turno) {
        return dao.traerCajerosPorTurnoMayoresDeEdad(turno);
    }

    public List<Cocinero> traerCocinerosPorEspecialidadYSueldo(String especialidad, int sueldoMinimo) {
        return dao.traerCocinerosPorEspecialidadYSueldo(especialidad, sueldoMinimo);
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