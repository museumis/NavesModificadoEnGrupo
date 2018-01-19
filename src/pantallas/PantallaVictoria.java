package pantallas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.Random;

import javax.imageio.ImageIO;

import base.EscribirFicheroScore;
import base.Jugador;
import base.LeerFicheroScore;
import base.PanelJuego;

public class PantallaVictoria implements Pantalla {

	private PanelJuego panelJuego;
	private Color color;
	private float tiempo;
	private final String RUTA_IMG_FONDO = "src//img//dragon.jpg";
	private Image imgFondo = null;
	Jugador jugador;

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
		actualizarFondo(g);

		g.setColor(Color.BLACK);
		g.setFont(panelJuego.getFuente());
		g.drawString("�VICTORIA!", panelJuego.getWidth() / 3, panelJuego.getHeight() / 2);
		g.setColor(Color.GREEN);
		DecimalFormat format = new DecimalFormat("#.##");
		g.drawString("Time ->" + (format.format(tiempo / 1000000000)), (panelJuego.getWidth() / 3) + 50,
				(panelJuego.getHeight() / 2) - 80);
		g.setColor(color);
		g.drawLine((panelJuego.getHeight() / 2) + 120, (panelJuego.getHeight() / 2) + 20,
				(panelJuego.getWidth() / 2) + 120, (panelJuego.getHeight() / 2) + 20);


		g.drawString("�Jugador !"+ jugador, 0, panelJuego.getHeight() / 3);
		
		// Crear fichero.
	}

	public void modificarFichero() {
		// Si la puntuacion es mayor que la del fichero
		jugador = LeerFicheroScore.leerObjetoFichero();
		// Tenemos jugador del fichero
		jugador.setVictorias(jugador.getVictorias() + 1);
		// Modificamos jugador
		 EscribirFicheroScore.escribirObjetoEnFichero(jugador);
		// Escribimos jugador
		// Leer fichero y modificarlo
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
		// TODO Auto-generated method stub

	}

	@Override
	public void pulsarRaton(MouseEvent e) {
		panelJuego.setPantalla(new PantallaJuego(panelJuego));

	}

	@Override
	public void mantenerPulsadoRaton(MouseEvent e) {
		// TODO Auto-generated method stub

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
