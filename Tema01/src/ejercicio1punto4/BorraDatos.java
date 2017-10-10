/**
 * 
 */
package ejercicio1punto4;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class BorraDatos {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String idEmple = args[0];
		
		File fichero = new File("AleatorioEmpleEjercicio.dat");

		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		
		int posicion = (Integer.parseInt(idEmple) - 1) * 36;
		
		file.seek(posicion);
		fichero.delete(	);
		
		file.close();

	}

}
