/**
 * 
 */
package gestioncafes;

import java.util.Scanner;

/**
 * @author usuario
 *
 */
public class AplicacionCafe {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("Terminal de Gesti�n de Caf�s");
		System.out.println("+++++++++++++++++++++++++++++\n");

		System.out.println("1.- Introduzca Caf�");
		System.out.println("2.- Control de Inventario");
		System.out.println("3.- Venta Caf�");
		System.out.println("4.- Salir \n");
		System.out.print("Introduzca la opci�n: ");

		Scanner entrada = new Scanner(System.in);
		int seleccion = entrada.nextInt();

		while (seleccion != 0 && seleccion < 4) {

			switch (seleccion) {
			case 1:

				Cafe listadoCafe = new Cafe();

				listadoCafe.introduceCafe();

				break;

			case 3:

				System.out.println("Fin del programa");
				System.exit(0);

			default:

				System.out.println("Debe elegir una opci�n");

				break;
			}
		}
		System.out.println("Desea realizar otra operaci�n");
		
		System.out.println("1.- Introduzca Caf�");
		System.out.println("2.- Control de Inventario");
		System.out.println("3.- Venta Caf�");
		System.out.println("4.- Salir \n");
		System.out.print("Introduzca la opci�n: ");

	}

}
