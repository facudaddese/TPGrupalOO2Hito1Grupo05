package dao;

import datos.Festival;
import datos.Staff;
import datos.UnidadDeVenta;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

public class UnidadDeVentaDao {

    private static Session session;
    private Transaction tx;
    private static UnidadDeVentaDao instancia = null;

    protected UnidadDeVentaDao() {
    }

    ;

    public static UnidadDeVentaDao getInstance() {
        if (instancia == null) {
            instancia = new UnidadDeVentaDao();
        }
        return instancia;
    }

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    public int agregar(UnidadDeVenta objeto) {
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

    public void actualizar(UnidadDeVenta objeto) {
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

    public void eliminar(UnidadDeVenta objeto) {
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

    public UnidadDeVenta traer(int id) {
        UnidadDeVenta objeto = null;
        try {
            iniciaOperacion();
            objeto = (UnidadDeVenta) session.get(UnidadDeVenta.class, id);
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return objeto;
    }

    public UnidadDeVenta traerPorCodigo(String codigo) {
        UnidadDeVenta objeto = null;
        try {
            iniciaOperacion();
            String hql = "from UnidadDeVenta u left join fetch u.responsable where u.codigo = :codigo";
            objeto = session.createQuery(hql, UnidadDeVenta.class).setParameter("codigo", codigo).uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return objeto;
    }

    public List<UnidadDeVenta> traer() {

        List<UnidadDeVenta> lista = new ArrayList<>();

        try {
            iniciaOperacion();
            Query<UnidadDeVenta> query = session.createQuery(
                    "from UnidadDeVenta u order by u.nombreComercial asc, u.codigo asc", UnidadDeVenta.class);
            lista = query.getResultList();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return lista;

    }

    public List<UnidadDeVenta> traer(Festival f) {
        List<UnidadDeVenta> lista = null;
        try {
            iniciaOperacion();
            //clase UnidadDeVenta, captura las unidades de venta q pertenecen a un festival específico
            String hQL = "from UnidadDeVenta u inner join fetch u.festival f where 	f.id=:idFestival";
            lista = session.createQuery(hQL, UnidadDeVenta.class).setParameter("idFestival",
                    f.getId()).getResultList();
        } finally {
            session.close();
        }
        return lista;
    }

    public UnidadDeVenta traerUnidadDeVentaYFestival(int idUnidadDeVenta) {
        UnidadDeVenta obj = null;
        try {
            iniciaOperacion();
            //devuelve una unidad de venta con festival asociado
            String hQL = "from UnidadDeVenta u inner join fetch u.festival f where u.id=:idUnidadDeVenta";
            obj = (UnidadDeVenta) session.createQuery(hQL).setParameter("idUnidadDeVenta",
                    idUnidadDeVenta).uniqueResult();
        } finally {
            session.close();
        }
        return obj;
    }

    public UnidadDeVenta traerUnidadDeVentaYStaff(int idUnidadDeVenta) {

        UnidadDeVenta objeto = null;
        try {
            iniciaOperacion();
            objeto = (UnidadDeVenta) session.get(UnidadDeVenta.class, idUnidadDeVenta);
            if (objeto != null) {
                Hibernate.initialize(objeto.getLstStaff());
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return objeto;
    }

    public UnidadDeVenta traerUnidadDeVentaYPlatos(int idUnidadDeVenta) {

        UnidadDeVenta objeto = null;
        try {
            iniciaOperacion();
            objeto = (UnidadDeVenta) session.get(UnidadDeVenta.class, idUnidadDeVenta);
            if (objeto != null) {
                Hibernate.initialize(objeto.getLstPlatos());
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return objeto;
    }

    public List<Staff> traerCocinerosDeFestivalEntreFechaDeNac(String nombreFestival, LocalDate fechaDesde, LocalDate fechaHasta) {
        List<Staff> lista = new ArrayList<>();
        try {
            iniciaOperacion();
            Query<Staff> query = session.createQuery(
                    "select s from UnidadDeVenta u " +
                            "join u.lstStaff s " +
                            "join u.festival f " +
                            "where f.nombre = :nombreFestival " +
                            "and s.class = Cocinero " +
                            "and s.fechaNacimiento between :fechaDesde and :fechaHasta",
                    Staff.class
            );
            query.setParameter("nombreFestival", nombreFestival);
            query.setParameter("fechaDesde", fechaDesde);
            query.setParameter("fechaHasta", fechaHasta);
            lista = query.getResultList();
        } finally {
            session.close();
        }
        return lista;
    }

    public List<Staff> traerCajerosDeFestivalPorTurnoYSueldo(String nombreFestival, String turno, int sueldo) {
        List<Staff> lista = new ArrayList<>();
        try {
            iniciaOperacion();
            Query<Staff> query = session.createQuery(
                    "select s from UnidadDeVenta u " +
                            "join u.lstStaff s " +
                            "join u.festival f " +
                            "where f.nombre = :nombreFestival " +
                            "and s.class = Cajero " +
                            "and s.turno = :turno " +
                            "and s.sueldo < :sueldo",
                    Staff.class
            );
            query.setParameter("nombreFestival", nombreFestival);
            query.setParameter("turno", turno);
            query.setParameter("sueldo", sueldo);
            lista = query.getResultList();
        } finally {
            session.close();
        }
        return lista;
    }

    public List<UnidadDeVenta> traerPorRangoFechasFestival(LocalDate desde, LocalDate hasta){
        List<UnidadDeVenta> lista = null;
        try{
            iniciaOperacion();
            String hql = "select distinct u from UnidadDeVenta u "
                        + "inner join fetch u.festival f "
                        + "where f.fechaInicio >= :desde and f.fechaFin <= :hasta";
            lista = session.createQuery(hql, UnidadDeVenta.class).setParameter("desde", desde).setParameter("hasta", hasta).list();
        }catch (HibernateException he){
            manejaExcepcion(he);
        }finally {
            session.close();
        }
        return lista;
    }

    public List<Object[]> traerUnidadesConVentasSuperioresA(double montoObjetivo){
        List<Object[]> lista = null;

        try{
            iniciaOperacion();
            String hql = "select u, sum(ip.cantidad * pl.precio) "
                        + "from ItemPedido ip "
                        + "inner join ip.pedido p "
                        + "inner join p.unidadDeVenta u "
                        + "inner join ip.plato pl "
                        + "group by u "
                        + "having sum(ip.cantidad * pl.precio) >= :monto "
                        + "order by sum(ip.cantidad * pl.precio) desc";
            lista = session.createQuery(hql, Object[].class).setParameter("monto", (long) montoObjetivo).list();
        }catch(HibernateException he){
            manejaExcepcion(he);
        }finally {
            session.close();
        }
        return lista;

    }

    public void desvincularStaff(UnidadDeVenta unidad, Staff staff){
        try{
            iniciaOperacion();
            UnidadDeVenta u = session.get(UnidadDeVenta.class, unidad.getId());
            Staff s = session.get(Staff.class, staff.getId());

            if(u != null && s != null){
                u.getLstStaff().remove(s);
                session.update(u);
            }
            tx.commit();
        }catch (HibernateException he){
            manejaExcepcion(he);
        }finally {
            session.close();
        }
    }


}
