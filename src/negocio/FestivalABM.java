package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FestivalDao;
import datos.Festival;
import datos.UnidadDeVenta;

public class FestivalABM {
	FestivalDao dao = new FestivalDao();

	public Festival traerFestival(int idFestival) {
		return dao.traer(idFestival);
	}

	//  ***************** corrección : se agregan nuevos métodos de traer  *****************
	public Festival traerFestivalPorNombre(String nombreFestival) {
		return dao.traerPorNombre(nombreFestival);
	}

	public Festival traerFestivalPorTemporadaNombreYFecha(String temporada, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
		return dao.traerFestivalPorTemporadaNombreYFecha(temporada, nombre, fechaInicio, fechaFin);
	}

	public Festival traerFestivalPorFechaInicioFin(LocalDate fechaInicio, LocalDate fechaFin) {
		return dao.traerPorFechaInicioFin(fechaInicio, fechaFin);
	}    
	
	//consultar si va acá o en UdV
	public List<UnidadDeVenta> traerUnidadesDeVentasPorFestival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
		return dao.traerUnidadesPorFestival(nombre, temporada, fechaInicio, fechaFin);
	}
	
	public Long traercostoTotalPlatosPorFestival(String nombreFestival) {
		return dao.costoTotalPlatosPorFestival(nombreFestival);
	}
	
	public Double traerSueldoPromedioStaffDeFestival(String nombreFestival) {
		return dao.sueldoPromedioStaffDeFestival(nombreFestival);
	}
	
	
	//  ***************** END corrección : se agregan nuevos métodos de traer  *****************


	public List<Festival> traer() {
		return dao.traer();
	}

	public Festival traerFestivalyCosto(int idFestival) {
		return dao.traerFestivalYCosto(idFestival);
	}
	
	public int agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
		Festival fExist = dao.traerFestivalPorTemporadaNombreYFecha(temporada, nombre, fechaInicio, fechaFin);
		if (fExist != null) {
			throw new Exception("Error: Se ha encontrado festival duplicado. ID: " + fExist.getId());
		}
		

		Festival f = new Festival(nombre, temporada, fechaInicio, fechaFin);
		return dao.agregar(f);
	}

	public void modificar(Festival f) throws Exception {
		Festival existe = dao.traer(f.getId());
		if (existe == null) {
			throw new Exception("ERROR:  no existe Festival con dicho ID " + f.getId());
		}
		dao.actualizar(f);
	}

	public void eliminar(int id) throws Exception {
		Festival c = dao.traer(id);
		if (c == null) {
			throw new Exception("ERROR: no existe Festival con dicho ID");
		}
		dao.eliminar(c);
	}

	public Festival traerFestivalYUnidadDeVenta(String nombre) {
		return dao.traerFestivalYUnidadDeVenta(nombre);
	}
	
}
