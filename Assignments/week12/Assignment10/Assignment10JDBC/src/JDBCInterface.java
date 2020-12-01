import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class JDBCInterface extends JFrame  implements ActionListener {

	private JPanel controlPanel,inputPanel;
	private JTextArea textQueryArea;
	private JTextField lastNameQuery;
	private JButton queryButton;
	JLabel lblFname,lblLname,lblAge,lblCity,lblf,lbll,lbla,lbls;
	JTextField txtFname,txtLname,txtAge,txtCity;
	JButton btnInsert;
	PreparedStatement insertStatement; 
	ResultSet rs ;
	
	
	private Connection conn;
	private PreparedStatement queryStmtLastName;
	
	
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT =500;
	final int AREA_ROWS = 20;
	final int AREA_COLUMNS = 40;
   
   public JDBCInterface() {


		try {
			conn = DriverManager.getConnection("jdbc:sqlite:assignment.db");
			queryStmtLastName = conn.prepareStatement("Select * from People WHERE Last = ?");
			
		} catch (SQLException e) {
			System.err.println("Connection error: " + e);
			System.exit(1);
		}
		
		try
		{
		    // Connect to a database
		    conn = DriverManager.getConnection
		      ("jdbc:sqlite:assignment.db");
		} catch (Exception e) {
			System.exit(0);
		}
		
		/* sets up the prepared statement for SQL inserts */
		String insertSQL = "Insert Into People (Last,First,age,city) " +
				"Values (?,?,?,?)";
		try {
			insertStatement = conn.prepareStatement(insertSQL);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
	
	   createInputPanel();	
	   createControlPanel();
	   queryButton.addActionListener(new QueryButtonListener());

	   textQueryArea = new JTextArea(
	            AREA_ROWS, AREA_COLUMNS);
	   textQueryArea.setEditable(false);
	   
	   /* scrollPanel is optional */
	   JScrollPane scrollPane = new JScrollPane(textQueryArea);
	   JPanel textPanel = new JPanel();
	   textPanel.add(scrollPane);
	   this.add(inputPanel,BorderLayout.NORTH);
	   this.add(textPanel, BorderLayout.SOUTH);
	   this.add(controlPanel, BorderLayout.CENTER);
   }
 private JPanel createInputPanel() {
	   
	   /* you are going to have to create a much more fully-featured layout */
	   
	   inputPanel = new JPanel();
	   
	   lblFname = new JLabel("First Name :");
	   lblLname = new JLabel("Last Name :");
	   lblAge = new JLabel("Age :");
	   lblCity = new JLabel("City :");
		
	   txtFname = new JTextField("",15);//To adjust width
	   txtLname = new JTextField();
	   txtAge = new JTextField();
	   txtCity = new JTextField();
	   JPanel pnlInputNorth = new JPanel(new GridLayout(2,4));
	   JPanel pnlInputSouth = new JPanel();
	   inputPanel.add(pnlInputNorth, BorderLayout.NORTH);
	   inputPanel.add(pnlInputSouth, BorderLayout.CENTER);
	   
	   pnlInputNorth.add(lblFname);
	   pnlInputNorth.add(txtLname);
		
	   pnlInputNorth.add(lblLname);
	   pnlInputNorth.add(txtFname);
		
	   pnlInputNorth.add(lblAge);
	   pnlInputNorth.add(txtAge);
		
	   pnlInputNorth.add(lblCity);
	   pnlInputNorth.add(txtCity);
	   btnInsert = new JButton("Insert");
	   class AddInterestListener implements ActionListener
       {
          public void actionPerformed(ActionEvent event)
          {
        	  insertData();
          }            
       }
 
       ActionListener listener = new AddInterestListener();
	   btnInsert.addActionListener(listener);
	   pnlInputSouth.add(btnInsert);
	   return inputPanel;
 
   }
 private void createMessageBox(String msg)
	{
		JFrame frame = new JFrame("Result");
		JLabel lbl = new JLabel(msg);
		frame.add(lbl);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
 private void clearControls()
	{
		String empty = "";
		
		txtFname.setText(empty);
		txtLname.setText(empty);
		txtAge.setText(empty);
		txtCity.setText(empty);

	}
 private void insertData()
	{
		try
		{

			insertStatement.setString(1, txtFname.getText());
			insertStatement.setString(2, txtLname.getText());
			insertStatement.setString(3, txtAge.getText());
			insertStatement.setString(4, txtCity.getText());
			insertStatement.execute();
			if (txtFname.getText().equals("") |txtLname.getText().equals("") |txtAge.getText().equals("") |txtCity.getText().equals("") ) {
				 JOptionPane.showMessageDialog(null,"All fields must be filled");
			}
			else {
			createMessageBox("Inserted Successfully");
			clearControls();
			}
		}
		catch(Exception e)
		{
			createMessageBox(e.getMessage());
		}
	}
   private JPanel createControlPanel() {
	   
	   /* you are going to have to create a much more fully-featured layout */
	   
	   controlPanel = new JPanel();
	   
	   JPanel inputPanel = new JPanel();
	   JLabel lbl = new JLabel("Last Name:");
	   inputPanel.add(lbl);
	   lastNameQuery = new JTextField(10);
	   inputPanel.add(lastNameQuery);
	   
	   JPanel buttonPanel = new JPanel();
	   queryButton = new JButton("Execute Query");
	   buttonPanel.add(queryButton);
	   
	   controlPanel.add(inputPanel);
	   controlPanel.add(buttonPanel);
	   
	   return controlPanel;
	   
	   
   }
   
   class InsertButtonListener implements ActionListener {
	   public void actionPerformed(ActionEvent event) {
		   /* You will have to implement this */
	   }
   }
   
   class QueryButtonListener implements ActionListener {
	   public void actionPerformed(ActionEvent event)
       {
		   /* as far as the columns, it is totally acceptable to
		    * get all of the column data ahead of time, so you only
		    * have to do it once, and just reprint the string
		    * in the text area.
		    */
		   
		   /* you want to change things here so that if the text of the 
		    * last name query field is empty, it should query for all rows.
		    * 
		    * For now, if the last name query field is blank, it will execute:
		    * SELECT * FROM People WHERE Last=''
		    * which will give no results
		    */
		   try {
			   textQueryArea.setText("");
			   PreparedStatement stmt = queryStmtLastName;
			   String lastNameText = lastNameQuery.getText();
			   if(lastNameText.equals("")) {
				   stmt =  conn.prepareStatement("Select * from People");
			   }else {
				   stmt.setString(1, lastNameText);
			   }
				ResultSet rset = stmt.executeQuery();
				ResultSetMetaData rsmd = rset.getMetaData();
				System.out.println(rset.getMetaData());
				int numColumns = rsmd.getColumnCount();
				

				System.out.println("numcolumns is "+ numColumns);
	
				String rowString = "";
				for (int i = 1; i <= numColumns ; i++)
				{
				   rowString += rsmd.getColumnLabel(i)+ "                      ";
				    
				}
				rowString += '\n';
				while (rset.next()) {
					for (int i=1;i<=numColumns;i++) {
						Object o = rset.getObject(i);
						rowString += o.toString() + "\t";
					}
					rowString += "\n";
				}
				
				textQueryArea.setText(  rowString);
		   } catch (SQLException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   }
       }
   }
    
   public static void main(String[] args)
	{  
	   JFrame frame = new JDBCInterface();
	   frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setVisible(true);      
	}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
