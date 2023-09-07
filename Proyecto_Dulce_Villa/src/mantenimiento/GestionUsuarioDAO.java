package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidad.Usuario;
import interfaces.UsuarioInterfacesDAO;
import utils.MySQLConexion8;

public class GestionUsuarioDAO implements UsuarioInterfacesDAO{

	@Override
	public int registrar(Usuario u) {
		//Declaración de variables
				int res = 0;
				Connection con = null;
				PreparedStatement pstm = null;
				try {
					//paso 1: Establecer la conexiï¿½n a la base de datos
					con = MySQLConexion8.getConexion();
					//Paso 2 : determinar la instrucciï¿½n SQL --> Registrar
					String sql = "insert into tb_usuarios values (null,?,?,?,?,?,?,default)";
					//paso 3 : crear el objeto pstm y enviar la variable sql 
					pstm = con.prepareStatement(sql);
					//paso 4: parametros
					pstm.setString(1, u.getNombre());
					pstm.setString(2, u.getApellido());
					pstm.setString(3, u.getUsuario());
					pstm.setString(4, u.getClave());
					pstm.setString(5, u.getfNacim());
					pstm.setInt(6, u.getTipo());
					// paso 5 . ejecutar la instrucción
					res = pstm.executeUpdate();
					
				} catch (Exception e) {
					System.out.println(">>>>>>>>>>>> Error en la Instrucción SQL - Registrar" + e.getMessage());
				}finally {
					try {
						if(pstm != null ) pstm.close();
						if(con != null) con.close();
						
					} catch (SQLException e2) {
						System.out.println("<<<< Error al cerrar la base de datos "+ e2.getMessage());
					}
				}
				return res ;
	}

	@Override
	public Usuario ValidarAcceso(String user, String clave) {
		//Declaraciï¿½n de variables
				Usuario usuario = null;
				Connection con = null;
				PreparedStatement pstm = null;
				ResultSet res= null;
				try {
					//paso 1: Establecer la conexiï¿½n a la base de datos
					con = MySQLConexion8.getConexion();
					//Paso 2 : Consulta
					String sql = "{call usp_ValidarUsuario(?,?)}";
					//paso 3 : crear el objeto pstm y enviar la variable sql 
					pstm = con.prepareStatement(sql);
					//paso 4: parametros
					pstm.setString(1, user);
					pstm.setString(2, clave);
				
					// paso 5 . ejecutar la instrucciï¿½n
					res = pstm.executeQuery();
					// condicional
					if(res.next()){
						usuario = new Usuario(res.getInt(1),
											res.getString(2),
											res.getString(3),
											res.getString(4),
											res.getString(5),
											res.getString(6),
											res.getInt(7),
											res.getInt(8));
					}
					
				} catch (Exception e) {
					System.out.println(">>>>>>>>>>>> Error en la Instrucciï¿½n SQL - Validar" + e.getMessage());
				}finally {
					try {
						if(pstm != null ) pstm.close();
						if(con != null) con.close();
						
					} catch (SQLException e2) {
						System.out.println("<<<< Error al cerrar la base de datos "+ e2.getMessage());
					}
				}
				return usuario ;
	}

}
