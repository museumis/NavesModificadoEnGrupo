package base;

public class Jugador {

	private String nombre;
	private int muertes;
	private int victorias;
	private float tiempo;

	/**
	 * Constructores
	 */
	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	public Jugador(int muertes, int victorias, float tiempo) {
		this.muertes = muertes;
		this.victorias = victorias;
		this.tiempo = tiempo;
	}

	public Jugador(String nombre, int muertes, int victorias, float tiempo) {
		super();
		this.nombre = nombre;
		this.muertes = muertes;
		this.victorias = victorias;
		this.tiempo = tiempo;
	}


	public Jugador(String nombre, int muertes, float teimpo) {
		super();
		this.nombre = nombre;
		this.muertes = muertes;
		this.tiempo = teimpo;
	}

	public Jugador(int muertes, float teimpo) {
		super();
		this.muertes = muertes;
		this.tiempo = teimpo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre +"\n Juegos -> "+ muertes +"\n Tiempo -> "+ tiempo+"\n VictoriasTotales -> "+victorias;
	}

	/**
	 * Get and Set
	 */

	public String getNombre() {
		return nombre;
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
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMuertes() {
		return muertes;
	}

	public void setMuertes(int muertes) {
		this.muertes = muertes;
	}

	public float getTeimpo() {
		return tiempo;
	}

	public void setTeimpo(float teimpo) {
		this.tiempo = teimpo;
	}

}
