package base;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private int muertes;
	private int victorias;
	private ArrayList<Float> tiempos;

	/**
	 * Constructores
	 */
	public Jugador() {
	}

	public Jugador(String nombre, int muertes, int victorias, ArrayList<Float> tiempos) {
		this.nombre = nombre;
		this.muertes = muertes;
		this.victorias = victorias;
		this.tiempos = new ArrayList<>();
		this.tiempos = tiempos;
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

	public ArrayList<Float> getTiempos() {
		return tiempos;
	}

	public void setTiempos(ArrayList<Float> tiempos) {
		this.tiempos = tiempos;
	}

	public void addTiempo(float tiempo) {
		this.tiempos.add(tiempo);
	}

	public void ordenarTiempos() {
		float auxiliar;
		for (int i = 0; i < tiempos.size() - 1; i++) {
			for (int j = i + 1; j < tiempos.size(); j++) {
				if (tiempos.get(i) > tiempos.get(j)) {
					auxiliar = tiempos.get(j);
					tiempos.set(j, tiempos.get(i));
					tiempos.set(i, auxiliar);
				}
			}
		}
	}
}