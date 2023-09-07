package entidad;

public class DetalleCDP {
	// Atributos privados
	private String numCDP;
	private String idtorta;
	private int cantidad;
	private double preciovta;
	private double importe;
	// Constructor
	public DetalleCDP() {
	
	}
	public DetalleCDP(String numCDP, String idtorta, int cantidad, double preciovta, double importe) {
		this.numCDP = numCDP;
		this.idtorta = idtorta;
		this.cantidad = cantidad;
		this.preciovta = preciovta;
		this.importe = importe;
	}
	// Métodos get/set
	public String getNumCDP() {
		return numCDP;
	}
	public void setNumCDP(String numCDP) {
		this.numCDP = numCDP;
	}
	public String getIdtorta() {
		return idtorta;
	}
	public void setIdtorta(String idtorta) {
		this.idtorta = idtorta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPreciovta() {
		return preciovta;
	}
	public void setPreciovta(double preciovta) {
		this.preciovta = preciovta;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporta(double importe) {
		this.importe = importe;
	}
	
	
	
}
