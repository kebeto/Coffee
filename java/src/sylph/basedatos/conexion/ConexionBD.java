package sylph.basedatos.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBD {

	private Connection con;
	private	Statement st;
	private ResultSet rs;
	
	public ConexionBD() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sylph", "root", "root");
			st = con.createStatement();
			//sentencia de ingreso de clientes//
			String query = "INSERT INTO administrador2 (Nombre, Apellido, CorreoElectronico, Contrasena) "
					+ "						   VAlUES ('Edwin','Bedoya','kebeto.dev@gmail.com','asdf')";
			st.execute(query);
			System.out.println("Un administrador fue ingresado");
			
			//consulta en main
			
			//Actualizar datos
			String actulizar =  "UPDATE administrador2 SET Nombre = 'Edwin' WHERE id = 3 " ;
			st.executeUpdate(actulizar);
			System.out.println("Actualización completada");
			//eliminar
			String eliminar = "DELETE FROM administrador2 WHERE id = 3 ";
			System.out.println("Eliminación completada");
						
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void getDatos() {
		
		try {
			
			String query = "SELECT * FROM cliente";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				String usuario = rs.getString("ID_Cliente");
				String nombre = rs.getString("Nombre");
				String apellido = rs.getString("Apellido");
				String correo = rs.getString("CorreoElectronico");
				String contrasena = rs.getString("Contrasena");
				String direccion  = rs.getString("Direccion");
				String telefono = rs.getString("Telefono");
				System.out.println("Usuario" + usuario + "\nNombre:" + nombre + "\nCorreo:" + correo );
				
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				con.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
}
