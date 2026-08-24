package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UnidadDeVentaDao {

    private static Session session;
    private Transaction tx;
    private static UnidadDeVentaDao instancia = null;

    protected UnidadDeVentaDao(){

    }
    public static UnidadDeVentaDao getInstance(){
        if(instancia == null){
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



}
