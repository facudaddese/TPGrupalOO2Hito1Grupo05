package dao;

import datos.Festival;

import datos.ItemPedido;
import datos.Pedido;
import datos.UnidadDeVenta;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class PedidoDao {
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

    public int agregar(Pedido objeto) {
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

    public void actualizar(Pedido objeto) {
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

    public void eliminar(Pedido objeto) {
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

    public Pedido traer(int idPedido) {
        Pedido objeto = null;
        try {
            iniciaOperacion();
            objeto = (Pedido) session.get(Pedido.class, idPedido);
        } finally {
            session.close();
        }
        return objeto;
    }

    public Pedido traerPedidoEitemPedido(int idPedido) throws HibernateException {
        Pedido objeto = null;
        try {
            iniciaOperacion();
            String hql = "from Pedido p where p.idPedido=:idPedido";
            objeto= (Pedido) session.createQuery(hql).setParameter("idPedido", idPedido).uniqueResult();
            Hibernate.initialize(objeto.getListaItems());
        }
        finally {
            session.close();
        }
        return objeto;
    }

    public Pedido traerPedidoYUnidadDeVenta(int idPedido) throws HibernateException {
        Pedido obj = null;
        try {
            iniciaOperacion();
            String hQL = "from Pedido p inner join fetch p.unidadDeVenta u where p.idPedido=:idPedido";
            obj = (Pedido) session.createQuery(hQL).setParameter("idPedido", idPedido).uniqueResult();
        } finally {
            session.close();
        }
        return obj;
    }

    public Pedido traerPedidoYFestival(int idPedido){
        Pedido obj = null;
        try {
            iniciaOperacion();
            String hQL = "from Pedido p inner join fetch p.festival f where p.idPedido=:idPedido";
            obj = (Pedido) session.createQuery(hQL).setParameter("idPedido", idPedido).uniqueResult();
        } finally {
            session.close();
        }
        return obj;
    }

    public List<Pedido> traerPedidosRealizadosEntreFechasDeUnaUDV(LocalDate inicio, LocalDate fin, UnidadDeVenta udv){
        List<Pedido> pedidos = null;
        try {
            iniciaOperacion();

            String hQL = "select distinct p from Pedido p left join fetch p.listaItems where p.unidadDeVenta.codigo = :codigo and p.fechaTransaccion between :inicio and :fin";
            pedidos = session.createQuery(hQL, Pedido.class).setParameter("codigo", udv.getCodigo()).setParameter("inicio", inicio).setParameter("fin", fin).getResultList();
        } finally {
            session.close();
        }

        return pedidos;
    }

    public List<Pedido> rankingPedidosMasCarosDeUnFestival(Festival festival){
        List<Pedido> pedidos = null;
        try {
            iniciaOperacion();
            String hQL = "select p from Pedido p inner join p.listaItems ip where p.festival = :festival group by p order by SUM(ip.precio * ip.cantidad) desc";
            pedidos = session.createQuery(hQL, Pedido.class).setParameter("festival", festival).setMaxResults(3).getResultList();

            // inicializo mientras la sesion sigue abierta
            for (Pedido p : pedidos) {
                Hibernate.initialize(p.getListaItems());
                for (ItemPedido ip : p.getListaItems()) {
                    Hibernate.initialize(ip.getPlato());
                }
            }

        } finally {
            session.close();
        }
        return pedidos;
    }


}
