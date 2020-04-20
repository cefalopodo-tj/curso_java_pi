// EJEMPLO CON UN UNICO FICHERO DONDE CONSTRUIREMOS TODAS LAS CLASES (NO COMO EN COCHE Y USO_COCHE
		//SE DESACONSEJA USAR SOLO 1 FICHERO, PERO VAMOS A PROBAR

//VIDEOS 33,34,35
package poo;

//VISTOS VIDEOS 33 Y 34 y 35. Y VIDEO 39 PARA VER SOBRECARGA DE CONSTRUCTORES
//VIDEO 42 CREANDO CLASE JEFATURA para ver herencia(ABAJO)
//VIDEO 43 CREAMOS INSTANCIAS JEFATURA Y VEMOS POLIMORFISMO.
//VIDEO 44 REFUNDICION DE OBJETOS. Convertimos un objeto de la lista (misempleados[5]
//VIDEO 44 CLASES Y METODOS "FINAL" (ABAJO VER CLASE DIRECTOR...
	//...Y set_sueldo() de Empleado)

import java.util.Date;//Para la variable alta_contratacion
import java.util.GregorianCalendar;//Para convertir dia, mes y año a date
 //Por herencia también vale para GetTime(), 
//que es de la clase Calendar (no gregorianCalendar vaya)

public class Uso_empleado {

	public static void main(String[] args) {
		/*
		Empleado Empleado1=new Empleado("Paco",22000,2004,05,22);
		Empleado Empleado2=new Empleado("Jessy del Fresno",33000,2002,04,02);
		Empleado Empleado3=new Empleado("Telesforo Wayne",10000,2012,9,11);
		
		Empleado1.set_sueldo(5);
		Empleado2.set_sueldo(5);
		Empleado3.set_sueldo(5);
		
		System.out.println("Nombre: "+Empleado1.get_nombre()+
				". Sueldo: "+Empleado1.get_sueldo()+
				". Fecha de alta: "+ Empleado1.get_fecha_contratacion());
		System.out.println("Nombre: "+Empleado2.get_nombre()+
				". Sueldo: "+Empleado2.get_sueldo()+
				". Fecha de alta: "+ Empleado2.get_fecha_contratacion());
		System.out.println("Nombre: "+Empleado3.get_nombre()+
				". Sueldo: "+Empleado3.get_sueldo()+
				". Fecha de alta: "+ Empleado3.get_fecha_contratacion());
		*/
		
		/*PARA VER POLIMORFISMO(VIDEO 43) CREAMOS UNA INSTANCIA DE LA CLASEJEFATURA:
		 */
		Jefatura jefe_RRHH=new Jefatura("Capo", 100000,2008,9,10);
		jefe_RRHH.set_incentivo(22000);
		System.out.println(jefe_RRHH.get_sueldo());
		
		/*MEJOR QUE EL CODIGO DE ARRIBA(QUE FUNCIONA, VAMOS A HACER UN ARRAY
		 * PARA LOS EMPLEADOS, Y LUEGO UN BUCLE FOR PARA RECORRER ESE ARRAY*/
		Empleado[]  misempleados=new Empleado[6];//String[] miarray=new String[3];
								//Que no se nos olvide modificar el nº en new Empleado[X];
		misempleados[0]=new Empleado ("Paco",22000,2004,05,22);
		misempleados[1]=new Empleado ("Jessy del Fresno",33000,2002,04,02);
		misempleados[2]=new Empleado ("Telesforo Wayne",10000,2012,9,11);
		misempleados[3]=jefe_RRHH;//Polimorfismo style
		//Abajo ej. de uso de constructor (2º) creado con un parámetro(en video 39)
		//El sueldo será = 0 y la fecha será =null(al no ser un tipo primitivo sino Date, que es un objeto)
		misempleados[4]=new Empleado ("Nombre con un parámetro en constructor");
		
		
		
		misempleados[5]=new Jefatura ("Sebas",44000,1999,4,25);//otro ejemplo de polimorfismo
		
		//AHORA  HACEMOS REFUNDICION PARA METERLE UN INCENTIVO (ANTES ERA UN OBJETO EMPLEADO, NO JEFATURA):
		Jefatura jefa_finanzas=(Jefatura) misempleados[5];//casting hecho!!!!
		jefa_finanzas.set_incentivo(25000);//Ahora aplicamos el incentivo
		
		
		for (Empleado e:misempleados){/*Esto lo mismo que for(int i=3,i<3,i++){
									misempleados[i].setsueldo(5);
									System.out.println(Nombre; "+ misempleados[i].get_nombre()+...
									*/
			e.set_sueldo(10);
			System.out.println("Nombre; "+ e.get_nombre()+
					", con un sueldo de: "+e.get_sueldo()+
					" , entró en la empresa el "+e.get_fecha_contratacion());
		}
	}

}



