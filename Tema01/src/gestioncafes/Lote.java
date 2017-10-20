/**
 * 
 */
package gestioncafes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author usuario
 *
 */
public class Lote {
	
	private double kilos;
	private String caducidad;
	
	public void introduceLote() throws IOException{
		
		BufferedWriter fichero = new BufferedWriter(new FileWriter("MisCafes.txt",true));
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader entradaLote = new BufferedReader(new InputStreamReader(System.in));

		while (entradaLote.readLine().trim().toLowerCase().equals("si")) { // Si la respuesta es "si" el usuario comienza a introducir el primer lote

			System.out.print("Introduzca Kilos Lote Cafe: \n");
			fichero.write(entrada.readLine());
			fichero.newLine();

			System.out.print("Introduzca Caducidad Lote Cafe: \n");
			fichero.write(entrada.readLine());
			fichero.newLine();

			System.out.println("Desea introducir un nuevo Lote: \n"); //Preguntamos si desea introducir un nuevo lote
			System.out.print("Si | No: ");
		}
		
	}

}
