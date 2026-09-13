package dao;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Festival;
import datos.UnidadDeVenta;

public class FestivalDao {
	
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

	public int agregar(Festival objeto) {
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
	public Festival traer(int idFestival) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			objeto = (Festival) session.get(Festival.class, idFestival);
		} finally {
			session.close();
		}
		return objeto;
	}
	/// ***************** corrección : se agregan nuevos métodos de traer  *****************
	public Festival traerPorNombre(String nombre) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Festival where nombre = :nombre";
	        objeto = (Festival) session.createQuery(hql)
	                .setParameter("nombre", nombre)
	                .uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	public Festival traerFestivalPorTemporadaNombreYFecha(String temporada, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Festival where temporada = :temporada and nombre = :nombre and  fechaInicio >= :fechaInicio and fechaFin <= :fechaFin";
	        objeto = (Festival) session.createQuery(hql)
	                .setParameter("temporada", temporada)
	                .setParameter("nombre", nombre)
	                .setParameter("fechaInicio", fechaInicio)
	                .setParameter("fechaFin", fechaFin)
	                .uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Festival traerPorFechaInicioFin(LocalDate fechaInicio, LocalDate fechaFin) {
	    Festival objeto = null;
	    try {
	        iniciaOperacion();
	        String hql = "from Festival where fechaInicio >= :fechaInicio and fechaFin <= :fechaFin";
	        objeto = (Festival) session.createQuery(hql)
	                .setParameter("fechaInicio", fechaInicio)
	                .setParameter("fechaFin", fechaFin)
	                .uniqueResult();
	    } finally {
	        session.close();
	    }
	    return objeto;
	}
	
	//traer unidades de venta de un festival, filtrando por nombre, temporada y rango de fechas
	public List<UnidadDeVenta> traerUnidadesPorFestival(String nombre, String temporada,
	                                                    LocalDate fechaInicio, LocalDate fechaFin) {
	    List<UnidadDeVenta> lista = new ArrayList<UnidadDeVenta>();

	    try {
	        iniciaOperacion();

	        String hql = "select u from UnidadDeVenta u "
	                   + "where u.festival.nombre = :nombre "
	                   + "and u.festival.temporada = :temporada "
	                   + "and u.festival.fechaInicio between :fechaInicio and :fechaFin "
	                   + "and u.festival.fechaFin between :fechaInicio and :fechaFin";

	        Query<UnidadDeVenta> query = session.createQuery(hql, UnidadDeVenta.class)
	                .setParameter("nombre", nombre)
	                .setParameter("temporada", temporada)
	                .setParameter("fechaInicio", fechaInicio)
	                .setParameter("fechaFin", fechaFin);

	        lista = query.getResultList();

	    } finally {
	        session.close();
	    }
	    return lista;
	}
	
	/// ***************** END corrección : se agregan nuevos métodos de traer  *****************
	
	//traer lista de costos por query
		public List<Festival> traer(){
			List<Festival> lista = new ArrayList<Festival>();
			
			try {
				iniciaOperacion();
				
				Query<Festival> query = session.createQuery("from Festival f", Festival.class);
				lista = query.getResultList();
				
			}finally{
				session.close();
			}
			return lista;
			
		}
	public Festival traerFestivalYCosto(int idFestival) throws HibernateException{
		Festival objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Festival f inner join fetch f.costo where f.id = :idFestival";
			objeto = (Festival) session.createQuery(hql).setParameter("idFestival", idFestival).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}
	
	
	public void actualizar(Festival objeto) {
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
	public void eliminar(Festival objeto) {
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
	
	public Festival traerFestivalYUnidadDeVenta(String nombre) throws HibernateException {
		Festival objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Festival f where f.nombre=:nombre";
			objeto=(Festival) session.createQuery(hql).setParameter("nombre", nombre).uniqueResult();
			Hibernate.initialize(objeto.getUnidadesDeVenta());
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
	
	public Long costoTotalPlatosPorFestival(String nombreFestival) {
	    Long total = 0L;
	    try {
	        iniciaOperacion();
	        String hql = "select sum(p.precio) "
	                   + "from UnidadDeVenta u join u.lstPlatos p "
	                   + "where u.festival.nombre = :nombreFestival";
	        total = (Long) session.createQuery(hql)
	                .setParameter("nombreFestival", nombreFestival)
	                .uniqueResult();
	    } finally {
	        session.close();
	    }
	    return (total != null) ? total : 0L;   // sum devuelve null si no hay filas
	}
	
	public Double sueldoPromedioStaffDeFestival(String nombreFestival) {
	    Double promedio = 0.0;
	    try {
	        iniciaOperacion();
	        String hql = "select avg(st.sueldo) "
	                   + "from UnidadDeVenta u join u.lstStaff st "
	                   + "where u.festival.nombre = :nombreFestival";
	        promedio = (Double) session.createQuery(hql)
	                .setParameter("nombreFestival", nombreFestival)
	                .uniqueResult();
	    } finally {
	        session.close();
	    }
	    return (promedio != null) ? promedio : 0.0;   // avg devuelve null si no hay filas
	}

}
