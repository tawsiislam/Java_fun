import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class recursionIntroWindow extends JFrame implements ActionListener {

	JTextArea textArea = new JTextArea("Start text!", 5, 20);
	JButton textButton = new JButton("Start");

	public recursionIntroWindow() {

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

		if (event.getSource() == textButton) {
			// Call the method
			textArea.setText("");
			printTriangle(5);
		}

	}

	public void printTriangle(int n) {
		for (int f = 0; f < n; f++)	textArea.append("*");
		textArea.append("\n");
		if (n > 1)	printTriangle(n - 1);
	}
}

public class recursionIntroWindowed {

	public static void main(String[] args) {

		recursionIntroWindow Bob = new recursionIntroWindow();

	}
}
