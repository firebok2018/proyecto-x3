package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConexionDatabase.ConexionProductos;
import model.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.sound.midi.SysexMessage;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;

public class FrmProductos extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2007627103438757455L;
	private JTextField txtNomPro;
	private JTextField txtCodPRo;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnSalir;
	private JButton btnModificar;
	private JButton btnNuevo;
	private JButton btnVolver;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnBuscar;
	
	private DefaultTableModel modelo;

	ConexionProductos produc= new ConexionProductos();
	private int tipOperacion;
	public final static int NUEVO=0;
	public final static int MODIFICAR=1;
	public final static int AGREGAR=2;
	public final static int VOLVER=3;
	public final static int ELIMINAR=4;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmProductos dialog = new FrmProductos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmProductos() {
		getContentPane().setBackground(Color.WHITE);
		setBorder(null);
		setTitle("Productos");
		setBounds(100, 100, 714, 500);
		getContentPane().setLayout(null);
		{
			JLabel lblNombreDelProducto = new JLabel("Nombre del Producto:");
			lblNombreDelProducto.setBounds(22, 65, 126, 14);
			getContentPane().add(lblNombreDelProducto);
		}
		{
			txtNomPro = new JTextField();
			txtNomPro.setEnabled(false);
			txtNomPro.setBounds(155, 62, 216, 20);
			getContentPane().add(txtNomPro);
			txtNomPro.setColumns(10);
		}
		{
			btnAgregar = new JButton("Agregar");
			btnAgregar.addActionListener(this);
			btnAgregar.setEnabled(false);
			btnAgregar.setIcon(new ImageIcon(FrmProductos.class.getResource("/imagen/plus.png")));
			btnAgregar.setBounds(412, 100, 115, 34);
			getContentPane().add(btnAgregar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setIcon(new ImageIcon(FrmProductos.class.getResource("/imagen/delete_database.png")));
			btnEliminar.setBounds(548, 56, 115, 34);
			getContentPane().add(btnEliminar);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(this);
			btnVolver.setEnabled(false);
			btnVolver.setIcon(new ImageIcon(FrmProductos.class.getResource("/imagen/ok.png")));
			btnVolver.setBounds(548, 11, 115, 34);
			getContentPane().add(btnVolver);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setIcon(new ImageIcon(FrmProductos.class.getResource("/imagen/cerrar.png")));
			btnSalir.setBounds(548, 101, 115, 33);
			getContentPane().add(btnSalir);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setIcon(new ImageIcon(FrmProductos.class.getResource("/imagen/settings.png")));
			btnModificar.setBounds(412, 55, 115, 33);
			getContentPane().add(btnModificar);
		}
		{
			JLabel lblCodigoDelProducto = new JLabel("Codigo:");
			lblCodigoDelProducto.setBounds(22, 31, 126, 14);
			getContentPane().add(lblCodigoDelProducto);
		}
		{
			txtCodPRo = new JTextField();
			txtCodPRo.setBounds(155, 28, 86, 20);
			getContentPane().add(txtCodPRo);
			txtCodPRo.setColumns(10);
		}
		{
			JLabel lblPrecioDelProducoi = new JLabel("Precio:");
			lblPrecioDelProducoi.setBounds(22, 155, 126, 14);
			getContentPane().add(lblPrecioDelProducoi);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setEnabled(false);
			txtPrecio.setBounds(166, 153, 89, 20);
			getContentPane().add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Stock:");
			lblNewLabel.setBounds(22, 129, 120, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			txtStock = new JTextField();
			txtStock.setEnabled(false);
			txtStock.setBounds(155, 126, 86, 20);
			getContentPane().add(txtStock);
			txtStock.setColumns(10);
		}
		{
			JLabel lblCategoria = new JLabel("Tipo:");
			lblCategoria.setBounds(22, 90, 106, 14);
			getContentPane().add(lblCategoria);
		}
		{
			
		
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 226, 690, 236);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo del Producto");
		modelo.addColumn("Nombre del Producto");
		modelo.addColumn("Precio del Producto");
		modelo.addColumn("Categoria del Producto");
		modelo.addColumn("Stock del Producto");
		
		table.setModel(modelo);
		listar();
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmProductos.class.getResource("/imagen/database.png")));
		btnNuevo.setBounds(414, 11, 113, 34);
		getContentPane().add(btnNuevo);
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setIcon(new ImageIcon(FrmProductos.class.getResource("/imagen/ok.png")));
			btnAceptar.setVisible(false);
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(412, 146, 115, 34);
			getContentPane().add(btnAceptar);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.setVisible(false);
			btnBuscar.setIcon(new ImageIcon(FrmProductos.class.getResource("/imagen/search.png")));
			btnBuscar.setBounds(266, 15, 115, 35);
			getContentPane().add(btnBuscar);
		}
		{
			cboTipo = new JComboBox();
			cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Menu", "Bebidas", "Extras"}));
			cboTipo.setBounds(153, 87, 134, 20);
			getContentPane().add(cboTipo);
		}
	}
	
	private JComboBox cboTipo;
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
	
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipOperacion=MODIFICAR;
		habilitarBoton(true);
		habilitarEntrada(true);
	}
	void habilitarBoton(Boolean not){
		if(tipOperacion==NUEVO){
			btnModificar.setEnabled(not);
			btnVolver.setEnabled(!not);
			btnAgregar.setEnabled(!not);
			btnNuevo.setEnabled(not);
			btnEliminar.setEnabled(not);
		}
		if(tipOperacion==VOLVER){
			btnNuevo.setEnabled(!not);
			btnNuevo.setEnabled(not);
			btnVolver.setEnabled(!not);
			btnModificar.setEnabled(not);
			btnAgregar.setEnabled(!not);
			btnEliminar.setEnabled(not);
			btnAceptar.setVisible(!not);
			btnBuscar.setVisible(!not);
		}if(tipOperacion==MODIFICAR){
			btnVolver.setEnabled(not);
			btnNuevo.setEnabled(!not);
			btnEliminar.setEnabled(!not);
			btnAgregar.setEnabled(!not);
			btnModificar.setEnabled(!not);
			btnAceptar.setVisible(not);
			btnBuscar.setVisible(not);
		}
		if(tipOperacion==ELIMINAR){
			btnNuevo.setEnabled(!not);
			btnModificar.setEnabled(!not);
			btnVolver.setEnabled(not);
			btnEliminar.setEnabled(!not);
			btnBuscar.setVisible(not);
			btnAceptar.setVisible(not);
		}
	}
	void habilitarEntrada(Boolean not){
		if(tipOperacion==NUEVO){
			txtNomPro.setEnabled(!not);
			txtPrecio.setEnabled(!not);
			txtStock.setEnabled(!not);
			cboTipo.setEnabled(!not);
			
		}
		if(tipOperacion==VOLVER){
			txtCodPRo.setEnabled(!not);
			txtNomPro.setEnabled(!not);
			txtPrecio.setEnabled(!not);
			txtStock.setEnabled(!not);
			cboTipo.setEnabled(!not);
		}
		if(tipOperacion==MODIFICAR){
			txtCodPRo.setEnabled(not);
			txtCodPRo.requestFocus();
		}
		if(tipOperacion==ELIMINAR){
			txtCodPRo.setEnabled(not);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		tipOperacion=NUEVO;
		habilitarBoton(false);
		habilitarEntrada(false);
		/*
		switch (tipOperacion) {
		case AGREGAR:
			agregarProducto();
			break;

		default:
			break;
		}*/
		
	}
	/*http://pabletoreto.blogspot.com/2013/03/procedimientos-almacenados-en-mysql-java.html
	 * 
	 */
	void agregarProducto() {
		// TODO Auto-generated method stub
		try {
			String cod=leerCodigo();
			if (cod.length()==0||cod.length()>=10) {
				error("Ingrese El Codigo Del Producto", txtCodPRo);
				
			}else{
				String nom=leerNombreProducto();
				if (nom.length()<=6|| nom.length()>=100) {
					error("ingrese como minimo 8 cararteres y maximo de 100", txtNomPro);
				}
				else{
					int t=leerTipoMenu();
					if(t<=2){
						try {
							int stock=leerStockPRoducto();
							//String n=txtStock.getText();
							if(stock==0){
								error("Stock minimo 1 y maximo de 25", txtStock);
							}else{
								Producto newPro=new Producto(leerTipoMenu(), leerCodigo(), leerNombreProducto(), leerCatProducto().trim()
										, leerStockPRoducto(), leerPrecioProducto());
								int valor=produc.addProducto(newPro);
								if (valor==1){
									System.out.println("PRoducto Registrado");}
								else{
									System.out.println("PRducto no registrado");
								}
								
							}
							
						} catch (NumberFormatException e) {
							// TODO: handle exception
							error("Ingrese un numero", txtStock);
						}
					}
					else {
						mensaje("Selecione sun tipo");
					}					
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
			
		
	}
	void listar(){
		
		
	}
	

	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		tipOperacion=VOLVER;
		habilitarBoton(true);
		habilitarEntrada(true);
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipOperacion=ELIMINAR;
		habilitarBoton(true);
		habilitarEntrada(true);
	}
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {		
			agregarProducto();
	
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
	}
	String leerCodigo(){
		return txtCodPRo.getText().trim();		
	}
	String leerNombreProducto(){
		return txtNomPro.getText();
	}
	int leerTipoMenu(){
		return cboTipo.getSelectedIndex();
	}
	double leerPrecioProducto(){
		return Double.parseDouble(txtPrecio.getText());
	}
	String leerCatProducto(){
		return cboTipo.getSelectedItem()+"";
	}
	int leerStockPRoducto(){
		return Integer.parseInt(txtStock.getText());
	}
	
	void error(String s, JTextField txt){
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void mensaje(String s){
		JOptionPane.showMessageDialog(this, s);
	}
}
