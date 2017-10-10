/**
 * 
 */
package ejercicio1punto3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class InsertaDatos {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String idEmple = args [0];
		String apellido = args [1];
		String departamento = args [2];
		String salario = args[3];
		
		File fichero = new File("AleatorioEmpleEjercicio.dat");
		
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		
		
	}

}
