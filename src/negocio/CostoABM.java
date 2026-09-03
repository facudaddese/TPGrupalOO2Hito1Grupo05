package negocio;

import java.util.List;

import dao.CostoDao;
import datos.Costo;
import datos.Festival;
import datos.Staff;

public class CostoABM {
    CostoDao dao = new CostoDao();

    public Costo traer(int idCosto) {
        return dao.traer(idCosto);
    }

    public List<Costo> traer() {
        return dao.traer();
    }

    public int agregar(int costoSuperficies, int costoMontaje, int plusElectricidad, int sueldoBase, Festival festival) {
        Costo c = new Costo(costoSuperficies, costoMontaje, plusElectricidad, sueldoBase, festival);
        return dao.agregar(c);
    }

    public int agregar(Costo c) throws Exception {
        //pre cond: validar que el objeto no exista en la lista
        //post cond: agregar el equipo. DAO asigna id autoincremental
        List<Costo> listaCostos = traer();
        int i = 0;
        boolean found = false;
        int idCosto = 0;

        while (i < listaCostos.size() && !found) {
            if (!found &&
                    listaCostos.get(i).getCostoMontaje() == c.getCostoMontaje() &&
                    listaCostos.get(i).getCostoSuperficies() == c.getCostoSuperficies() &&
                    listaCostos.get(i).getPlusElectricidad() == c.getPlusElectricidad() &&
                    listaCostos.get(i).getSueldoBase() == c.getSueldoBase()
            ) {
                found = true;
                idCosto = c.getId();
            }
            i++;
        }
        if (found) {
            throw new Exception("ERROR: ya existe un costo. ID: " + idCosto);
        }
        return dao.agregar(c);

    }

    public void modificar(Costo c) throws Exception {
        Costo existe = dao.traer(c.getId());
        if (existe == null) {
            throw new Exception("ERROR:  no existe costo con dicho ID " + c.getId());
        }

        dao.actualizar(c);
    }

    public void eliminar(int id) throws Exception {
        Costo c = dao.traer(id);
        if (c == null) {
            throw new Exception("ERROR: no existe costo con dicho ID");
        }
        dao.eliminar(c);
    }


}
