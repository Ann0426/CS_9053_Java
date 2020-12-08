package game;

import java.awt.BorderLayout;
import java.awt.EtchedBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import graphics.ImagePanel;
import student.StudentAddress;



public class YahtzeeFrame extends JFrame  implements YahtzeeConstant{
	
	private JLabel playerName, UpScore,UpBonus,UpGrand, YahBon,TotalLowSec,GrandTotal;
	private JTextField nameField;
    private JLabel AceTxt, TwosTxt, ThreesTxt, FoursTxt, FivesTxt, SixesTxt,UpScoreTxt,UpBonusTxt,UpGrandTxt, ThreeOfKindTxt,FourOfKindTxt,FullTxt,SmallTxt,LargeTxt ,YahtzeeTxt,BonTxt,lowSecTxt,GraToTxt;
    private JButton AcesBut, TwosBut, ThreesBut, FoursBut, FivesBut, SixesBut,ThreeOfKind,FourOfKind,Full,Small,Large,Yahtzee;
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
	int count = 0 ;
	int[] scorecard;
	static int[] categoriesScore = new int[N_SCORING_CATEGORIES];
	int BONUS_VALUE = 35;
	int BONUS_THRESHOLD = 63;
	int sum = 0;
	int Grandtotal = 0;
	int Bonus = 0;
	String host = "localhost";

	

	
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
	    
	       ThreeOfKind = new JButton("3 of a kind");
	       FourOfKind = new JButton("4 of a kind");
	       Full = new JButton("Full House");
	       Small = new JButton("Small Straight");
	       Large = new JButton("Large Straight");
	       Yahtzee = new JButton("Yahtzee");
	       YahBon = new JLabel("Yahtzee Bonus ");
	       TotalLowSec = new JLabel("Total of lower section");
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
	          {   count++;
      	  			if (count>= 4) {
    	  			JOptionPane.showMessageDialog(null,"Maximum 3 times");
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
      	  		 
      	  		 ThreeOfKindTxt.setText("Score: " + AcesScore(random_int));
      	  	     FourOfKindTxt.setText("Score: " + TwosScore(random_int));
      	  	     FullTxt.setText("Score: " + ThreesScore(random_int));
      	  	     SmallTxt.setText("Score: " + FoursScore(random_int));
      	  	     LargeTxt.setText("Score: " + FivesScore(random_int));
      	  	     YahtzeeTxt.setText("Score: " + SixsScore(random_int));
      	  	     BonTxt.setText("Score: " +  UpScore(random_int));
      	  	     lowSecTxt.setText("Score: " + Bonus(sum));
      	  	     GraToTxt.setText("Score: " +  Grandtotal);
     	  	
      	  	
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
	      JMenuItem item = new JMenuItem(name);      
	      class MenuItemListener implements ActionListener
	      {
	         public void actionPerformed(ActionEvent event)
	         {
	        	 System.out.print('h');
	         }
	      }      
	      ActionListener listener = new MenuItemListener();
	      item.addActionListener(listener);
	      return item;
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
	        	          new ScoreRecord( nameFieldStr,categoriesScore[0], categoriesScore[1], categoriesScore[2]
	        	        		  ,categoriesScore[3],
	        	        		  categoriesScore[4],
	        	        		  categoriesScore[5],sum,Bonus,Grandtotal,0,0,0,0,0,0,0,0,0);
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

	
	public static void main(String args[]) {
		YahtzeeFrame yahtzee = new YahtzeeFrame();
		
		yahtzee.setVisible(true);
	}
}
