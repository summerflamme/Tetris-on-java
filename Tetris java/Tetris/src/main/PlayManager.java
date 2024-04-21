package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import Tetrimono.Block;
import Tetrimono.Tetrimino;
import Tetrimono.Tetrimino_I;
import Tetrimono.Tetrimino_J;
import Tetrimono.Tetrimino_L;
import Tetrimono.Tetrimino_O;
import Tetrimono.Tetrimino_S;
import Tetrimono.Tetrimino_T;
import Tetrimono.Tetrimino_Z;
/*
 * Dessine la zone de jeu
 * Gere les tetrominoes
 * Gere les actions de jeu
 * Gere les lignes 
 * Gere le score
 * etc
 */
public class PlayManager {
	//main Play Area
	final int WIDTH = 300;
	final int HEIGHT = 600; 
	public static int left_x;
	public static int right_x;
	public static int top_y;
	public static int bottom_y;

	//Tetrimino

	Tetrimino currentTretrimino;
	final int tetrimino_origine_x;
	final int tetrimino_origine_y;
	Tetrimino[] mino  = new Tetrimino[7];
	Random random = new Random();
	int randoms = random.nextInt(mino.length);
	Tetrimino nextMino;
	final int NextTetrimino_origine_x;
	final int NextTetrimino_origine_y;
	Tetrimino nextMino2;
	final int NextTetrimino2_origine_x;
	final int NextTetrimino2_origine_y;
	Tetrimino nextMino3;
	final int NextTetrimino3_origine_x;
	final int NextTetrimino3_origine_y;

	public static ArrayList<Block> staticBlocks = new ArrayList<>();

	//auto drop toute les 60 frames
	//60 pour 60 fps
	public static int dropInterval = 60;
	boolean gameOver;

	//effets 
	boolean effectCounterOn;
	int effectCounter;
	ArrayList<Integer> effectY = new ArrayList<>();

	//score / level
	int level = 1 ; 
	public static int score ; 
	int lines ; 

	public PlayManager() {
		//zone de jeu
		this.left_x = (GamePanel.WIDHT/2) - (WIDTH/2);
		this.right_x = left_x + WIDTH; 
		this.top_y = 50; 
		this.bottom_y = top_y + HEIGHT;

		//définis l'apparition des tetrimino dans la zone de jeu 
		tetrimino_origine_x = left_x + (WIDTH/2) - Block.size;
		tetrimino_origine_y = top_y + Block.size;

		NextTetrimino_origine_x = right_x + 190;
		NextTetrimino_origine_y = top_y + 90;

		NextTetrimino2_origine_x = right_x + 190;
		NextTetrimino2_origine_y = top_y + 190;

		NextTetrimino3_origine_x = right_x + 190;
		NextTetrimino3_origine_y = top_y + 300;


		currentTretrimino = randomMino();
		///currentTretrimino = new Tetrimino_S();
		currentTretrimino.setXY(tetrimino_origine_x, tetrimino_origine_y);
		nextMino = randomMino();
		nextMino.setXY(NextTetrimino_origine_x, NextTetrimino_origine_y);
		nextMino2 = randomMino();
		nextMino2.setXY(NextTetrimino2_origine_x, NextTetrimino2_origine_y);
		nextMino3 = randomMino();
		nextMino3.setXY(NextTetrimino3_origine_x, NextTetrimino3_origine_y);



	} 
	public Tetrimino randomMino() {
		Random random = new Random();
		int randoms = random.nextInt(mino.length);
		mino[0] = new Tetrimino_I();
		mino[1] = new Tetrimino_J();
		mino[2] = new Tetrimino_L();
		mino[3] = new Tetrimino_O();
		mino[4] = new Tetrimino_S();
		mino[5] = new Tetrimino_T();
		mino[6] = new Tetrimino_Z();

		return mino[randoms];
	}

