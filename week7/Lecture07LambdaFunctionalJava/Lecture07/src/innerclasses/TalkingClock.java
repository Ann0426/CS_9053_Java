package innerclasses;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TalkingClock {

	private int interval;
	private boolean beep;
	
	public TalkingClock (int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
		
	}
	
	public void start() {
		TimePrinter listener = new TimePrinter();
		Timer timer = new Timer(interval, listener);
		timer.restart();
	}
	
	public class TimePrinter implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
			System.out.println("Interval is " + interval);
			if (beep) Toolkit.getDefaultToolkit().beep();
		}
		
		
	}
	
	public static void main(String[] args) {
		TalkingClock tc = new TalkingClock(1000, false);
		tc.start();
		JOptionPane.showMessageDialog(null, "Quit Program?");
		System.exit(0);
	}
}
