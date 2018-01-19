package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirFicheroScore {
	/*
	 * Escribir fichero serializado con los datos del objeto
	 */
	public static void escribirObjetoEnFichero(Jugador c) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		File fichero = new File("score.obj");

		try {
			// Abrir flujos
			fos = new FileOutputStream(fichero, true);
			oos = new ObjectOutputStream(fos);

			// Escribir en el fichero
			oos.writeObject(c);

		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No se encontró el fichero");
			e.printStackTrace();
		}
		System.out.println("Fichero serializado creado/modificado con éxito");
	}// Fin de escribir fichero

}