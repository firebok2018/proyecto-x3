package model;

public class Servicio {
	private int codigo;
	private String nomServi;
	private String Placa;
	private String descripcion;
	public Servicio(int codigo, String nomServi, String placa, String descripcion) {
		super();
		this.codigo = codigo;
		this.nomServi = nomServi;
		Placa = placa;
		this.descripcion = descripcion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomServi() {
		return nomServi;
	}
	public void setNomServi(String nomServi) {
		this.nomServi = nomServi;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
