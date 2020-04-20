package poo;

//VIDEO 40. HERENCIA 1

//Con extends vemos que furgoneta hereda de la clase coche :
public class Furgoneta extends coche {
	
	private int capacidad_carga;
	private int plazas_extra;
	
	
	public Furgoneta(int plazas_extra, int capacidad_carga) {
		
		super();//Llama al constructor de la clase padre(clase coche)
		this.capacidad_carga=capacidad_carga;
		this.plazas_extra=plazas_extra;
		
	}
	
	public String get_datos_furgoneta() {
		return "La capacidad de carga es: "+ capacidad_carga +
				" y las plazas son: " + plazas_extra;
	}
	
}
