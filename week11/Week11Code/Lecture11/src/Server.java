
import java.io.*;
import java.net.*;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Server extends JFrame implements Runnable {
	

	// Text area for displaying contents
	JTextArea ta;
    
	public Server() {
		super("Server");
		ta = new JTextArea();
		this.add(ta);

	    setSize(400, 200);
	    Thread t = new Thread(this);
	    t.start();
	}
	
  public void run() {
    
      try {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);

  
        while (true) {
        	  
	        // Listen for a connection request
	        Socket socket = serverSocket.accept();
	  
	        // Create data input and output streams
	        DataInputStream inputFromClient = new DataInputStream(
	          socket.getInputStream());
	        DataOutputStream outputToClient = new DataOutputStream(
	          socket.getOutputStream());
          // Receive radius from the client
          double radius = inputFromClient.readDouble();
  
          // Compute area
          double area = radius * radius * Math.PI;
  
          // Send area back to the client
          outputToClient.writeDouble(area);
  
          ta.append("Radius received from client: " 
              + radius + '\n');
            ta.append("Area is: " + area + '\n'); 

            Thread.sleep(1);
          }
        
      }
      catch(IOException ex) {
        ex.printStackTrace();
      } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    Server s=  new Server();
    s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    s.setVisible(true);
    
  }

}
