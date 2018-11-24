package ConexionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Producto;
import utils.Conexion;

public class ConexionProductos {
	
	public int addProducto(Producto pro){
		int valor=-1;
		Connection con =null;
		PreparedStatement pstm=null;
		try {
			con= new Conexion().getConexion();
			String sql="insert into Productos values(?,?,?,?,?)";
			pstm= con.prepareStatement(sql);
			pstm.setInt(1, pro.getIdPro());
			pstm.setString(2,pro.getCodigo() );
			pstm.setString(3, pro.getNombre());
			pstm.setInt(4, pro.getStock());
			pstm.setDouble(5, pro.getPrecio());
			valor= pstm.executeUpdate();
					
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No REGISTRADO");	
		}finally {
			try {
				con.close();
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return valor;
	}

}
