/**
 * 
 */
package newgestioncafes;

import java.util.ArrayList;
import java.util.Scanner;
import newgestioncafes.Lote;

/**
 * @author JesúsRuiver
 *
 */
public class Cafe extends Lote {

	private String nombre;
	private double precio;
	
	private String lotes;
	
	private double stock;
	private Scanner entradaCafe = new Scanner(System.in);
	private ArrayList<Cafe> cafes = new ArrayList<Cafe>();

	public Cafe(String nombre, double precio) {

		this.nombre = nombre;
		this.precio = precio;
	}	
	
	public Cafe(String nombre, double precio, double kilos, String caducidad) {

		super(kilos, caducidad);
		this.nombre = nombre;
		this.precio = precio;

	}

	public Cafe() {

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

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public void introduceCafe() {

		System.out.print("Introduzca Nombre Cafe: ");
		this.nombre = entradaCafe.nextLine().trim().toUpperCase();

		System.out.print("Introduzca Precio Cafe: ");
		this.precio = Double.parseDouble(entradaCafe.nextLine());
		
		cafes.add(new Cafe(getNombre(), getPrecio()));
				
		introduceLote();
		
		muestraCafes();
		
		muestraLotes();

	}

	public void muestraCafes() {

		for (Cafe c : cafes) {

			System.out.println(c.getNombre() + "\n" + c.getPrecio());
		}

	}

}
