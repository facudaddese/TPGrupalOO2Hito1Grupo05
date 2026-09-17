package test;

import datos.Staff;
import datos.UnidadDeVenta;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

public class Test_LGonzalez_CambiarResponsable {
    public static void  main(String[] args){
        UnidadDeVentaABM abmUDV = new UnidadDeVentaABM();
        StaffABM abmStaff = new StaffABM();

        System.out.println("=======================================================");
        System.out.println("TEST MODIFICAR: Reasignación de Responsable en UDV");
        System.out.println("=======================================================\n");

        String codigoPuesto = "PUESTO-001";
        try {
            // 1. Estado inicial de la UDV
            UnidadDeVenta puesto = abmUDV.traerPorCodigo(codigoPuesto);
            System.out.println("Puesto: " + puesto.getNombreComercial());
            System.out.println("Responsable actual: " + puesto.getResponsable().getNombre()
                    + " " + puesto.getResponsable().getApellido()
                    + " (DNI: " + puesto.getResponsable().getDni() + ")");

            // 2. Mostramos aquel que va a ser el nuevo encargado
            Staff nuevoResponsable = abmStaff.traerPorDni(14852741); // Facundo Díaz
            System.out.println("\n-> Asignando como nuevo responsable a: "
                    + nuevoResponsable.getNombre() + " " + nuevoResponsable.getApellido());

            // 3. Ejecutamos la modificación
            abmUDV.cambiarResponsable(codigoPuesto, nuevoResponsable);

            // 4. Mostramos como quedo la UDV
            UnidadDeVenta puestoActualizado = abmUDV.traerPorCodigo(codigoPuesto);
            System.out.println("\nComprobación post-modificación:");
            System.out.println("Nuevo responsable en BD: " + puestoActualizado.getResponsable().getNombre()
                    + " " + puestoActualizado.getResponsable().getApellido()
                    + " (DNI: " + puestoActualizado.getResponsable().getDni() + ")");

            if (puestoActualizado.getResponsable().getDni() == nuevoResponsable.getDni()) {
                System.out.println(">> El responsable fue actualizado exitosamente.");
            }

        } catch (Exception e) {
            System.out.println("Fallo en test de modificación: " + e.getMessage());
        }

        // 5. Caso de error: intentar asignar un responsable nulo
        try {
            System.out.println("\n--- Caso de error: Asignación nula ---");
            abmUDV.cambiarResponsable(codigoPuesto, null);
            System.out.println("ERROR: Debería haber fallado por parámetro nulo.");
        } catch (Exception e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}
