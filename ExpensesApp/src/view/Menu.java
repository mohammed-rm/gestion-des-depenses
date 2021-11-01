package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Menu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menu() {
		initComponents();
		setOpaque(false);
	}

	private void initComponents() {

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 188, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 178, Short.MAX_VALUE));
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D graph2D = (Graphics2D) grphcs;
		graph2D.setColor(getBackground());
		graph2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gradPaint = new GradientPaint(0, 0, Color.decode("#1a2a6c"), 0, getHeight(), Color.decode("#ffd452"));
		graph2D.setPaint(gradPaint);
		graph2D.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
		graph2D.fillRect(getWidth() - 25, 0, getWidth(), getHeight()); // Top right edge
		graph2D.fillRect(0, getHeight() - 25, getWidth(), getHeight()); // Bottom right edge
		super.paintComponent(grphcs);
	}

}
