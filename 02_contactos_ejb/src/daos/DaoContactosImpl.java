package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import model.Contacto;

@Stateless
public class DaoContactosImpl implements DaoContactos {

	private static final String url="jdbc:mysql://localhost:3306/agenda2";
	private static final String user="root";
	private static final String pwd="root";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void altaContacto() {
		try(Connection con=DriverManager.getConnection(url,user,pwd);){
			String sql="Insert into pedidos (producto,precio,categoria) values('libro php',20,'web')";
			Statement st=con.createStatement();
			st.execute(sql);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}



	/*
	 * public void altaContacto(Contacto contacto) { try(Connection
	 * con=DriverManager.getConnection(url,user,pwd);){ String
	 * sql="insert into contactos(nombre,email,edad) values(";
	 * sql+="'"+contacto.getNombre()+"','"+contacto.getEmail()+"',"+contacto.getEdad
	 * ()+")"; Statement st=con.createStatement(); st.execute(sql); }
	 * catch(SQLException ex) { ex.printStackTrace(); } }
	 */
	
	@Override
	public void altaContacto(Contacto contacto) {
		String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
		try(Connection con=DriverManager.getConnection(url,user,pwd);
				PreparedStatement prep=con.prepareStatement(sql);){	
			
			//Asignamos valore a los parametros
			prep.setString(1, contacto.getNombre());
			prep.setString(2, contacto.getEmail());
			prep.setInt(3, contacto.getEdad());
			
			//ejecutamos
			prep.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Contacto> recuperarContactos () {
		List<Contacto> res = new ArrayList<>();
		String sql = " SELECT  * FROM Contactos";
			
		try(Connection con=DriverManager.getConnection(url,user,pwd);
				PreparedStatement prep=con.prepareStatement(sql);
				ResultSet rs = prep.executeQuery (sql);){
						
			while (rs.next()) {
				Contacto contacto = new Contacto(rs.getInt("idContacto"),
																			 rs.getString("nombre"),
																			 rs.getString("email"),
																			 rs.getInt("edad"));
				res.add(contacto);
			}
		}		
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public void eliminarContacto(int id) {
	
		String sql = "DELETE FROM Contactos WHERE idContacto=?";
		
		try(Connection con=DriverManager.getConnection(url,user,pwd);
				PreparedStatement prep=con.prepareStatement(sql);){	
			
			//Asignamos valor al parametro
			prep.setInt(1, id);
			
			//ejecutamos
			prep.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}


}
