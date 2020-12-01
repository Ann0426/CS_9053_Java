import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.util.Scanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
class WordFinder extends JFrame {
	 private JLabel findLabel;
	 private JTextField findField;
	 private JButton button;
	 Scanner scan;
	 JTextArea  textAreaField;

	

	JFileChooser jFileChooser;
	private JPanel topPanel; // the top line of objects is going to go here
	WordList wordList;
	JList list;
	private JTextArea wordsBox; // results of the search go in here.
	
	

	public WordFinder() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set the size correctly
		this.setSize(500, 300);
		jFileChooser = new JFileChooser(".");
		wordList = new WordList();

		JPanel panelForTextFields = new JPanel();
		panelForTextFields.setSize(400, 180);


		//panel at the top
		topPanel = new JPanel();
		
		
		// there should be objects in the top panel
		JMenuBar menuBar = new JMenuBar();     
	    setJMenuBar(menuBar);
	    menuBar.add(createFileMenu());
	
		
	// There should probably be something passed into the JScrollPane

//		model = new DefaultListModel();
//		list = new JList(model);

		// and of course you will want them to be properly aligned in the frame
	    createFindField();
	    createButton();
	    createPanel();
	    createScroll();
	   
	     
	     
	}
	public void createScroll() {
		final int AREA_ROWS = 10;
	    final int AREA_COLUMNS = 50;

	    textAreaField = new JTextArea(
	            AREA_ROWS, AREA_COLUMNS);
	      textAreaField.setEditable(false);
	      JScrollPane scrollPane = new JScrollPane(textAreaField) ;
	      add(scrollPane,BorderLayout.SOUTH);
	}
	 public void createFindField()
	    {
	       findLabel = new JLabel("Find: ");
	       final int FIELD_WIDTH = 10;
	       findField = new JTextField(FIELD_WIDTH);
	       findField.setText("");
	       class FindListener implements DocumentListener {

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					List a1 = wordList.find(findField.getText());
					
					textAreaField.setText("");
		    		
					for (int i=0;i<a1.size();i++) {  
				    	textAreaField.append(a1.get(i).toString() + "\n");
					}		
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					List a1 = wordList.find(findField.getText());
					
					textAreaField.setText("");
		    		
					for (int i=0;i<a1.size();i++) {  
				    	textAreaField.append(a1.get(i).toString() + "\n");
					}
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					List a1 = wordList.find(findField.getText());
					
					textAreaField.setText("");
		    		
					for (int i=0;i<a1.size();i++) {  
				    	textAreaField.append(a1.get(i).toString() + "\n");
					}
				}
			}
	       DocumentListener  listener = new FindListener();
		  findField.getDocument().addDocumentListener(listener);
	    }
	 
    public void createButton()
    {  
       button = new JButton("Clear");
 
       class AddClearListener implements ActionListener
       {
          public void actionPerformed(ActionEvent event)
          {
            
             findField.setText(" ");
          }            
       }
 
       ActionListener listener = new AddClearListener();
       button.addActionListener(listener);
    }
	    
    public void createPanel()
    {
       JPanel panel = new JPanel();
       panel.add(findLabel);
       panel.add(findField);
       panel.add(button);   
       add(panel);
       
    }
	   
	public JMenu createFileMenu()
	   {
	      JMenu menu = new JMenu("File");
	      menu.add(createFileOpenItem());
	      menu.add(createFileExitItem());
	      return menu;
	   }
	 public JMenuItem createFileExitItem()
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

	 public JMenuItem createFileOpenItem(){
		  JMenuItem item = new JMenuItem("Open"); 
		  class OpenActionListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					OpenFileListener myFileListener = new OpenFileListener();
					myFileListener.actionPerformed(e);
				}
			}
		  ActionListener listener = new OpenActionListener();
		  item.addActionListener(listener);
		  return item;
	}
	   
		/* add a "File" menu with:
		 * "Open" item which allows you to choose a new file
		 * "Exit" item which ends the process with System.exit(0);
		 * Key shortcuts are optional
		 */
		
		/* OpenActionListener that will open the file chooser
		*/

	private void find(){
		List searchResult = null; // figure out from WordList how to get this

		// you're going to want to get the words in the
		// searchResult list and put them in the textbox.
	}
  	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int returnVal = jFileChooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					System.out.println("You chose to open this file: " + jFileChooser.getSelectedFile().getAbsolutePath());

					InputStream in = new FileInputStream(jFileChooser.getSelectedFile().getAbsolutePath());
					wordList.load(in);
					wordList.getWords();
					for (int i=0;i<wordList.getWords().size();i++) {
					   
					    	textAreaField.append(wordList.getWords().get(i).toString() + "\n");
							
					    
					}
					
					

					List searchResult = null;} // figure out from WordList how to get this
					// because you will load in a wordlist and there
					// might be data in the search box
			

				 catch (IOException error){
					error.printStackTrace();
				}
			}
		}}
	
	


	public static void main(String[] args) {

		WordFinder wordFinder = new WordFinder();
		wordFinder.setVisible(true);
		
		 
	           
	}
}
