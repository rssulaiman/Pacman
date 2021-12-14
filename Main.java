package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Pacman");
		Jeu game = new Jeu();
		Panel fenetre = new Panel(game);
		View vue = new View(fenetre);

		
	}

}
