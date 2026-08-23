package datos;

public class Costo {
   
    private int id; //autoincremental
    private int costoSuperficies;
    private int costoMontaje;
    private int plusElectricidad;
    private int sueldoBase;

    public Costo() {} // siempre hay que implementar el constructor vacío 
    
 // no va el id en el constructor por ser autoincrementable
    public Costo(int costoSuperficies, int costoMontaje, int plusElectricidad, int sueldoBase) {  
        super();
    	this.costoSuperficies = costoSuperficies;
        this.costoMontaje = costoMontaje;
        this.plusElectricidad = plusElectricidad;
        this.sueldoBase = sueldoBase;
    }
    
  //geters y seters 

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Costo [id=" + id + ", costoSuperficies=" + costoSuperficies + ", costoMontaje=" + costoMontaje
				+ ", plusElectricidad=" + plusElectricidad + ", sueldoBase=" + sueldoBase + "]";
	}
    
    
    
    
    

}
