package view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("unused")
public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
	
		JFrame frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBackground(new Color(0, 0, 0, 0));
		frame.setPreferredSize(new Dimension(800,450));
		frame.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width/2 - frame.getPreferredSize().width/2, screenSize.height/2 - frame.getPreferredSize().height/2);
		
		Panel panel = new Panel();
		Menu menu = new Menu();
		Bottom bottom = new Bottom();
		bottom.setSize(800, 40);
		bottom.setLocation(0, 410);
		menu.setLocation(0, 0);
		menu.setSize(180, 410);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(menu);
		panel.add(bottom);
		
		JLabel labClose = new JLabel();
		labClose.setIcon(getScaledImage(new ImageIcon(App.class.getResource("/icons/close.png")), 30,30));
		labClose.setBounds(765, 5, 30, 30);
		
		
		/* ACTION */
		labClose.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseClicked(MouseEvent e) 
		    {
		    	//System.exit(0);
		    	frame.dispose();
		    }
		});
		/* ********* */ 
		
		panel.add(labClose);
		menu.setLayout(null);
		
		JLabel labLogo = new JLabel();
		labLogo.setIcon(getScaledImage(new ImageIcon(App.class.getResource("/icons/logo.png")), 180,180));
		labLogo.setBounds(5, -40, 180, 180);
		menu.add(labLogo);
		menu.add(labLogo);
		
		JLabel labHome = new JLabel("Home");
		labHome.setHorizontalAlignment(SwingConstants.LEFT);
		labHome.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		labHome.setBounds(30, 140, 120, 20);
		labHome.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	labHome.setForeground(Color.WHITE);
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	labHome.setForeground(Color.getColor(null));
		    }
		});
		menu.add(labHome);
		
		JLabel labNewExpense = new JLabel("New Expense");
		labNewExpense.setHorizontalAlignment(SwingConstants.LEFT);
		labNewExpense.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		labNewExpense.setBounds(30, 180, 120, 20);
		labNewExpense.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	labNewExpense.setForeground(Color.WHITE);
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	labNewExpense.setForeground(Color.getColor(null));
		    }
		});
		menu.add(labNewExpense);
		
		JLabel labHistory = new JLabel("History");
		labHistory.setHorizontalAlignment(SwingConstants.LEFT);
		labHistory.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		labHistory.setBounds(30, 220, 120, 20);
		labHistory.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	labHistory.setForeground(Color.WHITE);
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	labHistory.setForeground(Color.getColor(null));
		    }
		});
		menu.add(labHistory);
		
		JLabel labSettings = new JLabel("Settings");
		labSettings.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		labSettings.setHorizontalAlignment(SwingConstants.LEFT);
		labSettings.setBounds(30, 260, 120, 20);
		labSettings.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	labSettings.setForeground(Color.WHITE);
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	labSettings.setForeground(Color.getColor(null));
		    }
		});
		menu.add(labSettings);
		
		JLabel labAbout = new JLabel("About");
		labAbout.setHorizontalAlignment(SwingConstants.LEFT);
		labAbout.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		labAbout.setBounds(30, 300, 120, 20);
		labAbout.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	labAbout.setForeground(Color.WHITE);
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	labAbout.setForeground(Color.getColor(null));
		    }
		});
		menu.add(labAbout);
		
		//frame.update(getGraphics());
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private ImageIcon getScaledImage(ImageIcon srcImg, int width, int height){
	    BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg.getImage(), 0, 0, width, height, null);
	    g2.dispose();
	    
	    ImageIcon res = new ImageIcon(resizedImg);
	    return res;
	}
}
