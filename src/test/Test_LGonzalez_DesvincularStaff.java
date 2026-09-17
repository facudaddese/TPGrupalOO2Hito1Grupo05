package test;

import datos.Staff;
import datos.UnidadDeVenta;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

public class Test_LGonzalez_DesvincularStaff {
    public static void main(String[] args){
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();
        StaffABM abmStaff = new StaffABM();

        System.out.println("=======================================================");
        System.out.println("TEST ELIMINAR: Desvinculación de Staff de una UDV");
        System.out.println("=======================================================\n");

        String codigoPuesto = "PUESTO-001";
        try {
            Staff cajera = abmStaff.traerPorDni(28555111);

            // 1. Ejecutamos la desvinculación
            abmUDV.desvincularStaff(codigoPuesto, cajera);
            System.out.println("-> Desvinculación ejecutada.");

            // 2. Verificación 1: La persona YA NO debe estar asociada a la unidad
            UnidadDeVenta puestoActualizado = abmUDV.traerPorCodigoYStaff(codigoPuesto);
            boolean sigueEnElPuesto = puestoActualizado.getLstStaff().contains(cajera);
            System.out.println("El empleado sigue en la unidad de venta?: " + sigueEnElPuesto + " (Si da false esta OK)");

            // 3. Verificación 2 CRÍTICA: La persona DEBE SEGUIR EXISTIENDO en la tabla Staff
            Staff empleadoEnSistema = abmStaff.traerPorDni(28555111);
            if (empleadoEnSistema != null) {
                System.out.println(">> VERIFICACIÓN DE INTEGRIDAD OK: El empleado sigue existiendo en el sistema.");
                System.out.println("   Empleado: " + empleadoEnSistema.getNombre() + " " + empleadoEnSistema.getApellido()
                        + " | Puesto en empresa: Cajero");
            } else {
                System.out.println("ERROR GRAVE: Se eliminó la entidad Staff en lugar de solo la relación.");
            }

        } catch (Exception e) {
            System.out.println("Fallo inesperado: " + e.getMessage());
        }

        //4. Caso de error: intentar desvincular al responsable de la UDV
        try {
            System.out.println("\n--- Caso de error: Desvincular al responsable actual ---");
            UnidadDeVenta puesto = abmUDV.traerPorCodigo(codigoPuesto);
            Staff responsableActual = puesto.getResponsable();

            System.out.println("Intentando desvincular a " + responsableActual.getNombre() + " (Responsable)");
            abmUDV.desvincularStaff(codigoPuesto, responsableActual);
            System.out.println("ERROR: Debería haber impedido desvincular al responsable.");
        } catch (Exception e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}
