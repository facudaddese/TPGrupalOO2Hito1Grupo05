package datos;

import java.util.Objects;

public class Costo {
   
    private int id; //autoincremental
    private int costoSuperficies;
    private int costoMontaje;
    private int plusElectricidad;
    private int sueldoBase;
    
    private Festival festival;

    public Costo() {} // siempre hay que implementar el constructor vacío 
    
 // no va el id en el constructor por ser autoincrementable
    public Costo(int costoSuperficies, int costoMontaje, int plusElectricidad, int sueldoBase) {  
        super();
    	this.costoSuperficies = costoSuperficies;
        this.costoMontaje = costoMontaje;
        this.plusElectricidad = plusElectricidad;
        this.sueldoBase = sueldoBase;
    }
    
    public Costo(int costoSuperficies, int costoMontaje, int plusElectricidad, int sueldoBase, Festival festival) {  
        super();
    	this.costoSuperficies = costoSuperficies;
        this.costoMontaje = costoMontaje;
        this.plusElectricidad = plusElectricidad;
        this.sueldoBase = sueldoBase;
        this.festival = festival;
    }
    
  //geters y seters 

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public int getCostoSuperficies() {
		return costoSuperficies;
	}

	public void setCostoSuperficies(int costoSuperficies) {
		this.costoSuperficies = costoSuperficies;
	}

	public int getCostoMontaje() {
		return costoMontaje;
	}

	public void setCostoMontaje(int costoMontaje) {
		this.costoMontaje = costoMontaje;
	}

	public int getPlusElectricidad() {
		return plusElectricidad;
	}

	public void setPlusElectricidad(int plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}

	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	@Override
	public String toString() {
		return "Costo [id=" + id + ", costoSuperficies=" + costoSuperficies + ", costoMontaje=" + costoMontaje
				+ ", plusElectricidad=" + plusElectricidad + ", sueldoBase=" + sueldoBase + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(costoMontaje), Integer.valueOf(costoSuperficies), festival,
				Integer.valueOf(plusElectricidad), Integer.valueOf(sueldoBase));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Costo other = (Costo) obj;
		return costoMontaje == other.costoMontaje && costoSuperficies == other.costoSuperficies
				&& Objects.equals(festival, other.festival) && plusElectricidad == other.plusElectricidad
				&& sueldoBase == other.sueldoBase;
	}
	
	

}
