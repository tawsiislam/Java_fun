import java.awt.*;
import java.awt.event.*; //Import event libraries
import javax.swing.*;

class twoButtonWindow extends JFrame implements ActionListener
{
	//Window components used by other method must be declared 
	//as class variables
	JLabel textLabel = new JLabel ("");
	JButton setButton = new JButton ("Set Text");
	JButton clearButton = new JButton ("Clear Text");
	JTextField textBox = new JTextField ("Your text here...",20); //Input text, write text inside and how many pixels wide
		
	public twoButtonWindow (){
		super("Input Example");
		setSize (300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible (true);
		
		Container contentArea = getContentPane();
		contentArea.setBackground(Color.white);
		
		FlowLayout flowManager = new FlowLayout();
		contentArea.setLayout(flowManager);
		
		setButton.addActionListener(this);
		clearButton.addActionListener(this);
		//Add an event listener to both buttons
		
		contentArea.add(textBox);
		contentArea.add(textLabel);
		contentArea.add(setButton);
		contentArea.add(clearButton);
	
		setContentPane(contentArea);
	}

	public void actionPerformed (ActionEvent event){
		String textString;
		if (event.getSource()== setButton){
			//Code here will be executed when setButton is pressed
			textString = textBox.getText(); //Get the text
			textLabel.setText(textString); //To set the text according to the variable
		}
		if (event.getSource()== clearButton){
			//Code here will be executed when clearButton is pressed
			textString = "Your text here...";
			textLabel.setText("");  
			textBox.setText(textString);
		}
	}
}

public class twoButtonInput {
	public static void main(String[] args) {
		twoButtonWindow Win = new twoButtonWindow();

	}
}
