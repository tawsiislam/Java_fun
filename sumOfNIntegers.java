import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

class sumWindow extends JFrame implements ActionListener
{
	JLabel textLabel = new JLabel ("Number: ");
	JButton sumButton = new JButton ("Sum");
	JTextField inputBox = new JTextField ("",3);
	JTextField outputBox = new JTextField ("",8);
		
	public sumWindow (){
		super("Recursion Example");
		setSize (200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible (true);
		
		Container contentArea = getContentPane();
		contentArea.setBackground(Color.lightGray );		
		FlowLayout flowManager = new FlowLayout();
		contentArea.setLayout(flowManager);
		
		sumButton.addActionListener(this);
		outputBox.setEditable(false);
		
		contentArea.add(textLabel);
		contentArea.add(inputBox);
		contentArea.add(sumButton);
		contentArea.add(outputBox);	
		setContentPane(contentArea);
	}
	
	public void actionPerformed (ActionEvent event){
		if (event.getSource()== sumButton){
			int num = Integer.parseInt (inputBox.getText());
			int sum = calcSum (num);
			outputBox.setText("Sum is " + sum);
		}
	}
	
	public  int calcSum (int num){
	//Recursive algorithm
		int sum=0;
		if (num == 1){
			sum = 1;
		}
		else {
			sum = num + calcSum(num -1);
		}
		return sum;
	}	
	
	/*
	public  int calcSum (int num){
	//Iterative algorithm
		int sum=0;
		while (num>0){
			sum+=num;
			num--;
		}
		return sum;
	} 
	*/
}
public class sumOfNIntegers {
	public static void main(String[] args) {
		sumWindow Win = new sumWindow();
	}
}