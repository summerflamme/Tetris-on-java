package Tetrimono;

import java.awt.Color;

public class Tetrimino_J extends Tetrimino {

	Color c = new Color(0,0,204);
	public Tetrimino_J() {
		create(c);
	}
	public void setXY(int x , int y) {
		/*
		 * Position initiale
		 * 		°			3
		 * 		° ° °  		2 0 1
		 * 
		 * +x -->
		 * -x <--
		 * 
		 * 
		 * +y  |
		 * 	   v
		 * 
		 * 	    ^
		 * -y	|
		 * 
		 */
		b[0].x = x ;
		b[0].y = y ;
		b[1].x = b[0].x + Block.size;
		b[1].y = b[0].y ; 
		b[2].x = b[0].x - Block.size;
		b[2].y = b[0].y;
		b[3].x = b[0].x - Block.size;
		b[3].y = b[0].y - Block.size;
	}

	public void getRotate1() {
		/*
		 * Position initiale
		 * 		°
		 * 		° ° °  
		 */
		tempB[0].x = b[0].x;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x + Block.size;
		tempB[1].y = b[0].y ; 
		tempB[2].x = b[0].x - Block.size;
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x - Block.size;
		tempB[3].y = b[0].y - Block.size;

		updateXY(1);

	}

	public void  getRotate2() {
		/*
		 * 		° °				2 3
		 * 		°				0
		 * 		°				1
		 */
		tempB[0].x = b[0].x ;
		tempB[0].y = b[0].y ;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y + Block.size;
		tempB[2].x = b[0].x;
		tempB[2].y = b[0].y - Block.size;
		tempB[3].x = b[0].x + Block.size;
		tempB[3].y = b[0].y -Block.size;

		updateXY(2);
	}

	public void getRotate3() {
		/*
		 *     ° ° °		
		 *     	   ° 
		 *     
		 *     
		 */
		tempB[0].x = b[0].x ;
		tempB[0].y = b[0].y ;
		tempB[1].x = b[0].x- Block.size;
		tempB[1].y = b[0].y ;
		tempB[2].x = b[0].x + Block.size;
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x + Block.size;
		tempB[3].y = b[0].y + Block.size;

		updateXY(3);
	}

	public void getRotate4() {
		/*
		 *     °
		 *     °
		 *   ° °
		 */

		tempB[0].x = b[0].x ;
		tempB[0].y = b[0].y ;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y - Block.size;
		tempB[2].x =  b[0].x;
		tempB[2].y = b[0].y + Block.size;
		tempB[3].x = b[0].x - Block.size;
		tempB[3].y = b[0].y + Block.size;

		updateXY(4);
	}
}
