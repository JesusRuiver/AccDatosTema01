/**
 * 
 */
package newgestioncafes;

import java.util.Scanner;

import newgestioncafes.AplicacionCafe;
import newgestioncafes.Cafe;
import newgestioncafes.Inventario;

/**
 * @author JesúsRuiver
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
		System.out.println("Terminal de Gestión de Cafés");
		System.out.println("+++++++++++++++++++++++++++++\n");

		System.out.println("1.- Introduzca Café");
		System.out.println("2.- Control de Inventario");
		System.out.println("3.- Venta Café");
		System.out.println("4.- Salir \n");
		System.out.print("Introduzca la opción: ");

		Scanner entrada = new Scanner(System.in);
		int seleccion = entrada.nextInt();

		while (seleccion != 0 && seleccion <= 4) {

			switch (seleccion) {
			case 1:
				
				cafe.introduceCafe();

				break;

			case 2: // Recordar tratar la excepción en la clase inventario y no
					// en la aplicación

				

			case 3:

				break;

			case 4:

				System.out.println("Fin del programa \n");
				System.exit(0);

				break;

			default:

				System.out.println("Debe elegir una opción \n");

				break;
			}
			break;
		}

	}
}
