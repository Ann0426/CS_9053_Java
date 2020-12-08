package student;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class StudentClient extends JFrame {
  private JTextField tfName = new JTextField(20);
  private JTextField tfStreet = new JTextField(20);
  private JTextField tfCity = new JTextField(20);
  private JTextField tfState = new JTextField(3);
  private JTextField tfZip = new JTextField(6);

  // Button for sending a student to the server
  private JButton btRegister = new JButton("Register to the Server");

  // Host name or ip
  String host = "localhost";

  public StudentClient() {
	  super("StudentClient");
	  
	  JPanel mainPanel = new JPanel();
	  mainPanel.setLayout(new BorderLayout());
	  
	  JPanel infoPanel = new JPanel();
	  infoPanel.setLayout(new GridLayout(6,2));
	  infoPanel.add(new JLabel("Name"));
	  infoPanel.add(tfName);
	  infoPanel.add(new JLabel("Street"));
	  infoPanel.add(tfStreet);
	  infoPanel.add(new JLabel("City"));
	  infoPanel.add(tfCity);
	  infoPanel.add(new JLabel("State"));
	  infoPanel.add(tfState);
	  infoPanel.add(new JLabel("Zip"));
	  infoPanel.add(tfZip);
	  
	  mainPanel.add(infoPanel, BorderLayout.CENTER);
	  
	  JPanel controlPanel = new JPanel();
	  controlPanel.add(btRegister);
	  mainPanel.add(controlPanel, BorderLayout.SOUTH);
	  this.add(mainPanel);
	  btRegister.addActionListener(new ButtonListener());
    
	  setSize(450, 200);
  }

  /** Handle button action */
  private class ButtonListener implements ActionListener {
	  
    public void actionPerformed(ActionEvent e) {
      try {
        // Establish connection with the server
        Socket socket = new Socket(host, 8000);

        // Create an output stream to the server
        ObjectOutputStream toServer =
          new ObjectOutputStream(socket.getOutputStream());

        // Get text field
        String name = tfName.getText().trim();
        String street = tfStreet.getText().trim();
        String city = tfCity.getText().trim();
        String state = tfState.getText().trim();
        String zip = tfZip.getText().trim();

        // Create a Student object and send to the server
        StudentAddress s =
          new StudentAddress(name, street, city, state, zip);
        toServer.writeObject(s);
      }
      catch (IOException ex) {
        ex.printStackTrace();
      }
    }

  }
  
  public static void main(String[] args) {

	  StudentClient sc = new StudentClient();
	  sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  sc.setVisible(true);
  }
}