package entidad;

public class Cliente {
	// Atributos privados
	private String codigo;
	private String nombre;
	private String apellido;
	private String dirección;
	private String celular;
	// Constructores
	public Cliente() {
	
	}
	public Cliente(String codigo, String nombre, String apellido, String dirección, String celular) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dirección = dirección;
		this.celular = celular;
	}
	// Métodos get/set
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
	public String getDirección() {
		return dirección;
	}
	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
}
