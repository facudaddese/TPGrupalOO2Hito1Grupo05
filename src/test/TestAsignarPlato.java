package test;

import negocio.UnidadDeVentaABM;

public class TestAsignarPlato {
    public static void main(String[] args) {
        UnidadDeVentaABM abm = new UnidadDeVentaABM();

        int idUnidadDeVenta = 1;
        int idUnidadDeVenta2 = 2;
        int idPlatoExistente = 1;
        int idPlatoExistente2 = 2;
        int idPlatoInexistente = 111;

        ///1. Caso de exito: Asignacion de plato
        try {
            System.out.println("-----TEST 1: ASIGNACION NORMAL-----");
            boolean asignado = abm.asignarPlato(idUnidadDeVenta, idPlatoExistente);
            boolean asignado2 = abm.asignarPlato(idUnidadDeVenta2, idPlatoExistente2);
            System.out.println("Platos agregados con exito: " + asignado + ", " + asignado2);
        } catch (Exception e) {
            System.out.println("Fallo inesperado: " + e.getMessage());
        }

        ///2. Caso de error: Intentar agregar el mismo plato (duplicado)
        try {
            System.out.println("\n-----TEST 2: CONTROL DE DUPLICADO------");
            abm.asignarPlato(idUnidadDeVenta, idPlatoExistente);
            System.out.println("ERROR: Si llego aca es porque no lanzo la excepcion por duplicado");
        } catch (Exception e) {
            System.out.println("Excepcion capturada correctamente: " + e.getMessage());
        }

        ///3. Caso de error: Plato inexistente
        try {
            System.out.println("\n------TEST 3: PLATO INEXISTENTE-----");
            abm.asignarPlato(idUnidadDeVenta, idPlatoInexistente);
            System.out.println("ERROR: Si llego aca es porque no lanzo la excepcion por plato no encontrado");
        } catch (Exception e) {
            System.out.println("Excepcion capturada correctamente: " + e.getMessage());
        }
    }
}
