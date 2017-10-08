/**
 * 
 */
package po0102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class EsPrimo {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		int num;
		boolean primo = true;

		Scanner entrada = new Scanner (System.in);
		
		System.out.print("Introduzca un número: ");
		
		num = entrada.nextInt();

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {

				primo = false;
			}
		}
		if (primo) {
			System.out.println("El numero es primo");
		} else {
			System.out.println("El numero NO es primo");
		}

	}
}
