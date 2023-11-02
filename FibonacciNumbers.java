import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.util.Scanner;

class FibonacciNumbersWindow extends JFrame implements ActionListener {

	JTextArea textArea = new JTextArea("Input your number", 5, 20);
	JButton textButton = new JButton("Start");

	public FibonacciNumbersWindow() {

		super("Area with text");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Container contentArea = getContentPane();
		contentArea.setBackground(Color.gray);
		FlowLayout flowManager = new FlowLayout();

		contentArea.setLayout(flowManager);
		textButton.addActionListener(this);

		contentArea.add(textButton);
		contentArea.add(textArea);
		setContentPane(contentArea);
	}

	public void actionPerformed(ActionEvent event) {
		//Add input to user and edit text output
		if (event.getSource() == textButton) {
			// Call the method
			if(textArea.getText().length()!=0){
				textArea.setText("Det "+Integer.parseInt(textArea.getText())+" talet är: "+CalculateFibonacciNumber(Integer.parseInt(textArea.getText())));
			}
		}

	}

	//n is the N:th Fibonacci number, place in the series
	public int CalculateFibonacciNumber(int n) {
		//an = a(n-1)+ a(n-2)
		//a1=1
		//a2=1
		
		int sum=0;
		if(n==1) return 1;
		else if(n==2) return 1;
		else {
			sum=CalculateFibonacciNumber(n-1)+CalculateFibonacciNumber(n-2);
		}
		return sum;
	}
}

public class FibonacciNumbers {

	public static void main(String[] args) {

		FibonacciNumbersWindow Bob = new FibonacciNumbersWindow();

	}
}
