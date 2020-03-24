package lesson03;
import javax.swing.*;
public class App03 {

	public static void main(String[] args) {	
		/*for (int i=0; i<1500; i+=150) {
			JFrame window1 = new JFrame();
			window1.setBounds(50+i,50,150,110);
			window1.setVisible(true);
		}*/
		String name = "Петя";
		if ( name == "Вася" ) {
			System.out.println("Мальчик");
		} else {
			System.out.println("Девочка");
		}
		switch (name) {
		case "Вася":
			System.out.println("Мальчик");
			break;
		case "Петя":
			System.out.println("Мальчик");
			break;
		case "Катя":
			System.out.println("Девочка");
			break;
		}
	}

}
