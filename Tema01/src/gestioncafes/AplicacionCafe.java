/**
 * 
 */
package gestioncafes;

import java.util.Scanner;

/**
 * @author Jes�s Manuel Ruiz Verdejo
 *
 */
public class AplicacionCafe {

	/**
	 * @param args
	 * @throws Exception 
	 */

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

				Cafe listadoCafe = new Cafe();

				listadoCafe.introduceCafe();

				break;
			
			case 2: //Recordar tratar la excepci�n en la clase inventario y no en la aplicaci�n
					
				
				try{
				Inventario informe = new Inventario();

				informe.controlInventario();
				
				break;
				
				} catch (Exception e) {
					e.getMessage();
				}
				
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
