package entidad;

public class Torta {
	// Atributos privados 
	private String idtorta;
	private String descripción;
	private int stock;
	private double precio;
	private int tipo;
	// Constructores
	public Torta() {
	}
	public Torta(String idtorta, String descripción, int stock, double precio, int tipo) {
		super();
		this.idtorta = idtorta;
		this.descripción = descripción;
		this.stock = stock;
		this.precio = precio;
		this.tipo = tipo;
	}
	// Métodos de acceso get/set
	public String getIdtorta() {
		return idtorta;
	}
	public void setIdtorta(String idtorta) {
		this.idtorta = idtorta;
	}
	public String getDescripción() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
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
