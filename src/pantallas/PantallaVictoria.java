package pantallas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import base.EscribirFicheroScore;
import base.Jugador;
import base.LeerFicheroScore;
import base.PanelJuego;

/**
 * @author Ismael Martín Ramírez
 * @author Alejandro Bajo Pérez
 */

public class PantallaVictoria implements Pantalla {

	private PanelJuego panelJuego;
	private Color color;
	private float tiempo;
	private final String RUTA_IMG_FONDO = "src//img//dragon.jpg";
	private Image imgFondo = null;
	Jugador jugador, aux;

	public PantallaVictoria(PanelJuego panelJuego, float tiempo) {
		this.panelJuego = panelJuego;
		this.color = Color.BLACK;
		this.tiempo = tiempo;
		cargarFondo();
		inicializarPantalla();
		redimensionarPantalla();
	}

	@Override
	public void inicializarPantalla() {
		modificarFichero();
	}

	@Override
	public void pintarPantalla(Graphics g) {
		// Escribir en grafico
		int posicion = 20;
		actualizarFondo(g);
		g.setColor(Color.BLACK);
		g.setFont(panelJuego.getFuente());
		g.drawString("¡VICTORIA!", 10, 70);
		g.setColor(Color.GREEN);
		DecimalFormat format = new DecimalFormat("#.##");
		g.drawString("Time ->" + (format.format(tiempo / 1000000000)), 350, 70);
		g.setColor(Color.BLUE);
		g.drawString("¡Datos de " + aux.getNombre() + "!", panelJuego.getWidth() / 2 - 200,
				panelJuego.getHeight() / 2 - 150);
		g.drawString("Victorias -> " + aux.getVictorias(), panelJuego.getWidth() / 2 - 450,
				panelJuego.getHeight() / 2 - 60);
		g.drawString("Muertes -> " + aux.getMuertes(), panelJuego.getWidth() / 2 - 450,
				panelJuego.getHeight() / 2 + 20);
		g.drawString("<- Mejores Tiempos ->", panelJuego.getWidth() / 2 - 20, panelJuego.getHeight() / 2 - 60);
		aux.ordenarTiempos();
		for (int i = 0; i < aux.getTiempos().size(); i++) {
			g.drawString((format.format(aux.getTiempos().get(i) / 1000000000)), panelJuego.getWidth() / 2 + 230,
					panelJuego.getHeight() / 2 + posicion);
			posicion += 90;
		}
	}

	public void modificarFichero() {
		try {
			jugador = LeerFicheroScore.leerFichero();
		} catch (Exception e) {
		}
		// Modificamos el jugador
		if (jugador != null) {
			jugador.addTiempo(tiempo);
			aux = new Jugador("", jugador.getMuertes(), jugador.getVictorias() + 1, jugador.getTiempos());
		} else {
			ArrayList<Float> tiempos = new ArrayList<>();
			tiempos.add(tiempo);
			aux = new Jugador("", 0, 1, tiempos);
		}
		// Lo guardamos en el fichero
		EscribirFicheroScore.escribirFichero(aux);
	}

	/**
	 * Dibuja el fondo del panel
	 */
	public void cargarFondo() {
		// Fondo
		try {
			imgFondo = ImageIO.read(new File(RUTA_IMG_FONDO));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Rellenar fondo
	 * 
	 * @param grafico
	 */
	public void actualizarFondo(Graphics g) {
		g.drawImage(imgFondo, 0, 0, null);
	}

	@Override
	public void ejecutarFrame() {
		try {
			// color de Inicio
			color = new Color(aleatorio(0, 255), aleatorio(0, 255), aleatorio(0, 255));
			Thread.sleep(425);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void moverRaton(MouseEvent e) {
	}

	@Override
	public void pulsarRaton(MouseEvent e) {
		panelJuego.setPantalla(new PantallaJuego(panelJuego));
	}

	@Override
	public void mantenerPulsadoRaton(MouseEvent e) {
	}

	@Override
	public void redimensionarPantalla() {
		imgFondo = imgFondo.getScaledInstance(panelJuego.getWidth(), panelJuego.getHeight(),
				BufferedImage.SCALE_SMOOTH);
	}

	/**
	 * Obtiene un aleatorio
	 * 
	 * @param minimo
	 * @param maximo
	 * @return aleatorio entre minimo y maximo
	 */
	public int aleatorio(int minimo, int cantidad) {
		Random r = new Random();
		int aleatorio = r.nextInt(cantidad) + minimo;
		return aleatorio;
	}
}