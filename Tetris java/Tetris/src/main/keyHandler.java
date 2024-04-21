package main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener{
	public static boolean rotate,descend,droite,gauche,pause,drop,reserve;
	@Override
	//Pas utilisé mais obligatoire car ca appartieznt a KeyListener

	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_Z) {
			rotate = true ; 
		}
		if(code == KeyEvent.VK_Q) {
			gauche = true;
		}
		if(code == KeyEvent.VK_S) {
			descend = true;
		}
		if(code == KeyEvent.VK_D) {
			droite = true;
		}
		if(code ==KeyEvent.VK_ESCAPE) {
			if(pause) {
				pause = false;
			}
			else {
				pause = true;
			}
		}
		if(code ==KeyEvent.VK_SPACE) {
			drop = true;
		}
		if(code == KeyEvent.VK_C) {
		}

	}

	//Pas utilisé mais obligatoire car ca appartieznt a KeyListener
	@Override
	public void keyReleased(KeyEvent e) { }

}
