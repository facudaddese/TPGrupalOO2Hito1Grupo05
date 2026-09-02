package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Costo;

public class CostoDao {

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

	// agregar costo
	public int agregar(Costo obejto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(obejto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	// actualizar costo
	public void actualizar(Costo objeto) {
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
	//eliminar costo 
	public void eliminar(Costo objeto) {
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
	
	//traer costo por id costo
	public Costo traer(int idCosto) {
		Costo objeto = null;
		try {
			iniciaOperacion();
			objeto = (Costo) session.get(Costo.class, idCosto);
		}finally {
			session.close();
		}
		return objeto;
	}
	
	//traer lista de costos por query
	public List<Costo> traer(){
		List <Costo> lista = new ArrayList<Costo>();
		
		try {
			iniciaOperacion();
			
			Query<Costo> query = session.createQuery("from Costo c", Costo.class);
			lista = query.getResultList();
			
		}finally{
			session.close();
		}
		return lista;
		
	}
}
