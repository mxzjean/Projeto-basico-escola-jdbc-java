package br.com.escola;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection connectWithDataBase() {
		try {
			String password = "";
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/escola_praticando?user=root&password=" + password);	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
