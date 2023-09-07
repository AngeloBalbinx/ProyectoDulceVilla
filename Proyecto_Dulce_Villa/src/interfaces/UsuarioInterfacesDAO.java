package interfaces;

import entidad.Usuario;

public interface UsuarioInterfacesDAO {
	// registrar
	public int registrar(Usuario u);
	// Validar el acceso al sistema
	public Usuario ValidarAcceso(String user,String clave);
}
