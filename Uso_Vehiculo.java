package poo;

import javax.swing.JOptionPane;
//videos 28, 29, 30 y 31 POO 2

//TAMBIEN CREAREMOS INSTANCIAS A LA CLASE FURGONETA, VIDEO 41 (ABAJO del todo)

public class Uso_Vehiculo {
	
	//En esta clase es por la que COMIENZA la ejecución de un programa AL TENER LA CLASE MAIN
	public static void main(String[] args) {
		
		// Esta clase tiene el método "main", no como la clase coche
		
		//Ahora vamos a crear objetos (instanciar)que comparten la estructura del chasis de la clase "coche":
		/*Cómo crear un objeto:1 - poner la clase a la que pertenece (coche)
		 						2 - nombre que queramos que tenga el objeto (Peugeot)
		 						3 - Signo =
		 						4 - new + nombre del constructor (new coche();)
		 */
		coche Peugeot=new coche();//Instanciar clase, Peugeot es un ejemplar de clase
		
		
		/* debido a la encapsulacion las líneas de abajo no se pueden leer al poner private en modulo "coche"
		System.out.println("Este coche tiene " + Peugeot.largo + " cm. de largo.");
		SOLUCION: en clase "coche" hemos hecho el metodo GETTER dime_largo() ABAJO*/
		System.out.println(Peugeot.dime_datos_generales());
		
		System.out.println("El jodido coche tiene " +Peugeot.dime_ruedas() + " ruedas.");
		
		
		/*Vamos a modificar el color del coche., que de primeras es azul
		 * (el módulo "coche" tenemos el método SETTER "establece_color"
		 */
		Peugeot.establece_color(JOptionPane.showInputDialog("Introduce un fuckin'color:"));//el valor del argumento se almacena en el parámetro"color_coche"
		System.out.println(Peugeot.dime_color());//Devuelve que el color del carro es lo dado en el argumento de fila de arriba
		//Si comentara la línea: Peugeot.establece_color();(2 más arriba) devuelve que el color del carro es NULL!!!
		
		
		Peugeot.configura_asientos(JOptionPane.showInputDialog("¿Quieres asientos de cuero? Si/No"));
		System.out.println(Peugeot.dime_asientos());
		
		
		Peugeot.configura_climatizador(JOptionPane.showInputDialog("¿Quieres climatizador? Si/No"));
		System.out.println(Peugeot.dime_climatizador());
		
		
		System.out.println(Peugeot.dime_peso_coche());
		
		System.out.println("El precio final del coche es: "+Peugeot.precio_coche());
		
		//Contruimos FURGONETA:
		Furgoneta mifragoneta1 = new Furgoneta(7,580); //parametros plazas_extra y capacidad_carga
		mifragoneta1.establece_color("verde pistacho");//metodo heredado de la clase coche!
		mifragoneta1.configura_asientos("si");
		mifragoneta1.configura_climatizador("si");
		
		System.out.println("Datos fragoneta: "+ mifragoneta1.dime_datos_generales());
		
		//En los resultados sale "coche" en el string pero como ejemplo de herencia de superclase vale:
		System.out.println(mifragoneta1.dime_color());
		System.out.println(mifragoneta1.dime_asientos());
		System.out.println(mifragoneta1.dime_climatizador());
	}

}
