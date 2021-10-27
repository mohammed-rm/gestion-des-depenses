package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class Appview extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Appview() {
		/* FRAME */
		JFrame frame = new JFrame();
		frame.setTitle("Expense Tracking Application™");
		frame.setResizable(false);
		frame.setSize(500, 500);
		
		/* TAB */
		JTabbedPane tab = new JTabbedPane();
		
		/* PANELS */
		JPanel homePanel = new JPanel();
		JPanel historyPanel = new JPanel();
		JPanel settingsPanel = new JPanel();
		JPanel aboutPanal = new JPanel();
		
		/* HOME MENU */
		JMenuBar bar = new JMenuBar();
		homePanel.setLayout(null);
		bar.setBounds(15, 10, 50, 50);
		JMenu menu = new JMenu("+");
		JMenuItem newExpense = new JMenuItem("New Expense");
		JMenuItem history = new JMenuItem("History");
		JMenuItem settings = new JMenuItem("Settings");
			
		/* ADD COMPONENTS */
		tab.add(homePanel, "Home"); 
		//tab.add(historyPanel, "History");
		//tab.add(settingsPanel, "Settings");
		tab.add(aboutPanal, "About");
		
		menu.add(newExpense);
		menu.add(history);
		menu.add(settings);
		homePanel.add(bar);
		bar.add(menu);
		
		frame.add(tab);
		
		/* END FRAME */
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
