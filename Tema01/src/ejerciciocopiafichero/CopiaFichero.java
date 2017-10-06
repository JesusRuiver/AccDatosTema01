/**
 * 
 */
package ejerciciocopiafichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class CopiaFichero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Crear un fichero de texto de varias líneas (Origen.txt). Utilizar los
		 * flujos y filtros de lectura y escritura de caracteres para crear un
		 * fichero copia del anterior.
		 */

		String original = "Origen.txt";
		String copia = "copia.txt";

		try {

			FileReader fr = new FileReader(original);
			BufferedReader br = new BufferedReader(fr);

			String textoOrigen = br.readLine();

			FileWriter fw = new FileWriter(copia);

			char[] cadena = textoOrigen.toCharArray();

			for (int i = 0; i < cadena.length; i++) {
				fw.write(cadena[i]);
			}
			fw.close(); //Cerramos el fichero

		} catch (Exception e) {
			System.out.println("ERROR---" + e.toString());
		}

	}

}
