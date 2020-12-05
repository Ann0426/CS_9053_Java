package game;

import java.awt.BorderLayout;
import java.awt.EtchedBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;



public class YahtzeeFrame extends JFrame {
	
	private JLabel playerName, UpScore,UpBonus,UpGrand, UpSec,YahBon,TotalLowSec,GrandTotal;
    private JTextField nameField,AceTxt, TwosTxt, ThreesTxt, FoursTxt, FivesTxt, SixesTxt,UpScoreTxt,UpBonusTxt,UpGrandTxt, ThreeOfKindTxt,FourOfKindTxt,FullTxt,SmallTxt,LargeTxt ,YahtzeeTxt,BonTxt,lowSecTxt,GraToTxt;
    private JButton AcesBut, TwosBut, ThreesBut, FoursBut, FivesBut, SixesBut,ThreeOfKind,FourOfKind,Full,Small,Large,Yahtzee;
    private JButton keep1,keep2,keep3,keep4,keep5,Roll;
    private JCheckBox keep1CheckBox,keep2CheckBox,keep3CheckBox,keep4CheckBox,keep5CheckBox;
    ImagePanel imagePanel1, imagePanel2, imagePanel3, imagePanel4,imagePanel5;
    Border raisedbevel;
    TitledBorder Uptitle,DownTitle;

	
	public YahtzeeFrame() {
		JMenuBar menuBar = new JMenuBar(); 
		setJMenuBar(menuBar);
	    menuBar.add(createGameMenu());
	    createPlayerPanel();
	    createLeftPanel();
	    createRightPanel();
	   
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,600);
		
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
	       
	      
	       final int FIELD_WIDTH = 10;
	       AceTxt = new JTextField(FIELD_WIDTH);
	       TwosTxt = new JTextField(FIELD_WIDTH); 
	       ThreesTxt  = new JTextField(FIELD_WIDTH);
	       FoursTxt = new JTextField(FIELD_WIDTH);
	       FivesTxt = new JTextField(FIELD_WIDTH);
	       SixesTxt = new JTextField(FIELD_WIDTH);
	       UpScoreTxt = new JTextField(FIELD_WIDTH);
	       UpBonusTxt = new JTextField(FIELD_WIDTH);
	       UpGrandTxt = new JTextField(FIELD_WIDTH);
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
	       ThreeOfKindTxt = new JTextField(FIELD_WIDTH);
	       FourOfKindTxt = new JTextField(FIELD_WIDTH);
	       FullTxt = new JTextField(FIELD_WIDTH);
	       SmallTxt = new JTextField(FIELD_WIDTH);
	       LargeTxt = new JTextField(FIELD_WIDTH);
	       YahtzeeTxt = new JTextField(FIELD_WIDTH);
	       BonTxt = new JTextField(FIELD_WIDTH);
	       lowSecTxt = new JTextField(FIELD_WIDTH);
	       GraToTxt = new JTextField(FIELD_WIDTH);
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
	     
	       JPanel Rightpanel = new JPanel(new GridLayout(11,1));
	       imagePanel1 = new ImagePanel("die1.png");
	       imagePanel1.scaleImage(0.3);
	       imagePanel2 = new ImagePanel("die1.png");
	       imagePanel2.scaleImage(0.3);
	       imagePanel3 = new ImagePanel("die1.png");
	       imagePanel3.scaleImage(0.3);
	       imagePanel4 = new ImagePanel("die1.png");
	       imagePanel4.scaleImage(0.3);
	       imagePanel5 = new ImagePanel("die1.png");
	       imagePanel5.scaleImage(0.3);
	       keep1CheckBox = new JCheckBox("keep");
	       keep2CheckBox = new JCheckBox("keep");
	       keep3CheckBox = new JCheckBox("keep");
	       keep4CheckBox = new JCheckBox("keep");
	       keep5CheckBox = new JCheckBox("keep");
	       Roll = new JButton("Roll");
	       JPanel RollButpanel = new JPanel();
	       RollButpanel.add(Roll);
	       Rightpanel.add(imagePanel1);
	       Rightpanel.add( keep1CheckBox);
	       Rightpanel.add(imagePanel2);
	       Rightpanel.add( keep2CheckBox);
	       Rightpanel.add(imagePanel3);
	       Rightpanel.add( keep3CheckBox);
	       Rightpanel.add(imagePanel4);
	       Rightpanel.add( keep4CheckBox);
	       Rightpanel.add(imagePanel5);
	       Rightpanel.add( keep5CheckBox);
	       Rightpanel.add( RollButpanel);
	       this.add(Rightpanel,BorderLayout.EAST);
	       
	       
	       
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
	
	
	public static void main(String args[]) {
		YahtzeeFrame yahtzee = new YahtzeeFrame();
		yahtzee.setVisible(true);
	}
}
