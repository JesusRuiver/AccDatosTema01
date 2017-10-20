/**
 * 
 */
package gestioncafes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class Cafe {

	/**
	 * @param args
	 * @throws IOException
	 */
	
	private String nombre;
	private ArrayList <String> nombres = new ArrayList<String>();
	private double precio;
	private double stock;
	private Vector<Lote>v;
	private Lote loteCafe = new Lote();
	private AplicacionCafe aplicacion = new AplicacionCafe();
	
	public void introduceCafe() {

		try{
			
		BufferedWriter fichero = new BufferedWriter(new FileWriter("MisCafes.txt",true));//Incorporamos al contructor true para poder actualizar el archivo sin machacar el anterior
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		do {

		System.out.print("Introduzca Nombre Cafe: ");
			
			
			fichero.write(this.nombre = entrada.readLine().toUpperCase());//Introducimos el tipo de cafe
			nombres.add(this.nombre); //Un invento raro para almacenar los nombres en el ArrayList
			fichero.newLine();
	
			System.out.print("Introduzca Precio Cafe: "); //Introducimos el precio del cafe
			fichero.write(entrada.readLine());
			fichero.newLine();

		System.out.println("Desea introducir Lotes de Cafe "); //Preguntamos al usuario si quiere introducir lotes de cafe
		System.out.print("Si | No: ");
		
			loteCafe.introduceLote(); //Ejecutamos el metodo introduce cafe de la clase Lote
		
		System.out.println("Fin de al introducción de datos \n"); //El programa nos avisa que hemos terminado de introducir los datos
		fichero.write("0"); //Escribimos una marca de final de registro con un "0" 
		fichero.newLine();

		System.out.println("Desea introducir un nuevo registro de Cafe "); //Preguntamos si quiere introducir un nuevo registro
		System.out.print("Si | No: ");
		
		} while (entrada.readLine().trim().toLowerCase().equals("si"));
		

		System.out.println("Desea realizar otra operación \n"); //Nos avisa que el programa a finalizado
		
		fichero.close();//Cierra el fichero
		
		aplicacion.menu();
		
		} catch (Exception e){
			e.getMessage();
		}

	}
	
}
