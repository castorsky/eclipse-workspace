package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
	private int level;
	private Field field;
	public Window(int level) {
		this.level = level;
		setBounds(100,100,800,600);
		setTitle("Game: Catch the ball");
		addKeyListener(new MyKey());
		setFocusable(true);
		field = new Field(level);
		Container container = getContentPane();
		container.add(field);
		setVisible(true);
	}

	private class MyKey implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			if (keyCode == 27) {
				System.exit(0);
			}
			if (keyCode == 37) {
				// Key LEFT
				field.moveBasket(-10);
			}
			if (keyCode == 39) {
				// Key RIGHT
				field.moveBasket(10);
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
		
	}
}















