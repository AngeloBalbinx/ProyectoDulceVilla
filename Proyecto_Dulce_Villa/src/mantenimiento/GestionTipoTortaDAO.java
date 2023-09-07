package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.TipoTorta;
import interfaces.TipoTortaInterfacesDAO;
import utils.MySQLConexion8;

public class GestionTipoTortaDAO implements TipoTortaInterfacesDAO {

	@Override
	public ArrayList<TipoTorta> listaTipoTorta() {
		ArrayList<TipoTorta> lista = new ArrayList<TipoTorta>();
		TipoTorta tip;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			//paso1: Establecer la conexión a la base de datos 
			con = MySQLConexion8.getConexion();
			//paso2: determinar la instrucción SQL ---> Consultar
			String sql = "SELECT * FROM tb_tipo";
			//paso3: enviar la instrucción al objeto pstm -- comandos sql
			pstm = con.prepareStatement(sql);
			//paso4: parametros-- NO HAY
			//paso5: ejecutar la instrucción
			res = pstm.executeQuery();
			//paso6: bucle para realizar el recorrido al objeto "res"
			while(res.next()){
				// crear un objeto de tipo "Usuario"
				tip = new TipoTorta();
				// setear (asignar valores del objeto "res" a los atributos privados
				tip.setIdtipo(res.getInt(1));
				tip.setDescripcion(res.getString(2));
				// añadir el objeto user al arreglo
				lista.add(tip);
			}
			
		} catch (Exception e) {
			System.out.println(">>>>>>> Error en la instrucción SQL - Consultar" + e.getMessage());
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

