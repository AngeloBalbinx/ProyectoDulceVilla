package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entidad.Torta;
import interfaces.TortaInterfacesDAO;
import utils.MySQLConexion8;

public class GestionTortaDAO implements TortaInterfacesDAO{

	@Override
	public int registrar(Torta tor) {
		//Declaración de variables
		int res=0;
		Connection con =null;
		PreparedStatement pstm =null;
		try {
			//paso1: Establecer la conexión a la base de datos 
			con = MySQLConexion8.getConexion();
			//paso2: Determinar la instrucción SQL ---> Registrar
			String sql = "insert into tb_torta values(?,?,?,?,?)";
			//paso3 : Crear el objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);
			//paso4 : Parametros
			pstm.setString(1, tor.getIdtorta());
			pstm.setString(2, tor.getDescripción());
			pstm.setInt(3, tor.getStock());
			pstm.setDouble(4, tor.getPrecio());
			pstm.setInt(5, tor.getTipo());
			//paso5: Ejecutar la instrucción
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(">>>>>>> Error en la instrucción SQL- Registrar" + e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(con !=null)con.close();
			} catch (SQLException e2) {
				System.out.println(">>>>>>>>Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int actualizar(Torta tor) {
		int res = 0;
		Connection con =null;
		PreparedStatement pstm =null;
		try {
			//paso1: Establecer la conexión a la base de datos 
			con = MySQLConexion8.getConexion();
			//paso2: determinar la instrucción SQL ---> Actualizar
			String sql = "update tb_torta set descripcion = ?,stock = ?,precio = ?,id_tipo= ? where id_torta = ?";
			// paso 3: enviar la instrucción al objeto pstm -->o obtener los comandos SQL
			pstm = con.prepareStatement(sql);
			// paso 4:parametros
			pstm.setString(1, tor.getDescripción());
			pstm.setInt(2, tor.getStock());
			pstm.setDouble(3, tor.getPrecio());
			pstm.setInt(4, tor.getTipo());
			pstm.setString(5, tor.getIdtorta());
			// paso 5: ejectura la instrucción
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(">>>>>>> Error en la instrucción SQL- Actualizar" + e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(con !=null)con.close();
			} catch (SQLException e2) {
				System.out.println(">>>>>>>>Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int eliminar(String idtorta) {
		int res = 0;
		Connection con =null;
		PreparedStatement pstm =null;
		try {
			//paso1: Establecer la conexión a la base de datos 
			con = MySQLConexion8.getConexion();
			//paso2: determinar la instrucción SQL ---> Eliminar
			String sql = "delete from tb_torta where id_torta = ?";
			//paso3: enviar instrucción al objeto pstm --- obtener comandos SQL
			pstm = con.prepareStatement(sql);
			//paso4: parametros
			pstm.setString(1, idtorta);
			//paso5: ejectuta la instrucción
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(">>>>>>> Error en la instrucción SQL- Eliminar" + e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(con !=null)con.close();
			} catch (SQLException e2) {
				System.out.println(">>>>>>>>Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public ArrayList<Torta> listarTortas() {
		ArrayList<Torta> lista = new ArrayList<Torta>();//null
		Torta tor;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			//paso1: Establecer la conexión a la base de datos 
			con = MySQLConexion8.getConexion();
			//paso2: determinar la instrucción SQL ---> Consultar
			String sql = "SELECT * FROM tb_torta";
			//paso3: enviar la instrucción al objeto pstm -- comandos sql
			pstm = con.prepareStatement(sql);
			//paso4: parametros-- NO HAY
			//paso5: ejecutar la instrucción
			res = pstm.executeQuery();
			//paso6: bucle para realizar el recorrido al objeto "res"
			while(res.next()){
				// crear un objeto de tipo "Torta"
				tor = new Torta();
				// setear (asignar valores del objeto "res" a los atributos privados
				tor.setIdtorta(res.getString(1));
				tor.setDescripción(res.getString(2));
				tor.setStock(res.getInt(3));
				tor.setPrecio(res.getDouble(4));
				tor.setTipo(res.getInt(5));
				// añadir el objeto tor al arreglo
				lista.add(tor);
			}
			
		} catch (Exception e) {
			System.out.println(">>>>>>> Error en la instrucción SQL- Consultar" + e.getMessage());
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

	@Override
	public ArrayList<Torta> listarTortaxTipo(int tipo) {
		ArrayList<Torta> lista = new ArrayList<Torta>();//null
		Torta tor;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			//paso1: Establecer la conexión a la base de datos 
			con = MySQLConexion8.getConexion();
			//paso2: determinar la instrucción SQL ---> Consultar
			String sql = "SELECT * FROM tb_torta where id_tipo = ?";
			//paso3: enviar la instrucción al objeto pstm -- comandos sql
			pstm = con.prepareStatement(sql);
			//paso4: parametros--
			pstm.setInt(1, tipo);
			//paso5: ejecutar la instrucción
			res = pstm.executeQuery();
			//paso6: bucle para realizar el recorrido al objeto "res"
			while(res.next()){
				// crear un objeto de tipo "Torta"
				tor = new Torta();
				// setear (asignar valores del objeto "res" a los atributos privados
				tor.setIdtorta(res.getString(1));
				tor.setDescripción(res.getString(2));
				tor.setStock(res.getInt(3));
				tor.setPrecio(res.getDouble(4));
				tor.setTipo(res.getInt(5));
				// añadir el objeto tor al arreglo
				lista.add(tor);
			}
			
		} catch (Exception e) {
			System.out.println(">>>>>>> Error en la instrucción SQL- Registrar" + e.getMessage());
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

	@Override
	public ArrayList<Torta> buscarTorta(String tor) {
		ArrayList<Torta> lista = new ArrayList<Torta>();//null
		Torta tort;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			//paso1: Establecer la conexión a la base de datos 
			con = MySQLConexion8.getConexion();
			//paso2: determinar la instrucción SQL ---> Consultar
			String sql = "{call usp_BuscarTorta(?)}";
			//paso3: enviar la instrucción al objeto pstm -- comandos sql
			pstm = con.prepareStatement(sql);
			//paso4: parametros-- 
			pstm.setString(1, tor);
			//paso5: ejecutar la instrucción
			res = pstm.executeQuery();
			//paso6: bucle para realizar el recorrido al objeto "res"
			while(res.next()){
				// crear un objeto de tipo "Torta"
				tort = new Torta();
				// setear (asignar valores del objeto "res" a los atributos privados
				tort.setIdtorta(res.getString(1));
				tort.setDescripción(res.getString(2));
				tort.setStock(res.getInt(3));
				tort.setPrecio(res.getDouble(4));
				tort.setTipo(res.getInt(5));
				// añadir el objeto tor al arreglo
				lista.add(tort);
			}
			
		} catch (Exception e) {
			System.out.println(">>>>>>> Error en la instrucción SQL- Consultar" + e.getMessage());
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
