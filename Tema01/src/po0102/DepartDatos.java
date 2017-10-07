/**
 * 
 */
package po0102;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class DepartDatos {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		/*
		 * Realiza un programa en Java que cree un fichero binario para guardar
		 * datos de departamentos, dale el nombre de Departamentos.dat
		 * 
		 * Introduce al menos 10 departamentos. Los Datos por cada departamento
		 * son: Número Departamento: int, Nombre: String y Localidad: String.
		 */

		int numDep;
		String nombre;
		String localidad;

		String[] nombres = { "Contabilidad", "Ventas", "Logística", "RRHH", "Informática", "Exportación", "Calidad",
				"Lega", "Comunicación", "Diseño" };

		String[] localidades = { "Zaragoza", "Bilbao", "Valencia", "Barcelona", "La Coruña", "Sevilla", "Cordoba",
				"Madrid", "Murcia", "Castellón" };

		int[] numsDeps = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		try {

			File ficheroDep = new File("Departamentos.dat");
			FileOutputStream flujoDatos = new FileOutputStream(ficheroDep);
			DataOutputStream escribeDatos = new DataOutputStream(flujoDatos);

			for (int i = 0; i < numsDeps.length; i++) {

				escribeDatos.writeInt(numsDeps[i]);
				escribeDatos.writeUTF(nombres[i]);
				escribeDatos.writeUTF(localidades[i]);
			}

			escribeDatos.close();
		} catch (Exception e) {

			e.getStackTrace();
		}
	}
}
