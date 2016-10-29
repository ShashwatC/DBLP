
import java.awt.Container;

import javax.swing.JFrame;

public class SearchEngine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame homeScreen = new JFrame("DBLP Search Engine");
		homeScreen.setSize(300,300);
		homeScreen.setLocationRelativeTo(null);
		homeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = homeScreen.getContentPane();
		homeScreen.setVisible(true);
	}

}
