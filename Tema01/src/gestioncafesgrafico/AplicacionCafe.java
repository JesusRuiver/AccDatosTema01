/**
 * 
 */
package gestioncafesgrafico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author JesúsRuiver
 *
 */
public class AplicacionCafe {

	/**
	 * @param args
	 */

	private ArrayList<Cafe> cafes = new ArrayList<Cafe>();

	public static void main(String[] args) {
		AplicacionCafe aplicacion = new AplicacionCafe();
		aplicacion.menu();

	}

	public void menu() {

		Scanner entrada = new Scanner(System.in);
		File fichero = new File("MisCafes.txt");

		while (true) {
			cafes.clear(); //Vacia Cafes
			
			leerCafes(fichero); //Llena cafes

			System.out.println("+++++++++++++++++++++++++++++");
			System.out.println("Terminal de Gestión de Cafés");
			System.out.println("+++++++++++++++++++++++++++++\n");

			System.out.println("1.- Introduzca Café");
			System.out.println("2.- Control de Inventario");
			System.out.println("3.- Venta Café");
			System.out.println("4.- Salir \n");
			System.out.print("Introduzca la opción: ");

			int seleccion = entrada.nextInt();

			switch (seleccion) {
			case 1:

				introducirCafe(entrada);

				break;

			case 2:

				muestraCafes();

				break;
			case 3:
				
				System.out.print("Que café desea comprar: ");
				String nombre = entrada.next().trim().toUpperCase();
				
				System.out.print("Que catidad: ");
				double cantidad = entrada.nextDouble();
				
				for (Cafe cafe : cafes){
					
					if (nombre == cafe.getNombre()){
						
						double stockTotal = 0;
						
						for (newgestioncafestexto.Lote lote : cafe.getLotes()){
							 stockTotal += lote.getKilos();
						}
						
						if (cantidad <= stockTotal){
							
							for (newgestioncafestexto.Lote lote : cafe.getLotes()){
								
								 
							}
							
							
						}else{
							System.out.println("No hay suficiente stock");
						}
						break;
					}
					
				}
				
				

				break;

			case 4:

				System.out.println("Fin del programa \n");
				System.exit(0);

				break;

			default:

				System.out.println("Debe elegir una opción \n");

				break;
			}

			escribirCafes(fichero);
		}
	}

	public void escribirCafes(File fichero) {
		
		try {
			
			fichero.delete();
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));

			for (Cafe cafe : cafes) {

				bw.write(cafe.getNombre());
				bw.newLine();
				bw.write(String.valueOf(cafe.getPrecio()));
				bw.newLine();
				for (newgestioncafestexto.Lote lote : cafe.getLotes()) {
					bw.write(String.valueOf(lote.getKilos()));
					bw.newLine();
					bw.write(lote.getCaducidad());
					bw.newLine();
				}
				
				bw.write("0");
				bw.newLine();
			}

			bw.close();

		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void leerCafes(File fichero) {
		ArrayList<String> lineas = new ArrayList<String>();

		if (fichero.exists())
			leerLineas(fichero, lineas);

		for (int i = 0; i < lineas.size();) {
			// Variable nombre
			String nombre = lineas.get(i);
			i++;
			// Variable precio
			double precio = Double.parseDouble(lineas.get(i));
			i++;
			// Variable ArrayList
			ArrayList<Lote> lotes = new ArrayList<Lote>();
			while (true) {
				String lineaTres = lineas.get(i);
				if (lineaTres.equals("0")) {
					i++;
					break;
				} else {
					double kilos = Double.parseDouble(lineaTres);
					i++;
					String caducidad = lineas.get(i);
					i++;
					Lote lote = new Lote(kilos, caducidad);
					lotes.add(lote);
				}
			}
			Cafe cafe = new Cafe(nombre, precio, lotes);
			boolean existe = false;
			for (Cafe cafeAntiguo : cafes) {
				if (cafeAntiguo.getNombre() == cafe.getNombre()) {
					existe = true;
					break;
				}

			}
			if (!existe)
				cafes.add(cafe);

		}
	}

	public void leerLineas(File fichero, ArrayList<String> lineas) {
		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				if (!(linea.isEmpty())) {
					lineas.add(linea.trim());

				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != fr)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void muestraCafes() {
		
		System.out.println("\t** INVENTARIO DE CAFES **");
		
		for (Cafe cafe : cafes) {
		
			System.out.println(cafe.getNombre() + " a " + cafe.getPrecio() + " euros/kg");

			for (newgestioncafestexto.Lote lote : cafe.getLotes()) {
				
				System.out.print("\t" + lote.getCaducidad() + ":");
				System.out.print(lote.getKilos() + "kg \n" );
				
			}
		}
	}

	public void introducirCafe(Scanner entrada) {
		do {
			System.out.print("Introduzca Nombre Cafe: ");
			String nombre = entrada.next().trim().toUpperCase();

			System.out.print("Introduzca Precio Cafe: ");
			double precio = entrada.nextDouble();

			System.out.print("Quiere introducir Lote: ");
			System.out.print("Si | No: ");

			ArrayList<Lote> lotes = new ArrayList<Lote>();

			añadirLotes(entrada, lotes);

			cafes.add(new Cafe(nombre, precio, lotes));

			System.out.println("Desea introducir un nuevo Café: ");
			System.out.println("Si | No: ");

		} while (entrada.next().trim().toLowerCase().equals("si"));
	}

	public void añadirLotes(Scanner entrada, ArrayList<Lote> lotes) {
		while (entrada.next().trim().toLowerCase().equals("si")) {

			System.out.print("Introduzca Kilos Lote Cafe: \n");

			Double kilos = entrada.nextDouble();

			System.out.print("Introduzca caducidad Lote Cafe: \n");

			String caducidad = entrada.next();

			lotes.add(new Lote(kilos, caducidad));

			System.out.print("Quiere introducir Lote: ");
			System.out.print("Si | No: ");

		}
	}
}
