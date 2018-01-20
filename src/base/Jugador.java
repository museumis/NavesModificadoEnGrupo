package base;

import java.io.Serializable;

public class Jugador implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private int muertes;
	private int victorias;
	private float tiempo;

	/**
	 * Constructores
	 */
	public Jugador() {
	}

	public Jugador(String nombre, int muertes, int victorias, float tiempo) {
		this.nombre = nombre;
		this.muertes = muertes;
		this.victorias = victorias;
		this.tiempo = tiempo;
	}

	// Getters && Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMuertes() {
		return muertes;
	}

	public void setMuertes(int muertes) {
		this.muertes = muertes;
	}

	public int getVictorias() {
		return victorias;
	}

	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public float getTiempo() {
		return tiempo;
	}

	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}
}