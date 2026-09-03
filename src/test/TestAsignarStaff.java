package test;

import negocio.UnidadDeVentaABM;

public class TestAsignarStaff {
    public static void main(String[] args) throws Exception{
        UnidadDeVentaABM abm = new UnidadDeVentaABM();

        int idUnidadDeVenta = 1;
        int idUnidadDeVenta2 = 2;
        int dniStaffExistente = 30111222;
        int dniStaffExistente2 = 28555111;

        int dniStaffInexistente = 11111;


        ///1. Caso de exito: Asignacion de personal
        try{
            System.out.println("--------TEST 1: Asignacion normal-----------");
            boolean asignado = abm.asignarStaff(idUnidadDeVenta, dniStaffExistente);
            System.out.println("Personal asignado con exito: " + asignado);
        } catch (Exception e) {
            System.out.println("Fallo inesperado: " + e.getMessage());
        }

        try{
            System.out.println("--------TEST 1: Asignacion normal-----------");
            boolean asignado = abm.asignarStaff(idUnidadDeVenta2, dniStaffExistente2);
            System.out.println("Personal asignado con exito: " + asignado);
        } catch (Exception e) {
            System.out.println("Fallo inesperado: " + e.getMessage());
        }

        ///2. Caso de error: Intentar asignar el mismo personal de nuevo (duplicado)
        try {
            System.out.println("\n--- Test 2: Control de duplicado ---");
            abm.asignarStaff(idUnidadDeVenta, dniStaffExistente);
            System.out.println("ERROR: Debería haber lanzado excepción por duplicado.");
        } catch (Exception e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }

        ///3. Caso de error: Staff Inexistente
        try {
            System.out.println("\n--- Test 3: Staff inexistente ---");
            abm.asignarStaff(idUnidadDeVenta, dniStaffInexistente);
            System.out.println("ERROR: Debería haber lanzado excepción por staff no encontrado.");
        } catch (Exception e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}
