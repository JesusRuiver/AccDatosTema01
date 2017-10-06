/**
 * 
 */
package lotescafe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class AlmacenCafe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Desea introducir nuevos datos");
		System.out.println("Si | No");

		BufferedReader leerEntrada = new BufferedReader(new InputStreamReader(System.in));

	}

}

class Lote {
	double kilos;
	String caducidad;

	public double getKilos() {
		return kilos;
	}

	public void setKilos(double kilos) {
		this.kilos = kilos;
	}

	public String getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}

}

class Cafe {
	String nombre;
	double precio;
	double stock;

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

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public Vector<Lote> getLotescafe() {
		return lotescafe;
	}

	public void setLotescafe(Vector<Lote> lotescafe) {
		this.lotescafe = lotescafe;
	}

	Vector<Lote> lotescafe;

}
