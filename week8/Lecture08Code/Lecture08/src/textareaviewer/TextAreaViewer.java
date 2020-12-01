package textareaviewer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import bankaccount.BankAccount;

/**
   This program shows a frame with a text area that displays
   the growth of an investment. 
*/
public class TextAreaViewer
{  

	private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
	
   public static void main(String[] args)
   {  
      JFrame frame = new JFrame();

      // The application adds interest to this bank account
      final BankAccount account = new BankAccount(INITIAL_BALANCE);
      // The text area for displaying the results
      final int AREA_ROWS = 10;
      final int AREA_COLUMNS = 30;

      final JTextArea textArea = new JTextArea(
            AREA_ROWS, AREA_COLUMNS);
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);

      // The label and text field for entering the interest rate
      JLabel rateLabel = new JLabel("Interest Rate: ");

      final int FIELD_WIDTH = 10;
      final JTextField rateField = new JTextField(FIELD_WIDTH);
      rateField.setText("" + DEFAULT_RATE);

      // The button to trigger the calculation
      JButton calculateButton = new JButton("Add Interest");

      // The panel that holds the input components
      JPanel northPanel = new JPanel();
      northPanel.add(rateLabel);
      northPanel.add(rateField);
      northPanel.add(calculateButton);
      
      frame.add(northPanel, BorderLayout.NORTH);
    
      frame.add(scrollPane);     
     
      class CalculateListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            double rate = Double.parseDouble(
                  rateField.getText());
            double interest = account.getBalance() 
                  * rate / 100;
            account.deposit(interest);
            textArea.append(DECIMAL_FORMAT.format(account.getBalance()) + "\n");
         }            
      }

      ActionListener listener = new CalculateListener();
      calculateButton.addActionListener(listener);

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   private static final double DEFAULT_RATE = 10;
   private static final double INITIAL_BALANCE = 1000;

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 200;
}
