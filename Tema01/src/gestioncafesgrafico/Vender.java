package gestioncafesgrafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class Vender extends JFrame {

	private JPanel contentPane;
	private ArrayList<Cafe> cafes = new ArrayList<Cafe>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender frame = new Vender();
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
	public Vender() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(20, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 45, 404, 192);
		contentPane.add(textArea);
		
		JComboBox cboNombresCafes = new JComboBox();
		cboNombresCafes.setBounds(147, 12, 257, 20);
		contentPane.add(cboNombresCafes);
		
		
		cboNombresCafes.addItem("Debe enseñar las lineas");
		
		for (Cafe cafe : VentanaPrincipal.){
			
			cboNombresCafes.addItem(cafe.getNombre());
		}
				
				
				
		
	}
}
