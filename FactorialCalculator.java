import java.awt.*;
import java.awt.event.*; //Import event libraries
import javax.swing.*;

class FactorialCalculatorWindow extends JFrame implements ActionListener
{

	JTextArea textArea = new JTextArea("", 5, 20);
	JButton StartButton = new JButton("Start");
	
	int counter = 0;
	
	public FactorialCalculatorWindow (){
		super("Area with text");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Container contentArea = getContentPane();
		contentArea.setBackground(Color.gray);
		FlowLayout flowManager = new FlowLayout();

		contentArea.setLayout(flowManager);
		StartButton.addActionListener(this);

		contentArea.add(StartButton);
		contentArea.add(textArea);
		setContentPane(contentArea);
	}

	public int Faculty(int n){
		int product=0;
		if(n==1) return 1; //Our last number that put a limit to this 
		else{
			product=n*Faculty(n-1); //Multiply current number with the number lower by one
		}
		return product;
	}
	
	public int Permutation(int n,int r) {
		// Combination=Permutation(n,n-k)
		
		int qoutien=0;
		qoutien=Faculty(n)/Faculty(n-r);	
		return qoutien;
	}
	
	public int Combination (int n, int k){
		int qoutien=0;
		qoutien=Permutation(n,k)/Faculty(k);
		return qoutien;
	}
	
	public void actionPerformed (ActionEvent event){
		if (event.getSource()== StartButton){
			textArea.setText("The combination is: "+Combination(7,3)+
					"\nThe permutation is: "+Permutation(7,3));
		}
		
		
	}
}

public class FactorialCalculator {
	public static void main(String[] args) {
		FactorialCalculatorWindow bob = new FactorialCalculatorWindow();
	}
}
