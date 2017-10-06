/**
 * 
 */
package lotescafe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class AlmacenCafe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Desea introducir nuevos datos");
		System.out.println("Si | No");
		
		BufferedReader leerEntrada = new BufferedReader(new InputStreamReader(System.in));

	}

	class Lote {
		double kilos;
		String caducidad;

	}

	class Cafe {
		String nombre;
		double precio;
		double stock;
		Vector<Lote> lotescafe;

	}

}
