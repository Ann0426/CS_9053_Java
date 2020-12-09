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
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.*;
public class SaveServer extends JFrame {
	 private ObjectOutputStream outputToFile;
	 private ObjectInputStream inputFromClient;
	 private JTextArea wordsBox;
	 PreparedStatement insertStatement,statement;
	 Statement stmt;
	 ResultSet rs ;
	 Connection con;
	 ScoreRecord s ;
	 LoadGame LG;
	 

	
	public SaveServer() {
		createMainPanel();
		wordsBox.append("Ready to Accept Connections");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setVisible(true);
		connectDB();
//		insertData();
		
	  
		
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
		       inputFromClient = new ObjectInputStream(socket.getInputStream());

		       // Read from input
		       Object object = inputFromClient.readObject();

		       // Write to the file
		       s = (ScoreRecord)object;
		       insertData();
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
		 insertData();
		
		 
		 }
	public void connectDB() {
		try
		{
		    // Connect to a database
		    this.con = DriverManager.getConnection
		      ("jdbc:sqlite:yahtzee.db");
		    System.out.println("The DB is connected");
		   
		    try {
		    
		    	 stmt = con.createStatement();
		    	 stmt.executeUpdate("drop table ScoreRecord ");
		         stmt.executeUpdate("CREATE TABLE ScoreRecord (score_id INTEGER PRIMARY KEY AUTOINCREMENT ,"
		         		+ "Player TEXT(10) NOT NULL,"
		         		+ "Ace INTEGER(10) NOT NULL,"
		         		+ " Two INTEGER(10) NOT NULL,"
		         		+ "Three INTEGER(10) NOT NULL,"
		         		+ "Four INTEGER(10) NOT NULL,"
		         		+ "Five INTEGER(10) NOT NULL,"
		         		+ "Six INTEGER(10) NOT NULL,"
		         		+ "UpSubtotal INTEGER(10) NOT NULL,"
		         		+ "Bonus INTEGER(10) NOT NULL,"
		         		+ "Uptotal INTEGER(10) NOT NULL,"
		         		+ "ThreeOfKind INTEGER(10) NOT NULL,"
		         		+ "FourOfKind INTEGER(10) NOT NULL,"
		         		+ "Full INTEGER(10) NOT NULL,"
		         		+ "Small INTEGER(10) NOT NULL,"
		         		+ "Large INTEGER(10) NOT NULL,"
		         		+ "Yahtzee  INTEGER(10) NOT NULL,"
		         		+ "YahtzeeBonus INTEGER(10) NOT NULL,"
		         		+ "lowerSectionTotal INTEGER(10) NOT NULL,"
		         		+ "GrandTotal INTEGER(10) NOT NULL)");

			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(0);
			}
		    

		    System.out.println("The Table is created");
		} catch (Exception e) {
			System.exit(0);
		}
		
		/* sets up the prepared statement for SQL inserts */
		String insertSQL = "Insert Into ScoreRecord (Player,Ace,Two,Three,Four,Five,Six,UpSubtotal,Bonus,Uptotal,Threeofkind,FourOfkind,full,small,large,yahtzee,YahtzeeBonus,lowerSectionTotal,GrandTotal) " +
				"Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			insertStatement = con.prepareStatement(insertSQL);
			 System.out.println("The insertStatement is created");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	public void insertData()
	{
		try
		{
			insertStatement.setString(1, s.name);
			insertStatement.setLong(2, s.Ace);
			insertStatement.setLong(3,s.Two);
			insertStatement.setLong(4, s.Three);
			insertStatement.setLong(5,s.Four);
			insertStatement.setLong(6, s.Five);
			insertStatement.setLong(7, s.Six);
			insertStatement.setLong(8,s.UpScore);
			insertStatement.setLong(9, s.UpBonus);
			insertStatement.setLong(10, s.UpGrand);
			insertStatement.setLong(11, s.ThreeOfKind);
			insertStatement.setLong(12,s.FourOfKind);
			insertStatement.setLong(13, s.Full);
			insertStatement.setLong(14, s.Small);
			insertStatement.setLong(15, s.Large);
			insertStatement.setLong(16, s.Yahtzee);
			insertStatement.setLong(17, s.Bon);
			insertStatement.setLong(18, s.lowSec);
			insertStatement.setLong(19, s.GraTo);
//			insertStatement.setLong(20, 1);
		
			insertStatement.execute();

			 System.out.println("Inserted Successfully" );
			 System.out.println(s.name );
			 System.out.println(s.GraTo );
			 
//			 getScoreRecord();
			 System.out.println(s.name );
		}
		catch(Exception e)
		{
			 System.out.println(e.getMessage());
			 System.out.println("Inserted UnSuccessfully" );}
			
		}
		
	public void getScoreRecord()
	{
		try
		{

			Connection con = DriverManager.getConnection
				      ("jdbc:sqlite:yahtzee.db");
			String sql = "Select * from ScoreRecord where Player = ? ";
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1,"debo");

			rs = statement.executeQuery();
			if (rs != null) {
//				System.out.println( "populate controls try");

				''populateRecord();
				
			}
			

					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println( "populate controls");
		}
		
		
	}
	public void populateRecord()
	{  
		System.out.print(LG);
		if (LG.loadname != null) {
			System.out.println( "name:" +  LG.loadname);
			System.out.println( "ace:" +  LG.score_id);
//			lblfVal.setText(rs.getString("fName"));
//			lbllVal.setText(rs.getString("lName"));
//			lblaVal.setText(rs.getString("Address"));
//			lblsVal.setText(rs.getString("Salary"));
//		
//			txtFname.setText(lblfVal.getText());
//			txtLname.setText(lbllVal.getText());
//			txtAddress.setText(lblaVal.getText());
//			txtSalary.setText(lblsVal.getText());
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