	private void getDeleteLine() {
		int x = left_x;
		int y = top_y;
		int blockCount = 0 ;
		int lineCount = 0;

		while (x < right_x && y < bottom_y) {
			for(int i=0; i<staticBlocks.size(); i++) {
				if(staticBlocks.get(i).x == x && staticBlocks.get(i).y == y) {
					blockCount++;
				}
			}
			x += Block.size;

			if(x == right_x) {

				if(blockCount == 10) {
					effectCounterOn = true; 
					effectY.add(y);
					for(int i = staticBlocks.size() -1  ; i> -1 ; i--) {
						if (staticBlocks.get(i).y == y ) {
							staticBlocks.remove(i);
						}
					}

					lineCount++;
					lines++;

					//vitesse de chute 

					if(lines % 10 == 0 && dropInterval > 1 ) {
						level ++ ;
						if(dropInterval > 10) {
							dropInterval -= 10;
						}
						else {
							dropInterval -= 1;
						}
					}

					// Si la ligne viens d'être supprimer descendre les blocks vers le bat 
					for(int i=0 ;i< staticBlocks.size();i++) {
						if(staticBlocks.get(i).y < y) {
							staticBlocks.get(i).y += Block.size;
						}
					}
				}
				blockCount =0;
				x =left_x;
				y += Block.size;
			}

			//Ajouter le score 
			if(lineCount > 0) {
				int singleLineScore = 100 * level;
				int doubleLineScore = 300 * level;
				int tripleLineScore = 500 * level;
				int quadrupleLineScore = 800 * level;
				if(lineCount == 1) {
					score = singleLineScore;
				}
				if(lineCount == 2) {
					score = doubleLineScore ;
				}
				if(lineCount == 3) {
					score = tripleLineScore;
				}
				if(lineCount == 4) {
					score = quadrupleLineScore;
				} 
			}
		}
	}
	public void update() {

		//Vérifie si le tetrimino actuelle est actif
		if(currentTretrimino.actif == false) {
			//quand le Tetrimino n'est plus actif mettre son état en static
			staticBlocks.add(currentTretrimino.b[0]);
			staticBlocks.add(currentTretrimino.b[1]);
			staticBlocks.add(currentTretrimino.b[2]);
			staticBlocks.add(currentTretrimino.b[3]);

			//vérifi le gameOver
			if(currentTretrimino.b[0].x == tetrimino_origine_x && currentTretrimino.b[0].y == tetrimino_origine_y) {
				gameOver = true;
			}

			currentTretrimino.desactiver = false;

			//Remplacer le tetrimino actuelle par le prochain
			currentTretrimino = nextMino;
			currentTretrimino.setXY(tetrimino_origine_x,tetrimino_origine_y);
			nextMino = nextMino2;
			nextMino.setXY(NextTetrimino_origine_x, NextTetrimino_origine_y);
			nextMino2 = nextMino3;
			nextMino2.setXY(NextTetrimino2_origine_x, NextTetrimino2_origine_y);
			nextMino3 = randomMino();
			nextMino3.setXY(NextTetrimino3_origine_x, NextTetrimino3_origine_y);


			//Quand la dernière piece deviens static on vérifie si il forme une ligne et si oui alors on la supprime
			getDeleteLine();
		}
		else {
			currentTretrimino.update();
		}
	}

	public void draw(Graphics2D g2) {

		//Desine la zone de jeu 

		g2.setColor(Color.white);
		//definit la largeur des bordure de la zone de jeu
		g2.setStroke(new BasicStroke(4f));
		/*
		 * Construit le rectangle de la zone de jeu
		 * 4 pour 4 pixel de largeur
		 */


		g2.drawRect(left_x-4, top_y-4, WIDTH+8, HEIGHT+8);
		g2.setStroke(new BasicStroke(1f));

		for(int i = left_x; i< right_x - Block.size; i = i+ Block.size) {
			g2.setColor(Color.gray);
			g2.drawLine(i + Block.size,top_y, i + Block.size, bottom_y);
		}

		for(int i = top_y; i< bottom_y - Block.size; i = i+Block.size) {
			g2.drawLine(right_x, i + Block.size , left_x, i + Block.size);
		}
		//		g2.drawLine(left_x + Block.size ,top_y,left_x + Block.size,bottom_y);

		//dessine la zone ou se trouve la prochaine piece 
		g2.setStroke(new BasicStroke(3f));
		g2.setColor(Color.white);


		int x = right_x + 100;
		int y = bottom_y - 604;
		g2.drawRect(x, y , 200, 200);
		//donne la font du texte
		g2.setFont(new Font("Lato", Font.PLAIN,30));
		//...
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		//Texte
		g2.drawString("Next", x+70, y -10);


		//zone de score 
		int xScoreZone;
		int yScoreZone;
		xScoreZone = x - 800;
		yScoreZone = top_y + 300;
		//		g2.drawRect(x - 800, top_y + 300, 250, 250);
		g2.drawRect(xScoreZone,yScoreZone, 250, 250);

		x = xScoreZone + 40;
		y = yScoreZone+ 60;
		g2.drawString("Score " + score, x, y); 
		y+= 70;
		g2.drawString("Level " + level, x, y); 
		y+= 70;
		g2.drawString("Lines " + lines, x, y); 

		// affiche le tetrimino courrant 

		if (currentTretrimino != null) {
			currentTretrimino.draw(g2);
		}

		//Affiche pause 
		g2.setColor(Color.WHITE);
		g2.setFont(g2.getFont().deriveFont(45F));
		if(keyHandler.pause) {
			x = left_x + 30;
			y = top_y + 200;
			g2.drawString("Game Pause", x, y);
		}

		//afficher GameOver
		g2.setColor(Color.WHITE);
		g2.setFont(g2.getFont().deriveFont(45F));
		if(gameOver) {
			x = left_x + 50;
			y = top_y + 200;
			g2.drawString("GameOver", x, y);
		}

		//Afficher le prochain Tetrimino
		nextMino.draw(g2);
		nextMino2.draw(g2);
		nextMino3.draw(g2);

		//Afficher le tetrimino Static 
		for(int i=0;i<staticBlocks.size();i++) {
			staticBlocks.get(i).draw(g2);
		}

		//Afficher les effets 
		if(effectCounterOn) {
			effectCounter++;
			g2.setColor(Color.WHITE);
			for(int i=0;i<effectY.size();i++) {
				g2.fillRect(left_x, effectY.get(i),WIDTH, Block.size);
			}
			if(effectCounter== 10) {
				effectCounterOn = false;
				effectCounter = 0;
				effectY.clear();
			}
		}



	}

}
