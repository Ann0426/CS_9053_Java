package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel(String img) {

		this(new ImageIcon(img).getImage());
	}
	
	public ImagePanel(Image img) {
		this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        /*setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);*/
        setLayout(null);
	}
    public void paintComponent(Graphics g) {
		System.out.println("paintComponent() called");
		g.drawImage(img, 50, 0, null);
    }

	// added left
	public void repaintLeft(Graphics graphics) {
//		graphics.clearRect(50, 0, 200, 100);
		graphics.drawImage(img, 50, 21, null);
	}
	// added right
	public void repaintRight(Graphics graphics) {
		graphics.drawImage(img, 350, 21, null);
	}
}
