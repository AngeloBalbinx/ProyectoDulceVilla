package interfaces;

import java.util.ArrayList;

import entidad.Cliente;


public interface ClienteInterfacesDAO {
	// Registrar
	public int registrar(Cliente cli);
	// Actualizar
	public int actualizar(Cliente cli);
	// Eliminar
	public int eliminar(String codigo);
	// Listar
	public ArrayList<Cliente> listarClientes();
}
