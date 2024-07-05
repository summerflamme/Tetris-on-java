package Tetrimono;

import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.StreamCorruptedException;

import main.PlayManager;
import main.keyHandler;

public class Tetrimino {
	public Block b[] = new Block[4];
	public Block tempB[] = new Block[4];
	int autoDrop = 0;
	public int rotate =1 ; //4 rotation différentes 1/2/3/4
	boolean collisionGauche , collisionDroite, collisionBas;
	public boolean actif = true;
	public boolean desactiver;
	int desactiverCoubnter = 0 ; 

	public void create(Color c) {
		//défini le tetrimino courrant 
		b[0] = new Block(c);
		b[1] = new Block(c);
		b[2] = new Block(c);
		b[3] = new Block(c);

		//défini les rotation
		tempB[0] = new Block(c);		
		tempB[1] = new Block(c);
		tempB[2] = new Block(c);
		tempB[3] = new Block(c);
	}
	public void setXY(int x ,int y ) {

	}
	public void updateXY(int Rotate) {
		getRotateCollision();

		if(collisionGauche == false && collisionDroite == false && collisionBas == false) {
			this.rotate = Rotate;
			b[0].x = tempB[0].x;	
			b[0].y = tempB[0].y;
			b[1].x = tempB[1].x;
			b[1].y = tempB[1].y;
			b[2].x = tempB[2].x;
			b[2].y = tempB[2].y;
			b[3].x = tempB[3].x;
			b[3].y = tempB[3].y;
		}

	}
	public void getRotate1() {

	}
	public void getRotate2() {

	}
	public void getRotate3() {

	}
	public void getRotate4() {

	}

	public void getMouvementCollision() {

		collisionBas = false;
		collisionDroite = false;
		collisionGauche = false;

		getStatciCollision();
		//vérifie la collision avex le mur de gauche
		for(int i=0; i< b.length; i++) {
			if(b[i].x == PlayManager.left_x) {
				collisionGauche = true;

			}
		}

		//Vérifie la collision avec le mur de droite
		for(int i=0;i< b.length; i++) {
			if(b[i].x + Block.size == PlayManager.right_x) {
				collisionDroite = true;
			}
		}

		//vérifie la collision avec le sol 
		for(int i=0; i<b.length;i++) {
			if(b[i].y + Block.size== PlayManager.bottom_y) {
				collisionBas = true;
			}
		}
	}
	public void getRotateCollision() {

		collisionBas = false;
		collisionDroite = false;
		collisionGauche = false;

		getStatciCollision();

		//vérifie la collision avex le mur de gauche
		for(int i=0; i< b.length; i++) {
			if(tempB[i].x < PlayManager.left_x) {
				collisionGauche = true;

			}
		}

		//Vérifie la collision avec le mur de droite
		for(int i=0;i< b.length; i++) {
			if(tempB[i].x + Block.size > PlayManager.right_x) {
				collisionDroite = true;
			}
		}

		//vérifie la collision avec le sol 
		for(int i=0; i<b.length;i++) {
			if(tempB[i].y + Block.size> PlayManager.bottom_y) {
				collisionBas = true;
			}
		}
	}
	private void getStatciCollision() {
		for(int i=0;i<PlayManager.staticBlocks.size();i++) {
			int staticX = PlayManager.staticBlocks.get(i).x;
			int staticY = PlayManager.staticBlocks.get(i).y;


			//Colision sol
			for(int i2=0;i2<b.length;i2++){
				if(b[i2].y + Block.size == staticY && b[i2].x == staticX) {
					collisionBas = true;
				}
			}

			//Collision gauche
			for(int i3=0;i3<b.length;i3++) {
				if(b[i3].x -Block.size == staticX && b[i3].y == staticY) {
					collisionGauche = true;
				}
			}

			//colision Droite
			for(int i4=0;i4<b.length;i4++) {
				if(b[i4].x + Block.size == staticX && b[i4].y == staticY) {
					collisionDroite = true;
				}
			}
		}
	}

	private void getDesactiver() {
		desactiverCoubnter++;

		//Attendre que 45 frames se passe 
		if(desactiverCoubnter == 45) {
			desactiverCoubnter = 0 ;
			//Vérifie que la piece touche le sol
			getMouvementCollision();

			//Si la piece touche le sol après 45 frames désactiver la piece
			if(collisionBas) {
				actif = false;
			}
		}

	}


	public void update() {
		if(desactiver) {
			getDesactiver();
		}
		getMouvementCollision();
		//déplacement des tetriminos

		if(keyHandler.rotate) {
			switch(rotate) {
			case 1:
				getRotate2();
				break;
			case 2:
				getRotate3();
				break;
			case 3: 
				getRotate4();
				break;
			case 4: 
				getRotate1();
				break;
			}
			keyHandler.rotate= false;
		}
		if(keyHandler.descend) {
			if(collisionBas== false) {

				//pareil que l'auto drop car c'est ça fait la même chose
				b[0].y += Block.size;			
				b[1].y += Block.size;
				b[2].y += Block.size;
				b[3].y += Block.size;

				autoDrop = 0;
				PlayManager.currentScore++;
			}

			keyHandler.descend = false;
		}

		if (keyHandler.gauche) {
			if(collisionGauche == false) {
				b[0].x -= Block.size;			
				b[1].x -= Block.size;
				b[2].x -= Block.size;
				b[3].x -= Block.size;
			}
			keyHandler.gauche = false;
		}


		if(keyHandler.droite) {
			if(collisionDroite == false) {
				b[0].x += Block.size;			
				b[1].x += Block.size;
				b[2].x += Block.size;
				b[3].x += Block.size;
			}
			keyHandler.droite = false;
		}
		if(keyHandler.drop) {
			if(collisionBas == false) {

			}
		}

		//Conmpteur incrémanté a chaque frame
		if(collisionBas) {
			desactiver = true;
		}
		else {
			autoDrop++;
			if(autoDrop == PlayManager.dropInterval) {
				if(collisionBas == false) {
					//descend de 1 case le tetromio
					b[0].y += Block.size;			
					b[1].y += Block.size;
					b[2].y += Block.size;
					b[3].y += Block.size;
					//reset le comteur
					autoDrop = 0 ;
				}
			}
		}
	}
	public void draw(Graphics2D g2) {
		//margin crée une séparation entre les block
		int margin = 2;
		g2.setColor(b[0].c);
		g2.fillRect(b[0].x+margin, b[0].y+margin, Block.size-(margin*2), Block.size-(margin*2));
		g2.fillRect(b[1].x+margin, b[1].y+margin, Block.size-(margin*2), Block.size-(margin*2));
		g2.fillRect(b[2].x+margin, b[2].y+margin, Block.size-(margin*2), Block.size-(margin*2));
		g2.fillRect(b[3].x+margin, b[3].y+margin, Block.size-(margin*2), Block.size-(margin*2));

	}
}
