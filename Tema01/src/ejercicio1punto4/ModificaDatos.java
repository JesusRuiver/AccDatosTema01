/**
 * 
 */
package ejercicio1punto4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * @author Vespertino
 *
 */
public class ModificaDatos {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	
		String idEmple = args[0];
		String importe = args[1];
		
		File fichero = new File("AleatorioEmpleEjercicio.dat");

		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		
		long posicion = (Integer.parseInt(idEmple) - 1) * 36; 
		
		file.seek(posicion);
		file.writeInt(Integer.parseInt(idEmple));
		file.writeDouble(Double.parseDouble(importe));
		
		file.close();
	}

}
