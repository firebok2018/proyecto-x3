package model;

import java.sql.Date;

public class Usuarios {
	private int idUser;
	private String usuario;
	private String password;
	private String correo;
	private String nomUser;
	private String apeUser;
	private String lastSigIn;
	private String timeSignIn;
	private int tipo;
	public Usuarios(int idUser, String usuario, String password, String correo, String nomUser, String apeUser,
			String lastSigIn, String timeSignIn, int tipo) {
		super();
		this.idUser = idUser;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.nomUser = nomUser;
		this.apeUser = apeUser;
		this.lastSigIn = lastSigIn;
		this.timeSignIn = timeSignIn;
		this.tipo = tipo;
	}
	public Usuarios(String usuario, String password, String correo, String nomUser, String apeUser, String lastSigIn,
			String timeSignIn, int tipo) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.nomUser = nomUser;
		this.apeUser = apeUser;
		this.lastSigIn = lastSigIn;
		this.timeSignIn = timeSignIn;
		this.tipo = tipo;
	}
	

	public Usuarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getApeUser() {
		return apeUser;
	}
	public void setApeUser(String apeUser) {
		this.apeUser = apeUser;
	}
	public String getLastSigIn() {
		return lastSigIn;
	}
	public void setLastSigIn(String lastSigIn) {
		this.lastSigIn = lastSigIn;
	}
	public String getTimeSignIn() {
		return timeSignIn;
	}
	public void setTimeSignIn(String timeSignIn) {
		this.timeSignIn = timeSignIn;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
