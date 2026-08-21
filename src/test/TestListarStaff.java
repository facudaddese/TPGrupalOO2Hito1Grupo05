package test;

import datos.Staff;
import dao.StaffDao;

import java.util.List;

public class TestListarStaff {
    public static void main(String[] args) {
        StaffDao dao = new StaffDao();
        List<Staff> lista = dao.traer();
        lista.forEach(System.out::println);
    }
}