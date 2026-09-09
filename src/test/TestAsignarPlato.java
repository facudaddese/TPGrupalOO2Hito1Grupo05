package test;

import datos.Plato;
import negocio.PlatoABM;
import negocio.UnidadDeVentaABM;

public class TestAsignarPlato {
    public static void main(String[] args) {
        UnidadDeVentaABM abm = new UnidadDeVentaABM();

        PlatoABM platoABM = new PlatoABM();
        Plato plato = platoABM.traerPorNombre("Milanesa Simple");
        Plato plato2 = platoABM.traerPorNombre("Ravioles");
        Plato platoInexistente = platoABM.traerPorNombre("Fideos con tuco");

        ///1. Caso de exito: Asignacion de plato
        try {
            System.out.println("-----TEST 1: ASIGNACION NORMAL-----");
            boolean asignado = abm.asignarPlato("PUESTO-001", plato);
            boolean asignado2 = abm.asignarPlato("PUESTO-002", plato2);
            System.out.println("Platos agregados con exito: " + asignado + ", " + asignado2);
        } catch (Exception e) {
            System.out.println("Fallo inesperado: " + e.getMessage());
        }

        ///2. Caso de error: Intentar agregar el mismo plato (duplicado)
        try {
            System.out.println("\n-----TEST 2: CONTROL DE DUPLICADO------");
            abm.asignarPlato("PUESTO-001", plato);
            System.out.println("ERROR: Si llego aca es porque no lanzo la excepcion por duplicado");
        } catch (Exception e) {
            System.out.println("Excepcion capturada correctamente: " + e.getMessage());
        }

        ///3. Caso de error: Plato inexistente
        try {
            System.out.println("\n------TEST 3: PLATO INEXISTENTE-----");
            abm.asignarPlato("PUESTO-001", platoInexistente);
            System.out.println("ERROR: Si llego aca es porque no lanzo la excepcion por plato no encontrado");
        } catch (Exception e) {
            System.out.println("Excepcion capturada correctamente: " + e.getMessage());
        }
    }
}
