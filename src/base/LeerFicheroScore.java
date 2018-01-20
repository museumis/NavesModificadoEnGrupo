package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerFicheroScore {

	/**
	 * Metodo para leer el fichero serializado donde se encuentra el objeto
	 */
	public static Jugador leerFichero() {
		Jugador jugador = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File fichero = new File("score.obj");

		try {
			// Abrir flujos
			fis = new FileInputStream(fichero);
			ois = new ObjectInputStream(fis);
			// Leer fichero
			jugador = (Jugador) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Error al encontrar el fichero.");
		} catch (IOException e) {
			// System.out.println("\n --- Fin de lectura ---\n");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al leer la clase del fichero");
		} finally {
			// Cierro flujos
			try {
				ois.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
			}
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
			}
		}
		return jugador;
	}// Fin de leer fichero
}