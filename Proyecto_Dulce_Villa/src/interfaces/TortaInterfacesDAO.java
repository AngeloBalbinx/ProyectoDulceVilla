package interfaces;

import java.util.ArrayList;

import entidad.Torta;

public interface TortaInterfacesDAO {
	// Registrar
	public int registrar(Torta tor);
	// Actualizar
	public int actualizar(Torta tor);
	// Eliminar
	public int eliminar(String idtorta);
	// Listar o consultar tabla
	public ArrayList<Torta> listarTortas();
	// Reporte torta por tipo
	public ArrayList<Torta> listarTortaxTipo(int tipo);
	// Buscar producto
	public ArrayList<Torta> buscarTorta(String tor);
	
}
