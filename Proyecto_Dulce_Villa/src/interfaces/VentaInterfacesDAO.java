package interfaces;

import java.util.ArrayList;

import entidad.CabeceraCDP;
import entidad.DetalleCDP;

public interface VentaInterfacesDAO {
	// m�todo para generar el n�mero de CDP
	public String numCDP();
	
	// proceso de transacci�n
	public int realizarVenta(CabeceraCDP cCdp,ArrayList<DetalleCDP>dCdp);
}
