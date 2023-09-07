package interfaces;

import java.util.ArrayList;

import entidad.CabeceraCDP;
import entidad.DetalleCDP;

public interface VentaInterfacesDAO {
	// método para generar el número de CDP
	public String numCDP();
	
	// proceso de transacción
	public int realizarVenta(CabeceraCDP cCdp,ArrayList<DetalleCDP>dCdp);
}
