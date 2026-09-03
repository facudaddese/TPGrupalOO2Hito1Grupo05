package dao;

import datos.ItemPedido;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemPedidoDao {
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

    public int agregar(ItemPedido objeto) {
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

    public void actualizar(ItemPedido objeto) {
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

    public void eliminar(ItemPedido objeto) {
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

    public ItemPedido traerSinPedido(int idItemPedido) {
        ItemPedido objeto = null;
        try {
            iniciaOperacion();
            objeto = (ItemPedido) session.get(ItemPedido.class, idItemPedido);
        } finally {
            session.close();
        }
        return objeto;
    }

    public ItemPedido traer(int idItemPedido) {
        ItemPedido obj = null;
        try {
            iniciaOperacion();
            String hQL = "from ItemPedido ip inner join fetch ip.pedido p where ip.idItemPedido=:idItemPedido";
            obj = (ItemPedido) session.createQuery(hQL).setParameter("idItemPedido", idItemPedido).uniqueResult();
        } finally {
            session.close();
        }
        return obj;
    }

    public ItemPedido traerIPyPlato(int idItemPedido){
        ItemPedido obj = null;
        try {
            iniciaOperacion();
            String hQL = "from ItemPedido ip inner join fetch ip.plato p where ip.idItemPedido=:idItemPedido";
            obj = (ItemPedido) session.createQuery(hQL).setParameter("idItemPedido", idItemPedido).uniqueResult();
        } finally {
            session.close();
        }
        return obj;
    }
}
