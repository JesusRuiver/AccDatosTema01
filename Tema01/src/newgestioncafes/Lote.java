package newgestioncafes;

import java.util.ArrayList;
import java.util.Scanner;

public class Lote {

	private double kilos;
	private String caducidad;
	private Scanner entradaLote = new Scanner(System.in);
	private ArrayList<Lote> lotes = new ArrayList<Lote>();

	public Lote() {

	}

	public Lote(double kilos, String caducidad) {

		this.kilos = kilos;
		this.caducidad = caducidad;
	}

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

	public void introduceLote() {

		System.out.println("Desea introducir un Lote: ");
		System.out.print("Si | No: ");

		while (entradaLote.nextLine().trim().toLowerCase().equals("si")) {

			System.out.print("Introduzca Kilos Lote Cafe: \n");
			this.kilos = Double.parseDouble(entradaLote.nextLine());

			System.out.print("Introduzca Caducidad Lote Cafe: \n");
			this.caducidad = entradaLote.nextLine();
			// SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");

			lotes.add(new Lote(getKilos(), getCaducidad()));

			System.out.println("Desea introducir un nuevo Lote: ");
			System.out.print("Si | No: ");

		}

		for (Lote e : lotes) {

			System.out.println(e.getKilos() + " " + e.getCaducidad());
		}

	}

}
