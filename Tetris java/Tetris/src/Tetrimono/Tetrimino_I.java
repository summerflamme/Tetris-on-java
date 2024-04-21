package Tetrimono;

import java.awt.Color;

public class Tetrimino_I extends Tetrimino{

	public Tetrimino_I() {
		create(Color.cyan);
	}


	public void setXY(int x , int y) {
		/*
		 * 		°		2
		 * 		°		0
		 * 		°		1
		 * 		°		3
		 */

		b[0].x = x;
		b[0].y = y;
		b[1].x = b[0].x - Block.size;
		b[1].y = b[0].y;
		b[2].x = b[0].x - (Block.size *2);
		b[2].y = b[0].y;
		b[3].x = b[0].x + Block.size;
		b[3].y = b[1].y;
	}

	public void getRotate1() {
		/*
		 * 		°		2
		 * 		°		0
		 * 		°		1
		 * 		°		3
		 */

		tempB[0].x = b[0].x ;
		tempB[0].y = b[0].y ;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y + Block.size;
		tempB[2].x = b[0].x;
		tempB[2].y = b[0].y - Block.size;
		tempB[3].x = b[0].x;
		tempB[3].y = b[1].y + (Block.size * 2);
		updateXY(1);
	}
	public void getRotate2() {
		/*
		 * 		° ° ° °		 2 0 1 3
		 */
		tempB[0].x = b[0].x - Block.size;
		tempB[0].y = b[0].y ;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y ;
		tempB[2].x = b[0].x - (Block.size *2);
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x +Block.size;
		tempB[3].y = b[0].y ;
		updateXY(2);

	}
	public void getRotate3() {
		/*
		 * 		°		2
		 * 		°		0
		 * 		°		1
		 * 		°		3
		 */

		tempB[0].x = b[0].x ;
		tempB[0].y = b[0].y ;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y + Block.size;
		tempB[2].x = b[0].x;
		tempB[2].y = b[0].y - Block.size;
		tempB[3].x = b[0].x;
		tempB[3].y = b[0].y + (Block.size *2);
		updateXY(3);
	}
	public void getRotate4() {
		/*
		 * 	° ° ° °   2 0 1 3 
		 * 
		 */
		tempB[0].x = b[0].x + Block.size;
		tempB[0].y = b[0].y ;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y ;
		tempB[2].x = b[0].x + (Block.size *2);
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x -Block.size;
		tempB[3].y = b[0].y ;
		updateXY(4);
	}
}
