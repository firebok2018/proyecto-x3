package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ConexionDatabase.ConexionCliente;
import ConexionDatabase.ConexionMesa;
import model.Cliente;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class FrmRegistroClientes extends JInternalFrame implements ActionListener, FocusListener {
	private JLabel lblNCodigo;
	private JTextField txtCodigoCliente;
	private JLabel lblNombre;
	private JTextField txtNombreCliente;
	private JLabel lblDni;
	private JTextField txtDniCliente;
	private JLabel lblApellido;
	private JTextField txtApellidoCliente;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JButton btnBuscar;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	private DefaultTableModel modelo;

	private int tipOperacion;
	
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR= 2;
	public final static int VOLVER=3;
	public final static int BUSCAR=4;
	public final static int ACEPTAR=5;

	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnCerrar;
	
	ConexionCliente conCli= new ConexionCliente();
	ConexionMesa conMesa= new ConexionMesa();
	
	private JLabel label;
	private JTextField txtNumeroDeSillas;
	private JComboBox cboEstado;
	private JComboBox cboNumMesa;
	private JLabel lblEstado;
	public static int codCli;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroClientes frame = new FrmRegistroClientes();
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
	public FrmRegistroClientes() {
		setTitle("Registro de Clientes");
		setBorder(null);
		setBounds(100, 100, 860, 539);
		getContentPane().setLayout(null);
		
		lblNCodigo = new JLabel("N\u00B0 Codigo:");
		lblNCodigo.setBounds(26, 24, 68, 14);
		getContentPane().add(lblNCodigo);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setBounds(99, 21, 100, 20);
		getContentPane().add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		txtCodigoCliente.setText("C"+"0"+generadorCodigo()+2);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(26, 60, 68, 14);
		getContentPane().add(lblNombre);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setEnabled(false);
		txtNombreCliente.setBounds(99, 57, 297, 20);
		getContentPane().add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(225, 24, 46, 14);
		getContentPane().add(lblDni);
		
		txtDniCliente = new JTextField();
		txtDniCliente.setEnabled(false);
		txtDniCliente.setBounds(271, 21, 125, 20);
		getContentPane().add(txtDniCliente);
		txtDniCliente.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(26, 98, 46, 14);
		getContentPane().add(lblApellido);
		
		txtApellidoCliente = new JTextField();
		txtApellidoCliente.setEnabled(false);
		txtApellidoCliente.setBounds(99, 95, 297, 20);
		getContentPane().add(txtApellidoCliente);
		txtApellidoCliente.setColumns(10);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(26, 136, 46, 14);
		getContentPane().add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setBounds(99, 133, 125, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setVisible(false);
		btnBuscar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/search.png")));
		btnBuscar.setBounds(482, 15, 116, 33);
		getContentPane().add(btnBuscar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setVisible(false);
		btnAceptar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/ok.png")));
		btnAceptar.setBounds(608, 60, 116, 33);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setVisible(false);
		btnVolver.addActionListener(this);
		btnVolver.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/previous.png")));
		btnVolver.setBounds(608, 103, 116, 33);
		getContentPane().add(btnVolver);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/plus.png")));
		btnAdicionar.setBounds(608, 15, 116, 33);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/engineering.png")));
		btnModificar.setBounds(734, 15, 116, 33);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/delete_database.png")));
		btnEliminar.setBounds(734, 60, 116, 33);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(-41, 190, 802, 311);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(734, 103, 116, 33);
		getContentPane().add(btnCerrar);
		
		label = new JLabel("Mesa");
		label.setBounds(238, 136, 46, 14);
		getContentPane().add(label);
		
		txtNumeroDeSillas = new JTextField();
		txtNumeroDeSillas.setEnabled(false);
		txtNumeroDeSillas.setColumns(10);
		txtNumeroDeSillas.setBounds(351, 133, 46, 20);
		getContentPane().add(txtNumeroDeSillas);
		
		cboEstado = new JComboBox();
		cboEstado.addFocusListener(this);
		cboEstado.setBounds(476, 133, 91, 20);
		getContentPane().add(cboEstado);
		
		cboNumMesa = new JComboBox();
		cboNumMesa.addFocusListener(this);
		cboNumMesa.setBounds(272, 133, 69, 20);
		getContentPane().add(cboNumMesa);
		cboNumMesa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//conMesa.numero_de_Mesa(txtNumeroDeSillas, cboNumMesa.getSelectedIndex());
			}
		});
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(420, 136, 46, 14);
		getContentPane().add(lblEstado);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		tipOperacion=VOLVER;
		habilitarBoton(true);
		habilitarEntrada(true);
	}
	void habilitarBoton(Boolean not){
		if(tipOperacion==ADICIONAR){
			btnAceptar.setVisible(!not);
			
			
			btnAdicionar.setEnabled(not);
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			btnVolver.setVisible(!not);
		}
		if(tipOperacion==VOLVER){
			btnAceptar.setVisible(!not);
			btnVolver.setVisible(!not);
			btnBuscar.setVisible(!not);
			btnAdicionar.setEnabled(not);
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			
		}if(tipOperacion==MODIFICAR){
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			btnAdicionar.setEnabled(not);
			btnAceptar.setVisible(!not);
			btnVolver.setVisible(!not);
			btnBuscar.setVisible(!not);
		}if(tipOperacion==ELIMINAR){
			btnEliminar.setEnabled(!not);
			btnModificar.setEnabled(!not);
			btnAdicionar.setEnabled(!not);
			btnVolver.setVisible(not);
			btnBuscar.setVisible(not);
			btnAceptar.setVisible(not);
		}
	}
	void habilitarEntrada(Boolean not){
		if(tipOperacion==ADICIONAR){
			txtNombreCliente.setEnabled(!not);
			txtApellidoCliente.setEnabled(!not);
			txtDniCliente.requestFocus();
			txtDniCliente.setEnabled(!not);
			txtTelefono.setEnabled(!not);
			
			
		}
		if(tipOperacion==MODIFICAR){
			txtNombreCliente.setEnabled(!not);
			txtApellidoCliente.setEnabled(!not);
			
			txtDniCliente.setEnabled(!not);
			txtDniCliente.requestFocus();
			txtTelefono.setEnabled(!not);
		}
		if(tipOperacion==VOLVER){
			txtNombreCliente.setEnabled(!not);
			txtApellidoCliente.setEnabled(!not);
			txtCodigoCliente.setEnabled(!not);
			txtDniCliente.setEnabled(!not);
			txtTelefono.setEnabled(!not);
			limpiar();
		}
		if(tipOperacion==ELIMINAR){
			txtDniCliente.setEnabled(not);
			txtDniCliente.requestFocus();
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipOperacion=ADICIONAR;
		habilitarBoton(false);
		habilitarEntrada(false);
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipOperacion=MODIFICAR;
		habilitarBoton(false);
		habilitarEntrada(false);
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipOperacion=ELIMINAR;
		habilitarBoton(true);
		habilitarEntrada(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipOperacion){
		case ADICIONAR:
			agregarCliente();
			break;
		case MODIFICAR:
			modificarCliente();
			break;
		case ELIMINAR:
			eliminarCliente();
		}
		/*Cliente newCli= new Cliente(0,codigo(), dni(), nombre(), apellido(), telefono());
		int valor=conCli.addCliente(newCli);
		if(valor==1){
			System.out.println("Cliente Registrado");
		}else{
			System.out.println("no esta registrado");
		}*/
		
	}
	String codigo(){return txtCodigoCliente.getText();}
	int dni(){return Integer.parseInt(txtDniCliente.getText());}
	String nombre(){return txtNombreCliente.getText();}
	String apellido(){return txtApellidoCliente.getText();}
	int telefono(){return Integer.parseInt(txtTelefono.getText());}
	int mesa(){
		String n = cboNumMesa.getSelectedItem().toString().trim();
		return Integer.parseInt(n);}
	int estado(){
		return cboEstado.getSelectedIndex();
	}
	void limpiar(){
		txtDniCliente.setText(null);
		txtNombreCliente.setText(null);
		txtApellidoCliente.setText(null);
		txtTelefono.setText(null);
		txtDniCliente.requestFocus();
	}
	void agregarCliente(){
		System.out.println("Agregando Cliente");
		try {
			int dni=dni();
			String d=txtDniCliente.getText();
			if (d.length()==0||d.length()<8){
				error("Ingrese Correctamente el DNI.", txtDniCliente);
			}else{
				String n=nombre();
				if (n.length()<4) {
					error("Ingrese como minimo 3 carateres ", txtNombreCliente);
				}else{
					String s=apellido();
					if (s.length()<4) {
						error("ingrese como minimo 4 caracteres", txtApellidoCliente);
					}else{
						try {
							int t=telefono();
							String f=txtTelefono.getText();
							if (f.length()<9||f.length()>9) {
								mensaje("Ingrese correctamente el numero de telefono");
							}else{
								Cliente xCli = new Cliente(codigo(), dni(), nombre(), apellido(), telefono(), mesa(),estado());								
								conCli.add_cliente(xCli);
								limpiar();
							}
						} catch (NumberFormatException e) {
							// TODO: handle exception
							error("ingrese Correctamente los datos requeridos", txtTelefono);
						}
						
					}
					
				}
				
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			error("Ingrese un numero de DNI valido !!", txtDniCliente);
		}
		
		
	}
	void modificarCliente(){
		System.out.println("modificar cliente");
	}
	void eliminarCliente(){
		System.out.println("eliminar cliente");
	}
	int generadorCodigo(){
		if(codCli==0){
			return 0001;
		}else{
			return codCli++;
		}
	}
	void error(String s,JTextField txt){mensaje(s);txt.setText("");txt.requestFocus();}
	void mensaje(String s) {JOptionPane.showMessageDialog(this, s,"Error de Formato",0);}
	public void focusGained(FocusEvent e) {
		if (e.getSource() == cboEstado) {
			focusGainedCboEstado(e);
		}
		if (e.getSource() == cboNumMesa) {
			focusGainedCboNumMesa(e);
		}
	}
	public void focusLost(FocusEvent e) {
	}
	protected void focusGainedCboNumMesa(FocusEvent e) {
		conMesa.numeroMesa(cboNumMesa);
	}
	protected void focusGainedCboEstado(FocusEvent e) {
		conMesa.EstadoMesa(cboEstado);
	}
}
