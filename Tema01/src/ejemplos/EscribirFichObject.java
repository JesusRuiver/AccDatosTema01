package ejemplos;

import java.io.*;

public class EscribirFichObject {
  public static void main(String[] args) throws IOException {   
   
   Persona persona;//defino variable persona
   
   File fichero = new File("FichPersona.dat");//declara el fichero
   FileOutputStream fileout = new FileOutputStream(fichero,true);  //crea el flujo de salida
    //conecta el flujo de bytes al flujo de datos
   ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
   
   String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés",
                       "Julio","Antonio","María Jesús"};
					   
   int edades[] = {14,15,13,15,16,12,16,14,13};
	
   for (int i=0;i<edades.length; i++){ //recorro los arrays    
      persona= new Persona(nombres[i],edades[i]); //creo la persona	  
	  dataOS.writeObject(persona); //escribo la persona en el fichero
   }     
   dataOS.close();  //cerrar stream de salida    
   }
}

class Persona implements Serializable {
	private int edad;
	private String nombre;
	
	public Persona(String nombre, int edad) {
	
		this.nombre = nombre;
		this.edad = edad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}