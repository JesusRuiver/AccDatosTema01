/**
 * 
 */
package ejerciciosclase;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Vespertino
 *
 */
public class ConsultaEmpleado {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		File fichero = new File("C:\\EJERCICIOS\\UNI1\\AleatorioEmple2.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		
		int identitificador = 5;
		// Calculamos donde empieza el registro
		int posicion = (identitificador - 1) * 36;

		if (posicion >= fichero.length()) {

			System.out.printf("ID: %d, NO EXISTE EMPLEADO...", identitificador);
		}else {			
			
			file.seek(posicion); //nos posicionamos
			int id = file.readInt(); //obtengo el id del empleado
			System.out.println("ID: " + id);   
			
			//Terminar de obtener los empleados
		}

	}

}
