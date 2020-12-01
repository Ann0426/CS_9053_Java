package callbacks;
import java.awt.Toolkit;
import java.awt.event.*;
import java.time.Instant;
import javax.swing.Timer;

/* ActionListener interface:
 
 public interface ActionListener {
 	void actionPerformed(ActionEvent event);
}
  
 */

/* java.swing.Timer:
 * 
 javax.swing.Timer.Timer(int delay, ActionListener listener)

Creates a Timer and initializes both the initial delay and between-event delay to delay milliseconds. If delay is less than or equal to zero, the timer fires as soon as it is started. If listener is not null, it's registered as an action listener on the timer.

Parameters:
delay milliseconds for the initial and between-event delay
listener an initial listener; can be null
See Also:
addActionListener
setInitialDelay
setRepeats

 */

public class TimePrinter implements ActionListener {

	
	public void actionPerformed(ActionEvent event) {
		/* event is the parameter that's passed when an event is triggered */
		System.out.println("Event source: " + event.getSource());
	}
	
	public static void main(String[] args) {
		TimePrinter listener = new TimePrinter();
		Timer t = new Timer(1000, listener);

		t.addActionListener(listener);
		t.start();

	}
		
}

/* Listener as a lambda:
 * 
  Timer t = new Timer(1000, (e) -> { System.out.println("At the tone, the time is " + Instant.ofEpochMilli(e.getWhen()));
 
										Toolkit.getDefaultToolkit().beep();});
*/
