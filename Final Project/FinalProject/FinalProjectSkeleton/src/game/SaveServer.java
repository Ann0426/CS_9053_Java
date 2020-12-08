package game;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.io.*;
public class SaveServer extends JFrame {
	 private ObjectOutputStream outputToFile;
	 private ObjectInputStream inputFromClient;
	 private JTextArea wordsBox;
	
	public SaveServer() {
		createMainPanel();
		wordsBox.append("Ready to Accept Connections");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setVisible(true);
		
		 try {
		     // Create a server socket
		     ServerSocket serverSocket = new ServerSocket(8000);
		     System.out.println("Server started ");

		     // Create an object ouput stream
		     outputToFile = new ObjectOutputStream(
		       new FileOutputStream("score.dat", true));

		     while (true) {
		       // Listen for a new connection request
		       Socket socket = serverSocket.accept();

		       // Create an input stream from the socket
		       inputFromClient =
		         new ObjectInputStream(socket.getInputStream());

		       // Read from input
		       Object object = inputFromClient.readObject();

		       // Write to the file
		       ScoreRecord s = (ScoreRecord)object;
		       System.out.println("got object " + object.toString());
		       outputToFile.writeObject(object);
		       outputToFile.flush();
		       System.out.println("A new ScoreRecord is stored");
		       wordsBox.append("Player:" + s.name +"\n" +
		    		   "Ace Score:" + s.Ace +"\n" +
		    		   "Two Score:" + s.Two +"\n" +
		    		   "Three Score:" + s.Three +"\n" +
		    		   "Four Score:" + s.Four +"\n" +
		    		   "Five Score:" + s.Five +"\n" +
		    		   "Six Score:" + s.Six +"\n" +
		    		   "Upper Subtotal Score:" + s.UpScore +"\n" +
		    		   "Upper Bonus:" + s.UpBonus +"\n" +
		    		   "Upper Total Score:" + s.UpGrand  +"\n" +
		    		   "ThreeOfKind:" + s.ThreeOfKind +"\n" +
		    		   "FourOfKind:" + s.FourOfKind +"\n" +
		    		   "Full:" + s.Full +"\n" +
		    		   "Small:" + s.Small +"\n" +
		    		   "Large:" + s.Large  +"\n" +
		    		   "Yahtzee:" + s.Yahtzee +"\n" +
		    		   "Yahtzee Bonus:" + s.Bon +"\n" +
		    		   "lower section total:" + s.lowSec +"\n" +
		    		   "Grand Total:" + s.GraTo +"\n" 
		       );
		      
		     }
		   }
		
		   catch(ClassNotFoundException ex) {
		     ex.printStackTrace();
		   }
		   catch(IOException ex) {
		     ex.printStackTrace();
		   }
		   finally {
		     try {
		       inputFromClient.close();
		       outputToFile.close();
		     }
		     catch (Exception ex) {
		       ex.printStackTrace();
		     }
		   }
		 }
	
	
	public void createMainPanel() {
		wordsBox = new JTextArea(35,10);

		JScrollPane listScroller = new JScrollPane(wordsBox);
		this.add(listScroller, BorderLayout.CENTER);
		listScroller.setPreferredSize(new Dimension(250, 80));
	}
	
	public static void main(String[] main) {
		SaveServer saveServer = new SaveServer();
	}
}
