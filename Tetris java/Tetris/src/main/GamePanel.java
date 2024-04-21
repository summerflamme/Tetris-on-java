package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;
public class GamePanel extends JPanel implements Runnable {

	public static final int WIDHT = 1280;
	public static final int HEIGHT = 720;
	final int fps = 60;
	// run gameLoop, pour l'utiliser il faut implemanter l'interface Runnable
	Thread gameThread;
	PlayManager pm;
	//parametre du panel
	//Couleur du fond 
	Color cb = new Color(19,19,65);
	public GamePanel() {
		//definis les dimention de la fenetre
		this.setPreferredSize(new  Dimension(WIDHT,HEIGHT));
		//definis la couleur du fond de la fenetre 
		this.setBackground(cb);
		//definis le gestionnaire de conteneurs
		this.setLayout(null);

		pm = new PlayManager();
	}
	//lance le jeu
	public void lauchGame() {
		//intialise gameThead au type Thread
		gameThread = new Thread(this);

		// lance le jeu fait un appel automatique a plublic void run() ; 
		gameThread.start();

		//implémentation du ketListener
		this.addKeyListener(new keyHandler());
		this.setFocusable(true);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

		/*
		 *GameLoop 
		 *Update les dessin de l'ecran
		 *60 fps
		 */
		double drawInterval = 1000000000/fps;
		double delta = 0 ; 
		long lastTime = System.nanoTime();
		long currentTime;

		while(gameThread != null) {
			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime ;

			if (delta >= 1) {
				update();
				//appele paintComponent(Graphics g);
				repaint();
				delta -- ;
			}
		}
	}
	//met a jour la position de l'objet en x ou en y, le score, le level , les points etc...
	private void update() {
		if(keyHandler.pause == false && pm.gameOver == false) {
			pm.update();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		pm.draw(g2);
	}
}