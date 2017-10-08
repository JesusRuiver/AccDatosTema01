/**
 * 
 */
package po0102;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class DepartPrimos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String localidad = args[0]; // Pasamos el nombre de la localidad como
									// parámetro

		String[] nombres = { "Contabilidad", "Ventas", "Logística", "RRHH", "Informática", "Exportación", "Calidad",
				"Lega", "Comunicación", "Diseño" };

		String[] localidades = { "Zaragoza", "Bilbao", "Valencia", "Barcelona", "La Coruña", "Sevilla", "Cordoba",
				"Madrid", "Murcia", "Castellón" };

		int[] numsDeps = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		try {

			File ficheroDep = new File("DepartamentosPrimos.dat");
			FileOutputStream flujoDatos = new FileOutputStream(ficheroDep);
			DataOutputStream escribeDatos = new DataOutputStream(flujoDatos);

			for (int i = 0; i < numsDeps.length; i++) {

				escribeDatos.writeInt(numsDeps[i]);
				escribeDatos.writeUTF(nombres[i]);

				int num = numsDeps[i];
				boolean primo = true;

				for (int j = 2; j < num; j++) {
					if (num % j == 0) {

						primo = false;

					}
				}
				if (primo) {

					escribeDatos.writeUTF(localidad);

				} else {
					escribeDatos.writeUTF(localidades[i]);

				}
			}

			escribeDatos.close();
		} catch (Exception e) {

			e.getStackTrace();
		}
	}
}
