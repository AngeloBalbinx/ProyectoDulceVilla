package entidad;

public class CabeceraCDP {
	// Atributos privados
	private String numCDP;
	private String fecha;
	private String codCli;
	private int codUsu;
	private double total;
	// Constructor
	public CabeceraCDP() {
	}
	public CabeceraCDP(String numCDP, String fecha, String codCli, int codUsu, double total) {
		
		this.numCDP = numCDP;
		this.fecha = fecha;
		this.codCli = codCli;
		this.codUsu = codUsu;
		this.total = total;
	}
	// métodos get/set
	public String getNumCDP() {
		return numCDP;
	}
	public void setNumCDP(String numCDP) {
		this.numCDP = numCDP;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCodCli() {
		return codCli;
	}
	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}
	public int getCodUsu() {
		return codUsu;
	}
	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
