import java.awt.*;
import java.awt.event.*; //Import event libraries
import javax.swing.*;

class gridLayoutPanel extends JFrame implements ActionListener {
	JButton NorthButton = new JButton ("Hide North");
	JButton WestButton = new JButton ("Hide West");
	JButton SouthButton = new JButton ("Hide South");
	JButton EastButton = new JButton ("Hide East");
	JButton CenterButton = new JButton ("Hide Center");
	
	JPanel NorthPanel = new JPanel(new GridLayout(1,0,0,0));
	JPanel WestPanel = new JPanel(new GridLayout(1,0,0,0));
	JPanel SouthPanel = new JPanel(new GridLayout(1,0,0,0));
	JPanel EastPanel = new JPanel(new GridLayout(1,0,0,0));
	JPanel CenterPanel = new JPanel(new GridLayout(1,0,0,0));
	
	public gridLayoutPanel() {
		super("gridLayoutPanels");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Container contentArea = getContentPane();
		contentArea.setBackground(Color.white);
		
		NorthButton.addActionListener(this);
		WestButton.addActionListener(this);
		SouthButton.addActionListener(this);
		EastButton.addActionListener(this);
		CenterButton.addActionListener(this);
		
		NorthPanel.add(NorthButton);
		WestPanel.add(WestButton);
		SouthPanel.add(SouthButton);
		EastPanel.add(EastButton);
		CenterPanel.add(CenterButton);
		
		SouthButton.setPreferredSize(new Dimension(50,75));
		NorthButton.setPreferredSize(new Dimension(50,75));
		EastButton.setPreferredSize(new Dimension(100,50));
		WestButton.setPreferredSize(new Dimension(100,50));
		
		/*NorthButton.setSize(getPreferredSize());
		EastButton.setSize(getPreferredSize());
		WestButton.setSize(getPreferredSize());
		SouthButton.setSize(getPreferredSize());
		CenterButton.setSize(getPreferredSize());
		*/
		contentArea.add("North", NorthPanel);
		contentArea.add("South", SouthPanel);
		contentArea.add("Center", CenterPanel);
		contentArea.add("West", WestPanel);
		contentArea.add("East", EastPanel);
		
		setContentPane(contentArea);
		}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == NorthButton) {
			NorthPanel.setVisible(false);
		}
		if (event.getSource() == SouthButton) {
			SouthPanel.setVisible(false);
		}
		if (event.getSource() == EastButton) {
			EastPanel.setVisible(false);
		}
		if (event.getSource() == WestButton) {
			WestPanel.setVisible(false);
		}
		if (event.getSource() == CenterButton) {
			CenterPanel.setVisible(false);
		}
	}
}

public class gridLayoutPanelTask {

	
	public static void main(String[] args) {
		gridLayoutPanel Win = new gridLayoutPanel();
	}

}
