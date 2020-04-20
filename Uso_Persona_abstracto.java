package poo;

import java.util.Date;
import java.util.GregorianCalendar;


//FUNCION DEL VIDEO: LA CLASE PADRE SERÁ Persona, QUE HEREDARÁ DE LAS CLASES Empleado2 Y Alumno
//VEREMOS LA FUNCIÓN DEL METODO ABSTRACTO get_descripcion  PARA LAS 2 CLASES HIJAS
//A SU VEZ LA CLASE PADRE (Persona) TAMBIÉN TENDRÁ QUE SER ABSTRACTA POR COJONES

public class Uso_Persona_abstracto {

	public static void main(String[] args) {
		//Creamos un array con todas las personas
		Persona[] laspersonas=new Persona[2];
		
		laspersonas[0]=new Empleado2("Currela1", 18000, 2009,11,04);
		laspersonas[1]=new Alumno("Manolito","Psicología");
		
		for (Persona p:laspersonas) {
			//Abajo método dame_descripcion porque SI está definido en las clases que heredan de Persona
			System.out.println(p.get_nombre() + " , " + p.dame_descripcion());
		}
	}

}

abstract class Persona{//Al tener un método abstracto abajo la clase será abstracta
	//Todas las clases que hereden de ésta están obligadas a sobreescribir el método...
	//...abstracto ue heredarán de esta clase(dame_descripcion)
	
	public Persona(String nom) {
		nombre=nom;
	}
	
	public String get_nombre() {//Mismo método para todas las clases hijas, no abstracto
		return nombre;
	}
	
	public abstract String dame_descripcion();//En métodos abstractos no {}!!!
				//Al tener este método abstracto la clase Persona será tb abstracta
	
	private String nombre;
	
}



//CLASE Empleado COPIADA Y PEGADA INICIALMETE DE Uso_empleado.java (sólo añadiendo Id e IdSiguiente para igualar con el video)
class Empleado2 extends Persona{//No podemos llamar a la clase Empleado al haber otra clase con ese nombre en el paquete, le metemos un 2

	public Empleado2(String  nom, double sue,  int agno, int mes,int dia) { 
		//nombre=nom;Vb eliminada al haberse eliminado el método get_nombre de esta clase
		super(nom);//Así invocamos al constructor de la clase padre con su único parámetro
		sueldo=sue;
		GregorianCalendar calendario=new GregorianCalendar(agno, mes-1,dia);		
		alta_contratacion= calendario.getTime();
		++IdSiguiente;
		Id=IdSiguiente;

	}
	public String dame_descripcion() {//A izq triangulo que indica que estamos sobreescribiendo el método dame_descripcion de la clase padre
		
		return "Este empleado tiene un Id= " + Id + " con un sueldo= "+sueldo;
	}
	
//ELIMINADO DE LA COPIA DE Uso_empleado EL SEGUNDO CONSTRUCTOR CON SOLO UN PARAMETRO

//ELIMINADO DE LA COPIA DE Uso_empleado EL METODO get_nombre,  VA A ESTAR EN LA CLASE PERSONA


	public double get_sueldo() {
		return sueldo;
	}
	public Date get_fecha_contratacion() {
		return alta_contratacion;
	}
	
		
	public void set_sueldo(double porcentaje) {
		double aumento=sueldo*(porcentaje/100); 
		sueldo+=aumento;//Total de salario+subida
	}
	/*
	public final void set_sueldo2(double porcentaje) {Le pongo un "2" en el nombre para que EL EJ. no de error
		double aumento=sueldo*(porcentaje/100); 
		sueldo+=aumento;
		
		
	}*///EL METODO set_sueldo2 de justo ARRIBA NO ES LOGICO EN EL EJ. Solo para ver "final"
	
	
	//private String nombre;--> Vb eliminada al haberse eliminado el método get_nombre de esta clase
	private double sueldo;
	private Date alta_contratacion;
	private static int IdSiguiente;
	private int Id;

}

class Alumno extends Persona{
	
	public Alumno(String nom, String car) {
		
		super(nom);
		carrera=car;
	}
	public String dame_descripcion() {//sobreescribiendo método abstracto de la clase padre
		return "Este alumno está estudiando la carrera de: "+ carrera;
	}
	
	private String carrera;
}


