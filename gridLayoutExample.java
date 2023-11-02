import java.awt.*;
import java.awt.event.*; //Import event libraries
import javax.swing.*;

class gridWindow extends JFrame implements ActionListener {
	// Window components used by other method must be declared
	// as class variables

	// Gives an identifier to the image file
	ImageIcon tick = new ImageIcon("tick.png");
	ImageIcon cross = new ImageIcon("cross.png");
	ImageIcon SpadeA = new ImageIcon("SpadeA.png");
	ImageIcon Spade3 = new ImageIcon("Spade3.png");
	ImageIcon Back = new ImageIcon("Back.png");

	// Many interface components can have text and/or Image
	JLabel textLabel = new JLabel("Your text here... ");
	JLabel cardLabel1 = new JLabel(Back);
	JLabel cardLabel2 = new JLabel(Back);
	JButton drawButton = new JButton("Draw", tick);
	JButton resetButton = new JButton("Reset", cross);
	JTextField textBox = new JTextField("", 20);

	// Create three JPanels to divide up the content panel
	JPanel bank = new JPanel(new GridLayout(0, 1, 5, 25));
	JPanel plyr = new JPanel(new GridLayout(0, 1, 5, 45));
	JPanel cards = new JPanel(new GridLayout(1, 2, 5, 25));

	/*
	 * public GridLayout( int rows, int cols, int hgap, int vgap) 
	 * rows - the rows, with the value zero meaning any number of rows 
	 * cols - the columns, with the value zero meaning any number of columns 
	 * hgap - the horizontal gap 
	 * vgap - the vertical gap
	 */

	int cardCount;

	public gridWindow() {
		super("gridLayoutExample");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Container contentArea = getContentPane();
		contentArea.setBackground(Color.white);

		// Add an event listener to both buttons
		drawButton.addActionListener(this);
		resetButton.addActionListener(this);

		// Add components to different panels dependent on the first name
		bank.add(textLabel);
		plyr.add(textBox);
		bank.add(drawButton);
		plyr.add(resetButton);
		cards.add(cardLabel1);
		cards.add(cardLabel2);

		// add panels to different compass points on the whole content area
		contentArea.add("North", plyr);
		contentArea.add("South", bank);
		contentArea.add("Center", cards);
		/*
		 * Areas: North West, Center, East South (this is a part of BorderLayout)
		 */
		setContentPane(contentArea);

		cardCount = 0;
	}

	public void actionPerformed(ActionEvent event) {
		String textString;
		if (event.getSource() == drawButton) {
			// Code here will be executed when drawButton is pressed
			if (cardCount == 0) {
				cardLabel1.setIcon(SpadeA); //Changes the cardLabel1 from Back to SpadeA
				cardCount++;
			} else
				cardLabel2.setIcon(Spade3);
		}
		if (event.getSource() == resetButton) {
			// Code here will be executed when resetButton is pressed
			cardLabel1.setIcon(Back);
			cardLabel2.setIcon(Back);
			cardCount = 0;

		}
	}
}

public class gridLayoutExample {
	public static void main(String[] args) {
		gridWindow Win = new gridWindow();

	}
}