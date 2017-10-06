/**
 * 
 */
package lotescafe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class LotesCafe {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String listaCafe;
		
		BufferedWriter fichero = new BufferedWriter (new FileWriter("ListaCafe.txt"));
		
		System.out.print("Introduca Cafe: ");
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		fichero.write(entrada.readLine());
		fichero.newLine();
		
		fichero.close();
		
		
	}

}
