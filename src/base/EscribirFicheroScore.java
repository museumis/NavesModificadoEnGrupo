package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Ismael Martín Ramírez
 * @author Alejandro Bajo Pérez
 */

public class EscribirFicheroScore {

	/**
	 * Escribir fichero serializado con los datos del objeto
	 */
	public static void escribirFichero(Jugador j) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		File fichero = new File("score.obj");
		fichero.delete();
		try {
			// Abrir flujos
			fos = new FileOutputStream(fichero);
			oos = new ObjectOutputStream(fos);
			// Escribir en el fichero
			oos.writeObject(j);
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (IOException e) {
			System.out.println("Error de escritura");
		} finally {
			// Cierro flujos
			try {
				oos.close();
			} catch (IOException e) {
				System.out.println("Error de escritura");
			}
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("Error de escritura");
			}
		}
	}// Fin de escribir fichero
}