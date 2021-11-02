package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class InternalPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InternalPanel() {
		setOpaque(false);
		new JPanel();
		setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
        Graphics2D g2d = (Graphics2D) grphcs;
        //g2d.setColor(getBackground());
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradPaint = new GradientPaint(0, 0, Color.decode("#5a4a4c"), getWidth(), getHeight(), Color.decode("#fdbb4f"));
        g2d.setPaint(gradPaint);
        g2d.fillRect(0, 0, 620, 380);
        super.paintComponent(grphcs);
	
	}
}