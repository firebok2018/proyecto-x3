package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JIFinforme extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JTextField textField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIFinforme frame = new JIFinforme();
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
	public JIFinforme() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 434, 270);
		getContentPane().add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(233, 123, 4, 22);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(35, 31, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(242, 95, 89, 23);
		getContentPane().add(btnNewButton);

	}
}
