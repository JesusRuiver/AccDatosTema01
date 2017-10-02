package ejercicios;

import java.io.*;
public class EscribirFichTextoBufPruebas {
  public static void main(String[] args) {
  try{      
      BufferedWriter fichero = new BufferedWriter(new FileWriter("FichTexto.txt"));
      for (int i=1; i<11; i++){
	    fichero.write("Fila numero: "+i); //escribe una l�nea
	    fichero.newLine(); //escribe un salto de l�nea
	    fichero.flush();
      }
      fichero.close(); 
      System.out.println("Fichero creado");
      }
	catch (FileNotFoundException fn ){                      
               System.out.println("No se encuentra el fichero");}
	catch (IOException io) {
               System.out.println("Error de E/S ");}
  }
}