package negocio;

import dao.PlatoDao;
import datos.Plato;

public class PlatoABM {

    PlatoDao dao = new PlatoDao();

    public Plato traer(int idPlato) {
        return dao.traer(idPlato);
    }

    public int agregar(String nombre, long precio, long costoProduccion) {
        Plato p = new Plato(nombre, precio, costoProduccion);
        return dao.agregar(p);
    }

    public void modificar(Plato p) {
        dao.actualizar(p);
    }
}
