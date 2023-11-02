/* 
Allow your class to access the objects and methods of the Swing Class. The Swing class creates windows 

JLabel 
The object of JLabel class is a component for placing text in a container. It is used to display a single line of read only text. The text can be changed by an application but a user cannot edit it directly. It inherits JComponent class. 
 
JTextArea 
The object of a JTextArea class is a multi line region that displays text. It allows the editing of multiple line text. It inherits JTextComponent class 
*/
import javax.swing.*; 
//Allow your class to access the objects and methods of the awt Class. The Abstract Windowing Toolkit Class create interface components. 
import java.awt.*; 

class Window extends JFrame 
{ 
	//Define Label at class level so that it can be accessed  
	//by all the methods of the class. 
	JLabel textLabel = new JLabel("Hello World!");
	JLabel textLabel2 = new JLabel("And Goodbye!");
	
	public Window() 
	{ 
		//Create your window. 
		super("Hello World program"); 
		setSize(500,300); 	//Width, Height
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		setVisible(true); 
		
		//Create your container. This holds all interface components. contentArea is the name.
		Container contentArea = getContentPane(); 
		//Add a Layout-manager. This decides positioning of interface components. 
		
		FlowLayout flowManager = new FlowLayout (); 
		contentArea.setLayout(flowManager); 
		
		//Create Interface components or adds
		contentArea.add(textLabel);
		contentArea.add(textLabel2); 
		
		//Apply Interface components to the container. 
		setContentPane(contentArea); 
		} 
}

public class windowHello 
{ 
	public static void main(String[] args) 
	{ 
		Window HelloWindow = new Window(); 
	} 
} 