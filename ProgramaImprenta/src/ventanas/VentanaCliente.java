package ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class VentanaCliente extends JPanel {

	/**
	 * Create the panel.
	 */
	public VentanaCliente() {
		setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(105, 60, 49, 14);
		add(label);

	}

}
