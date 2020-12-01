package graphics;

import javax.swing.JFrame;

public class ShowColors extends JFrame {

	public ShowColors() {
		super("Using colors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ColorJPanel colorJPanel = new ColorJPanel();
		add(colorJPanel);
		setSize(500,180);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ShowColors showColors = new ShowColors();
	}
}
