package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class Field extends JPanel {
	private Image background, basket, gameover;
	private int basketX = 350, level;
	private Ball[] balls;
	private Timer redrawTimer, checkBalls;
	
	public void moveBasket(int basketShift) {
		if ((basketX>-50) && (basketX<700)) {
			basketX = basketX + basketShift;
		}
	}
	
	public Field(int level) {
		this.level = level;
		balls = new Ball[level]; // ARRAY = МАССИВ
		try {
			for (int i=0; i<level; i++) {
				balls[i] = new Ball(ImageIO.read(
					new File("/home/user/Документы/ball"+(i+1)+".png")));     
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			background = ImageIO.read(new File(
						"/home/user/Документы/court.jpg"));
			basket = ImageIO.read(new File(
					"/home/user/Документы/basket.png"));
			gameover = ImageIO.read(new File(
					"/home/user/Документы/gameover.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		redrawTimer = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				repaint();
			}
			
		});
		redrawTimer.start();
		checkBalls = new Timer(3000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				checkAndAddBalls();
			}
			
		});
		checkBalls.start();
	}
	
	protected void checkAndAddBalls() {
		int counter = 0;
		for (int i = 0; i < balls.length; i++) {
			if (balls[i].isActive()) {
				counter++; // Если мяч уже есть, то увеличиваем счетчик
			} else {
				if (counter < level) {
					balls[i].start();
					break;
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(background, 0, 0, 800, 600, null);
		arg0.drawImage(basket, basketX, 420, 150, 150, null);
		for (int i = 0; i < balls.length; i++) {
			balls[i].draw(arg0);
			if ((balls[i].isActive()) &&
					(balls[i].getBallY() > 445)) {
				if (Math.abs(balls[i].getBallX() - basketX - 50) < 10) {
					// Мяч пойман, убираем его с экрана
					balls[i].deactivate();
				} else {
					// Мяч пропущен, останавливаем игру
					redrawTimer.stop();
					checkBalls.stop();
					arg0.drawImage(gameover, 0, 0, 800, 600, null);
					break;
				}
			}
		}
	}
	
}
















