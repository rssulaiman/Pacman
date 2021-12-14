package pacman;

import java.awt.BasicStroke;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.geom.Ellipse2D;


public class Jeu extends JPanel implements ActionListener, KeyListener{

	private final int CaseNumWidth = 18;
	private final int CaseNumHeight = 11;
	private Timer timer = new Timer(5, this);
	private int x = 0, y = 0, velX = 0, velY = 0;

	private final int CaseSize = 56;

	private final int[][] map = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,2,1,1,1,0,1,1,1,1,1,1,0,1,1,1,3,0},
			{0,1,0,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0},
			{0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0},
			{0,1,0,1,0,0,1,0,1,1,0,1,0,0,1,0,1,0},
			{1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1},
			{0,1,0,1,0,0,1,0,0,0,0,1,0,0,1,0,1,0},
			{0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0},
			{0,1,0,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0},
			{0,4,1,1,5,0,1,1,1,1,1,1,0,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	};

	public Jeu () {
		super();
		timer.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}


    public int getCaseNumWidth() {
		return CaseNumWidth;
	}

	public int getCaseNumHeight() {
		return CaseNumHeight;
	}

	public int getCaseSize() {
		return CaseSize;
	}

	
	
	public Case[][] createMap (Graphics2D g) {
		Case[][] carte = new Case[CaseNumHeight][CaseNumWidth];

		for(int x = 0 ; x < CaseNumHeight ; x++) {
			for(int y = 0 ; y < CaseNumWidth ; y++) {

				g.setColor(new Color(51,107,255));
				g.setStroke(new BasicStroke(5));

				carte[x][y] = new Case(x,y);

				if(map[x][y] == 0) {
				carte[x][y].setCaseType(CaseType.MUR);
					g.fillRect(y*CaseSize, x*CaseSize, CaseSize, CaseSize);
				} else if (map[x][y] == 2){
				g.setColor(new Color(41, 222, 58));
				g.fillOval(y*CaseSize + 23 , x*CaseSize + 23, 17, 17);
				} else if (map[x][y] == 3){
				g.setColor(new Color(125, 3, 172));
				g.fillOval(y*CaseSize + 23 , x*CaseSize + 23, 17, 17);
					} else if (map[x][y] == 4){
					g.setColor(new Color(249, 137, 41));
				g.fillOval(y*CaseSize + 21 , x*CaseSize + 20, 17, 17);
						} else {
				g.setColor(new Color(255,255,255));
				g.fillOval(y*CaseSize + 28 , x*CaseSize + 28, 6, 6);
			}
			}
		}

		return carte;
	}
	
	
	
	
	 public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	       Graphics2D g2d = (Graphics2D) g;
	      // Case[][] carte = new Case[CaseNumHeight][CaseNumWidth];

			//for(int x = 0 ; x < CaseNumHeight ; x++) {
			//for(int y = 0 ; y < CaseNumWidth ; y++) {

			//		g.setColor(new Color(8, 41, 249));
		//	((Graphics2D) g).setStroke(new BasicStroke(5));

			//	carte[x][y] = new Case(x,y);

			//	if(map[x][y] == 5) {
					int size = 45;
						g2d.setColor(new Color(248, 248, 32));
						g.fillArc(y, x, size, size, 45, 270);
						// g2d.fill(new Ellipse2D.Double(y,x,40,40));
					
						
			//		} 
			//	}
	
			//	}
			}
	  
	
	 

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void up() {
		x += -15;
		//velX = -1;
		//velY = 0;
		// Graphics2D g2d = (Graphics2D) g;
		// g2d.rotate(Math.toRadians(90));
	}
	
    public void down() {
    	x += 15;
    	//velX = 0;
		//velY = -1;
		// Graphics2D g2d = (Graphics2D) g;
		// g2d.rotate(Math.toRadians(270));
	}

    public void left() {
    	y += -15;
    	//velX = 0;
		//velY = 1;
    	// Graphics2D g2d = (Graphics2D) g;
		// g2d.rotate(Math.toRadians(180));
    }

    public void right() {
    	y += 15;
    	//velX = 1;
		//velY = 0;
    }


	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP) {
			up();
		} if (code == KeyEvent.VK_DOWN) {
			down();
		} if (code == KeyEvent.VK_LEFT) {
			left();
		} if (code == KeyEvent.VK_RIGHT) {
			right();
		}
		repaint();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(x < 0) {
			velX = 0;
			x = 0;
		} if(x > 420) {
			velX = 0;
			x = 420;
		} if(y < 0) {
			velY = 0;
			y = 0;
		} if(y > 750) {
			velY = 0;
			y = 750;
		}
		x = x + velX;
		y = y + velX;
		repaint();
	}
	
}
