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
        if (dao.traerPorDni(s.getDni()) != null) {
			throw new Exception("ERROR: ya existe un integrante del Staff con el mismo DNI " + s.getDni());
		}

        int edad = Period.between(s.getFechaNacimiento(), LocalDate.now()).getYears();
        if (edad < 18) {
			throw new Exception("ERROR: el personal debe ser mayor de edad");
		}

        return dao.agregar(s);
    }

    public void modificar(Costo s) throws Exception {
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