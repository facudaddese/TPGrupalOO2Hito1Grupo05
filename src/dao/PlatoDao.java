package dao;

import datos.Plato;
import datos.UnidadDeVenta;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlatoDao {
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

    public int agregar(Plato objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }

    public void actualizar(Plato objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();

        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public void eliminar(Plato objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public Plato traer(int idPlato) {
        Plato objeto = null;
        try {
            iniciaOperacion();
            objeto = (Plato) session.get(Plato.class, idPlato);
        } finally {
            session.close();
        }
        return objeto;
    }

    public boolean existePlatoEnUnidad(String nombre, UnidadDeVenta udv) {
        Plato objeto = null;
        try {
            String hql = "from Plato p where p.nombre= :nombre AND p.unidadDeVenta=:udv";
            objeto  = (Plato) session.createQuery(hql).setParameter("nombre", nombre).setParameter("udv", udv).uniqueResult();

        } finally {
            session.close();
        }
        return objeto != null;

    }

    public List<Plato> traerPlatosPorTexto(String texto) {
        List<Plato> platos = null;
        try {
            iniciaOperacion();
            String hql = "from Plato p where lower(p.nombre) like lower(:texto)";
            platos = session.createQuery(hql, Plato.class).setParameter("texto", "%" + texto + "%").list();
        } finally {
            session.close();
        }
        return platos;
    }

    public List<Object[]> traerRankingPlatosMasVendidosDeUnaUDV( UnidadDeVenta udv) {
        List<Object[]>  platos = null;
        try {
            iniciaOperacion();
            String hql = "select p, sum(i.cantidad) from Plato p inner join p.listaItems i where p.unidadDeVenta=:udv group by p order by sum(i.cantidad) desc";
            platos = session.createQuery(hql, Object[].class).setParameter("udv", udv).getResultList();
        } finally {
            session.close();
        }
        return platos;
    }

}
