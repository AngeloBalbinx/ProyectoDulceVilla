package entidad;

public class Torta {
	// Atributos privados 
	private String idtorta;
	private String descripci�n;
	private int stock;
	private double precio;
	private int tipo;
	// Constructores
	public Torta() {
	}
	public Torta(String idtorta, String descripci�n, int stock, double precio, int tipo) {
		super();
		this.idtorta = idtorta;
		this.descripci�n = descripci�n;
		this.stock = stock;
		this.precio = precio;
		this.tipo = tipo;
	}
	// M�todos de acceso get/set
	public String getIdtorta() {
		return idtorta;
	}
	public void setIdtorta(String idtorta) {
		this.idtorta = idtorta;
	}
	public String getDescripci�n() {
		return descripci�n;
	}
	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
