package main;


import javax.swing.*;


public class start {
	public static void main(String[] args) {
		//declaration + initialisation d'un variable window qui permet de faire des fenetre grace a JFrame
		JFrame window = new JFrame("Tetris");

		//parametre de la fenetre

		//définis comment la fenetre se ferme
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Definis si l'utilisateur peut modifier la taille
		window.setResizable(false);

		//ajouter le GamePanel a la fenetre window
		GamePanel gp = new GamePanel ();
		// ajoute le GamePanel gp a la fentre window
		window.add(gp);
		//definis la taille de gamePanel a celle de window 
		window.pack();

		//Definis l'emplacement de la fenetre si l'ecran mentionner est l'ecran sur le qu'elle se trouve la fenetre  a l'appel de la methode 
		window.setLocationRelativeTo(null);
		//Permet de definir si la fenetre est afficher ou cacher
		window.setVisible(true);

		gp.lauchGame();
	}
}