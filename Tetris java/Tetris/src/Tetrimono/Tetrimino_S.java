package Tetrimono;

import java.awt.Color;

public class Tetrimino_S extends Tetrimino{
		
	public Tetrimino_S(){
		create(Color.GREEN);
	}
	
	public void setXY (int x, int y ) {
		/*
		 *       ° °            0 1
		 *     ° °            3 2
		 */
		 b[0].x = x;
		 b[0].y = y;
		 b[1].x = b[0].x + Block.size;
		 b[1].y = b[0].y;
		 b[2].x = b[0].x ;
		 b[2].y = b[0].y + Block.size;
		 b[3].x = b[0].x - Block.size;
		 b[3].y = b[0].y + Block.size;	
	}
	
	public void getRotate1() {
		/*
		 *       ° °            0 1
		 *     ° °            3 2
		 */
			tempB[0].x = b[0].x + Block.size;
			tempB[0].y = b[0].y;
			tempB[1].x = b[0].x + (Block.size*2);
			tempB[1].y = b[0].y;
			tempB[2].x = b[0].x + Block.size;
			tempB[2].y = b[0].y + Block.size;
			tempB[3].x = b[0].x;
			tempB[3].y = b[0].y + Block.size;
		updateXY(1);
	}
	
	public void getRotate2() {
		/*
		 *    °        1
		 *    ° °      0 2
		 *      °        3
		 */
		tempB[0].x = b[0].x;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y - Block.size;
		tempB[2].x = b[0].x + Block.size;
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x + Block.size;
		tempB[3].y = b[0].y + Block.size;
		updateXY(2);
	}
	
	public void getRotate3() {
		/*
		 *       ° °            0 1
		 *     ° °            3 2
		 */
		tempB[0].x = b[0].x - Block.size;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y;
		tempB[2].x = b[0].x - Block.size;
		tempB[2].y = b[0].y + Block.size;
		tempB[3].x = b[0].x -(Block.size *2) ;
		tempB[3].y = b[0].y + Block.size;
		updateXY(3);
	}
	
	public void getRotate4() {
		/*
		 *    °        1
		 *    ° °      0 2
		 *      °        3
		 */
		tempB[0].x = b[0].x;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y - Block.size;
		tempB[2].x = b[0].x + Block.size;
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x + Block.size; 
		tempB[3].y = b[0].y +Block.size;
		updateXY(4);
	}
}
