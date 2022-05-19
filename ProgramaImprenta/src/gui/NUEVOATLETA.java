package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;

public class NUEVOATLETA extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NUEVOATLETA frame = new NUEVOATLETA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NUEVOATLETA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(40, 48, 49, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(196, 45, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(194, 385, 146, 9);
		contentPane.add(progressBar);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(200, 598, 186, 99);
		contentPane.add(scrollBar);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(415, 145, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(604, 145, 111, 23);
		contentPane.add(rdbtnNewRadioButton_1);

	}
}