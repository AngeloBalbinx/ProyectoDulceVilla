package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.CabeceraCDP;
import entidad.DetalleCDP;
import interfaces.VentaInterfacesDAO;
import utils.MySQLConexion8;

public class GestionVentasDAO implements VentaInterfacesDAO{

	@Override
	public String numCDP() {
		String codigo = "C0001";
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			//1.
			con = MySQLConexion8.getConexion();
			//2.
			String sql = "select substring(max(num_cdp),2)from tb_cab_cdp";
			//3.
			pstm = con.prepareStatement(sql);
			//4.
			//5. ejecutar la instrucción
			res = pstm.executeQuery();
			//6.
			if(res.next()){
				DecimalFormat df = new DecimalFormat("0000");
				codigo = "C" + df.format(Integer.parseInt(res.getString(1))+1);				
			}
		
			
		} catch (Exception e) {
			System.out.println("Error al generar número de CDP" + e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(res != null)res.close();
				if(con !=null)con.close();
			} catch (SQLException e2) {
				System.out.println(">>>>>>>>Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return codigo;
	}

	@Override
	public int realizarVenta(CabeceraCDP cCdp, ArrayList<DetalleCDP> dCdp) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm1 = null; // registrar los datos en la tabla tb_cab_cdp
		PreparedStatement pstm2 = null; // registrar los datos en la tabla tb_det_cdp
		PreparedStatement pstm3 = null; // actualizar la tabla torta(stock)
		try {
			//1.
			con = MySQLConexion8.getConexion();
			//2.
			con.setAutoCommit(false);
			//Instrucción SQL --> Registrar los datos a la tb_cab_cdp
			String sql1 = "insert into tb_cab_cdp values(?,?,?,?,?)";
			//
			pstm1= con.prepareStatement(sql1);
			//parametros
			pstm1.setString(1, cCdp.getNumCDP());
			pstm1.setString(2, cCdp.getFecha());
			pstm1.setString(3, cCdp.getCodCli());
			pstm1.setInt(4, cCdp.getCodUsu());
			pstm1.setDouble(5, cCdp.getTotal());
			// ejecutar
			estado = pstm1.executeUpdate();
			
			// Instrucción sql2 --> registrar los datos a la tb_det_cdp
			String sql2 = "insert into tb_det_cdp values(?,?,?,?,?)";
			for (DetalleCDP detalleCDP : dCdp) {
				pstm2 = con.prepareStatement(sql2);
				// parametros
				pstm2.setString(1, cCdp.getNumCDP());
				pstm2.setString(2, detalleCDP.getIdtorta());
				pstm2.setInt(3, detalleCDP.getCantidad());
				pstm2.setDouble(4, detalleCDP.getPreciovta());
				pstm2.setDouble(5, detalleCDP.getImporte());
				// ejecutar
				estado = pstm2.executeUpdate();
			}
			// Instrucción sql3-- > actualizar la tabla productos(stock)
			String sql3 = "update tb_torta set stock = stock- ? where id_torta=?";
			for (DetalleCDP detalleCDP : dCdp) {
				//
				pstm3 = con.prepareStatement(sql3);
				//
				pstm3.setInt(1, detalleCDP.getCantidad());
				pstm3.setString(2, detalleCDP.getIdtorta());
				//
				estado = pstm3.executeUpdate();
			}
			//confirmar transacciones
			con.commit();
			
		} catch (Exception e) {
			System.out.println("Error al realizar la venta" + e.getMessage());
			try {
				con.rollback();
			} catch (Exception e2) {
				System.out.println("Error al restaurar la BD" + e.getMessage());
			}
		}finally {
			try {
				if(pstm1 != null)pstm1.close();
				if(pstm2 != null)pstm2.close();
				if(pstm3 != null)pstm3.close();
				if(con !=null)con.close();
			} catch (SQLException e2) {
				System.out.println(">>>>>>>>Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return estado;
	}

}
