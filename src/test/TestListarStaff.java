package test;

import java.util.List;

import datos.Staff;
import negocio.StaffABM;

public class TestListarStaff {
    public static void main(String[] args) {
        StaffABM abm = new StaffABM();
        List<Staff> lista = abm.traer();
        lista.forEach(System.out::println);
    }
}