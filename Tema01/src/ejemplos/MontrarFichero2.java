/**
 * 
 */
package ejemplos;

import java.io.File;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class MontrarFichero2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length > 0) {

			String directorio = args[0];

			System.out.println("Archivos en el directorio " + directorio);

			File fichero = new File(directorio);

			String[] ficheros = fichero.list();

			for (int i = 0; i < fichero.length()-1; i++) {
				System.out.println(ficheros[i]);
			}

		}
	}
}
