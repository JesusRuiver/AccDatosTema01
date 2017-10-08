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
	public static void main(String[] args) {

		String listaCafe;
		try{
		BufferedWriter fichero = new BufferedWriter(new FileWriter("MisCafes.txt",true));//Incorporamos al contructor true para poder actualizar el archivo sin machacar el anterior

		System.out.print("Introduca Nombre Cafe: ");
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

			fichero.write("Cafe tipo: " + entrada.readLine()); //Introducimos el tipo de cafe
			fichero.newLine();
	
			System.out.print("Introduzca Precio Cafe: "); //Introducimos el precio del cafe
			fichero.write("Precio Cafe: " + entrada.readLine());
			fichero.newLine();

		System.out.println("Desea introducir Lotes de Cafe: "); //Preguntamos al usuario si quiere introducir lotes de cafe
		System.out.print("Si | No: ");

		BufferedReader entradaLote = new BufferedReader(new InputStreamReader(System.in));

			while (entradaLote.readLine().trim().toLowerCase().equals("si")) { // Si la respuesta es "si" el usuario comienza a introducir el primer lote
	
				System.out.print("Introduzca Numero de Lote Cafe: ");
				fichero.write("Lote nº: " + entrada.readLine());
				fichero.newLine();
	
				System.out.print("Introduzca Kilos Lote Cafe: ");
				fichero.write("Kilos Lote: " + entrada.readLine());
				fichero.newLine();
	
				System.out.print("Introduzca Caducidad Lote Cafe: ");
				fichero.write("Fecha caducidad Lote: " + entrada.readLine());
				fichero.newLine();
	
				System.out.println("Desea introducir un nuevo Lote: "); //Preguntamos si desea introducir un nuevo lote
				System.out.print("Si | No: ");
			}
		System.out.println("Fin de al introducción de datos"); //El programa nos avisa que hemos terminado de introducir los datos
		fichero.write("0"); //Escribimos una marca de final de registro con un "0" 
		fichero.newLine();

		System.out.println("Desea introducir un nuevo registro de Cafe: "); //Preguntamos si quiere introducir un nuevo registro
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

		System.out.println("Fin del Programa"); //Nos avisa que el programa a finalizado
		
		fichero.close();//Cierra el fichero
		
		} catch (Exception e){
			e.getMessage();
		}

	}

}
