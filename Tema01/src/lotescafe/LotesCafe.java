/**
 * 
 */
package lotescafe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class LotesCafe {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String listaCafe;

		BufferedWriter fichero = new BufferedWriter(new FileWriter("MisCafes.txt"));

		System.out.print("Introduca Nombre Cafe: ");
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		fichero.write("Cafe tipo: " + entrada.readLine());
		fichero.newLine();

		System.out.print("Introduzca Precio Cafe: ");
		fichero.write("Precio Cafe: " + entrada.readLine());
		fichero.newLine();

		System.out.println("Desea introducir Lotes de Cafe: ");
		System.out.print("Si | No: ");

		BufferedReader entradaLote = new BufferedReader(new InputStreamReader(System.in));

		while (entradaLote.readLine().trim().toLowerCase().equals("si")) {

			System.out.print("Introduzca Numero de Lote Cafe: ");
			fichero.write("Lote nº: " + entrada.readLine());
			fichero.newLine();

			System.out.print("Introduzca Kilos Lote Cafe: ");
			fichero.write("Kilos Lote: " + entrada.readLine());
			fichero.newLine();

			System.out.print("Introduzca Caducidad Lote Cafe: ");
			fichero.write("Fecha caducidad Lote: " + entrada.readLine());
			fichero.newLine();

			System.out.println("Desea introducir un nuevo Lote: ");
			System.out.print("Si | No: ");
		}
		System.out.println("Fin de al introducción de datos");
		fichero.write("0");
		fichero.newLine();

		System.out.println("Desea introducir un nuevo registro de Cafe: ");
		System.out.print("Si | No: ");

		BufferedReader entradaRegistro = new BufferedReader(new InputStreamReader(System.in));

		while (entradaRegistro.readLine().trim().toLowerCase().equals("si")) {

			entradaRegistro = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Introduca Nombre Cafe: ");
			entrada = new BufferedReader(new InputStreamReader(System.in));

			fichero.write("Cafe tipo: " + entrada.readLine());
			fichero.newLine();

			System.out.print("Introduzca Precio Cafe: ");
			fichero.write("Precio Cafe: " + entrada.readLine());
			fichero.newLine();

			System.out.println("Desea introducir Lotes de Cafe: ");
			System.out.print("Si | No: ");

			entradaLote = new BufferedReader(new InputStreamReader(System.in));

			while (entradaLote.readLine().trim().toLowerCase().equals("si")) {

				System.out.print("Introduzca Numero de Lote Cafe: ");
				fichero.write("Lote nº: " + entrada.readLine());
				fichero.newLine();

				System.out.print("Introduzca Kilos Lote Cafe: ");
				fichero.write("Kilos Lote: " + entrada.readLine());
				fichero.newLine();

				System.out.print("Introduzca Caducidad Lote Cafe: ");
				fichero.write("Fecha caducidad Lote: " + entrada.readLine());
				fichero.newLine();

				System.out.println("Desea introducir un nuevo Lote: ");
				System.out.print("Si | No: ");
			}
			System.out.println("Fin de al introducción de datos");
			fichero.write("0");
			fichero.newLine();

			System.out.println("Desea introducir un nuevo registro de Cafe: ");
			System.out.print("Si | No: ");
		}

		System.out.println("Fin de Programa");
		fichero.close();

	}

}
