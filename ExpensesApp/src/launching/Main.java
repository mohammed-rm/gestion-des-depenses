package launching;

import java.awt.EventQueue;

import view.App;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					App frame = new App();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
