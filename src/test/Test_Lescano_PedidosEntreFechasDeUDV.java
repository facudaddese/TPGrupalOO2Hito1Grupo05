package test;


import datos.Pedido;
import datos.UnidadDeVenta;
import negocio.PedidoABM;
import negocio.UnidadDeVentaABM;

import java.time.LocalDate;
import java.util.List;

public class Test_Lescano_PedidosEntreFechasDeUDV {
    static void main(String[] args) {

        PedidoABM abmPedido = new PedidoABM();
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();
        UnidadDeVenta udv = abmUDV.traer(1);

        //Test traer pedidos realizados entre rango de fechas de una UDV especifica - Malena Lescano
        System.out.println("\n--- TEST: Traer Pedidos ---");
        LocalDate inicio = LocalDate.of(2026,9,1);
        LocalDate fin = LocalDate.of(2026,9,10);
        System.out.println("\nPedidos entre " + inicio + " y " + fin + " de " + udv.getNombreComercial());

        List<Pedido> resultados = abmPedido.traerPedidosRealizadosEntreFechasDeUnaUDV(inicio, fin, udv);

        for (Pedido p : resultados) {
            System.out.println("=================================================");
            System.out.println("Pedido ID: " + p.getIdPedido() + " | Fecha: " + p.getFechaTransaccion());


        }
    }
}
