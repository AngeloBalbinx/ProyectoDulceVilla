package entidad;

public class Cliente {
	// Atributos privados
	private String codigo;
	private String nombre;
	private String apellido;
	private String direcci�n;
	private String celular;
	// Constructores
	public Cliente() {
	
	}
	public Cliente(String codigo, String nombre, String apellido, String direcci�n, String celular) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direcci�n = direcci�n;
		this.celular = celular;
	}
	// M�todos get/set
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDirecci�n() {
		return direcci�n;
	}
	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
}