class Empleado{//Como sólo puede haber un public por fichero y ya lo tenemos en Uso_empleado no se puede
				//Y sólo podemos tener un método main
	
	
	//PRIMER Constructor de la clase empleado con parámetros(único constructor hasta video 35:
	public Empleado(String  nom, double sue,  int agno, int mes,int dia) { 
		nombre=nom;
		sueldo=sue;
		//Para establecer la fecha de alta utilizamos la clase GregorianCalendar
		//De todos los constructores de gregoriancalendar usaremos el siguiente recogido de la API:
		/*public GregorianCalendar​(int year, int month, int dayOfMonth)
		 * Para este contructor Enero es el mes 0. CUIDADO!!:*/
		GregorianCalendar calendario=new GregorianCalendar(agno, mes-1,dia);
		/*Devuelve la fecha pasando uno de los métodos pertenecientes a 
		 * la clase gregoriancalendar, que es GetTime, método heredado:
		 */
		alta_contratacion= calendario.getTime();
		
	}
	//SEGUNDO CONSTRUCTOR para aquellos empleados de los que SOLO conocemos el nombre
	public Empleado(String nom) {
		//nombre=nom; -> Lo usaremos si nos da igual que salgan los datos por defecto de sueldo (0) y de fecha(null)
		
		//Con el this llamamos al otro constructor para sueldo y fecha!
		//Así los datos no saldrán como 0 (sueldo) y null(fecha), SINO QUE ASIGNAMOS..
		//SUELDO POR DEFECTO(15000) Y FECHA(01/01/2010):
		this(nom, 15000, 2010,01,01);
		
	}
	
	/*Abajo getters que nos van a devolver los valores almacenados:*/
	public String get_nombre() {
		return nombre;
	}
	
	public double get_sueldo() {
		return sueldo;
	}
	public Date get_fecha_contratacion() {
		return alta_contratacion;
	}
	
	/*Abajo método setter que se encarga de subir el sueldo */	
	public void set_sueldo(double porcentaje) {
		double aumento=sueldo*(porcentaje/100); //creamos variable para definir cantidad de subida extra
		sueldo+=aumento;//Total de salario+subida
	}
	//PARA VER METODOS FINAL (PARA QUE el método set_sueldo de la clase Jefatura...
	//... NO PUEDA HEREDAR DE LA CLASE PADRE (EMPLEADO) - VER EJ. ABAJO:
	public final void set_sueldo2(double porcentaje) {//Le pongo un "2" en el nombre para que EL EJ. no de error
		double aumento=sueldo*(porcentaje/100); 
		sueldo+=aumento;
	}//EL METODO set_sueldo2 de justo ARRIBA NO ES LOGICO EN EL EJ. Solo para ver "final"
	
	//Podemos crear los campos de las clases al final (por verlo de otra forma que en coche):
	private String nombre;
	private double sueldo;
	private Date alta_contratacion;
	
}

//EMPEZAMOS CON LA SUBCLASE JEFATURA(video 43)
//FINAL para que laclase Director(abajo) no herede (video 44)
final class Jefatura extends Empleado{
	
	public Jefatura(String  nom, double sue,  int agno, int mes,int dia) {
		super(nom,sue,agno,mes,dia); //Llamada al constructor de la clase padre pasándole los parámetros
	
	}
	
	public void set_incentivo(double b) {
		incentivo=b;
	}
	public double get_sueldo() {//Mismo nombre que el método que hereda
//Triángulo verde ya que este método está sobreescribiendo el método que hereda de la clase Empleado
		double sueldo_jefe=super.get_sueldo();//Este método es el de la clase Empleado
								//Con super usamos get_sueldo de la clase padre!!!
		return sueldo_jefe + incentivo;
	}
	
	private double incentivo;
}

//CLASE DIRECTOR QUE INTENTA HEREDAR DE JEFATURA (PARA VER "FINAL" IR A CLASS EMPLEADO)
/*LA CLASE DE ABAJO DA ERROR  AL NO PODER HEREDAR DE LA CLASE JEFATURA POR EL FINAL
class Director extends Jefatura{
	public Director(String  nom, double sue,  int agno, int mes,int dia) {
		super(nom,sue,agno,mes,dia); 
	}
}*/

