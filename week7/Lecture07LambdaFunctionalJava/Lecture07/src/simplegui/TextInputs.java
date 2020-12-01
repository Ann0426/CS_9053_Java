package simplegui;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class TextInputs extends JFrame {
	
	private final JTextField textField1;
	private final JTextField textField2;
	private final JButton jButton1;
	
	public TextInputs() {
		super("Testing JTextField");
		setLayout(new FlowLayout());
		
		textField1 = new JTextField(10);
		textField2 = new JTextField(10);
		jButton1 = new JButton("Press Me");
		add(textField1);
		add(textField2);
		add(jButton1);
		
		
	}
	
	public static void main(String[] args) {
		TextInputs textInputs = new TextInputs();
		textInputs.setSize(200, 150);
		textInputs.setVisible(true);
	}
}
