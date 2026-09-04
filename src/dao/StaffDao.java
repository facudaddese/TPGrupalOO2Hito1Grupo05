package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Staff;

public class StaffDao {

    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    public int agregar(Staff objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    public void actualizar(Staff objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public void eliminar(Staff objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public Staff traer(long id) {
        Staff objeto = null;
        try {
            iniciaOperacion();
            objeto = (Staff) session.get(Staff.class, id);
        } finally {
            session.close();
        }
        return objeto;
    }

    public Staff traerPorDni(int dni) {
        Staff objeto = null;
        try {
            iniciaOperacion();
            Query<Staff> query = session.createQuery(
                    "from Staff s where s.dni = :dni", Staff.class);
            query.setParameter("dni", dni);
            objeto = query.uniqueResultOptional().orElse(null);
        } finally {
            session.close();
        }
        return objeto;
    }

    public List<Staff> traer() {
        List<Staff> lista = new ArrayList<>();
        try {
            iniciaOperacion();
            Query<Staff> query = session.createQuery(
                    "from Staff s order by s.apellido asc, s.nombre asc", Staff.class);
            lista = query.getResultList();
        } finally {
            session.close();
        }
        return lista;
    }
}