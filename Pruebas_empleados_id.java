/* LOS TRABAJADORES NUEVOS ENTRAN POR COJONES AL DPTO DE ADMINISTRACION. S UNA REGLA.
 * CON EL TIEMPO SE LES PUEDE CAMBIAR O NO. */

//VIDEO 36 + 37 + 38. 

package poo;

//FINAL-->CONSTANTES -->PARA NO PODER CAMBIAR EL NOMBRE A POSTERIORI(VALOR DE LA CONSTANTE)
// STATIC-->PARA VARIABLES QUE PERTENECEN A LA CLASE(Empleados)...
	//...Y NO A CADA OBJETO DE LA CLASE. VISTO CON IDŚ INCREMENTABLES

public class Pruebas_empleados_id {

	public static void main(String[] args) {
		
		Empleados currela1=new Empleados("Paco");//Este valor no podrá cambiar por el final.
		Empleados currela2=new Empleados("Julita");
		Empleados currela3=new Empleados ("Ramón");
		
		//Con el argumento el estado inicial(administración) ha cambiado:
		currela2.cambia_seccion("Pocería");
		
		//Cambiar nombre no tiene sentido. Ver FINAL en la vb nombre para ver CONSTANTES:
		//currela1.cambianombre("Paquito");
		
		System.out.println(currela1.devuelvedatos());
		//Ejemplo mal hecho previo->Empleados.Id++;//Vemos que la vb pertenece a la clase, no a ningún objeto. Mal porque no funcionaria con vb private
		System.out.println(currela2.devuelvedatos());
		System.out.println(currela3.devuelvedatos());
		//System.out.println(Math.PI);//ejemplo de constante de clase
									//nombre de la clase(math) + . + método estático
		
		//ABAJO METODO ESTATICO getidsiguiente. Vemos que no opera sobre objetos, sino sobre la clase
		System.out.println(Empleados.getidsiguiente());//Método estático en cursiva
														//Fijarse en nomenclatura del punto
	}

}

class Empleados{
	
	
	private final String nombre;/*Con el FINAL vemos que es una CONSTANTE, no se puede cambiar
								con el método set "cambianombre" de más abajo.
								No tiene sentido que se pueda cambiar el nombre*/
	private String seccion;
	
	private int Id;
						//Fijarse que al poner static la vb se pone en cursiva
	private static int Idsiguiente=1;//Único campo Idsiguiente que comparten todos los objetos(currelas de arriba)
							
	
	//Constructor:
	public Empleados(String nom){//Solo el nombre como parámetro, la sección inicial siempre es admon.
		nombre=nom;
		seccion="Administración";
		//Idsiguiente al ser static al no pertenecer a los distintos empleados, sino que va por libre.
		Id=Idsiguiente;//Para el primer objeto que creemos ID=1
		Idsiguiente++;//Para cada uno de los objetos posteriores al primero sumará 1
		
	}
	
	public void cambia_seccion(String seccion) {//SETTER argumento por ahora dado de antemano
		
		this.seccion=seccion;
	}
	
	/*public void cambianombre(String nombre) { AHORA VEMOS QUE EL NOMBRE NO SE PUEDE CAMBIAR(FINAL)
		
		this.nombre=nombre;
	}*/
	
	public String devuelvedatos() {
		
		return "El nombre es " + nombre + " el Id es "+Id+" y la sección es "+seccion;
	}
	
	
	//ABAJO METODO ESTATICO. NO OPERA SOBRE OBJETOS, SINO SOBRE LA CLASE
	public static String getidsiguiente() {
		return "El Id siguiente al último usado es; " + Idsiguiente;
	}
	
}
