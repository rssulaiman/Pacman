package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JComponent;



public class Panel extends JComponent{

	private final Jeu game;



	private static final long serialVersionUID = 1L;

	public Panel (Jeu game) {
		super();
		this.game = game;
		setOpaque(true);
		setSize( game.getCaseSize()*game.getCaseNumWidth(), game.getCaseSize()*game.getCaseNumHeight());
		}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	g.setColor(Color.black);
       g.fillRect(0, 0, game.getCaseSize()*game.getCaseNumWidth(),game.getCaseSize()*game.getCaseNumHeight());
    Graphics2D g2d = (Graphics2D) g;
    
     game.createMap(g2d);
   game.paintComponent(g2d);
   
     }
	
	
}
