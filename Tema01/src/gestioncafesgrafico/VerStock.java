package gestioncafesgrafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestioncafesgrafico.Cafe;
import gestioncafesgrafico.Lote;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VerStock extends JFrame {

	private JPanel contentPane;
	private double stockTotal;
	private ArrayList<Cafe> cafes = new ArrayList<Cafe>();

	
	/**
	 * Create the frame.
	 */
	public VerStock() {
		
		leerCafes(new File("MisCafes.txt"));
		
		setTitle("Ver Stock");
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 295, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTextArea txtStock = new JTextArea();
		txtStock.setEditable(false);
		contentPane.add(txtStock, BorderLayout.CENTER);
		
		JButton button = new JButton("Ver Stock");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				txtStock.setText("");
				txtStock.append("\t** INVENTARIO DE CAFES **\n");

				for (Cafe cafe : cafes) {

					txtStock.append(cafe.getNombre() + " a " + cafe.getPrecio() + " euros/kg\n");

					for (Lote lote : cafe.getLotes()) {
						
						stockTotal = 0;
						txtStock.append("\t" + lote.getCaducidad() + ":\n");
						txtStock.append("\t" + lote.getKilos() + "kg \n");
						
						stockTotal += lote.getKilos();
						

					}
					txtStock.append("Stock Total: " + stockTotal + "\n");
				}
			}
		});
		contentPane.add(button, BorderLayout.NORTH);
		
		
	
	}
	
	public void leerCafes(File fichero) {
		ArrayList<String> lineas = new ArrayList<String>();

		if (fichero.exists())
			leerLineas(fichero, lineas);

		for (int i = 0; i < lineas.size();) {
			// Variable nombre
			String nombre = lineas.get(i);
			i++;
			// Variable precio
			double precio = Double.parseDouble(lineas.get(i));
			i++;
			// Variable ArrayList
			ArrayList<Lote> lotes = new ArrayList<Lote>();
			while (true) {
				String lineaTres = lineas.get(i);
				if (lineaTres.equals("0")) {
					i++;
					break;
				} else {
					double kilos = Double.parseDouble(lineaTres);
					i++;
					String caducidad = lineas.get(i);
					i++;
					Lote lote = new Lote(kilos, caducidad);
					lotes.add(lote);
				}
			}
			Cafe cafe = new Cafe(nombre, precio, lotes);
			boolean existe = false;
			for (Cafe cafeAntiguo : cafes) {
				if (cafeAntiguo.getNombre() == cafe.getNombre()) {
					existe = true;
					break;
				}

			}
			if (!existe)
				cafes.add(cafe);

		}
	}

	public void leerLineas(File fichero, ArrayList<String> lineas) {
		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				if (!(linea.isEmpty())) {
					lineas.add(linea.trim());

				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != fr)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}