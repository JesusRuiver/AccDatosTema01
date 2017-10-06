/**
 * 
 */
package ejercicio1punto2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class VisualizaFichero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String original = "Original.txt";

		try {

			System.out.println("Desea leer el texto 'Original.txt'");
			System.out.println("Si | No");

			BufferedReader leerMenu = new BufferedReader(new InputStreamReader(System.in));

			if (leerMenu.readLine().trim().toLowerCase().equals("si")) {
				
				
				FileReader origen = new FileReader(original);

				BufferedReader leerEntrada = new BufferedReader(origen);

				int linea;

				while ((linea = leerEntrada.read()) != -1) {

					char caracter = (char) linea;

					System.out.print(caracter);
					
				}leerEntrada.close();
			} else {
				System.out.println("Tu te lo pierdes");
			}

		} catch (Exception e) {

			System.out.println("El archivo no existe");
		}

	}

}
