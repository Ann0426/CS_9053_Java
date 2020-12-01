package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RollDice extends JFrame {
	JPanel mainPanel;
	ImagePanel imagePanelLeft;
	ImagePanel imagePanelRight;
	JLabel totalLabel;

	public int faceLeft;
	public int faceRight;
	public int total;

	public RollDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		setupPanels();
		setSize(600, 800);
		setVisible(true);
	}

	public void setupPanels() {
		// Panel 1
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 2));

		imagePanelLeft = new ImagePanel("PartIV/die1.png");
		imagePanelRight = new ImagePanel("PartIV/die1.png");

		mainPanel.add(imagePanelLeft);
		mainPanel.add(imagePanelRight);

		// Panel 2
		JPanel resultPanel = new JPanel();

		JLabel resultLabel = new JLabel("Result: ");
		totalLabel = new JLabel("##");

		resultPanel.add(resultLabel);
		resultPanel.add(totalLabel);
		resultPanel.setBounds(250, 200, 80, 40);

		// Panel 3
		JPanel buttonPanel = new JPanel();
		JButton rollDiceButton = new JButton("Roll Dice");
		rollDiceButton.addActionListener(new RollDiceListener());

		buttonPanel.add(rollDiceButton);
		buttonPanel.setBounds(240, 230, 100, 100);

		this.add(buttonPanel);
		this.add(resultPanel);
		this.add(mainPanel);

		// add mouse listener for clicking left image
		imagePanelLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println("Left image clicked!");
				// generate random sequence
				int cycleLeft = generateSequence();
				faceLeft = cycleLeft % 6;
				if (faceLeft == 0) {
					faceLeft = 6;
				}
				System.out.println("FaceLeft: " + faceLeft);
				System.out.println("FaceRight: " + faceRight);
				total = faceLeft + faceRight;
				System.out.println("Total Sum: " + total);
				totalLabel.setText(String.valueOf(total));
				imagePanelLeft = new ImagePanel("PartIV/die" + faceLeft + ".png");
				imagePanelLeft.repaintLeft(getGraphics());
			}
		});

		// add mouse listener for clicking right image
		imagePanelRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println("Right image clicked!");
				// generate random sequence
				int cycleRight = generateSequence();
				faceRight = cycleRight % 6;
				if (faceRight == 0) {
					faceRight = 6;
				}
				System.out.println("FaceLeft: " + faceLeft);
				System.out.println("FaceRight: " + faceRight);
				total = faceLeft + faceRight;
				System.out.println("Total Sum: " + total);
				totalLabel.setText(String.valueOf(total));
				imagePanelRight = new ImagePanel("PartIV/die" + faceRight + ".png");
				imagePanelRight.repaintRight(getGraphics());
			}
		});
	}

	public static void main(String[] args) {
		System.out.println("Roll Dice");
		RollDice rollDice = new RollDice();

	}

	public int generateSequence() {
		// get random number from 1 to 100, which is the number of dice cycles
		int random = (int) (Math.random()*100);
		System.out.println("The number of cycle(s): " + random);
		return random;
	}

	private class RollDiceListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// generate random sequence
			int cycleLeft = generateSequence();
			int cycleRight = generateSequence();

			faceLeft = cycleLeft % 6;
			faceRight = cycleRight % 6;
			if (faceLeft == 0) {
				faceLeft = 6;
			}
			if (faceRight == 0) {
				faceRight = 6;
			}
			System.out.println("FaceLeft: " + faceLeft);
			System.out.println("FaceRight: " + faceRight);
			total = faceLeft + faceRight;
			System.out.println("Total Sum: " + total);
			totalLabel.setText(String.valueOf(total));

//			mainPanel.remove(imagePanelLeft);
			imagePanelLeft = new ImagePanel("PartIV/die" + faceLeft + ".png");
			imagePanelLeft.repaintLeft(getGraphics());
			imagePanelRight = new ImagePanel("PartIV/die" + faceRight + ".png");
			imagePanelRight.repaintRight(getGraphics());


			// animation
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException interruptedException) {
//				interruptedException.printStackTrace();
//			}

//			mainPanel.remove(imagePanelLeft);
//			imagePanelLeft = new ImagePanel("PartIV/die3.png");
//			imagePanelLeft.repaint(getGraphics());
		}
	}
}
