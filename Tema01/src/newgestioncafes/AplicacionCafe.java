/**
 * 
 */
package newgestioncafes;

import java.util.Scanner;

import newgestioncafes.AplicacionCafe;
import newgestioncafes.Cafe;
import newgestioncafes.Inventario;

/**
 * @author Jes�sRuiver
 *
 */
public class AplicacionCafe {

	/**
	 * @param args
	 */
	
	private Cafe cafe = new Cafe ();
	
	public static void main(String[] args) {
		AplicacionCafe aplicacion = new AplicacionCafe();
		aplicacion.menu();

	}

	public void menu() {

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

		while (seleccion != 0 && seleccion <= 4) {

			switch (seleccion) {
			case 1:
				
				cafe.introduceCafe();

				break;

			case 2: // Recordar tratar la excepci�n en la clase inventario y no
					// en la aplicaci�n

				

			case 3:

				break;

			case 4:

				System.out.println("Fin del programa \n");
				System.exit(0);

				break;

			default:

				System.out.println("Debe elegir una opci�n \n");

				break;
			}
			break;
		}

	}
}
