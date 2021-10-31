package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
@SuppressWarnings("unused")
public class Bottom extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Bottom() {
        //initComponents();
        setOpaque(false);
        setBackground(new Color(68, 68, 68));
    }

    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradPaint = new GradientPaint(0, 0, Color.decode("#525252"), 0, getHeight(), Color.decode("#3d72b4"));
		g2.setPaint(gradPaint);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        g2.fillRect(0, 0, getWidth(), 20);
        super.paintComponent(grphcs);
    }
}
