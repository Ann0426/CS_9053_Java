package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RollDice extends JFrame {
	private JButton button;
	private JLabel resultLabel;
	ImagePanel imagePanel1;
	ImagePanel imagePanel2;
	JPanel mainPanel;
	JPanel buttonPanel ;
	JPanel imagePanelleft, imagePanelright ,imagePanel;
	
	Map<Integer,String > hashMap = new HashMap<>();
	int max = 6;
	int min = 1;
	int random_int1; 
	int random_int2 ; 
	   

	
	public RollDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		
		
		
		createMap();
		createButton();
		setupPanels();
		
		setSize(900,550);
		setVisible(true);
		
	
	}
	public void createMap() {
		hashMap.put(1,"die1.png");
		hashMap.put(2,"die2.png");
		hashMap.put(3,"die3.png");
		hashMap.put(4,"die4.png");
		hashMap.put(5,"die5.png");
		hashMap.put(6,"die6.png");
	}
	 
	 public void createButton()
	    {  
	       button = new JButton("Roll Dice");
	 
	       class AddButtonListener implements ActionListener
	       {
	          public void actionPerformed(ActionEvent event)
	          {  
	        	  random_int1 = (int)(Math.random() * (max - min ) + min);
	        	  random_int2 = (int)(Math.random() * (max - min ) + min);
	        	  int sum =  random_int1 +  random_int2 ;
	        	  imagePanel1 = new ImagePanel(hashMap.get(random_int1));
	        	  imagePanel2 = new ImagePanel(hashMap.get(random_int2));
	        	  imagePanelleft.removeAll();
	        	  imagePanelright.removeAll();
	        	  
	        	  mainPanel.removeAll();
	        	 
	        	  imagePanelleft.add(imagePanel1);
	      		  imagePanelright.add(imagePanel2);
//	      		  mainPanel.add(imagePanel);
	      		  imagePanel.add(imagePanelleft);
	      		imagePanel.add(imagePanelright);
	      		 
	      		  mainPanel.add(resultLabel);
	      		  
	      		  
	              resultLabel.setText("Result: " +  sum );
	            
	              mainPanel.add(resultLabel);
	              mainPanel.add(buttonPanel);
	              

	          }            
	       }
	 
	       ActionListener listener = new AddButtonListener();
	       button.addActionListener(listener);
	    }

	
		 
	 
	 
	public void setupPanels() {
		 mainPanel = new JPanel();
		 buttonPanel = new JPanel();
		 imagePanel = new JPanel();
		 imagePanelright = new JPanel();
		 imagePanelleft = new JPanel();
		 random_int1 = (int)(Math.random() * (max - min ) + min);
		 random_int2 = (int)(Math.random() * (max - min ) + min);
		 imagePanel1 = new ImagePanel(hashMap.get(random_int1));
		 imagePanel2 = new ImagePanel(hashMap.get(random_int2));
		 imagePanelright.addMouseListener(new MouseAdapter() {
			@Override
			 public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println("imagePanel1 clicked!");
//			      random_int1 = (int)(Math.random() * (max - min ) + min);
	        	  random_int2 = (int)(Math.random() * (max - min ) + min);
	        	  int sum =  random_int1 +  random_int2 ;
//	        	  imagePanel1 = new ImagePanel(hashMap.get(random_int1));
	        	  imagePanel2 = new ImagePanel(hashMap.get(random_int2));
//	        	  imagePanelleft.removeAll();
	        	  imagePanelright.removeAll();
	        	  
	        	  mainPanel.removeAll();
	        	 
//	        	  imagePanelleft.add(imagePanel1);
	      		  imagePanelright.add(imagePanel2);
//	      		  mainPanel.add(imagePanel);
//	      		  imagePanel.add(imagePanelleft);
	      	  	imagePanel.add(imagePanelright);
	      		 
	      		  mainPanel.add(resultLabel);
	      		  
	      		  
	              resultLabel.setText("Result: " +  sum );
	            
	              mainPanel.add(resultLabel);
	              mainPanel.add(buttonPanel);
	              

				}
		});
		imagePanelleft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println("imagePanel2 clicked!");
				 random_int1 = (int)(Math.random() * (max - min ) + min);
//	        	  random_int2 = (int)(Math.random() * (max - min ) + min);
	        	  int sum =  random_int1 +  random_int2 ;
	        	  imagePanel1 = new ImagePanel(hashMap.get(random_int1));
//	        	  imagePanel2 = new ImagePanel(hashMap.get(random_int2));
	        	  imagePanelleft.removeAll();
	        	  imagePanelright.removeAll();
	        	  
	        	  mainPanel.removeAll();
	        	 
	        	  imagePanelleft.add(imagePanel1);
	      		  imagePanelright.add(imagePanel2);
//	      		  mainPanel.add(imagePanel);
	      		  imagePanel.add(imagePanelleft);
	      		imagePanel.add(imagePanelright);
	      		 
	      		  mainPanel.add(resultLabel);
	      		  
	      		  
	              resultLabel.setText("Result: " +  sum );
	            
	              mainPanel.add(resultLabel);
	              mainPanel.add(buttonPanel);
	              

//	              
			}
		});

		
		buttonPanel.add(button);
		imagePanel.setLayout(new GridLayout(1,2));
	
		
	
		imagePanelleft.add(imagePanel1);
		imagePanelright.add(imagePanel2);
		imagePanel.add(imagePanelleft);
		imagePanel.add(imagePanelright);
		this.add(imagePanel,BorderLayout.NORTH);
//		System.out.print(random_int2);
//		System.out.print(random_int1);
		int sum =  random_int1 +  random_int2 ;
		
		mainPanel.setLayout(new GridLayout(3,1));
		
		resultLabel = new JLabel(
	             "Result: " + sum  );
		
		
		
		mainPanel.add(resultLabel,BorderLayout.CENTER);
		mainPanel.add(buttonPanel);
	
		this.add(mainPanel);
	}
	public static void main(String[] args) {
		RollDice rollDice = new RollDice();
		
	
	}
}
