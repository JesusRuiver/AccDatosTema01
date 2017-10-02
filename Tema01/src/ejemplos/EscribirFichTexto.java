package ejemplos;

import java.io.*;
public class EscribirFichTexto {
  public static void main(String[] args) throws IOException {
   File fichero = new File("C:\\EJERCICIOS\\UNI1\\FichTexto.txt");//declara fichero          
   FileWriter fic = new FileWriter(fichero); //crear el flujo de salida       
   String cadena ="Esto es una prueba con FileWriter";
   char[] cad = cadena.toCharArray();//convierte un String en array de caracteres
	
   for(int i=0; i<cad.length; i++)
	   fic.write(cad[i]);  //se va escribiendo un carácter

   fic.append('*'); //añado al final un *
   fic.close();    //cerrar fichero
  }
}
