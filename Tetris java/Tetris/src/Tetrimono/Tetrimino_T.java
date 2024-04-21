package Tetrimono;

import java.awt.Color;

public class Tetrimino_T extends Tetrimino{

	public Tetrimino_T() {
		create(Color.MAGENTA);
	}

	@Override
	public void setXY(int x, int y) {
		/*
		 * 				°			3			
		 *            ° ° °	      1 0 2
		 */
		b[0].x = x;
		b[0].y = y;
		b[1].x = b[0].x - Block.size;
		b[1].y = b[0].y;
		b[2].x = b[0].x + Block.size;
		b[2].y = b[0].y ;
		b[3].x = b[0].x;
		b[3].y = b[0].y - Block.size;

	}

	public void getRotate1() {
		/*
		 * 				°			3			
		 *            ° ° °	      1 0 2
		 */

		tempB[0].x = b[0].x ;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x - Block.size;
		tempB[1].y = b[0].y;
		tempB[2].x = b[0].x + Block.size;
		tempB[2].y = b[0].y ;
		tempB[3].x = b[0].x;
		tempB[3].y = b[0].y - Block.size;
		updateXY(1);


	}
	public void getRotate2() {
		/*
		 * 				°			3			
		 *              ° °	        0 2
		 *              °			1
		 */
		tempB[0].x = b[0].x;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y + Block.size;
		tempB[2].x = b[0].x + Block.size;
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x;
		tempB[3].y = b[0].y - Block.size;
		updateXY(2);

	}
	public void getRotate3() {
		/*		
		 *            ° ° °	      3 0 2
		 *            	°           1
		 */
		tempB[0].x = b[0].x ;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x;	
		tempB[1].y = b[0].y + Block.size;
		tempB[2].x = b[0].x + Block.size;
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x - Block.size;
		tempB[3].y = b[0].y;
		updateXY(3);

	}
	public void getRotate4() {
		/*
		 * 				°			2			
		 *            ° °         3 0
		 *              °			1
		 */
		tempB[0].x = b[0].x ;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y + Block.size;
		tempB[2].x = b[0].x ;
		tempB[2].y = b[0].y - Block.size;
		tempB[3].x = b[0].x - Block.size;
		tempB[3].y = b[0].y;
		updateXY(4);

	}
}
