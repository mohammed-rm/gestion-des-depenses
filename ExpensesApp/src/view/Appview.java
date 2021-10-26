package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class Appview {

	public Appview() {
		/* FRAME */
		JFrame frame = new JFrame();
		frame.setTitle("Expense Tracking Application™");
		frame.setResizable(false);
		frame.setSize(800, 500);
		
		/* TAB */
		JTabbedPane tab = new JTabbedPane();
		
		/* PANELS */
		JPanel homePanel = new JPanel();
		JPanel historyPanel = new JPanel();
		JPanel settingsPanel = new JPanel();
		
		/* ADD COMPONENTS */
		tab.add(homePanel, "Home"); 
		tab.add(historyPanel, "History");
		tab.add(settingsPanel, "Settings");
		
		frame.add(tab);
		
		/* END FRAME */
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
