/**
 * 
 */
package gestioncafesgrafico;

import java.util.ArrayList;
import java.util.Scanner;

import gestioncafesgrafico.Lote;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class Cafe {

	private String nombre;
	private double precio;
	private ArrayList<Lote> lotes = new ArrayList<Lote>();

	public Cafe(String nombre, double precio, ArrayList lotes) {

		this.nombre = nombre;
		this.precio = precio;
		this.lotes = lotes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public ArrayList<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(ArrayList<Lote> lotes) {
		this.lotes = lotes;
	}

}
