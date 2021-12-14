package pacMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Panel extends JComponent {

	private final Jeu game;

	private static final long serialVersionUID = 1L;

	public Panel (Jeu game) {
		super();
		this.game = game;
		setOpaque(true);
		setSize( game.getCaseSize()*game.getCaseNumWidth(), game.getCaseSize()*game.getCaseNumHeight());
		
		KeyListener myListener = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();

				/*if (inGame) {
					if (key == KeyEvent.VK_LEFT) {
						req_dx = -1;
						req_dy = 0;
					} else if (key == KeyEvent.VK_RIGHT) {
						req_dx = 1;
						req_dy = 0;
					} else if (key == KeyEvent.VK_UP) {
						req_dx = 0;
						req_dy = -1;
					} else if (key == KeyEvent.VK_DOWN) {
						req_dx = 0;
						req_dy = 1;
					} else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
						inGame = false;
					} 
				} else {
					if (key == KeyEvent.VK_SPACE) {
						inGame = true;
						initGame();
					}
				}
			}
		};
				 */
			}

		};
		addKeyListener(myListener);
		

	}
	
	/*@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
        g.fillRect(0, 0, game.getCaseSize()*game.getCaseNumWidth(),game.getCaseSize()*game.getCaseNumHeight());
        Graphics2D g2d = (Graphics2D) g;
        game.createMap(g2d);
	}*/
	
	 public void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        Graphics2D g2d = (Graphics2D) g;

	        g2d.setColor(Color.black);
	        g2d.fillRect(0, 0, game.getCaseSize()*game.getCaseNumWidth(),game.getCaseSize()*game.getCaseNumHeight());

	        game.createMap(g2d);

	        Toolkit.getDefaultToolkit().sync();
	        g2d.dispose();
	    }
}
