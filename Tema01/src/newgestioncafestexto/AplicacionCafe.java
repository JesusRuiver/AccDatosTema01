/**
 * 
 */
package newgestioncafestexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jesús Manuel Ruiz Verdejo
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

			cafes.clear(); // Vacia Cafes

			leerCafes(fichero); // Llena cafes

			System.out.println("\n");
			System.out.println("+++++++++++++++++++++++++++++");
			System.out.println("Terminal de Gestión de Cafés");
			System.out.println("+++++++++++++++++++++++++++++\n");

			System.out.println("1.- Introduzca Café");
			System.out.println("2.- Control de Inventario");
			System.out.println("3.- Venta Café");
			System.out.println("4.- Exportar");
			System.out.println("5.- Importar");
			System.out.println("6.- Salir \n");
			System.out.print("Introduzca la opción: ");

			int seleccion = entrada.nextInt();

			switch (seleccion) {
			case 1:

				introducirCafe(entrada);

				break;

			case 2:

				inventarioCafes();

				break;

			case 3:

				System.out.print("Que café desea comprar: ");
				String nombre = entrada.next().trim().toUpperCase();

				System.out.print("Que catidad: ");
				double cantidad = entrada.nextDouble();

				for (Cafe cafe : cafes) {

					if (nombre == cafe.getNombre()) {

						double stockTotal = 0;

						for (Lote lote : cafe.getLotes()) {
							stockTotal += lote.getKilos();
						}

						if (cantidad <= stockTotal) {

							for (Lote lote : cafe.getLotes()) {
								
								

							}

						} else {
							System.out.println("No hay suficiente stock");
						}
						break;
					}

				}

				break;

			case 4:

				escribirFicheroDat();

				break;

			case 5:

				break;

			case 6:

				System.out.println("Fin del programa \n");
				System.exit(0);

				break;

			default:

				System.out.println("Debe elegir una opción \n");

				break;
			}

			escribirFicheroMisCafes(fichero);
		}
	}

	public void escribirFicheroDat() {
		try {

			File ficheroCafesDat = new File("MisCafes.dat");
			FileOutputStream flujoDatos = new FileOutputStream(ficheroCafesDat);
			DataOutputStream escribeDatos = new DataOutputStream(flujoDatos);

			for (Cafe cafe : cafes) {

				escribeDatos.writeUTF(cafe.getNombre());
				escribeDatos.writeDouble(cafe.getPrecio());

				for (Lote lote : cafe.getLotes()) {

					escribeDatos.writeDouble(lote.getKilos());
					escribeDatos.writeUTF(lote.getCaducidad());
				}

				escribeDatos.writeUTF("0");
			}

			escribeDatos.close();
		} catch (Exception e) {

			e.getStackTrace();
		}
	}

	public void escribirFicheroMisCafes(File fichero) {

		try {

			fichero.delete();
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));

			for (Cafe cafe : cafes) {

				bw.write(cafe.getNombre());
				bw.newLine();
				bw.write(String.valueOf(cafe.getPrecio()));
				bw.newLine();
				for (Lote lote : cafe.getLotes()) {
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
			String lineaNombre = lineas.get(i);
			i++;
			// Variable precio
			double lineaPrecio = Double.parseDouble(lineas.get(i));
			i++;
			// Variable ArrayList
			ArrayList<Lote> lotes = new ArrayList<Lote>();
			while (true) {
				String lineaLotes = lineas.get(i);
				if (lineaLotes.equals("0")) {
					i++;
					break;
				} else {
					double kilos = Double.parseDouble(lineaLotes);
					i++;
					String caducidad = lineas.get(i);
					i++;
					Lote lote = new Lote(kilos, caducidad);
					lotes.add(lote);
				}
			}
			Cafe cafe = new Cafe(lineaNombre, lineaPrecio, lotes);
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

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (null != fr)
				try {
					fr.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
		}
	}

	public void inventarioCafes() {

		System.out.println("\t** INVENTARIO DE CAFES **");

		for (Cafe cafe : cafes) {

			System.out.println(cafe.getNombre() + " a " + cafe.getPrecio() + " euros/kg");

			for (Lote lote : cafe.getLotes()) {

				System.out.print("\t" + lote.getCaducidad() + ":");
				System.out.print(lote.getKilos() + "kg \n");
			}

			double stockTotal = 0;
				
			for (Lote lote : cafe.getLotes()) {

				 stockTotal += lote.getKilos();
				
			}
			System.out.println("Stock Total: " + stockTotal);
		}

	}

	public void introducirCafe(Scanner entrada) {
		do {
			System.out.print("Introduzca Nombre Cafe: ");
			String nombre = entrada.next().trim().toUpperCase();

			System.out.print("Introduzca Precio Cafe: ");
			double precio = Double.parseDouble(entrada.next());

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

			Double kilos = Double.parseDouble(entrada.next());

			System.out.print("Introduzca caducidad Lote Cafe: \n");

			String caducidad = entrada.next();

			lotes.add(new Lote(kilos, caducidad));

			System.out.print("Quiere introducir Lote: ");
			System.out.print("Si | No: ");

		}
	}
}
