package test;

import datos.Staff;
import negocio.StaffABM;

import java.util.List;

public class TestListarStaff {
    public static void main(String[] args) {
        StaffABM abm = new StaffABM();
        List<Staff> lista = abm.traer();
        lista.forEach(System.out::println);
    }
}