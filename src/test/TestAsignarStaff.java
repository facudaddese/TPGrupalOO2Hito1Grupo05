package test;

import datos.Staff;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

public class TestAsignarStaff {
    public static void main(String[] args) throws Exception {
        UnidadDeVentaABM abm = new UnidadDeVentaABM();
        StaffABM staffABM = new StaffABM();
        Staff staff = staffABM.traerPorDni(30111222);
        Staff staff2 = staffABM.traerPorDni(14852741);
        Staff staffInexistente = staffABM.traerPorDni(1111);


        ///1. Caso de exito: Asignacion de personal
        try {
            System.out.println("--------TEST 1: Asignacion de Staff a una Unidad de Venta-----------");
            boolean asignado = abm.asignarStaff("PUESTO-001", staff);
            System.out.println("Personal asignado con exito: " + asignado);
        } catch (Exception e) {
            System.out.println("Fallo inesperado: " + e.getMessage());
        }

        try {
            System.out.println("--------TEST 1b: Asignacion de Staff a una Unidad de Venta-----------");
            boolean asignado = abm.asignarStaff("PUESTO-002", staff2);
            System.out.println("Personal asignado con exito: " + asignado);
        } catch (Exception e) {
            System.out.println("Fallo inesperado: " + e.getMessage());
        }

        ///2. Caso de error: Intentar asignar el mismo personal de nuevo (duplicado)
        try {
            System.out.println("\n--- Test 2: Control de duplicado ---");
            abm.asignarStaff("PUESTO-001", staff);
            System.out.println("ERROR: Debería haber lanzado excepción por duplicado.");
        } catch (Exception e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }

        ///3. Caso de error: Staff Inexistente
        try {
            System.out.println("\n--- Test 3: Staff inexistente ---");
            abm.asignarStaff("PUESTO-001", staffInexistente);
            System.out.println("ERROR: Debería haber lanzado excepción por staff no encontrado.");
        } catch (Exception e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }

        try {
            System.out.println("\n--- Test 4: Unidad de venta inexistente ---");
            abm.asignarStaff("PUESTO-003", staff2);
            System.out.println("ERROR: Debería haber lanzado excepción por unidad no encontrada.");
        } catch (Exception e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}
