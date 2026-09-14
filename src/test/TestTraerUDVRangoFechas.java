package test;

import datos.UnidadDeVenta;
import negocio.UnidadDeVentaABM;

import java.time.LocalDate;
import java.util.List;

public class TestTraerUDVRangoFechas {
    public static void  main(String[] args) throws Exception {
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();

        System.out.println("=======================================================");
        System.out.println("TEST: Traer Unidades de Venta por Rango de Fechas");
        System.out.println("=======================================================\n");

        // 1. Caso de Éxito: Rango amplio (abarca Primavera Sound y Fiesta BA)
        try {
            System.out.println("--- TEST 1: Rango que abarca múltiples festivales (Nov 2026 - Ene 2027) ---");
            LocalDate desde = LocalDate.of(2026, 11, 1);
            LocalDate hasta = LocalDate.of(2027, 1, 15);

            List<UnidadDeVenta> lista = abmUDV.traerPorRangoFechasFestival(desde, hasta);

            if (lista == null || lista.isEmpty()) {
                System.out.println("No se encontraron unidades en ese rango de fechas.");
            } else {
                System.out.println("Unidades encontradas: " + lista.size());
                for (UnidadDeVenta u : lista) {
                    System.out.println(" -> [" + u.getCodigo() + "] " + u.getNombreComercial()
                            + " | Festival: " + u.getFestival().getNombre()
                            + " (" + u.getFestival().getFechaInicio() + " al " + u.getFestival().getFechaFin() + ")");
                }
            }
        } catch (Exception e) {
            System.out.println("Fallo inesperado en Test 1: " + e.getMessage());
        }

        // 2. Caso de Éxito: Rango acotado (solo Primavera Sound)
        try {
            System.out.println("\n--- TEST 2: Rango acotado (Noviembre 2026) ---");
            LocalDate desde = LocalDate.of(2026, 11, 1);
            LocalDate hasta = LocalDate.of(2026, 11, 30);

            List<UnidadDeVenta> lista = abmUDV.traerPorRangoFechasFestival(desde, hasta);

            System.out.println("Unidades encontradas: " + lista.size());
            for (UnidadDeVenta u : lista) {
                System.out.println(" -> [" + u.getCodigo() + "] " + u.getNombreComercial()
                        + " | Festival: " + u.getFestival().getNombre());
            }
        } catch (Exception e) {
            System.out.println("Fallo inesperado en Test 2: " + e.getMessage());
        }

        // 3. Caso sin resultados: Fechas sin festivales programados
        try {
            System.out.println("\n--- TEST 3: Rango sin festivales (Enero 2025 - Febrero 2025) ---");
            LocalDate desde = LocalDate.of(2025, 1, 1);
            LocalDate hasta = LocalDate.of(2025, 2, 28);

            List<UnidadDeVenta> lista = abmUDV.traerPorRangoFechasFestival(desde, hasta);
            System.out.println("Resultado: " + lista.size() + " unidades (Correcto si es 0)");
        } catch (Exception e) {
            System.out.println("Fallo inesperado en Test 3: " + e.getMessage());
        }

        // 4. Caso de Excepción: 'desde' posterior a 'hasta'
        try {
            System.out.println("\n--- TEST 4: Validación de rango invertido (desde > hasta) ---");
            LocalDate desde = LocalDate.of(2027, 1, 1);
            LocalDate hasta = LocalDate.of(2026, 1, 1);

            abmUDV.traerPorRangoFechasFestival(desde, hasta);
            System.out.println("ERROR: Debería haber lanzado excepción por fechas inconsistentes.");
        } catch (Exception e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }

        // 5. Caso de Excepción: Parámetros nulos
        try {
            System.out.println("\n--- TEST 5: Validación de fechas nulas ---");
            abmUDV.traerPorRangoFechasFestival(null, LocalDate.of(2026, 12, 1));
            System.out.println("ERROR: Debería haber lanzado excepción por fecha nula.");
        } catch (Exception e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}
