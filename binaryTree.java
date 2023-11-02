import java.awt.*;
import java.awt.event.*; 
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;

class bTreeDemoWindow extends JFrame implements ActionListener
{
	static class Node {	//Form of object orientation 
		  Node left;
		  Node right;
		  int value;
		  public Node(int value) {
			  this.value = value;
			  }
		  }
	
	static Node rootnode = new Node(50);
	
	Queue<String> valuesQueue = new LinkedList<String>();
	
	boolean FoundNode=false;
	
	ImageIcon add = new ImageIcon("add.png");
	ImageIcon out = new ImageIcon("out.png");
	JButton addButton = new JButton ("add", add);
	JButton searchButton = new JButton ("search");
	JButton preOrderButton = new JButton ("Pre Order ", out);
	JButton inOrderButton = new JButton ("In Order ", out);
	JButton postOrderButton = new JButton ("Post Order ", out);
	JLabel textLabel = new JLabel ("Enter Element:");
	JLabel searchLabel = new JLabel ("Search Element:");
	JTextField textBox = new JTextField ("50",10);
	JTextField searchBox = new JTextField("",10);
	JTextArea textArea1 = new JTextArea(20,5);
	JScrollPane textPane1 = new JScrollPane (textArea1);
	
	JLabel textLabelConsole = new JLabel ("Console output:");
	JLabel textLabelConsoleOutput = new JLabel ("");
	
	JPanel centre = new JPanel(new GridLayout(1,2));
	JPanel top = new JPanel(new GridLayout(3,3));
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
		searchButton.addActionListener(this);
		preOrderButton.addActionListener(this);
		inOrderButton.addActionListener(this);
		postOrderButton.addActionListener(this);

		top.add(textLabel);
		top.add(textBox);
		top.add(addButton);
		top.add(searchLabel);
		top.add(searchBox);
		top.add(searchButton);
		top.add(preOrderButton);
		top.add(inOrderButton);
		top.add(postOrderButton);
		centre.add(textPane1);
		bottom.add(textLabelConsole);
		bottom.add(textLabelConsoleOutput);
		
		contentArea.add("North",top);
		contentArea.add("Center",centre);
		contentArea.add("South",bottom);
		textBox.grabFocus();	//Automatically goes back to the textarea
		textBox.selectAll();	
		setContentPane(contentArea);
		getRootPane().setDefaultButton(addButton);
	}

	public void actionPerformed (ActionEvent event){		
		if (event.getSource()== addButton ){
			String value = textBox.getText();
			valuesQueue.offer(textBox.getText());
			int num = Integer.valueOf(value);
			insert (rootnode, num);	//Calls for the first value
			textBox.setText("");
			textBox.grabFocus();
		}
		if(event.getSource()==searchButton){
			String value = searchBox.getText();
			int num = Integer.valueOf(value);
			SearchNode(rootnode,num);
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
			if (node.left == null) { //Checks if there is a node to the left
				consoleOutput = "Inserted " + value +  " to left of node " + node.value;
				node.left = new Node(value);	//We create a new node with the inserted value
			} else {
				insert(node.left, value);	//Our current node becomes temporary new root node
			}
		} else if (value > node.value) { //Checks on the right side
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
	public void SearchNode(Node node, int value){
		if(value==node.value){	//Checks if the node matches with the value we are searching
			textArea1.append("Found "+value+"\n");
			FoundNode=true;
		}
		else if(node.left==null&&node.right==null){
			textArea1.setText("Element "+value+" does not exist\n");
		}
		else if(value<node.value){	//If the node is larger than searched value, we go to the left
			textArea1.append("Left of "+node.value +"; ");
			SearchNode(node.left,value);			
		}
		else {	//Else the node is smaller than the value and we got to the right
			textArea1.append("Right of "+node.value +"; ");
			SearchNode(node.right,value);
		}
	}
	public void RemoveNode(Node node, int value){
		SearchNode(node,value);
		if(FoundNode){
			valuesQueue.peek();
		}
	}
}

public class binaryTree {
	public static void main(String[] args) {
		bTreeDemoWindow Win = new bTreeDemoWindow();
	}
}	


