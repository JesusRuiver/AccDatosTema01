/**
 * 
 */
package ejercicio1punto1;

import java.io.File;

/**
 * @author Jesús Manuel Ruiz Verdejo
 */
public class MostrarFichero {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Estos son los ficheros de este directorio:");
		
		File fichero = new File("c://");
		
		String [] ficheros = fichero.list();
		
		for (int i = 0; i <= fichero.length(); i++){
			
			System.out.println(ficheros[i]);
		}

	}

}
