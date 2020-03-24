package game;

import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args) {
		String levelStr = JOptionPane.showInputDialog(
				null, "Введите сложность (от 1 до 5)", 1);
		int level = Integer.parseInt(levelStr);
		
		if ((level >= 1) && (level <= 5)) {
			Window window = new Window(level);
		}
	}

}
