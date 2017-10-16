package ejemplos;

import java.io.*;

import ejemplosSAX.Persona;

public class LeerFichObject {
  public static void main(String[] args) throws IOException, ClassNotFoundException{   
   Persona persona;   //defino la variable persona
   File fichero = new File("FichPersona.dat");//declara el fichero
   FileInputStream filein = new FileInputStream(fichero);//crea el flujo de entrada   
   //conecta el flujo de bytes al flujo de datos
   ObjectInputStream dataIS = new ObjectInputStream(filein);
      int i=1;
   try {
    while (true) { //lectura del fichero
	  persona= (Persona) dataIS.readObject(); //leer una Persona              
      System.out.println("Nombre: " + persona.getNombre() + ", edad: " + persona.getEdad());  
      System.out.println(i);i++;
    }
    }catch (EOFException eo) {}
	catch (StreamCorruptedException x) {}
   dataIS.close();  //cerrar stream de entrada      
  }
}