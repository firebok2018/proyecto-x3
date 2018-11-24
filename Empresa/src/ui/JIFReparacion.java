package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JIFReparacion extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JIFReparacion dialog = new JIFReparacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JIFReparacion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
	}

}
