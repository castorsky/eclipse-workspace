package lesson05;
import java.awt.*;
import javax.swing.*;
public class App05 {
	public static void main(String[] args) {
		MyFrame window = new MyFrame();
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
}
class MyPanel extends JPanel {

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.setColor(Color.RED); // new Color
		arg0.fillRect(10, 10, 300, 200);
		arg0.setColor(Color.BLACK);
		arg0.fillOval(150, 200, 500, 300);
		arg0.setColor(new Color(150,150,150));
		arg0.fillRoundRect(300, 100, 100, 100, 20, 20);
		for (int i=0; i<256; i++) {
			arg0.setColor(new Color(i,255,i));
			arg0.drawLine(100, 200+i, 600, 200+i);
		}
	}
	
}



















