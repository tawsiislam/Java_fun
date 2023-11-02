import java.awt.*;
import java.awt.event.*; //Import event libraries
import javax.swing.*;

class pushButtonWindow extends JFrame implements ActionListener
{
	//Window components used by other method must be declared 
	//as class variables
	JLabel textLabel = new JLabel ("Your text here... ");
	JButton pushButton = new JButton ("Set Text");
	
	int counter = 0;
	
	public pushButtonWindow (){
		super("Input Example");
		setSize (300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible (true);
		Container contentArea = getContentPane();
		contentArea.setBackground(Color.white);
		FlowLayout flowManager = new FlowLayout();
		contentArea.setLayout(flowManager);

		//Add an event listener to the button
		pushButton.addActionListener(this);
		
		contentArea.add(textLabel);
		contentArea.add(pushButton);
		setContentPane(contentArea);
	}

	public void actionPerformed (ActionEvent event){
		if (event.getSource()== pushButton){
			//Code here will be executed when pushButton is pressed
			counter++;
			textLabel.setText("You have pressed the button " + counter + " number of times");
		}
	}
}

public class pushButton {
	public static void main(String[] args) {
		pushButtonWindow Win = new pushButtonWindow();
	}
}