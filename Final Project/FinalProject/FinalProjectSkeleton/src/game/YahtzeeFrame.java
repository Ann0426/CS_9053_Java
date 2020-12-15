package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.EventListenerList;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;






public class YahtzeeFrame extends JFrame  implements YahtzeeConstant{
	
	private JLabel playerName, UpScore,UpBonus,UpGrand, YahBon,TotalLowSec,GrandTotal;
	private JTextField nameField;
    private JLabel AceTxt, TwosTxt, ThreesTxt, FoursTxt, FivesTxt, SixesTxt,UpScoreTxt,UpBonusTxt,UpGrandTxt, ThreeOfKindTxt,FourOfKindTxt,FullTxt,SmallTxt,LargeTxt ,YahtzeeTxt,BonTxt,lowSecTxt,GraToTxt;
    private JButton AcesBut, TwosBut, ThreesBut, FoursBut, FivesBut, SixesBut;
    private JRadioButton ThreeOfKind,FourOfKind,Full,Small,Large,Yahtzee;
    private JButton keep1,keep2,keep3,keep4,keep5,Roll;
    private JCheckBox keep1CheckBox,keep2CheckBox,keep3CheckBox,keep4CheckBox,keep5CheckBox;
    ImagePanel imagePanel1, imagePanel2, imagePanel3, imagePanel4,imagePanel5;
    JPanel Rightpanel;
    Border raisedbevel;
    TitledBorder Uptitle,DownTitle;
	Map<Integer,String > hashMap = new HashMap<>();
	int max = 6;
	int min = 1;
	int[] random_int = new int[N_DICE]; 
	int count = 0 ,lowbonus = 0,grandTotal ;
	ButtonGroup group;
	static int[] categoriesScore = new int[N_SCORING_CATEGORIES];
	int BONUS_VALUE = 35;
	int BONUS_THRESHOLD = 63;
	int sum = 0;
	int Grandtotal = 0;
	int Bonus = 0;
	String host = "localhost";
	JPanel panelLoadGame ;
	JLabel scoreId, player;
	JButton LoadGame;
	JTextField scoreIdtxt, playertxt;
	String loadname;
	int score_id;
	LoadGame LG;
	ResultSet rs ;
	JTextArea RecordBox;
	JFrame frameList;


	

	
	public YahtzeeFrame() {
		createMap();
		JMenuBar menuBar = new JMenuBar(); 
		setJMenuBar(menuBar);
	    menuBar.add(createGameMenu());
	    createPlayerPanel();
	    createLeftPanel();
	    createRightPanel();
	   
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,620);
		
	}
	public JMenu createGameMenu()
	   {
	      JMenu menu = new JMenu("Game");
	      menu.add(createLoadItem("Load Game"));
	      menu.add(createSaveItem("Save Game"));
	      menu.add(createExitItem("Exit"));
	      return menu;
	   }  
	 public void createPlayerPanel()
	    {
	       JPanel playerpanel = new JPanel();
	       playerName = new JLabel("Player Name: ");
	       final int FIELD_WIDTH = 20;
	       nameField = new JTextField(FIELD_WIDTH);
	       playerpanel.add(playerName);
	       playerpanel.add(nameField); 
	       this.add(playerpanel, BorderLayout.NORTH);
	    }
	 public void createLeftPanel()
	    {
	       JPanel Leftpanel = new JPanel();
	       JPanel UpperLeftpanel = new JPanel(new GridLayout(9,2));
	       JPanel LowerLeftpanel = new JPanel(new GridLayout(9,2));
   
	       AceTxt = new JLabel();
	       TwosTxt = new JLabel(); 
	       ThreesTxt  = new JLabel();
	       FoursTxt = new JLabel();
	       FivesTxt = new JLabel();
	       SixesTxt = new JLabel();
	       UpScoreTxt = new JLabel();
	       UpBonusTxt = new JLabel();
	       UpGrandTxt = new JLabel();
	       UpScore = new JLabel("Score Subtotal ");
	       UpBonus  = new JLabel("Bonus ");
	       UpGrand = new JLabel("GrandTotal ");
	       AcesBut = new JButton("Aces");
	       TwosBut = new JButton("Twos"); 
	       ThreesBut = new JButton("Threes"); 
	       FoursBut = new JButton("Fours");
	       FivesBut = new JButton("Fives");
	       SixesBut = new JButton("Sixes");
	       UpperLeftpanel.add(AcesBut);
	       UpperLeftpanel.add(AceTxt);
	       UpperLeftpanel.add(TwosBut);
	       UpperLeftpanel.add( TwosTxt);
	       UpperLeftpanel.add(ThreesBut);
	       UpperLeftpanel.add(ThreesTxt);
	       UpperLeftpanel.add(FoursBut);
	       UpperLeftpanel.add(FoursTxt);
	       UpperLeftpanel.add(FivesBut);
	       UpperLeftpanel.add(FivesTxt);
	       UpperLeftpanel.add(SixesBut);
	       UpperLeftpanel.add(SixesTxt);
	       UpperLeftpanel.add(UpScore);
	       UpperLeftpanel.add( UpScoreTxt);
	       UpperLeftpanel.add(UpBonus);
	       UpperLeftpanel.add(UpBonusTxt);
	       UpperLeftpanel.add(UpGrand);
	       UpperLeftpanel.add(UpGrandTxt);
	    
	       
	       class ChoiceListener implements ActionListener
	       {  
	          public void actionPerformed(ActionEvent event)
	          {  
	        	  if (ThreeOfKind.isSelected()) { 
	     			 grandTotal = categoriesScore[6] + sum;}
	        	    
	     	      else if (FourOfKind.isSelected()) 
	     	    	  {grandTotal =  categoriesScore[7] + sum;}
	     	      else if (Full.isSelected()) 
	     	    	  {grandTotal =  categoriesScore[8] + sum;}
	     	      else if (Small.isSelected()) 
	     	    	  {grandTotal =  categoriesScore[9] + sum;}
	     	      else if (Large.isSelected()) 
	     	    	  {grandTotal =  categoriesScore[10] + sum;}
	     	      else if (Yahtzee.isSelected()) 
	     	    	  {grandTotal =  categoriesScore[11] + sum;}
	        	  GraToTxt.setText("Score: " +  grandTotal);
	          }
	       }
	    
	       ActionListener listener = new ChoiceListener();
	       ThreeOfKind =new JRadioButton("3 of a kind");	
	       ThreeOfKind.addActionListener(listener);
	       FourOfKind = new JRadioButton("4 of a kind");
	       FourOfKind.addActionListener(listener);
	       Full = new JRadioButton("Full House");
	       Full.addActionListener(listener);
	       Small = new JRadioButton("Small Straight");
	       Small.addActionListener(listener);
	       Large = new JRadioButton("Large Straight");
	       Large.addActionListener(listener);
	       Yahtzee = new JRadioButton("Yahtzee");
	       Yahtzee.addActionListener(listener);
	       group = new ButtonGroup();
	       group.add(ThreeOfKind);
	       group.add(FourOfKind);
	       group.add(Full);
	       group.add(Small);
	       group.add(Large);
	       group.add(Yahtzee);
	       YahBon = new JLabel("Yahtzee Bonus ");
	       TotalLowSec = new JLabel("Sum of lower section dice ");
	       GrandTotal = new JLabel("Grand Total ");
	       ThreeOfKindTxt = new JLabel();
	       FourOfKindTxt = new JLabel();
	       FullTxt = new JLabel();
	       SmallTxt = new JLabel();
	       LargeTxt = new JLabel();
	       YahtzeeTxt = new JLabel();
	       
	   
  	       
	       BonTxt = new JLabel();
	       lowSecTxt = new JLabel();
	       GraToTxt = new JLabel();
	       LowerLeftpanel.add(ThreeOfKind);
	       LowerLeftpanel.add(ThreeOfKindTxt);
	       LowerLeftpanel.add(FourOfKind);
	       LowerLeftpanel.add(FourOfKindTxt);
	       LowerLeftpanel.add(Full);
	       LowerLeftpanel.add(FullTxt);
	       LowerLeftpanel.add( Small);
	       LowerLeftpanel.add( SmallTxt);
	       LowerLeftpanel.add(Large);
	       LowerLeftpanel.add(LargeTxt );
	       LowerLeftpanel.add(Yahtzee);
	       LowerLeftpanel.add(YahtzeeTxt );
	       LowerLeftpanel.add(YahBon);
	       LowerLeftpanel.add(BonTxt);
	       LowerLeftpanel.add(TotalLowSec);
	       LowerLeftpanel.add( lowSecTxt);
	       LowerLeftpanel.add(GrandTotal);
	       LowerLeftpanel.add( GraToTxt);
	       
	      
	       
	       raisedbevel = BorderFactory.createRaisedBevelBorder();
	       UpperLeftpanel.setBorder(raisedbevel);
	       Uptitle = BorderFactory.createTitledBorder("Upper Section");
	       UpperLeftpanel.setBorder(Uptitle);
	       LowerLeftpanel.setBorder(raisedbevel);
	       DownTitle = BorderFactory.createTitledBorder("Lower Section");
	       LowerLeftpanel.setBorder(DownTitle);
	       Leftpanel.setLayout(new BorderLayout());
	       Leftpanel.add(UpperLeftpanel, BorderLayout.NORTH);
	       Leftpanel.add(LowerLeftpanel, BorderLayout.SOUTH);
	       this.add(Leftpanel,BorderLayout.WEST);
	       
	         
	    }


	 public void createRightPanel()
	    {
	     
	       Rightpanel = new JPanel(new GridLayout(11,1));
	       JPanel imagePanel1panel = new JPanel();JPanel keep1CheckBoxpanel = new JPanel();
	       JPanel imagePanel2panel = new JPanel();JPanel keep2CheckBoxpanel = new JPanel();
	       JPanel imagePanel3panel = new JPanel(); JPanel keep3CheckBoxpanel = new JPanel();
	       JPanel imagePanel4panel = new JPanel(); JPanel keep4CheckBoxpanel = new JPanel();
	       JPanel imagePanel5panel = new JPanel(); JPanel keep5CheckBoxpanel= new JPanel();
	       
	       imagePanel1 = new ImagePanel("die1.png");imagePanel1.scaleImage(0.25);
	       imagePanel2 = new ImagePanel("die2.png");imagePanel2.scaleImage(0.25);
	       imagePanel3 = new ImagePanel("die3.png");imagePanel3.scaleImage(0.25);
	       imagePanel4 = new ImagePanel("die4.png");imagePanel4.scaleImage(0.25);
	       imagePanel5 = new ImagePanel("die5.png");imagePanel5.scaleImage(0.25);
	      
	       keep1CheckBox = new JCheckBox("keep");
	       keep2CheckBox = new JCheckBox("keep");
	       keep3CheckBox = new JCheckBox("keep");
	       keep4CheckBox = new JCheckBox("keep");
	       keep5CheckBox = new JCheckBox("keep");
	      
	       imagePanel1panel.add(imagePanel1); keep1CheckBoxpanel.add(keep1CheckBox );
	       imagePanel2panel.add(imagePanel2); keep2CheckBoxpanel.add(keep2CheckBox );
	       imagePanel3panel.add(imagePanel3);keep3CheckBoxpanel.add(keep3CheckBox );
	       imagePanel4panel.add(imagePanel4);keep4CheckBoxpanel.add(keep4CheckBox );
	       imagePanel5panel.add(imagePanel5); keep5CheckBoxpanel.add(keep5CheckBox );

	       Roll = new JButton("Roll");
	       class AddButtonListener implements ActionListener
	       {
	          public void actionPerformed(ActionEvent event)
	          {   
	        	  count++;
      	  			if (count>= 4) {
    	  			JOptionPane.showMessageDialog(null,"Maximum 3 times");
    	  		
    	  			count = 0;
    	  			nameField.setText("");
      	  			}
      	  			else {

	        	  if (!keep1CheckBox.isSelected()){
	        		  random_int[0] = (int)(Math.random() * (max - min ) + min);
	        		  imagePanel1panel.removeAll();
	        		  imagePanel1 = new ImagePanel(hashMap.get( random_int[0]));imagePanel1.scaleImage(0.25);
	        		  imagePanel1panel.add(imagePanel1);imagePanel1panel.revalidate();
	        		  imagePanel1panel.repaint();
	        		  }
	        		  
	        	  if (!keep2CheckBox.isSelected() ) {
	        		  random_int[1] = (int)(Math.random() * (max - min ) + min);
	        		  imagePanel2panel.removeAll();
	        		  imagePanel2 = new ImagePanel(hashMap.get(random_int[1] ));imagePanel2.scaleImage(0.25);
	        		  imagePanel2panel.add(imagePanel2);imagePanel2panel.revalidate();
	        		  imagePanel2panel.repaint();
	        	  }
	        	  if (!keep3CheckBox.isSelected() ) {
	        		  random_int[2]  = (int)(Math.random() * (max - min ) + min);
	        		  imagePanel3panel.removeAll();
	        		  imagePanel3 = new ImagePanel(hashMap.get(random_int[2] ));imagePanel3.scaleImage(0.25);
	        		  imagePanel3panel.add(imagePanel3);imagePanel3panel.revalidate();
	        		  imagePanel3panel.repaint();
	        	  }
	        	  if (!keep4CheckBox.isSelected() ) {
	        		  random_int[3]  = (int)(Math.random() * (max - min ) + min);
	        		  imagePanel4panel.removeAll();
	        		  imagePanel4 = new ImagePanel(hashMap.get(random_int[3] ));imagePanel4.scaleImage(0.25);
	        		  imagePanel4panel.add(imagePanel4);imagePanel4panel.revalidate();
	        		  imagePanel4panel.repaint();
	        	  }
	        	  if (!keep5CheckBox.isSelected() ) {
	        		  random_int[4]  = (int)(Math.random() * (max - min ) + min);
	        		  imagePanel5panel.removeAll();
	        		  imagePanel5 = new ImagePanel(hashMap.get(random_int[4] ));imagePanel5.scaleImage(0.25);
	        		  imagePanel5panel.add(imagePanel5);imagePanel5panel.revalidate();
	        		  imagePanel5panel.repaint();
	        		  
	        		 
	        	  }
	        	  
      	  		}
      	  	
      	  		AceTxt.setText("Score: " + AcesScore(random_int));
      	  		 TwosTxt.setText("Score: " + TwosScore(random_int));
      	  		 ThreesTxt.setText("Score: " + ThreesScore(random_int));
      	  		 FoursTxt.setText("Score: " + FoursScore(random_int));
      	  		 FivesTxt.setText("Score: " + FivesScore(random_int));
      	  		 SixesTxt.setText("Score: " + SixsScore(random_int));
      	  		 UpScoreTxt.setText("Score: " +  UpScore(random_int));
      	  		 UpBonusTxt.setText("Score: " + Bonus(sum));
      	  		 UpGrandTxt.setText("Score: " + Grandtotal);
      	  		 
      	  		 ThreeOfKindTxt.setText("Score: " + ThreeOfKind(random_int));
      	  	     FourOfKindTxt.setText("Score: " + FourOfKind(random_int));
      	  	     FullTxt.setText("Score: " + Full(random_int));
      	  	     SmallTxt.setText("Score: " + small(random_int));
      	  	     LargeTxt.setText("Score: " + Large(random_int));
      	  	     YahtzeeTxt.setText("Score: " + Yahtzee(random_int));
      	  	     BonTxt.setText("Score: " + lowbonus);
      	  	     lowSecTxt.setText("Score: " +chance(random_int));
      	  	     GraToTxt.setText("Score: " +  sum );
//      	  	     ThreeOfKind.setSelected(false);
//      	  	     FourOfKind.setSelected(false);
//      	  	     Full.setSelected(false);
//      	  	     Small.setSelected(false);
//      	  	     Large.setSelected(false);
//      	  	     Yahtzee.setSelected(false);
      	  	     group.clearSelection();
	          }
	       }
	 
	       ActionListener listener = new AddButtonListener();
	       Roll.addActionListener(listener);
	       JPanel RollButpanel = new JPanel();
	       RollButpanel.add(Roll);
	       Rightpanel.add(imagePanel1panel);Rightpanel.add(  keep1CheckBoxpanel);
	       Rightpanel.add( imagePanel2panel);Rightpanel.add( keep2CheckBoxpanel);
	       Rightpanel.add(imagePanel3panel);Rightpanel.add( keep3CheckBoxpanel);
	       Rightpanel.add( imagePanel4panel);Rightpanel.add( keep4CheckBoxpanel);
	       Rightpanel.add(imagePanel5panel);  Rightpanel.add( keep5CheckBoxpanel);
	       Rightpanel.add( RollButpanel);
	       this.add(Rightpanel,BorderLayout.EAST);    
	    }
	 public void createMap() {
			hashMap.put(1,"die1.png");
			hashMap.put(2,"die2.png");
			hashMap.put(3,"die3.png");
			hashMap.put(4,"die4.png");
			hashMap.put(5,"die5.png");
			hashMap.put(6,"die6.png");
		}
	
	    
	public JMenuItem createLoadItem(final String name)
	   {
	      JMenuItem item3 = new JMenuItem(name);      
	      class MenuItemListener implements ActionListener
	      {
	         public void actionPerformed(ActionEvent event)
	         {
	        	 JFrame frame=new JFrame("Load Game");
	        	 JPanel panelLoadGame = new JPanel();
	        	 scoreId = new JLabel("Enter Game Record Id:");
	        	 scoreIdtxt = new JTextField(10);
	        	 player = new JLabel("Enter Player Name:");
	        	 playertxt = new JTextField(10);
	        	 createRecordListPanel();
	        	
	        	
	        	 LoadGame = new JButton("Load Game");
	  	       class AddButtonListener implements ActionListener
	  	       {
	  	          public void actionPerformed(ActionEvent event)
	  	          {  
	  	        	 if (scoreIdtxt.getText().equals("") |playertxt.getText().equals("") ) {createMessageBox("Must filled in player name and id");}
	  	        	 else {loadname = playertxt.getText() ;
	  	      	  	 score_id = Integer.parseInt(scoreIdtxt.getText());
	  	      	  	
	  	      	  	 System.out.print(loadname);
	  	      
	  	      	  	 LG = new LoadGame( loadname,score_id);
	  	      	     getScoreRecord();
	  	      	 frame.dispose();
	  	      	frameList.dispose();
	  	      	 
	  	        	 }
	  	          }
	  	       }
	  	       ActionListener listener = new AddButtonListener();
	  	       LoadGame.addActionListener(listener);
	  	       JPanel RollButpanel = new JPanel();
	  	       RollButpanel.add(LoadGame);
	  	       panelLoadGame.add(scoreId ); panelLoadGame.add(scoreIdtxt);
	  	       panelLoadGame.add(player  );panelLoadGame.add(playertxt  );
	  	       panelLoadGame.add(RollButpanel  );
	  	       frame.add(panelLoadGame);
//	             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	             //set JFrame ssize
	             frame.setSize(200,250);
	             //make JFrame visible. So we can see it
	             frame.setVisible(true);
	          

	       
	         }
	      }      
	      ActionListener listener = new MenuItemListener();
	      item3.addActionListener(listener);
	      return item3;
	   }
	public JMenuItem createSaveItem(final String name)
	   {
	      JMenuItem item2 = new JMenuItem(name);      
	      class MenuItemListener implements ActionListener
	      {
	         public void actionPerformed(ActionEvent event)
	         {
	        	 try {
	        	        // Establish connection with the server
	        	        Socket socket = new Socket(host, 8000);

	        	        // Create an output stream to the server
	        	        ObjectOutputStream toServer =
	        	          new ObjectOutputStream(socket.getOutputStream());
	        	        String nameFieldStr = nameField.getText().trim();

	        	        // Create a Score object and send to the server
	        	        ScoreRecord  s =
	        	          new ScoreRecord( nameFieldStr,
	        	        		  categoriesScore[0], 
	        	        		  categoriesScore[1], 
	        	        		  categoriesScore[2],
	        	        		  categoriesScore[3],
	        	        		  categoriesScore[4],
	        	        		  categoriesScore[5],
	        	        		  sum,
	        	        		  Bonus,
	        	        		  Grandtotal,
	        	        		  categoriesScore[6],
	        	        		  categoriesScore[7],
	        	        		  categoriesScore[8],
	        	        		  categoriesScore[9],
	        	        		  categoriesScore[10],
	        	        		  categoriesScore[11],
	        	        		  lowbonus,
	        	        		  categoriesScore[12],
	        	        		  grandTotal);
	        	        toServer.writeObject(s);
	        	      }
	        	      catch (IOException ex) {
	        	        ex.printStackTrace();
	        	      }
	         }
	      }      
	      ActionListener listener = new MenuItemListener();
	      item2.addActionListener(listener);
	      return item2;
	   }
	public JMenuItem createExitItem(final String name)
	   {
		JMenuItem item = new JMenuItem("Exit");      
	      class MenuItemListener implements ActionListener
	      {
	         public void actionPerformed(ActionEvent event)
	         {
	            System.exit(0);
	         }
	      }      
	      ActionListener listener = new MenuItemListener();
	      item.addActionListener(listener);
	      return item;
	   }

	public  int AcesScore(int[] random_int) {
		categoriesScore[0] = 0;
		for (int i = 0;i < 5; i++) {
			
			if ( random_int[i] == 1) {categoriesScore[0] += random_int[i] ;}
		}
		return categoriesScore[0];
	}
	public  int TwosScore(int[] random_int) {
		categoriesScore[1] = 0;
		for (int i = 0;i < 5; i++) {
			
			if ( random_int[i] == 2) {categoriesScore[1] += random_int[i] ;}
		}
		return categoriesScore[1];
	}
	
	public  int ThreesScore(int[] random_int) {
		categoriesScore[2] = 0;
		for (int i = 0;i < 5; i++) {
			
			if ( random_int[i] == 3) {categoriesScore[2] += random_int[i] ;}
		}
		return categoriesScore[2];
	}
	
	public  int FoursScore(int[] random_int) {
		categoriesScore[3] = 0;
		for (int i = 0;i < 5; i++) {
			
			if ( random_int[i] == 4) {categoriesScore[3] += random_int[i] ;}
		}
		return categoriesScore[3];
	}
	
	public  int FivesScore(int[] random_int) {
		categoriesScore[4] = 0;
		for (int i = 0;i < 5; i++) {
			
			if ( random_int[i] == 5) {categoriesScore[4] += random_int[i] ;}
		}
		return categoriesScore[4];
	}
	public  int SixsScore(int[] random_int) {
		categoriesScore[5] = 0;
		for (int i = 0;i < 5; i++) {
			
			if ( random_int[i] == 6) {categoriesScore[5] += random_int[i] ;}
		}
		return categoriesScore[5];
	}
	public  int UpScore(int[] random_int) {
		sum = 0;
		
		for (int i = 0;i < 5; i++) {	
			sum += categoriesScore[i] ;}
		return sum;
	}
	
	public  int Bonus(int sum) {
		
		if (sum >= 63) {
			Bonus = 35;
			 Grandtotal = sum + 35;
		}
		Grandtotal = sum ;
	return Bonus;
	}
	/** Determines if the dice values are a full house. */
