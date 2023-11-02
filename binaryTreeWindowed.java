import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

class bTreeDemoWindow extends JFrame implements ActionListener
{
	static class Node {
		  Node left;
		  Node right;
		  int value;
		  public Node(int value) {
			  this.value = value;
			  }
		  }
	
	static Node rootnode = new Node(50);
	
	ImageIcon add = new ImageIcon("add.png");
	ImageIcon out = new ImageIcon("out.png");
	JButton addButton = new JButton ("add", add);
	JButton preOrderButton = new JButton ("Pre Order ", out);
	JButton inOrderButton = new JButton ("In Order ", out);
	JButton postOrderButton = new JButton ("Post Order ", out);
	JLabel textLabel = new JLabel ("Enter Element:");
	JTextField textBox = new JTextField ("50",10);
	JTextArea textArea1 = new JTextArea(20,5);
	JScrollPane textPane1 = new JScrollPane (textArea1);
	
	JLabel textLabelConsole = new JLabel ("Console output:");
	JLabel textLabelConsoleOutput = new JLabel ("");
	
	JPanel centre = new JPanel(new GridLayout(1,2));
	JPanel top = new JPanel(new GridLayout(2,3));
	JPanel bottom = new JPanel (new GridLayout(2,1));

	public bTreeDemoWindow (){
		super("Binary Tree Demo");
		setSize (500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible (true);
		Container contentArea = getContentPane();
		contentArea.setBackground(Color.white);
		textArea1.setEditable(false); 

		addButton.addActionListener(this);
		preOrderButton.addActionListener(this);
		inOrderButton.addActionListener(this);
		postOrderButton.addActionListener(this);

		top.add(textLabel);
		top.add(textBox);
		top.add(addButton);
		top.add(preOrderButton);
		top.add(inOrderButton);
		top.add(postOrderButton);
		centre.add(textPane1);
		bottom.add(textLabelConsole);
		bottom.add(textLabelConsoleOutput);
		
		contentArea.add("North",top);
		contentArea.add("Center",centre);
		contentArea.add("South",bottom);
		textBox.grabFocus();
		textBox.selectAll();	
		setContentPane(contentArea);
		getRootPane().setDefaultButton(addButton);
	}

	public void actionPerformed (ActionEvent event){		
		if (event.getSource()== addButton ){
			String value = textBox.getText();
			int num = Integer.valueOf(value);
			insert (rootnode, num);
			textBox.setText("");
			textBox.grabFocus();
		}
		if (event.getSource()== preOrderButton){
			textArea1.append("Pre Order Traversal \n");
			printPreOrder(rootnode);
			textArea1.append("\n");
		}
		if (event.getSource()== inOrderButton){
			textArea1.append("In Order Traversal \n");
			printInOrder(rootnode);
			textArea1.append("\n");
		}
		if (event.getSource()== postOrderButton){
			textArea1.append("Post Order Traversal \n");
			printPostOrder(rootnode);
			textArea1.append("\n");
		}
	}
	public void insert(Node node, int value) {
		String consoleOutput ="";
		if (value == node.value) consoleOutput = "Tree does not allow duplicate elements";
		if (value < node.value) {
			if (node.left == null) {
				consoleOutput = "Inserted " + value +  " to left of node " + node.value;
				node.left = new Node(value);	
			} else {
				insert(node.left, value);
			}
		} else if (value > node.value) {
			if (node.right == null) {
				consoleOutput = "Inserted " + value + "  to right of node " + node.value;
				node.right = new Node(value);			
			} else {
				insert(node.right, value);
			}
		}
		if(consoleOutput!="") textLabelConsoleOutput.setText(consoleOutput);
	}
	public void printPreOrder(Node node) {
		if (node != null) {
			textArea1.append(node.value +"; ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		 }
	}
	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			textArea1.append(node.value +"; ");
			printInOrder(node.right);
		 }
	}
	public void printPostOrder(Node node) {
		if (node != null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			textArea1.append(node.value +"; ");
		 }
	}
}

public class binaryTree {
	public static void main(String[] args) {
		bTreeDemoWindow Win = new bTreeDemoWindow();
	}
}	


