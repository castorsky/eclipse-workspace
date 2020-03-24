package lesson06;

import java.awt.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class App06 {
	public static void main(String[] args) {
		MyFrame window = new MyFrame(100,100,600,400,10);
	}
}
class MyFrame extends JFrame {
	public MyFrame() {
		MyPanel panel = new MyPanel();
		Container cont = getContentPane();
		cont.add(panel);
		setBounds(10,10,800,600);
		setVisible(true);
	}
	public MyFrame(int x, int width, int y, int height) {
		MyPanel panel = new MyPanel();
		Container cont = getContentPane();
		cont.add(panel);
		setBounds(x, y, width, height);
		setVisible(true);
	}
	public MyFrame(int x, int y, int width, 
					int height, int shift) {
		MyPanel panel = new MyPanel();
		panel.setShift(shift);
		Container cont = getContentPane();
		cont.add(panel);
		setBounds(x, y, width, height);
		setVisible(true);
	}
}
class MyPanel extends JPanel {
	private int x=10, y=10, shift=5;
	private int direction = 2; // 2 = RIGHT
	private Image picture;
	
	public void setShift(int shift) {
		this.shift = shift;
	}

	public MyPanel() {
		addKeyListener(new MyKey());
		setFocusable(true);
		try {
			picture = ImageIO.read(
				new File("/home/castor/pen-rocket-pen.jpg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Timer timer = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (direction == 0) {
					x-=shift; // LEFT
					// x = x - shift;
				}
				if (direction == 1) {
					y-=shift; // UP
					// y = y - shift;
				}
				if (direction == 2) {
					x+=shift; // RIGHT
					// x = x + shift;
				}
				if (direction == 3) {
					y+=shift; // DOWN
					// y = y + shift;
				}
				repaint();
			}
			
		});
		timer.start();
	}
	
	private class MyKey implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case 37:
				direction = 0; // LEFT
				break;
			case 38: 
				direction = 1; // UP
				break;
			case 39:
				direction = 2; // RIGHT
				break;
			case 40: 
				direction = 3; // DOWN
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.clearRect(x-shift, y-shift, 200+shift, 200+shift);
		arg0.drawImage(picture, x, y, 200, 200, null);
	}
	
}



















