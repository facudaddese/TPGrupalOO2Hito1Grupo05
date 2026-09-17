package test;

import datos.Plato;
import datos.UnidadDeVenta;
import negocio.PlatoABM;
import negocio.UnidadDeVentaABM;

import java.util.List;

public class Test_Lescano_PlatosOrdenadosPorPrecio {
    static void main(String[] args) {

        PlatoABM abmPlato = new PlatoABM();
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();
        UnidadDeVenta udv = abmUDV.traer(1);

        List<Plato> platos = abmPlato.traerPlatosDeUnaUDVOrdenadosPorPrecio(udv);

        System.out.println("\nPlatos de " + udv.getNombreComercial() + ":");

        for (Plato plato : platos) {
            System.out.println(plato.getNombre() + " - Precio: $" + plato.getPrecio() + " - Costo: $" + plato.getCostoProduccion()
            );
        }
    }
}
