package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	/*Declaramos las variables de acceso a la base de datos*/
	static String datB = "jose";
	static String user = "jose";
	static String pass = "jose";
	static String serv = "jdbc:oracle:thin:@1localhost:1521/thor";
	
	//Variable para la conexion
	Connection conn = null;
	
	public DbConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(serv, user, pass);
			if(conn != null) {
				System.out.print("Estamos conectados!");
			}
		}catch (SQLException e) {
			System.out.print("este es el error, conexion => " + e.getMessage());
		}catch(ClassNotFoundException e) {
			System.out.print("este es el error, clase no encontrada => " + e.getMessage());
		}
	}
	
	/*Recuperamos la conecion*/
	public Connection getConnection() {
		return conn;
	}
	
	/*Desconectamos de la base de datos*/
	public void desconectar() {
		if(conn != null) {
			try {
				conn.close();
			}catch (SQLException e) {
				System.out.print("este es el error, conexion => " + e.getMessage());
			}
		}
	}
}
