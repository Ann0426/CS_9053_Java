package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RollDice extends JFrame {
	private JButton button;
	private JLabel resultLabel;

	
	public RollDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		resultLabel = new JLabel(
	             "Result: " );
	 
		createButton();
		setupPanels();
		setSize(900,200);
		setVisible(true);
	
	}
	 public void createButton()
	    {  
	       button = new JButton("Roll Dice");
	 
	       class AddButtonListener implements ActionListener
	       {
	          public void actionPerformed(ActionEvent event)
	          {
	             
	             resultLabel.setText(
	                   "Result:  123  " );
	          }            
	       }
	 
	       ActionListener listener = new AddButtonListener();
	       button.addActionListener(listener);
	    }
	 
	public void setupPanels() {
		JPanel mainPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel imagePanel = new JPanel();
		buttonPanel.add(button);
		mainPanel.setLayout(new GridLayout(3,1));
		ImagePanel imagePanel1 = new ImagePanel("die1.png");
		ImagePanel imagePanel2 = new ImagePanel("die2.png");
		imagePanel.add(imagePanel1);
		imagePanel.add(imagePanel2);
		mainPanel.add(imagePanel);
		mainPanel.add(resultLabel,BorderLayout.CENTER);
		mainPanel.add(buttonPanel);
		this.add(mainPanel);
	}
	public static void main(String[] args) {
		RollDice rollDice = new RollDice();
	
	}
}
