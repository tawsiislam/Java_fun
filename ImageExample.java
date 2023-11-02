import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ImageExampleWindow extends JFrame implements ActionListener {

	//Imports images
	ImageIcon less = new ImageIcon("less.png");
	ImageIcon equal = new ImageIcon("equal.png");
	ImageIcon more = new ImageIcon("Greater.png");

	//The JButtons uses the images to show
	JLabel productLabel = new JLabel();
	JLabel answerLabel = new JLabel();
	JLabel totalLabel = new JLabel("You have 0 correct");
	JButton lessButton = new JButton(less);
	JButton equalButton = new JButton(equal);
	JButton moreButton = new JButton(more);

	int playerTotal = 0;
	int a, b, c;

	public ImageExampleWindow() {

		super("Simple Math Game");
		setSize(200, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Container contentArea = getContentPane();
		contentArea.setBackground(Color.white);
		FlowLayout flowManager = new FlowLayout();

		contentArea.setLayout(flowManager);
		lessButton.addActionListener(this);
		equalButton.addActionListener(this);
		moreButton.addActionListener(this);

		contentArea.add(productLabel);
		contentArea.add(answerLabel);
		contentArea.add(lessButton);
		contentArea.add(equalButton);
		contentArea.add(moreButton);
		contentArea.add(totalLabel);
		setContentPane(contentArea);

		newQuestion();
	}

	public void actionPerformed(ActionEvent event) {

		int card;
		if (event.getSource() == lessButton) {
			// Code here will be executed when lessButton is pressed

			if (a * b < c){
				playerTotal++;
			}
			else{
				playerTotal--;
			}
			newQuestion();
			totalLabel.setText("You have " + playerTotal + " correct");
		}

		if (event.getSource() == equalButton) {
			// Code here will be executed when equalButton is pressed
			if (a * b == c){
				playerTotal++;
		}
			else{
				playerTotal--;
		}
			newQuestion();
			totalLabel.setText("You have " + playerTotal + " correct");
		}
		if (event.getSource() == moreButton) {
			// Code here will be executed when newButton is pressed
			if (a * b > c){
				playerTotal++;
			}
			else{
				playerTotal--;
			}
			newQuestion();
			totalLabel.setText("You have " + playerTotal + " correct");
		}
	}

	public void newQuestion() {
		a = (int) Math.ceil(Math.random() * 10);
		b = (int) Math.ceil(Math.random() * 10);
		c = a * b + (int) Math.ceil(Math.random() * 3 - 2);
		productLabel.setText("               " + a + "  *  " + b + "  ? ");
		answerLabel.setText(c + "           ");
	}
}

public class ImageExample {
	public static void main(String[] args) {
		ImageExampleWindow Bob = new ImageExampleWindow();
	}
}