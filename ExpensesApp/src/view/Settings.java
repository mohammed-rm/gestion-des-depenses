package view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Settings extends Component {

	private static final long serialVersionUID = 1L;
	private  JComboBox<String> comboBox;
	private  JLabel labLanguage;

	public Settings() {
		comboBox = new JComboBox<String>();
		labLanguage = new JLabel("Language");
	}

	public  JComboBox<String> createCombo() {
		comboBox.setBounds(77, 8, 45, 22);
		comboBox.addItem("Fr");
		comboBox.addItem("En");

		return comboBox;
	}

	public  JLabel createLabel() {
		labLanguage.setFont(new Font("Baskerville Old Face", Font.BOLD, 14));
		labLanguage.setBounds(10, 12, 57, 15);
		return labLanguage;
	}
}
