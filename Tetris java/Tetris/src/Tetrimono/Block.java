package Tetrimono;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Block extends Rectangle {
	public int x,y;
	//block size 30x30 
	public static final int size = 30; 
	public Color c;
	
	//constructeur pour les couleur car chaque minos a une couleur différente
	public Block (Color c) {
		this.c = c; 
	}
	
	public void draw(Graphics2D g2)  {
		int margin = 2;
		g2.setColor(c);
		g2.fillRect(x + 2, y +4, size - (margin *2), size- (margin *2));
	}
}
