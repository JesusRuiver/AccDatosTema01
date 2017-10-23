package gestioncafesgrafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.VersionSpecHelper;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private ArrayList<Cafe> cafes = new ArrayList<Cafe>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 258, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAñadeCafe = new JButton("A\u00F1adir");
		btnAñadeCafe.setBounds(55, 37, 148, 23);
		contentPane.add(btnAñadeCafe);

		JButton btnInventario = new JButton("Ver Stock");

		btnInventario.setBounds(55, 87, 148, 23);
		contentPane.add(btnInventario);

		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(55, 142, 148, 23);
		contentPane.add(btnVender);

		JButton btnExportar = new JButton("Exportar");
		btnExportar.setBounds(55, 202, 148, 23);
		contentPane.add(btnExportar);

		JButton btnImportar = new JButton("Importar");
		btnImportar.setBounds(55, 257, 148, 23);
		contentPane.add(btnImportar);

		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VerStock v = new VerStock();
				
				v.setVisible(true);
			}
		});
	}
}
