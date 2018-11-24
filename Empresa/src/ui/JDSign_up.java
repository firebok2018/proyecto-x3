  package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionDatabase.ConexionPrevilegio;
import ConexionDatabase.ConexionSign_Up;
import model.Encrypt;
import model.Previlegio;
import model.Usuarios;
import utils.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;

public class JDSign_up extends JInternalFrame implements ActionListener, KeyListener, FocusListener {
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblConfirmarContrasea;
	private JLabel lblNombre;
	private JLabel lblCorreo;
	private JLabel lblApellido;
	private JTextField txtUser;
	private JTextField txtCorreo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnRegistrar;
	private JPasswordField txtPassword;
	private JPasswordField txtPasswordConfirm;
	
	
	ConexionSign_Up users= new ConexionSign_Up();
	
	private JLabel lblRegistroDeNuevo;
	private JButton btnLimpiar;
	private JComboBox cboPrivilegio;
	
	private int form;
	public final static int REGISTRAR = 0;
	public final static int NOTREGISTRAR = 1;
	private JButton btnCerrar;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JLabel lblPrivilegio;
	ConexionSign_Up SingUp = new ConexionSign_Up();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDSign_up dialog = new JDSign_up();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDSign_up() {
		//setModal(true);
		setResizable(false);
		setBounds(100, 100, 445, 539);
		getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(28, 49, 72, 14);
		getContentPane().add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(28, 74, 89, 14);
		getContentPane().add(lblContrasea);
		
		lblConfirmarContrasea = new JLabel("<html>Confirmar Contrase\u00F1a:</html>");
		lblConfirmarContrasea.setBounds(28, 99, 89, 28);
		getContentPane().add(lblConfirmarContrasea);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 163, 72, 14);
		getContentPane().add(lblNombre);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(28, 138, 72, 14);
		getContentPane().add(lblCorreo);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(28, 188, 72, 14);
		getContentPane().add(lblApellido);
		
		txtUser = new JTextField();
		txtUser.setBounds(110, 46, 153, 20);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(110, 135, 153, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(110, 160, 215, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(110, 185, 215, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(JDSign_up.class.getResource("/imagen/addUser.png")));
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(169, 446, 125, 33);
		getContentPane().add(btnRegistrar);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(110, 71, 153, 20);
		getContentPane().add(txtPassword);
		
		txtPasswordConfirm = new JPasswordField();
		txtPasswordConfirm.addFocusListener(this);
		txtPasswordConfirm.addKeyListener(this);
		txtPasswordConfirm.setBounds(110, 102, 153, 20);
		getContentPane().add(txtPasswordConfirm);
		
		lblRegistroDeNuevo = new JLabel("Registro de Nuevo Usuario");
		lblRegistroDeNuevo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistroDeNuevo.setBounds(61, 11, 264, 27);
		getContentPane().add(lblRegistroDeNuevo);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(JDSign_up.class.getResource("/imagen/view_details.png")));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(28, 446, 105, 33);
		getContentPane().add(btnLimpiar);
		
		cboPrivilegio = new JComboBox();
		cboPrivilegio.setBounds(110, 216, 137, 20);
		getContentPane().add(cboPrivilegio);
		ConexionPrevilegio Cperm = new ConexionPrevilegio();
		Cperm.TipPrev(cboPrivilegio);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(JDSign_up.class.getResource("/imagen/cerrar.png")));
		btnCerrar.setBounds(318, 446, 111, 33);
		getContentPane().add(btnCerrar);
		
		checkBox = new JCheckBox("Configurac\u00F3n");
		checkBox.setBounds(36, 258, 97, 23);
		getContentPane().add(checkBox);
		
		checkBox_1 = new JCheckBox("Agregar mesa");
		checkBox_1.setBounds(36, 299, 97, 23);
		getContentPane().add(checkBox_1);
		
		checkBox_2 = new JCheckBox("Modificar Productos");
		checkBox_2.setBounds(169, 299, 141, 23);
		getContentPane().add(checkBox_2);
		
