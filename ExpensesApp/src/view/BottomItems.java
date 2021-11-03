package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 * @author RMICH Mohammed
 *
 */
public class BottomItems {

	public JLabel createLabRights() {
		JLabel labRights = new JLabel("\u00A9 2021 HopyMed France, All rights reserved.");
		labRights.setForeground(UIManager.getColor("Button.background"));
		labRights.setBackground(UIManager.getColor("Button.focus"));
		labRights.setBounds(10, 15, 260, 15);

		return labRights;
	}

	public JLabel createTime() {
		JLabel labTime = new JLabel();
		labTime.setForeground(UIManager.getColor("Button.background"));
		labTime.setHorizontalAlignment(SwingConstants.RIGHT);
		labTime.setText(new Date().toString());
		ActionListener updateClockAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labTime.setText(new Date().toString());
			}
		};
		Timer t = new Timer(1000, updateClockAction);
		t.start();
		labTime.setBounds(460, 15, 330, 15);

		return labTime;
	}
}
