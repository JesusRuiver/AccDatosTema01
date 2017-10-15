/**
 * 
 */
package ejercicio1punto5;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

/**
 * @author Jesús Manuel Ruiz Verdejo
 *
 */
public class CreaDocumentoXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * A partir del fichero de objetos Persona utilizado anteriormente crea
		 * un documento XML usando DOM
		 */

		/* Creo el Fichero de objetos para repasar comceptos del Tema 1 */

		Persona persona;

		String nombres[] = { "Ana", "Luis Miguel", "Alicia", "Pedro", "Manuel", "Andrés", "Julio", "Antonio",
				"María Jesús" };

		String apellidos[] = { "Perez", "Ruiz", "Martinez", "Alonso", "Jimenez", "Godoy", "Lopez", "Justa",
				"María Jesús" };

		int edades[] = { 14, 15, 13, 15, 16, 12, 16, 14, 13 };

		File fichero = new File("Persona.dat");
		
		///Hay que leer el fichero

		try {

			ObjectOutputStream escribeFichero = new ObjectOutputStream(new FileOutputStream(fichero));

			for (int i = 0; i < nombres.length; i++) {
				persona = new Persona(nombres[i], apellidos[i], edades[i]);
				escribeFichero.writeObject(persona);

			}
			escribeFichero.close();
		} catch (IOException e) {
			e.getMessage();
		}

		/* Creamos el fichero XML */

		DocumentBuilderFactory creadorDocumento = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder creadorDoc = creadorDocumento.newDocumentBuilder();
			DOMImplementation implementacion = creadorDoc.getDOMImplementation();

			Document documento = implementacion.createDocument(null, "PersonasXML", null);

			documento.setXmlVersion("1.0"); // Vesion XML

			Element raiz = documento.createElement("persona"); // Creamos el
																// nodo raiz
																// "persona"

			documento.getDocumentElement().appendChild(raiz); // Lo pegamos a la
																// raiz del
																// documento

			for (;;) {
				
				

				// Añade Nombre

				crearElemento("nombre", String(nombre), raiz, documento);

				// Añade Apellido

				crearElemento("apellido", String(apellido), raiz, documento);

				// Añade Edad

				crearElemento("edad", Integer.toString(edad), raiz, documento);

			} // Fin del for

			Source codigoXML = new DOMSource(documento);
			Result resultado = new StreamResult(new java.io.File("Personas.xml"));
			Transformer transformar = TransformerFactory.newInstance().newTransformer();
			transformar.transform(codigoXML, resultado);

		} catch (Exception e) {

			System.err.println("Error: " + e);
		}

	}// Fin del Main

	static void crearElemnto(String datoPersona, String valor, Element raiz, Document documento) {

		Element elemento = documento.createElement(datoPersona);

		Text texto = documento.createTextNode(valor);

		raiz.appendChild(elemento);
		elemento.appendChild(texto);
	}
}

class Persona implements Serializable {

	private String nombre;
	private String apellido;
	private int edad;

	public Persona(String nombre, String apellido, int edad) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}