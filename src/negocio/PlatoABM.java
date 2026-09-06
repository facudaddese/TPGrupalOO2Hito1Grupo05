package negocio;

import dao.PlatoDao;
import datos.Plato;
import datos.UnidadDeVenta;

import java.util.List;

public class PlatoABM {

    PlatoDao dao = new PlatoDao();

    public Plato traer(int idPlato) {
        return dao.traer(idPlato);
    }

    public List<Plato> traerPlatosPorTexto(String texto) {
        return dao.traerPlatosPorTexto(texto);
    }

    public int agregar(String nombre, long precio, long costoProduccion, UnidadDeVenta udv) throws Exception {
        if (dao.existePlatoEnUnidad(nombre, udv)) {
            throw new Exception(
                    "Ya existe un plato con ese nombre en la unidad de venta"
            );
        }

        Plato p = new Plato(nombre, precio, costoProduccion, udv);
        return dao.agregar(p);
    }

    public void modificar(Plato p) {
        dao.actualizar(p);
    }
}
