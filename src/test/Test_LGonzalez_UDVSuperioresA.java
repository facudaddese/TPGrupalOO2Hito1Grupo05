package test;

import datos.UnidadDeVenta;
import negocio.UnidadDeVentaABM;

import java.util.List;

public class Test_LGonzalez_UDVSuperioresA{
    public static void main(String[] args){
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();

        System.out.println("===============================================================");
        System.out.println("TEST: Unidades de Venta con Recaudación Superior a un Objetivo");
        System.out.println("===============================================================\n");

        // TEST 1: Caso de éxito con umbral intermedio ($50.000)
        try {
            double objetivo = 50000.0;
            System.out.println("--- TEST 1: Puestos que superaron $" + objetivo + " en ventas ---");

            List<Object[]> resultados = abmUDV.traerUnidadesConVentasSuperioresA(objetivo);

            if (resultados.isEmpty()) {
                System.out.println("Ninguna unidad de venta alcanzó el objetivo de $" + objetivo);
            } else {
                for (Object[] fila : resultados) {
                    UnidadDeVenta u = (UnidadDeVenta) fila[0];
                    Double totalFacturado = ((Number) fila[1]).doubleValue();

                    System.out.println("-> Unidad: [" + u.getCodigo() + "] " + u.getNombreComercial()
                            + " | Facturación Total: $" + totalFacturado);
                }
            }
        } catch (Exception e) {
            System.out.println("Fallo inesperado en Test 1: " + e.getMessage());
        }

        // TEST 2: Caso de éxito exigente (Umbral inalcanzable: $10.000.000)
        try {
            double objetivoAlto = 10000000.0;
            System.out.println("\n--- TEST 2: Filtro con umbral inalcanzable ($" + objetivoAlto + ") ---");

            List<Object[]> vacio = abmUDV.traerUnidadesConVentasSuperioresA(objetivoAlto);
            System.out.println("Unidades que superaron el monto: " + vacio.size() + " (Correcto si es 0)");
        } catch (Exception e) {
            System.out.println("Fallo inesperado en Test 2: " + e.getMessage());
        }

        // TEST 3: Validación de regla de negocio (Monto negativo)
        try {
            System.out.println("\n--- TEST 3: Validación de monto negativo ---");
            abmUDV.traerUnidadesConVentasSuperioresA(-500.0);
            System.out.println("ERROR: Debería haber lanzado excepción por monto negativo.");
        } catch (Exception e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}
