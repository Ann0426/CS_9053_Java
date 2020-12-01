package textfields;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class BasicTextField extends JFrame {

	JTextField textField;
	
	
	public BasicTextField() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(175, 75);
		textField = new JTextField(12);
		setLayout(new FlowLayout());
		add(textField);
		textField.addActionListener((e) -> System.out.println("textfield has value: " + textField.getText()));
		// textField.addCaretListener(new TypingListener());
	}
	
	class TypingListener implements CaretListener {

		@Override
		public void caretUpdate(CaretEvent e) {
			System.out.println("textfield has value: " + textField.getText());
			
		}
		
	}
	
	public static void main(String[] args) {
		BasicTextField btf = new BasicTextField();
		btf.setVisible(true);
	}
}
