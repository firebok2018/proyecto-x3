package model;

public class Producto {
	private int idPro;
	private String Codigo;
	private String Nombre;
	private String Tipo;
	private int Stock;
	private double Precio;
	
	
	public Producto(int idPro, String codigo, String nombre, String tipo, int stock, double precio) {
		super();
		this.idPro = idPro;
		Codigo = codigo;
		Nombre = nombre;
		Tipo = tipo;
		Stock = stock;
		Precio = precio;
	}
	public int getIdPro() {
		return idPro;
	}
	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	

}
