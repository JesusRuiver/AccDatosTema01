package ejemplosSAX;

import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class PruebaSax1 {
	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {

		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		GestionContenido gestor = new GestionContenido();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource("Personas.xml");
		procesadorXML.parse(fileXML);
	}
}// fin PruebaSax1

class GestionContenido extends DefaultHandler {

	private boolean edad;
	private boolean nombre;
	private boolean esMayor;
	private String almacenaEdad;

	public GestionContenido() {
		super();
	}

	public void startDocument() {
		System.out.println("MayoresDe14");
	}

	public void endDocument() {
		System.out.println("/MayoresDe14");
	}

	public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
		if (nombre.equals("edad")) {
			this.edad = true;
		}

		if (nombre.equals("nombre")) {
			this.nombre = true;
		}
	}

	public void endElement(String uri, String nombre, String nombreC) {

		if (this.edad) {
			this.edad = false;
		}

		if (nombre.equals("nombre")) {
			this.nombre = false;
		}

	}

	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		String car = new String(ch, inicio, longitud);
		// quitar saltos de línea
		car = car.replaceAll("[\t\n]", "");
		if (this.edad = true) {

			if (Integer.parseInt(car) > 13) {
				this.esMayor = true;
				this.almacenaEdad = car;
			} else {
				this.esMayor = false;
			}

			System.out.println("<nombre>" + car + "</nombre>");

		}
	}
}// fin GestionContenido
