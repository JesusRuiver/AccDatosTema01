package gestioncafesgrafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VerStock extends JFrame {

	private JPanel contentPane;
	private ArrayList<Cafe> cafes = new ArrayList<Cafe>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerStock frame = new VerStock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VerStock() {
		setTitle("Ver Stock");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); // Coloca por defecto el layaout a null

		JButton btnVerStock = new JButton("Ver Stock");

		btnVerStock.setBounds(20, 11, 404, 23);
		contentPane.add(btnVerStock);

		JTextArea txtStock = new JTextArea();
		txtStock.setEditable(false);
		txtStock.setBounds(20, 45, 404, 205);
		contentPane.add(txtStock);

		// Regla de estilo: Los eventos debajo
		// Podemos dejar comentario de lo que hace

		btnVerStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// aqui meteriamos el codigo del metodo que queremos

				String texto = ("\t** INVENTARIO DE CAFES **");

				for (Cafe cafe : cafes) {

					System.out.println(cafe.getNombre() + " a " + cafe.getPrecio() + " euros/kg");

					for (newgestioncafestexto.Lote lote : cafe.getLotes()) {

						texto = "\t" + lote.getCaducidad() + ":";
						texto = lote.getKilos() + "kg \n";

					}

					txtStock.setText(texto);
				}
			}
		});
	}
}