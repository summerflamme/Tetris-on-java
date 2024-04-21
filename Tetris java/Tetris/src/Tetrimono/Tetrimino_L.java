package Tetrimono;

import java.awt.Color;

public class Tetrimino_L extends Tetrimino{
	public Tetrimino_L() {
		create(Color.orange);
	}

	public void setXY(int x , int y) {
		/*
		 * 			°					b[3]
		 * 		° ° ° 			b[1]b[0]b[2]
		 * 			
		 * 
		 * 
		 * On choisi b[0] le block du milieu car c'est le seule qui ne bouge pas lors des rotations des pieces
		 * retirer 1x size en x décale de 1 case vers la gauche
		 * ajouter 1x size en x décalde de 1 case vers la droite
		 * retirrer 1x zise en y décalde de 1 case vers le haut 
		 * ajouter 1x size en y déclade de 1 case vers le bas
		 */
		//		b[0].x = x;
		//		b[0].y = y;
		//		//pour faire b[1] qui se trouve au dessus de b[0] il faut retirer une fois zise a y
		//		b[1].x = b[0].x- Block.size;
		//		b[1].y = b[0].y ;
		//		//pour faire b[2] qui se trouve au dessus de b[0] il faut ajouter une fois zise a y
		//		b[2].x = b[0].x + Block.size;
		//		b[2].y = b[0].y;
		//		//pour faire b[3] qui se trouve au dessus de b[0] il faut ajouter une fois zise a y pour faire comme b[2] puis ajouter encore une fois size a x 
		//		b[3].x = b[0].x - Block.size;
		//		b[3].y = b[0].y + Block.size;

		b[0].x = x;
		b[0].y = y;
		b[1].x = b[0].x - Block.size;
		b[1].y = b[0].y;
		b[2].x = b[0].x+ Block.size;
		b[2].y = b[0].y ;
		b[3].x = b[0].x + Block.size;
		b[3].y = b[0].y - Block.size;

	}
	public void getRotate1() {
		/*
		 * 			°					b[3]
		 * 		° ° ° 			b[1]b[0]b[2]
		 */

		tempB[0].x = b[0].x ;
		tempB[0].y = b[0].y ;
		tempB[1].x = b[0].x- Block.size;
		tempB[1].y = b[0].y ;
		tempB[2].x = b[0].x + Block.size;
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x + Block.size;
		tempB[3].y = b[0].y - Block.size;

		updateXY(1);

	}

	public void getRotate2() {
		/*
		 * 	° 				b[1]
		 *  ° 				b[0]
		 * 	° °				b[2] b[3]
		 * 
		 */
		tempB[0].x = b[0].x;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y - Block.size;
		tempB[2].x = b[0].x;
		tempB[2].y = b[0].y + Block.size;
		tempB[3].x = b[0].x + Block.size;
		tempB[3].y = b[0].y + Block.size;

		updateXY(2);

	}

	public void getRotate3() {
		/*
		 *  ° ° °    b[1]b[0]b[2]
		 *  °        b[3]
		 */
		tempB[0].x = b[0].x ;
		tempB[0].y = b[0].y ;
		tempB[1].x = b[0].x- Block.size;
		tempB[1].y = b[0].y ;
		tempB[2].x = b[0].x + Block.size;
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x - Block.size;
		tempB[3].y = b[0].y + Block.size;

		updateXY(3);
	}

	public void getRotate4() {
		/*
		 *  ° °      b[3] b[1]
		 *    °           b[0]
		 *    °           b[2]
		 */
		tempB[0].x = b[0].x;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y - Block.size;
		tempB[2].x = b[0].x;
		tempB[2].y = b[0].y + Block.size;
		tempB[3].x = b[0].x - Block.size;
		tempB[3].y = b[0].y - Block.size;

		updateXY(4);
	}
}
