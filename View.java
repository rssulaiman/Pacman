package pacman;

import javax.swing.JFrame;

public class View extends JFrame{
	
	private Panel fenetre;


	public View (Panel fenetre) {
		this.fenetre = fenetre;	
		
		// Le pacman et le background apparaissent parfaitement mais le pacman ne bouge pas, il ne bouge que si on commente les lignes 17, 18 et uncommente la ligne 20
		JFrame frame = new JFrame("PAC-MAN");
		Jeu jeu = new Jeu();
		frame.add(jeu);
		frame.add(fenetre);
		frame.setSize(fenetre.getSize());
		frame.setResizable(false);
		//frame.setSize(800, 500);
		frame.setLocation(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
}
