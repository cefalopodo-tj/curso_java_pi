package poo;

public class Amoto {
	private int ruedas;
	private int cilindrada;
	private int intermitentes;
	
	
	private boolean llantas;
	private boolean maletas;
	private String color;
	
	public Amoto() {
		
		ruedas=2;
		cilindrada=600;
		intermitentes=4;
	}
	
	public String get_datos_generales() {
		
		return "La fuckin'amoto tiene " + ruedas + " ruedas, una cilindrada de "
				+cilindrada + " cm3 y " + intermitentes + " intermitentes.";
	}
	
	public void  set_color(String color) {
		
		this.color=color;
	}
	
	public String get_color() {
		
		return "Aunque es una horterada, el color elegido es: "+color;
	}
	
	
	public void set_maletas(String maletas) {
		
		if (maletas.equalsIgnoreCase("si")) {
			this.maletas=true;
		}else {
			this.maletas=false;
		}
	}
	
	public String get_maletas() {
		
		if(maletas==true) {
			return "Has elegido la burra con maletas.";
		}else {
			return "La burra va a pelo, sin maletas ni hostias";
		}
		
	}
	
}
