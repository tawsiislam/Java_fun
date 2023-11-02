import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

class qDemoWindow extends JFrame implements ActionListener
{
	Queue<String> people = new LinkedList<String>();
	
	ImageIcon join = new ImageIcon("in.png");
	ImageIcon leave = new ImageIcon("out.png");
	JButton offerButton = new JButton ("Offer", join);
	JButton pollButton = new JButton ("Poll", leave);

	JLabel textLabel = new JLabel ("Name:");
	JTextField textBox = new JTextField ("Type..",10);

	JTextArea textArea1 = new JTextArea(20,5);
	JScrollPane textPane1 = new JScrollPane (textArea1);
	JTextArea textArea2 = new JTextArea(20,5);
	JScrollPane textPane2 = new JScrollPane (textArea2);	
	
	JPanel centre = new JPanel(new GridLayout(1,2));
	JPanel top = new JPanel(new GridLayout(2,2));

	public qDemoWindow (){
		super("Queue Demo");
		setSize (320,260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible (true);
		
		Container contentArea = getContentPane();
		contentArea.setBackground(Color.white);
		textArea1.setEditable(false); 
		textArea2.setEditable(false);
		
		offerButton.addActionListener(this);
		pollButton.addActionListener(this);

		top.add(textLabel);
		top.add(textBox);
		top.add(offerButton);
		top.add(pollButton);
		centre.add(textPane1);
		centre.add(textPane2);

		contentArea.add("North",top);
		contentArea.add("Center",centre);
		textBox.grabFocus();
		textBox.selectAll();
	
		setContentPane(contentArea);
		getRootPane().setDefaultButton(offerButton);
	}

	public void actionPerformed (ActionEvent event){
		
		if (event.getSource()== offerButton ){
			String name = textBox.getText();
			people.offer(name);
			textArea1.append(name+"\n");
			textBox.setText("");
		}
		if (event.getSource()== pollButton){
			String name = people.poll();
			textArea2.append(name+"\n");
		}
	} 
}

public class queueDemo {

	public static void main(String[] args) {
		qDemoWindow Win = new qDemoWindow();
	}
}
