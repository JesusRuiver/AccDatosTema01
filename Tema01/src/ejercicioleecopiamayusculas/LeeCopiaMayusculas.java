/**
 * 
 */
package ejercicioleecopiamayusculas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author usuario
 *
 */
public class LeeCopiaMayusculas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		String original = "Origen.txt";
		String copia = "CopiaMayusculas.txt";

		try {

			FileReader fr = new FileReader(original);
			BufferedReader br = new BufferedReader(fr);

			String textoOrigen = br.readLine().toUpperCase(); //Leemos y convertimos en mayusculas

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
