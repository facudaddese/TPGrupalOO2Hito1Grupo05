package test;

import datos.ItemPedido;
import datos.Pedido;
import datos.UnidadDeVenta;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.UnidadDeVentaABM;

import java.time.LocalDate;
import java.util.List;

public class Test_Lescano_PedidosEntreFechasDeUDV {
    static void main(String[] args) {

        PedidoABM abmPedido = new PedidoABM();
        PlatoABM abmPlato = new PlatoABM();
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();
        UnidadDeVenta udv = abmUDV.traer(1);

        //Test traer pedidos realizados entre rango de fechas de una UDV especifica - Malena Lescano
        System.out.println("\n--- TEST: Traer Pedidos ---");
        LocalDate inicio = LocalDate.of(2026,9,1);
        LocalDate fin = LocalDate.of(2026,9,10);
        System.out.println("\nPedidos entre " + inicio + " y " + fin + " de " + udv.getNombreComercial());

        List<Object[]> resultados = abmPedido.traerPedidosRealizadosEntreFechasDeUnaUDV(inicio, fin, udv);

        for (Object[] fila : resultados) {
            Pedido p = (Pedido) fila[0];
            ItemPedido ip = (ItemPedido) fila[1];

            System.out.println("=================================================");
            System.out.println("Pedido ID: " + p.getIdPedido() + " | Fecha: " + p.getFechaTransaccion());
            System.out.println("  -> Plato: " + abmPlato.traer(ip.getPlato().getIdPlato()) + ", cantidad: " + ip.getCantidad());
        }
    }
}
