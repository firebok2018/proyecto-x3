package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionDatabase.ConexionLogin;
import ConexionDatabase.ConexionSign_In;
import model.Encrypt;
import model.Usuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Component;

public class JIFSign_In extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblUsuario;
	private JTextField txtUser;
	private JLabel lblContrasea;
	private JPasswordField txtPassword;
	private JButton btnIngresar;

	private int login;
	public final static int SIGNIN = 0;
	public final static int NOTSIGNIN = 1;
	private JLabel lblNewLabel;
	private JButton btnClose;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIFSign_In frame = new JIFSign_In();
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
	public JIFSign_In() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 457);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblUsuario.setBounds(112, 183, 130, 14);
		contentPane.add(lblUsuario);
		
		txtUser = new JTextField();
		txtUser.setMargin(new Insets(2, 5, 2, 2));
		txtUser.setFont(new Font("Consolas", Font.BOLD, 16));
		txtUser.setBounds(65, 208, 200, 26);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblContrasea.setBounds(98, 245, 160, 33);
		contentPane.add(lblContrasea);
		
		txtPassword = new JPasswordField();
		txtPassword.setMargin(new Insets(2, 5, 2, 2));
		txtPassword.setFont(new Font("Consolas", Font.BOLD, 16));
		txtPassword.setBounds(65, 283, 200, 26);
		contentPane.add(txtPassword);
		
		btnIngresar = new JButton("Ingresar");
		//btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		btnIngresar.setIcon(new ImageIcon(JIFSign_In.class.getResource("/imagen/ok.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(112, 344, 130, 33);
		contentPane.add(btnIngresar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JIFSign_In.class.getResource("/imagen/user.png")));
		lblNewLabel.setBounds(98, 16, 160, 156);
		contentPane.add(lblNewLabel);
		
		btnClose = new JButton("");
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnClose.setAlignmentY(Component.TOP_ALIGNMENT);
		btnClose.addActionListener(this);
		btnClose.setBorder(null);
		btnClose.setBackground(Color.WHITE);
		btnClose.setIcon(new ImageIcon(JIFSign_In.class.getResource("/imagen/cerrar.png")));
		btnClose.setBounds(295, 11, 34, 33);
		contentPane.add(btnClose);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnClose) {
			actionPerformedBtnClose(arg0);
		}
		
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		ConexionLogin login= new ConexionLogin();
		/*
		if(login.Sign_In(leerUser(), leerPwd())==1){
			this.dispose();
			System.out.println("ingresando al sistema");
			
			JOptionPane.showMessageDialog(null, "Acceso permitido :\n"+leerUser());
			
			JFSsytemRepair prin= new JFSsytemRepair();
			prin.setLocationRelativeTo(prin);
			prin.setVisible(true);
		}
		else{
			System.out.println("erro de ingreso");
			JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
			        + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
			        JOptionPane.ERROR_MESSAGE);
		}*/
		if (login==null) {
			System.out.println("Registra");
			this.dispose();
			FrmPrincipal sys= new FrmPrincipal();
			sys.setLocationRelativeTo(sys);
			sys.setVisible(true);
		}else{
			System.out.println("NO esta registrado");
			JOptionPane.showMessageDialog(null, "Usted no se encuentra registrado",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	void enableButon(boolean yes){
		if(login==SIGNIN){
			btnIngresar.setEnabled(!yes);
		}
		if (login==NOTSIGNIN) {
			btnIngresar.setEnabled(yes);
		}
	}
	String leerUser() {
		return txtUser.getText();
	}
	String leerPwd(){
		String pwd = new String(txtPassword.getPassword());
		return pwd;
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
	}
	
	protected void actionPerformedBtnClose(ActionEvent arg0) {
		System.exit(0);
	}
}
