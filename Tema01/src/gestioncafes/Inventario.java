package gestioncafes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Jes�s Manuel Ruiz Verdejo
 *
 */

public class Inventario {

	public void controlInventario() throws Exception {

		File fichero = new File("MisCafes.txt");

		FileReader fic = new FileReader(fichero); // crear el flujo de entrada

		int i;

		while ((i = fic.read()) != -1) // se va leyendo un car�cter
			System.out.print((char) i);

		fic.close(); // cerrar fichero
	}
}
