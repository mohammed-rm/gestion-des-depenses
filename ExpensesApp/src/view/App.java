package view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

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
		labClose.setIcon(new ImageIcon(App.class.getResource("/icons/close.png")));
		labClose.setBounds(760, 0, 40, 40);
		panel.add(labClose);
		
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
