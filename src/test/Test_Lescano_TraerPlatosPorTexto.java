package test;

import datos.Plato;
import negocio.PlatoABM;

import java.util.List;

public class Test_Lescano_TraerPlatosPorTexto {
    static void main(String[] args) {

        PlatoABM abmPlato = new PlatoABM();

        //Test traer platos que contengan el texto pasado por parametro en el nombre - Malena Lescano
        System.out.println("\n--- TEST: Traer Platos ---");
        System.out.println("\nPlatos que contengan 'Mila' en su nombre:");
        List<Plato> platosConNombre = abmPlato.traerPlatosPorTexto("Mila");
        platosConNombre.forEach(System.out::println);
    }
}
