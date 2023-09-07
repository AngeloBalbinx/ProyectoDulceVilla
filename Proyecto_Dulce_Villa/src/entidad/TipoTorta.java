package entidad;

public class TipoTorta {
	// Atributos privados
	private int idtipo;
	private String descripcion;
	// Constructores
	public TipoTorta() {

	}
	public TipoTorta(int idtipo, String descripcion) {
		super();
		this.idtipo = idtipo;
		this.descripcion = descripcion;
	}
	// Métodos de acceso get/set
	public int getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
