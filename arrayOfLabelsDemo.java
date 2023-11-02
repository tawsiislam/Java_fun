import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

class arrayOfLabelsDemoWindow extends JFrame implements ActionListener {

	JLabel []jLabelArray = new JLabel[10];
	public arrayOfLabelsDemoWindow() {

		super("Area with text");
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Container contentArea = getContentPane();
		contentArea.setBackground(Color.white);
		FlowLayout flowManager = new FlowLayout();

		contentArea.setLayout(flowManager);
		for (int i =0;i<jLabelArray.length;i++){
			jLabelArray[i]=new JLabel("Detta är JLabel "+i);
			contentArea.add(jLabelArray[i]);	
		}
		
		
		setContentPane(contentArea);
	}

	public void actionPerformed(ActionEvent event) {
		
	}
}

public class arrayOfLabelsDemo {

	public static void main(String[] args) {

		arrayOfLabelsDemoWindow Lod = new arrayOfLabelsDemoWindow();

	}
}
