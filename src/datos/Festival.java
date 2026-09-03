package datos;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Festival {
	private int id; //autoincremental
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Set<UnidadDeVenta> unidadesDeVenta;
	private Costo costo;
	
	public Festival() {}

	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, Costo costo) {
		super();
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costo = costo;
	}
	
	//1.9 constructor de festival sin Costo ni UnidadesDeVenta
	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<UnidadDeVenta> getUnidadesDeVenta() {
		return unidadesDeVenta;
	}

	public void setUnidadesDeVenta(Set<UnidadDeVenta> unidadesDeVenta) {
		this.unidadesDeVenta = unidadesDeVenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Costo getCosto() {
		return costo;
	}

	public void setCosto(Costo costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Festival [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", costo=" + costo + ", unidadesDeVenta=" + unidadesDeVenta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, fechaFin, fechaInicio, Integer.valueOf(id), nombre, temporada, unidadesDeVenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Festival other = (Festival) obj;
		return Objects.equals(costo, other.costo) && Objects.equals(fechaFin, other.fechaFin)
				&& Objects.equals(fechaInicio, other.fechaInicio) && id == other.id
				&& Objects.equals(nombre, other.nombre) && Objects.equals(temporada, other.temporada)
				&& Objects.equals(unidadesDeVenta, other.unidadesDeVenta);
	};

}
