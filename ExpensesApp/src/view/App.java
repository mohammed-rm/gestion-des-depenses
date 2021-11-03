package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimerTask;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("unused")
public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Panel panel;
	private InternalPanel internalPanel;
	private Menu menu;
	private Bottom bottom;
	private JLabel labClose;
	private JLabel labMin;
	private JLabel labLogo;
	private JLabel labHome;
	private JLabel labNewExpense;
	private JLabel labHistory;
	private JLabel labSettings;
	private JLabel labAbout;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private int xMouse;
	private int yMouse;

	/**
	 * Create the window with all components.
	 */
	public App() {

		initFrame();
		initComponents();
		iconsConfig();
		menuConfig();
		frameListener();
		panelListener();

		BottomItems itemRights = new BottomItems();
		bottom.add(itemRights.createLabRights());
		bottom.add(itemRights.createTime());

		frame.getContentPane().add(panel);
		panel.add(internalPanel);
		panel.add(menu);
		panel.add(bottom);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Initialize the main frame
	 */
	public void initFrame() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBackground(new Color(0, 0, 0, 0));
		frame.setPreferredSize(new Dimension(800, 450));
		frame.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width / 2 - frame.getPreferredSize().width / 2,
				screenSize.height / 2 - frame.getPreferredSize().height / 2);
	}

	/**
	 * Initialize the frame components
	 */
	public void initComponents() {
		panel = new Panel();

		internalPanel = new InternalPanel();
		internalPanel.setSize(620, 380);
		internalPanel.setLocation(180, 30);

		menu = new Menu();
		menu.setSize(180, 410);
		menu.setLocation(0, 0);

		bottom = new Bottom();
		bottom.setSize(800, 40);
		bottom.setLocation(0, 410);
	}

	/**
	 * Close and minimize icons
	 */
	public void iconsConfig() {
		labClose = new JLabel();
		labClose.setHorizontalAlignment(SwingConstants.LEFT);
		labClose.setIcon(new ImageIcon(App.class.getResource("/icons/close_in.png")));
		labClose.setBounds(765, 0, 30, 30);
		labClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// System.exit(0);
				frame.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				labClose.setIcon(new ImageIcon(App.class.getResource("/icons/close.png")));
				labClose.setBounds(765, 0, 30, 30);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labClose.setIcon(new ImageIcon(App.class.getResource("/icons/close_in.png")));
				labClose.setBounds(765, 0, 30, 30);
			}
		});
		panel.add(labClose);

		labMin = new JLabel();
		labMin.setIcon(new ImageIcon(App.class.getResource("/icons/minimize.png")));
		labMin.setBounds(745, 0, 30, 30);
		labMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				labMin.setIcon(new ImageIcon(App.class.getResource("/icons/minimize_in.png")));
				labMin.setBounds(745, 0, 30, 30);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labMin.setIcon(new ImageIcon(App.class.getResource("/icons/minimize.png")));
				labMin.setBounds(745, 0, 30, 30);
			}
		});
		panel.add(labMin);
	}

	/**
	 * Configuration of the menu items
	 */
	public void menuConfig() {
		labLogo = new JLabel();
		labLogo.setIcon(new ImageIcon(App.class.getResource("/icons/logo.png")));
		labLogo.setBounds(-5, -40, 200, 190);
		menu.add(labLogo);
		menu.add(labLogo);

		labHome = new JLabel("Home");
		labHome.setIcon(new ImageIcon(App.class.getResource("/icons/home.png")));
		labHome.setHorizontalAlignment(SwingConstants.LEFT);
		labHome.setVerticalAlignment(SwingConstants.BOTTOM);
		labHome.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		labHome.setBounds(0, 140, 120, 60);
		labHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labHome.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labHome.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				internalPanel.removeAll();

				frame.pack();
				frame.repaint();
			}
		});
		menu.add(labHome);

		labNewExpense = new JLabel("New");
		labNewExpense.setIcon(new ImageIcon(App.class.getResource("/icons/add.png")));
		labNewExpense.setHorizontalAlignment(SwingConstants.LEFT);
		labNewExpense.setVerticalAlignment(SwingConstants.BOTTOM);
		labNewExpense.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		labNewExpense.setBounds(0, 180, 120, 60);
		labNewExpense.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labNewExpense.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labNewExpense.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				internalPanel.removeAll();

				frame.pack();
				frame.repaint();
			}
		});
		menu.add(labNewExpense);

		labHistory = new JLabel("History");
		labHistory.setIcon(new ImageIcon(App.class.getResource("/icons/history.png")));
		labHistory.setHorizontalAlignment(SwingConstants.LEFT);
		labHistory.setVerticalAlignment(SwingConstants.BOTTOM);
		labHistory.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		labHistory.setBounds(0, 220, 120, 60);
		labHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labHistory.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labHistory.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				internalPanel.removeAll();

				frame.pack();
				frame.repaint();
			}
		});
		menu.add(labHistory);

		labSettings = new JLabel("Settings");
		labSettings.setIcon(new ImageIcon(App.class.getResource("/icons/settings.png")));
		labSettings.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		labSettings.setHorizontalAlignment(SwingConstants.LEFT);
		labSettings.setVerticalAlignment(SwingConstants.BOTTOM);
		labSettings.setBounds(0, 260, 120, 60);
		labSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labSettings.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labSettings.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Settings settings = new Settings();
				internalPanel.removeAll();

				internalPanel.add(settings.createLabel());
				internalPanel.add(settings.createCombo());

				frame.pack();
				frame.repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		menu.add(labSettings);

		labAbout = new JLabel("About");
		labAbout.setIcon(new ImageIcon(App.class.getResource("/icons/about.png")));
		labAbout.setHorizontalAlignment(SwingConstants.LEFT);
		labAbout.setVerticalAlignment(SwingConstants.BOTTOM);
		labAbout.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		labAbout.setBounds(0, 300, 120, 60);
		labAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labAbout.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labAbout.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				internalPanel.removeAll();

				frame.pack();
				frame.repaint();
			}
		});
		menu.add(labAbout);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.RED);
		separator_1.setBounds(20, 190, 140, 1);
		menu.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setForeground(Color.RED);
		separator_2.setBounds(20, 230, 140, 1);
		menu.add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setForeground(Color.RED);
		separator_3.setBounds(20, 270, 140, 1);
		menu.add(separator_3);

		separator_4 = new JSeparator();
		separator_4.setForeground(Color.RED);
		separator_4.setBounds(20, 310, 140, 1);
		menu.add(separator_4);
	}

	/**
	 * Add listeners to the frame to change back the minimize icon to its original
	 * state
	 */
	public void frameListener() {
		frame.addWindowListener((WindowListener) new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				labMin.setIcon(new ImageIcon(App.class.getResource("/icons/minimize.png")));
				labMin.setBounds(745, 0, 30, 30);
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}
		});
	}

	/**
	 * Add listeners to move the undecorated frame when the mouse is dragged
	 */
	public void panelListener() {
		panel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getLocation().x + e.getX() - xMouse, frame.getLocation().y + e.getY() - yMouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
	}
}
