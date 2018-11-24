package ConexionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.CallableStatement;

import model.Cliente;
import utils.Conexion;

public class ConexionCliente {
	
	public void add_cliente(Cliente cli){
		Connection con = null;
		CallableStatement calls=null;
		try {
			con= new Conexion().getConexion();
			con.setAutoCommit(false);
			String sp="{call add_cliente(?,?,?,?,?,?,?)}";
			calls=con.prepareCall(sp);
			calls.setString(1, cli.getCodigo());
			calls.setInt(2, cli.getDNI());
			calls.setString(3, cli.getNombre());
			calls.setString(4, cli.getApellido());
			calls.setInt(5, cli.getTelefono());
			calls.setInt(6, cli.getMesa());
			calls.setInt(7, cli.getEstado());
			calls.execute();
			con.commit();
            System.out.println("Insertado con exito");
		} catch (SQLException e) {
			// TODO: handle exception
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage()+" Error de Insertar datos");
			}
		}finally {
			try {
				con.close();
				calls.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage()+"error de cerado del procedimiento");
			}
		}
	}
	
	
	/*public int addCliente(Cliente cli){
		int valor=-1;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			con= new Conexion().getConexion();
			String sql= "insert into Clientes values (null,?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cli.getCodigo());
			pstm.setInt(2,cli.getDNI());
			pstm.setString(3,cli.getNombre() );
			pstm.setString(4, cli.getApellido());
			pstm.setInt(5, cli.getTelefono());
	
			valor =pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No REGISTRADO cliente");
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return valor;
	}*/
	
	

}
