package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloMesa;
import ConexionDatabase.ConexionMesa;
import model.Mesa;
import model.Usuarios;
import utils.Conexion;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.FocusListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmAgregarMesa extends JInternalFrame implements FocusListener, ActionListener {
	private JScrollPane scrollPane;
	private JLabel lblNDeMesa;
	private JTextField txtNumMesa;
	private JButton btnAgregar;
	private JLabel label_4;
	private JTextField txtNumSillas;
	private JTable tblMesa;
	private DefaultTableModel default_table;
	
	ConexionMesa conMesa = new ConexionMesa();
	private JButton btnSalir;
	private JTextField txtCodigoMesa;
	private JLabel lblCodigo;
	private JComboBox cboEstado;
	private JLabel lblEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAgregarMesa frame = new FrmAgregarMesa();
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
	public FrmAgregarMesa() {
		setTitle("Actualizar | Mesa");
		setBounds(100, 100, 614, 356);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 370, 224);
		getContentPane().add(scrollPane);
		
		tblMesa = new JTable();
		scrollPane.setViewportView(tblMesa);
		tblMesa.setModel(new DefaultTableModel(
				new Object[][]{	},
				new Object[]{
						"ID",
						"Numero de Mesa",
						"Numero de Sillas"
				}
				));
		
		lblNDeMesa = new JLabel("N\u00B0 de Mesa:");
		lblNDeMesa.setBounds(195, 24, 76, 14);
		getContentPane().add(lblNDeMesa);
		
		txtNumMesa = new JTextField();
		txtNumMesa.setColumns(10);
		txtNumMesa.setBounds(267, 21, 46, 20);
		getContentPane().add(txtNumMesa);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(FrmAgregarMesa.class.getResource("/imagen/plus.png")));
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(358, 15, 122, 33);
		getContentPane().add(btnAgregar);
		
		label_4 = new JLabel("Sillas:");
		label_4.setBounds(223, 49, 46, 14);
		getContentPane().add(label_4);
		
		txtNumSillas = new JTextField();
		txtNumSillas.setText("4");
		txtNumSillas.setColumns(10);
		txtNumSillas.setBounds(267, 49, 46, 20);
		getContentPane().add(txtNumSillas);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(FrmAgregarMesa.class.getResource("/imagen/cerrar.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(358, 48, 122, 33);
		getContentPane().add(btnSalir);
		
		txtCodigoMesa = new JTextField();
		txtCodigoMesa.setBounds(101, 21, 84, 20);
		getContentPane().add(txtCodigoMesa);
		txtCodigoMesa.setColumns(10);
		txtCodigoMesa.setText(CodMesa()+1);

		
		lblCodigo = new JLabel("CODIGO:");
		lblCodigo.setBounds(41, 24, 46, 14);
		getContentPane().add(lblCodigo);
		
		cboEstado = new JComboBox();
		cboEstado.addActionListener(this);
		cboEstado.addFocusListener(this);
		cboEstado.setBounds(101, 46, 84, 20);
		getContentPane().add(cboEstado);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(41, 49, 50, 14);
		getContentPane().add(lblEstado);

	}
	public void focusGained(FocusEvent arg0) {
		if (arg0.getSource() == cboEstado) {
			focusGainedCboEstado(arg0);
		}
	}
	public void focusLost(FocusEvent arg0) {
	}
	int NumeroMesa(){ return Integer.parseInt(txtNumMesa.getText().trim()); }
	int NumeroSilla(){ return Integer.parseInt(txtNumSillas.getText().trim()); }
	void mensaje(String s){	JOptionPane.showMessageDialog(this,  s); }
	void error(String x,JTextField j){
		mensaje(x);
		j.setText(null);
		j.requestFocus();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboEstado) {
			actionPerformedCboEstado(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		try {
			 int m = NumeroMesa();
			 String s=txtNumMesa.getText();
			 if (s.length()==0|| m<=0 || m>=26 || s.length()>=3||m==0) {
				 error("ingrese un numero valido", txtNumMesa);
				}else{
					int n= NumeroSilla();
					String t=txtNumSillas.getText();
					if (n!=0||t.length()!=0) {
						
						Mesa addMesa=new Mesa();
						
						int x= conMesa.add_mesa(addMesa,CodigoMesa(),NumeroMesa(),NumeroSilla(),Estado());
						if(x==1){
							System.out.println("Resistrado");
						}else{
							
						}
						
						/*conMesa.add_mesa(sd,CodigoMesa(), NumeroMesa(), NumeroSilla(),Estado())){ 
							System.out.println("Registrado");
							JOptionPane.showMessageDialog(null, "Numero  "+NumeroMesa()+"  de mesa Agregado ");	
						}*/
								
						
					}else{
						error("ingrese un numero valido", txtNumSillas);
					}
			}
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			error("Ingrese un numero", txtNumMesa);
		}
		
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	String CodMesa(){
		return "M000"+1;
	}
	String CodigoMesa(){
		return txtCodigoMesa.getText();
	}
	int Estado(){return cboEstado.getSelectedIndex();}
	protected void focusGainedCboEstado(FocusEvent arg0) {
		conMesa.EstadoMesa(cboEstado);
	}
	protected void actionPerformedCboEstado(ActionEvent arg0) {
		System.out.println(cboEstado.getSelectedItem());
	}
}
