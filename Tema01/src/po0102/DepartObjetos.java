/**
 * 
 */
package po0102;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class DepartObjetos {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {

		Departamento departamento; // Declaramos una variable de tipo
									// Departamento

		String[] nombres = { "Contabilidad", "Ventas", "Logística", "RRHH", "Informática", "Exportación", "Calidad",
				"Lega", "Comunicación", "Diseño" };

		String[] localidades = { "Zaragoza", "Bilbao", "Valencia", "Barcelona", "La Coruña", "Sevilla", "Cordoba",
				"Madrid", "Murcia", "Castellón" };

		int[] numsDeps = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		try {

			File ficheroDep = new File("DepartamentosObjetos.dat");
			FileOutputStream flujoDatos = new FileOutputStream(ficheroDep);
			ObjectOutputStream escribeObjetos = new ObjectOutputStream(flujoDatos);

				for (int i = 0; i < numsDeps.length; i++) {
					departamento = new Departamento(numsDeps[i], nombres[i], localidades[i]);
					escribeObjetos.writeObject(departamento);
				}

			} catch (IOException e) {
			e.getStackTrace();
			}
	}

}

class Departamento implements Serializable { // Creamos una clase Departamento
												// para poder crear objetos de
												// tipo Departamento

	private int numDep;
	private String nombre;
	private String localidad;

	public Departamento(int numDep, String nombre, String localidad) {

		this.numDep = numDep;
		this.nombre = nombre;
		this.localidad = localidad;
	}

	public int getNumDep() {
		return numDep;
	}

	public void setNumDep(int numDep) {
		this.numDep = numDep;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

}
