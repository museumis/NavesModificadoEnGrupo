package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeerFicheroScore {
	/**
	 * Metodo para leer el fichero serializado donde se encuentra el objeto
	 */
	public static Jugador leerObjetoFichero() {

		Jugador jugador = new Jugador();

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			// Abrir flujos
			fis = new FileInputStream("score.obj");
			ois = new ObjectInputStream(fis);

			System.out.println("\n--Jugadores --");
			while (true) {
				jugador = (Jugador) ois.readObject();
				System.out.println(jugador);
			}

		} catch (

		FileNotFoundException e) {
			System.out.println("Error al encontrar el fichero.");
		} catch (IOException e) {
			System.out.println("\n --- Fin de lectura ---\n");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al leer la clase del fichero");
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el fichero");
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el fichero");
					e.printStackTrace();
				}
			}
		}

		return jugador;
	}// Fin de leer fichero

}