		checkBox_3 = new JCheckBox("Configurar precios");
		checkBox_3.setBounds(169, 258, 146, 23);
		getContentPane().add(checkBox_3);
		
		lblPrivilegio = new JLabel("Privilegio:");
		lblPrivilegio.setBounds(28, 219, 60, 14);
		getContentPane().add(lblPrivilegio);
		
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(arg0);
		}
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
		
	}
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		
		//String pwd= new String(txtPassword.getPassword());
		//String pwdEncrypt = Encrypt.sha1(pwd);
		
		if (leerPwd().equals(leerPwdCofirm())) {
			if (leerUser().length()==0 || leerPwd().length()==0 ||
					leerPwdCofirm().length()==0 || leerCorreo().length()==0 ||
					leerNomUser().length()==0 || leerApeUser().length()==0  ) {
				System.out.println("rellene todos los campos requeridos");
				JOptionPane.showMessageDialog(null, "Ingrese Todos campos requeridos");
				this.requestFocus();
	
			}else{
				String pwdEncrypt = Encrypt.sha1(leerPwd());
				//Usuarios newUser= new Usuarios(0, leerUser(), pwdEncrypt, leerCorreo(), leerNomUser(), leerApeUser(),leerLastSigIn(),leerTimeSignIn(),leerTipo() );
				Usuarios usr= new Usuarios(leerUser(), pwdEncrypt, leerCorreo(), leerNomUser(), leerApeUser(), leerLastSigIn(), leerTimeSignIn(), leerTipo());
				SingUp.Sign_up(usr);
			}
			
		}else{
			System.out.println("Contraseña incoorecta");
		}
	}
	//obtencion de datos del formulario
	String leerUser() { return txtUser.getText();}
	String leerPwd(){ String pwd = new String(txtPassword.getPassword()); return pwd;}
	String leerPwdCofirm(){ String pwdC = new String(txtPasswordConfirm.getPassword()); return pwdC;}
	String leerCorreo(){ return txtCorreo.getText();}
	String leerNomUser(){ return txtNombre.getText();}
	String leerApeUser(){ return txtApellido.getText();}
	String leerLastSigIn(){
		Date d = new Date();
		DateFormat f1= DateFormat.getDateInstance();
		String date= f1.format(d);
		return date;
	}
	String leerTimeSignIn(){
		Date t = new Date();		
		DateFormat fh= DateFormat.getTimeInstance();
		String time=fh.format(t);
		return time;
	}
	int leerTipo(){ return cboPrivilegio.getSelectedIndex();}
	void limpiar(JTextField s){ s.setText(null);}
	protected void actionPerformedBtnLimpiar(ActionEvent arg0) {
		limpiar(txtUser);
		limpiar(txtPassword);
		limpiar(txtPasswordConfirm);
		limpiar(txtCorreo);
		limpiar(txtNombre);
		limpiar(txtApellido);
		txtUser.requestFocus();
		cboPrivilegio.setSelectedIndex(0);	
	}

	public void focusGained(FocusEvent arg0) {
		if (arg0.getSource() == txtPasswordConfirm) {
			focusGainedTxtPasswordConfirm(arg0);
		}
	}
	public void focusLost(FocusEvent arg0) {
		System.out.println("Fous Lost");
		if (leerPwd().equals(leerPwdCofirm())) {
			System.out.println("Las Contraseñas Coinciden");
			form=REGISTRAR;
			enableBoton(true);
			//btnRegistrar.setEnabled(true);
			
		} else {
			System.out.println("No COINIDEN????????????????");
			//btnRegistrar.setEnabled(false);
			form=NOTREGISTRAR;
			enableBoton(false);
		}
	}
	protected void focusGainedTxtPasswordConfirm(FocusEvent arg0) {
		//System.out.println("SALIENDO DEL TXTFILED");
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	void enableBoton(boolean yes){
		if(form==REGISTRAR){
			btnRegistrar.setEnabled(yes);
		}
		if(form==NOTREGISTRAR){
			btnRegistrar.setEnabled(yes);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
}

	
