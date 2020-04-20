package poo;


//video 27, 30, 31 POO 1

public class coche {
	/*En esta clase ponemos las caracteristicas comunes en LA PLATAFORMA de todos los coches*/
	
	private int ruedas;/*Con private ENCAPSULAMOS desde la clase, 
	con lo que ya no podemos variar el número de ruedas en ningún módulo*/
	
	//Necesitamos comunicarnos con otras clases a traves de métodos
	//(por ej para ver el largo desde otro módulo(getters y setters MAS ABAJO)
	private float largo; /*En principio int porque se va a especificar en cm, cambiado a float para que dime_datos_generales quede OK*/
	private int ancho;
	private int motor; /*en cm3 */
	private int peso_plataforma; /*kg*/
	
	/*Como puede variar en otros módulos SÓLO se van a poder utilizar a través de los métodos
	 *  correspondientes settter (abajo ej. con establece_color/dime_color)
	 *  y no en otro módulo a través de, por ejemplo, Peugeot.color="rojo", lo que duplicaría la información
	 */
	private String color;
	private int peso_total;
	private boolean asientos_cuero, climatizador; //O tiene o no tiene

	
	/*Abajo método CONSTRUCTOR que se encarga de dar un estado inicial a nuestro objeto*/
	/* Ponemos public + el nombre de la clase + () + {}:*/
	public coche() {
		ruedas=4;
		largo=3482;//Si luego medimos
		ancho=300;
		motor=1600;
		peso_plataforma=500;
	}
	
	//Tenemos que ENCAPSULAR para que las ruedas sólo puedan ser 4, no como:Peugeot.ruedas=3;(con private)
	/*Para acceder a los datos de coche encapsulados  con private EN OTROS MODULOS tenemos que 
	 * usar el método GETTER. Sintaxis:
	* public dato_a_devolver nombre_método() {código + return} ABAJO:
	*/
	public String dime_datos_generales() {//ej. de método getter
		return "La plataforma del vehículo tiene " + ruedas + " ruedas, "
				+ largo/1000 + " metros de largo, "+ ancho + " cm de ancho, "
				+ " un motor de "+motor+" cm3 y un peso de " + peso_plataforma+ " kg.";
	}
	public int dime_ruedas() {
		return ruedas;
	}
	
	
	/* Sintaxis de métodos SETTER, estos establecen valores a una propiedad
	 * public void nombre_método(){código}; 
	 * "void" indica que el método no devuelve ningún valor, AL CONTRARIO DE METODO GETTER
	 */
	public void establece_color(String color_coche) { //Parámetros para jugar desde otro módulo
		color=color_coche; //La vb es = al argumento que se dé en otro módulo a color_coche
		//color="azul"; //sin return ni hostias--> Esto visto antes de meter parámetros, luego no vale para nada
	}
	//A continuación tenemos que crear un metodo getter que nos informe del color:
	public String dime_color() {
		return "El color del carro es "+ color; // vb color dentro del método "establece_color()"
	}
	
	
	
	public void configura_asientos(String asientos_cuero) { //Setter
		//ej. en el que el nombre del argumento es = que el de la vb(arriba)
		/*this.asientos_cuero=asientos_cuero;
		 				* Con el this. le indicamos a java que estamos haciendo referencia a 
						*la vb de la clase. El que NO lleva el this hace referencia al argumento*/
		if (asientos_cuero.equalsIgnoreCase("si")) {
			this.asientos_cuero=true;
		}else {
			this.asientos_cuero=false;
		}		
	}
	public String dime_asientos() {//Getter
		if (asientos_cuero==true) {
			return "El coche tiene asientos de cuero";
		}else {
			return "El coche tiene los asientos de serie.";
		}
		
	}
	
	
	public void configura_climatizador(String climatizador) {//setter
		if (climatizador.equalsIgnoreCase("si")){//EN LUGAR DE USAR climatizador=="si". Encima distingue entre may y min
			this.climatizador=true;
		}else {
			this.climatizador=false;
		}
	}
	public String dime_climatizador() {//getter
		if (climatizador==true) {
			return "El coche tiene climatizador.";
		}else {
			return "El coche no tiene climatizador.";
		}
	}
	
	//METODO SETTER Y GETTER A LA VEZ (NO RECOMENDADO, para verlo na más que se puede hacer)
	
	public String dime_peso_coche() {
		
		int peso_carroceria=500;//establece
		peso_total= peso_plataforma+peso_carroceria;
		
		if (asientos_cuero==true) {
			peso_total=peso_total+50;
		}
		if (climatizador==true) {
			peso_total=peso_total+20;		
		}
		
		return "El peso del coche es "+peso_total;//devuelve
	}
	
	
	//metodo que devuelve el precio del coche:
	public int precio_coche() {//Esto es otro getter
		
		int precio_final=10000;
		
		if (asientos_cuero==true) {
			precio_final+=2000;
		}
		if (climatizador==true) {
			precio_final+=500;	
		}
		return precio_final;//como solo incluye la cantidad en uso_coche incluiremos una cadena antes
	}
	
}
