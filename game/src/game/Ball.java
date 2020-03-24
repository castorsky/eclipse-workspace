package game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Timer;
import java.awt.event.*;

public class Ball {
	private int ballX, ballY;
	private boolean active;
	private Timer ballTimer;
	private Image ballPic;
	
	public Ball(Image picture) {
		ballTimer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				moveDown();
			}
		});
		ballPic = picture;
		active = false;
	}
	
	public int getBallX() {
		return ballX;
	}

	public int getBallY() {
		return ballY;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void deactivate() {
		active = false;
	}
	
	public void start() {
		ballTimer.start();
		ballY = 0;
		ballX = (int)(Math.random()*750);
		active = true;
	}
	
	public void draw(Graphics arg0) {
		if (active) {
			arg0.drawImage(
				ballPic, ballX, ballY, 50, 50, null);
		}
	}

	protected void moveDown() {
		if (active) {
			ballY += 25;
		}
		if (ballY > 445) {
			ballTimer.stop();
		}
	}
}










