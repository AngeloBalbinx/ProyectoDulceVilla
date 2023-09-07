package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.TipoUsuario;
import interfaces.TipoUsuarioInterfacesDAO;
import utils.MySQLConexion8;

public class GestionTipoUsuarioDAO implements TipoUsuarioInterfacesDAO{

	@Override
	public ArrayList<TipoUsuario> listaTipoUsuario() {
		ArrayList<TipoUsuario> lista = new ArrayList<TipoUsuario>();
		TipoUsuario tip;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			//paso1: Establecer la conexi�n a la base de datos 
			con = MySQLConexion8.getConexion();
			//paso2: determinar la instrucci�n SQL ---> Consultar
			String sql = "SELECT * FROM tb_tipouser";
			//paso3: enviar la instrucci�n al objeto pstm -- comandos sql
			pstm = con.prepareStatement(sql);
			//paso4: parametros-- NO HAY
			//paso5: ejecutar la instrucci�n
			res = pstm.executeQuery();
			//paso6: bucle para realizar el recorrido al objeto "res"
			while(res.next()){
				// crear un objeto de tipo "Usuario"
				tip = new TipoUsuario();
				// setear (asignar valores del objeto "res" a los atributos privados
				tip.setIdtipo(res.getInt(1));
				tip.setDescripcion(res.getString(2));
				// a�adir el objeto user al arreglo
				lista.add(tip);
			}
			
		} catch (Exception e) {
			System.out.println(">>>>>>> Error en la instrucci�n SQL - Consultar" + e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(res != null)res.close();
				if(con !=null)con.close();
			} catch (SQLException e2) {
				System.out.println(">>>>>>>>Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		
		return lista;
	}

}
