package cl.sustantiva.model.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection connection = null;
	
	private Conexion() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://0.0.0.0:3310/sakila", "root", "kupita");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error al establecer la conexión a la BD.");
			e.printStackTrace();
		}
		
	}

	public static Connection getConnection() {
		
		if (connection == null) {
			new Conexion();	
		}
		return connection;
	}
	
	
	
	
	

}
