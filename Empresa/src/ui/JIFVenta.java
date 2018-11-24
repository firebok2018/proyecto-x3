package ui;

import java.awt.EventQueue;
import java.awt.TrayIcon.MessageType;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ConexionDatabase.ConexionTipo_Menu;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

import javax.naming.OperationNotSupportedException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JIFVenta extends JInternalFrame implements ActionListener {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblDni;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNombre;
	private JLabel lblApllidos;
	private JTextField textField_3;
	private JComboBox cboTipo;
	private JLabel lblCategoria;
	private JButton btnVender;
	private JButton btnLimpiar;
	private JButton btnCerrar;
	private JComboBox cboSubTipo;
	private JLabel lblCantidad;
	private JTextField txtCantidadPedido;
	private JButton btnAgregar;
	private JScrollPane scrollPane;
	private JTable table;

	ConexionTipo_Menu tipo_menu= new ConexionTipo_Menu();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIFVenta dialog = new JIFVenta();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public JIFVenta() {
		
		
		
		setBorder(null);
		setTitle("Venta | productos");
		setBounds(100, 100, 523, 502);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("N\u00B0 Venta:");
		lblNewLabel.setBounds(26, 22, 62, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(98, 19, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(206, 22, 46, 14);
		getContentPane().add(lblDni);
		
		textField_1 = new JTextField();
		textField_1.setBounds(248, 19, 126, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 50, 276, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(26, 55, 62, 14);
		getContentPane().add(lblNombre);
		
		lblApllidos = new JLabel("Apllidos:");
		lblApllidos.setBounds(26, 87, 73, 14);
		getContentPane().add(lblApllidos);
		
		textField_3 = new JTextField();
		textField_3.setBounds(98, 81, 276, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		cboTipo = new JComboBox();
		//cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Menu", "BEbidas", "Extras"}));
		cboTipo.setBounds(86, 120, 116, 20);
		getContentPane().add(cboTipo);
		
		tipo_menu.tipoMenu(cboTipo);
		
		lblCategoria = new JLabel("Tipo:");
		lblCategoria.setBounds(26, 123, 73, 14);
		getContentPane().add(lblCategoria);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setIcon(new ImageIcon(JIFVenta.class.getResource("/imagen/dinero.png")));
		btnVender.setBounds(122, 226, 115, 33);
		getContentPane().add(btnVender);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(JIFVenta.class.getResource("/imagen/list.png")));
		btnLimpiar.setBounds(247, 226, 127, 33);
		getContentPane().add(btnLimpiar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(JIFVenta.class.getResource("/imagen/cerrar.png")));
		btnCerrar.setBounds(405, 226, 108, 33);
		getContentPane().add(btnCerrar);
		
		cboSubTipo = new JComboBox();
		cboSubTipo.setBounds(232, 120, 79, 20);
		getContentPane().add(cboSubTipo);
	
		
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(312, 123, 62, 14);
		getContentPane().add(lblCantidad);
		
		txtCantidadPedido = new JTextField();
		txtCantidadPedido.setBounds(364, 120, 45, 20);
		getContentPane().add(txtCantidadPedido);
		txtCantidadPedido.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setIcon(new ImageIcon(JIFVenta.class.getResource("/imagen/plus.png")));
		btnAgregar.setBounds(23, 231, 99, 28);
		getContentPane().add(btnAgregar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 275, 503, 189);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
		if (arg0.getSource() == btnVender) {
			actionPerformedBtnVender(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnVender(ActionEvent arg0) {
		JOptionPane.showConfirmDialog(null, 
                "Do you want to proceed?", "Select an Option...",JOptionPane.YES_NO_OPTION);
	}
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
	}
	
}
