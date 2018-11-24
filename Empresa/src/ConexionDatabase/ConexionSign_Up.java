package ConexionDatabase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;



import model.Usuarios;
import utils.Conexion;

public class ConexionSign_Up extends Conexion {
	/*
	public int Sign_Up(Usuarios user){		
		int valor=-1;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			con= new Conexion().getConexion();
			String sql= "insert into Usuarios values (null,?,?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, user.getUsuario());
			pstm.setString(2,user.getPassword());
			pstm.setString(3, user.getCorreo());
			pstm.setString(4, user.getNomUser());
			pstm.setString(5, user.getApeUser());
			pstm.setString(6, user.getLastSigIn());
			pstm.setString(7, user.getTimeSignIn());
			pstm.setInt(8, user.getTipo());
			
			valor =pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No REGISTRADO");
			
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
		//https://gist.github.com/jujogracu/3069429

	}*/
	public void Sign_up(Usuarios user){
		Connection con= null;
		CallableStatement callsp=null;
		//'incautipa flores','23/11/2018 s','8:18 pm',1);
		try {
			con= new Conexion().getConexion();
			String sp="{call add_usuario(?,?,?,?,?,?,?,?)}";
			con.setAutoCommit(false);
			callsp= con.prepareCall(sp);
			callsp.setString(1, user.getUsuario());
			callsp.setString(2, user.getPassword());
			callsp.setString(3, user.getCorreo());
			callsp.setString(4, user.getNomUser());
			callsp.setString(5, user.getApeUser());
			callsp.setString(6, user.getLastSigIn());
			callsp.setString(7, user.getTimeSignIn());
			callsp.setInt(8, user.getTipo());
			callsp.execute();
			con.commit();
			 System.out.println("nuevo usuario agregado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage()+" Error al registrar USuarios");
			}
		}finally {
			try {
				con.close();
				callsp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage()+"error de cerado del procedimiento");

			}
		}
	}

}
