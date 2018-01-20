package base;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * @author Ismael Martín Ramírez
 * @author Alejandro Bajo Pérez
 */
public class FramePrincipal {

	private JFrame frame;
	private PanelJuego juego;

	public FramePrincipal() {
		frame = new JFrame("");
		frame.setBounds(200, 200, 1100, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void iniciar() {
		iniciarComponentes();
		iniciarListened();
		frame.setVisible(true);
	}

	public void iniciarComponentes() {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(false);
		frame.setLayout(new GridLayout());

		juego = new PanelJuego();

		frame.add(juego);
	}

	public void iniciarListened() {
	}
}