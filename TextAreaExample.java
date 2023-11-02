import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class TextAreaExampleWindow extends JFrame implements ActionListener {

	JTextArea textArea = new JTextArea("Start text!", 5, 20);
	JButton textButton = new JButton("Change text");

	public TextAreaExampleWindow() {

		super("Area with text");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Container contentArea = getContentPane();
		contentArea.setBackground(Color.gray);
		FlowLayout flowManager = new FlowLayout();

		contentArea.setLayout(flowManager);
		textButton.addActionListener(this);

		contentArea.add(textArea);
		contentArea.add(textButton);
		setContentPane(contentArea);
		
		//settings for TextArea, uncomment and see what they do.
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == textButton) {
			// Code here will be executed when textButton is pressed
			addMoreText();
		}
	}

	public void addMoreText() {
		String newText = "This is an editable JTextArea. " +
	    				"\nA text area is a \"plain\" text component, " +
	    				"which means that although it can display text " +
	    				"in any font, all of the text is in the same font.";
		textArea.setText(newText);
		// a way to control new lines is to input \n in the next, try it in the string above.
	}
}

public class TextAreaExample {
	public static void main(String[] args) {
		TextAreaExampleWindow Bob = new TextAreaExampleWindow();
	}
}