//    private boolean checkFullHouse(int[] rand_int) {
//        // found three of a kind
//        boolean foundThree = false;
//        // found two of a kind
//        boolean foundTwo = false;
//        
//        for (int i = 0; i < N_DICE; i++) {
//            int count = 0;
//            for (int j = 0; j < N_DICE; j++) {
//                if (rand_int[i] == rand_int[j]) {
//                    count++;
//                }
//            }
//            if (count == 3) {
//                foundThree = true;
//            } else if (count == 2) {
//                foundTwo = true;
//            }
//        }
//        if (foundThree && foundTwo) {
//            return true;
//        } else {
//            return false;    
//        }
//    }
	public void getScoreRecord()
	{
		try
		{

			Connection con = DriverManager.getConnection
				      ("jdbc:sqlite:yahtzee.db");
			String sql = "Select * from ScoreRecord where Player = ? and score_id = ? ";
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1,LG.loadname);
			statement.setLong(2,LG.score_id);
			System.out.println( "nameLG:" +  LG.loadname);
			System.out.println( "scoreLG:" +  LG.score_id);

			rs = statement.executeQuery();
			if(!rs.isBeforeFirst()){
				JOptionPane.showMessageDialog(null,"No such name or id");
			}
		
			if (rs != null) {
				System.out.println( "populate controls try");
				 populateRecord();
				
			}
			try { con.close(); } catch (Exception e) { /* ignored */ }
			
			

					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println( "populate controls");
		}
		
		
	
			
		
	}
	public void getAllScoreRecord()
	{
		try
		{

			Connection con = DriverManager.getConnection
				      ("jdbc:sqlite:yahtzee.db");
			String sql = "Select Player, score_id from ScoreRecord ";
			
			PreparedStatement statement1 = con.prepareStatement(sql);
			rs = statement1.executeQuery();
			if(!rs.isBeforeFirst()){
				JOptionPane.showMessageDialog(null,"No records");
			}
			while(rs.next() && !rs.isAfterLast())//After Last was giving invalid cursor state error
			{
				try {
					System.out.print("123:" + rs.getLong("score_id"));
					RecordBox.append("Game_id:" + rs.getLong("score_id") + "  "+"Player:" + rs.getString("Player")+"\n" );
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			 try { con.close(); } catch (Exception e) { /* ignored */ }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println( "populate controls");
		}
	
			
		
		
	}
	
	public void populateRecord()
	{  
		try {
			System.out.print(rs.getLong("Ace"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (LG.loadname != null) {
			try {
				System.out.print(rs);
				nameField.setText( rs.getString("Player"));
				AceTxt.setText("Score: " + rs.getLong("Ace"));
				TwosTxt.setText("Score: " + rs.getLong("Two"));
				ThreesTxt.setText("Score: " + rs.getLong("Three"));
				
	 	  		 FoursTxt.setText("Score: " + rs.getLong("Four"));
	 	  		 FivesTxt.setText("Score: " + rs.getLong("Five"));
	 	  		 SixesTxt.setText("Score: " + rs.getLong("Six"));
	 	  		 UpScoreTxt.setText("Score: " +  rs.getLong("UpSubtotal"));
	 	  		 UpBonusTxt.setText("Score: " + rs.getLong("Bonus"));
	 	  		 UpGrandTxt.setText("Score: " + rs.getLong("UpTotal"));
	 	  		 
	 	  		 ThreeOfKindTxt.setText("Score: " + rs.getLong("ThreeOfKind"));
	 	  	     FourOfKindTxt.setText("Score: " + rs.getLong("FourOfKind"));
	 	  	     FullTxt.setText("Score: " + rs.getLong("Full"));
	 	  	     SmallTxt.setText("Score: " + rs.getLong("Small"));
	 	  	     LargeTxt.setText("Score: " + rs.getLong("Large"));
	 	  	     YahtzeeTxt.setText("Score: " + rs.getLong("Yahtzee"));
	 	  	     BonTxt.setText("Score: " +  rs.getLong("YahtzeeBonus"));
	 	  	     lowSecTxt.setText("Score: " + rs.getLong("lowerSectionTotal"));
	 	  	     GraToTxt.setText("Score: " +  rs.getLong("GrandTotal"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	  	
	


		}
	}
	public void createRecordListPanel() {
		frameList=new JFrame("List of Game Record");
		 RecordBox = new JTextArea(250,250);
		 RecordBox.setEditable(false);
//		 JPanel panelLoadGame = new JPanel();
//		 panelLoadGame.add(RecordBox);

//		frameList.add(panelLoadGame);
		JScrollPane areaScrollPane = new JScrollPane(RecordBox);
		areaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(250, 250));
		frameList.setVisible(true);
		frameList.getContentPane().add(areaScrollPane, BorderLayout.CENTER);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frameList.setSize(250,250);
		frameList.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		RecordBox.append("List of the Records:\n");
		getAllScoreRecord();
	
	

	}
	private void createMessageBox(String msg)
	{
		JFrame frame = new JFrame("Result");
		JLabel lbl = new JLabel(msg);
		frame.add(lbl);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
	public  int ThreeOfKind(int[] random_int) {
		categoriesScore[6] = 0;
		int[] arr = new int[]{0,0,0,0,0,0};
		for (int i = 0;i < 5; i++) {
			arr[ random_int[i]-1 ]+=1;			
		}
		 int max = getMaxValue(arr);
		 if (max >=3) {
			 for(int i = 0;i < 5; i++) {
				 categoriesScore[6] += random_int[i];
			 }
		 }
		
		return categoriesScore[6];
	}
	public  int FourOfKind(int[] random_int) {
		categoriesScore[7] = 0;
		int[] arr = new int[]{0,0,0,0,0,0};
		for (int i = 0;i < 5; i++) {
			arr[ random_int[i]-1 ]+=1;			
		}
		 int max = getMaxValue(arr);
		 if (max >=4) {
			 for(int i = 0;i < 5; i++) {
				 categoriesScore[7] += random_int[i];
			 }
		 }
		
		return categoriesScore[7];
	}
	public  int Full(int[] random_int) {
		categoriesScore[8] = 0;
		int[] arr = new int[]{0,0,0,0,0,0};
		for (int i = 0;i < 5; i++) {
			arr[ random_int[i]-1 ]+=1;			
		}
		 int max = getMaxValue(arr);
		 int min = getMaxValue(arr);
		 if (max == 3 && min == 2) {
			
				 categoriesScore[8] = 25;
		 }
		return categoriesScore[8];
	}
	public  int small(int[] random_int) {
		categoriesScore[9] = 0;
		Arrays.sort(random_int);
		for (int j = 0; j < 4; j++)
		{
			int temp = 0;
			if (random_int[j] == random_int[j + 1])
			{
				temp = random_int[j];

				for (int k = j; k < 4; k++)
				{
					random_int[k] = random_int[k + 1];
				}

				random_int[4] = temp;
			}
		}
		if (((random_int[0] == 1) && (random_int[1] == 2) && (random_int[2] == 3) && (random_int[3] == 4))
				|| ((random_int[0] == 2) && (random_int[1] == 3) && (random_int[2] == 4) && (random_int[3] == 5))
				|| ((random_int[0] == 3) && (random_int[1] == 4) && (random_int[2] == 5) && (random_int[3] == 6))
				|| ((random_int[1] == 1) && (random_int[2] == 2) && (random_int[3] == 3) && (random_int[4] == 4))
				|| ((random_int[1] == 2) && (random_int[2] == 3) && (random_int[3] == 4) && (random_int[4] == 5))
				|| ((random_int[1] == 3) && (random_int[2] == 4) && (random_int[3] == 5) && (random_int[4] == 6)))
		{
				 categoriesScore[9] =30;
		 }
		return categoriesScore[9];
	}
	public  int Large(int[] random_int) {
		categoriesScore[10] = 0;
		Arrays.sort(random_int);
		if (((random_int[0] == 1) && (random_int[1] == 2) && (random_int[2] == 3)
				&& (random_int[3] == 4) && (random_int[4] == 5))
				|| ((random_int[0] == 2) && (random_int[1] == 3) && (random_int[2] == 4)
						&& (random_int[3] == 5) && (random_int[4] == 6)))
		{
				 categoriesScore[10] =40;
		 }
		return categoriesScore[10];
	}
	public  int Yahtzee(int[] random_int) {
		categoriesScore[11] = 0;
		int[] arr = new int[]{0,0,0,0,0,0};
		for (int i = 0;i < 5; i++) {
			arr[ random_int[i]-1 ]+=1;			
		}
		 int max = getMaxValue(arr);
		 if (max == 5) {
				
			 categoriesScore[11] =50;
			 lowbonus += 10;
	 }
		
		
		return categoriesScore[11];
	}
	
	public  int chance(int[] random_int) {
		categoriesScore[12] = 0;
		for (int i = 0;i < 5; i++) {
		 categoriesScore[12] += random_int[i];
	 }	
		return categoriesScore[12];
	}
	
	public static int getMaxValue(int[] numbers){
		  int maxValue = numbers[0];
		  for(int i=1;i < numbers.length;i++){
		    if(numbers[i] > maxValue){
		      maxValue = numbers[i];
		    }
		  }
		  return maxValue;
		}
	public static int getMinValue(int[] numbers){
		  int minValue = numbers[0];
		  for(int i=1;i<numbers.length;i++){
		    if(numbers[i] < minValue){
		      minValue = numbers[i];
		    }
		  }
		  return minValue;
		}
	public static void main(String args[]) {
		YahtzeeFrame yahtzee = new YahtzeeFrame();
		
		yahtzee.setVisible(true);
	}
}
