package test;

import datos.Festival;
import datos.UnidadDeVenta;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.UnidadDeVentaABM;

import java.time.LocalDate;

public class TestAgregarPedido {
    static void main(String[] args) {
        PedidoABM abm = new PedidoABM();
        UnidadDeVentaABM uAbm = new UnidadDeVentaABM();
        FestivalABM fAbm = new FestivalABM();

        int idUDV = 1;
        int idFest = 1;
        UnidadDeVenta udv = uAbm.traer(idUDV);
        Festival fest = fAbm.traer(idFest);

        try {
            long ultimoId;
            ultimoId = abm.agregar(LocalDate.of(2027, 8, 23), udv, fest);
            System.out.printf("Id pedido: %d", ultimoId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
