/**
 * 
 */
package gestioncafes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * @author Jes�s Manuel Ruiz Verdejo
 *
 */
public class Cafe {

	/**
	 * @param args
	 * @throws IOException
	 */
	
	private String nombre;
	private double precio;
	private double stock;
	private Vector<Lote>v;
	private Lote loteCafe = new Lote();
	
	public void introduceCafe() {

		try{
			
		BufferedWriter fichero = new BufferedWriter(new FileWriter("MisCafes.txt",true));//Incorporamos al contructor true para poder actualizar el archivo sin machacar el anterior
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		do {

		System.out.print("Introduzca Nombre Cafe: ");
		
			fichero.write(entrada.readLine().toUpperCase()); //Introducimos el tipo de cafe
			fichero.newLine();
	
			System.out.print("Introduzca Precio Cafe: "); //Introducimos el precio del cafe
			fichero.write(entrada.readLine());
			fichero.newLine();

		System.out.println("Desea introducir Lotes de Cafe: "); //Preguntamos al usuario si quiere introducir lotes de cafe
		System.out.print("Si | No: ");
		
			this.loteCafe.introduceLote();
		
		System.out.println("Fin de al introducci�n de datos"); //El programa nos avisa que hemos terminado de introducir los datos
		fichero.write("0"); //Escribimos una marca de final de registro con un "0" 
		fichero.newLine();

		System.out.println("Desea introducir un nuevo registro de Cafe: "); //Preguntamos si quiere introducir un nuevo registro
		System.out.print("Si | No: ");
		
		} while (entrada.readLine().trim().toLowerCase().equals("si"));
		
		

		System.out.println("Fin del Programa"); //Nos avisa que el programa a finalizado
		
		fichero.close();//Cierra el fichero
		
		} catch (Exception e){
			e.getMessage();
		}

	}

}
