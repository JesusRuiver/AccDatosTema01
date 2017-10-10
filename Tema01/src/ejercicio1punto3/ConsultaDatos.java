/**
 * 
 */
package ejercicio1punto3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class ConsultaDatos {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		String idEmple = args[0];

		File fichero = new File("AleatorioEmpleEjercicio.dat");

		// declara el fichero de acceso aleatorio a leer

		RandomAccessFile file = new RandomAccessFile(fichero, "r");

		int id, dep, posicion;
		Double salario;
		char apellido[] = new char[10], aux;

		posicion = (Integer.parseInt(idEmple) - 1) * 36; // para situarnos al principio

		if (posicion >= file.length()) { 
			
			System.out.printf("ID: %d, NO EXISTE EMPLEADO...", Integer.parseInt(idEmple));
			
		}else {// recorro el fichero
			file.seek(posicion); // nos posicionamos en posicion
			id = file.readInt(); // obtengo id de empleado
				
			System.out.println(
					"ID: " + id);
				
		
		} // fin bucle for
		file.close(); // cerrar fichero
	}

}

