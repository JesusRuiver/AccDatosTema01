package pruebaswindowbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PruebaVentana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaVentana frame = new PruebaVentana();
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
	public PruebaVentana() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); //Coloca por defecto el layaout a null
		
		JButton btnBotonVerStock = new JButton("Ver Stock");
		
		
		btnBotonVerStock.setBounds(20, 11, 404, 23);
		contentPane.add(btnBotonVerStock);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 45, 404, 205);
		contentPane.add(textArea);
		
		//Regla de estilo: Los eventos debajo
		//Podemos dejar comentario de lo que hace
		
		btnBotonVerStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//aqui meteriamos el codigo del metodo que queremos
			}
		});
	}
}
