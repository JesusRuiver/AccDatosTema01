package ejemplos;

import java.io.*;

public class LeerFichTexto {
  public static void main(String[] args) throws IOException {
    File fichero = new File("C:\\EJERCICIOS\\UNI1\\LeerFichTexto.java");
                //declarar fichero
    FileReader fic = new FileReader(fichero); //crear el flujo de entrada   
    int i;
    while ((i = fic.read()) != -1) //se va leyendo un carácter
      System.out.println((char) i);
    fic.close(); //cerrar fichero   
  }
}
