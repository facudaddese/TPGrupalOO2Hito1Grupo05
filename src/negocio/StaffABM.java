package negocio;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import dao.StaffDao;
import datos.Staff;

public class StaffABM {

    StaffDao dao = new StaffDao();

    public Staff traer(long id) {
        return dao.traer(id);
    }

    public int agregar(Staff s) throws Exception {
        int edad = Period.between(s.getFechaNacimiento(), LocalDate.now()).getYears();
        if (edad < 18) throw new Exception("ERROR: el personal debe ser mayor de edad");
        return dao.agregar(s);
    }

    public void modificar(Staff s) {
        dao.actualizar(s);
    }

    public void eliminar(long id) {
        Staff s = dao.traer(id);
        dao.eliminar(s);
    }

    public List<Staff> traer() {
        return dao.traer();
    }
}