package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsFeatures extends JFrame {

	public GraphicsFeatures() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		setupPanels();
		setSize(900,200);
		setVisible(true);
	}
	
	public void setupPanels() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1,3));
		PaintPanel paintPanel = new PaintPanel();
		Dimension size = new Dimension(200,180);
		paintPanel.setPreferredSize(size);
		paintPanel.setMinimumSize(size);
		paintPanel.setMaximumSize(size);
		paintPanel.setSize(size);
		mainPanel.add(paintPanel);
		LinesRectsOvalsJPanel lrojp = new LinesRectsOvalsJPanel();
		mainPanel.add(lrojp);
		ImagePanel imagePanel = new ImagePanel("die1.png");
		mainPanel.add(imagePanel);
		this.add(mainPanel);
	}
	
	public static void main(String[] args) {
		GraphicsFeatures graphicsFeatures = new GraphicsFeatures();
	
	}
}
