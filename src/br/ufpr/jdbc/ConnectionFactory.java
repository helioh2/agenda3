package br.ufpr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public Connection getConnection() {
		try {
			return DriverManager
					.getConnection("jdbc:mysql://localhost/agenda", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
				
				
	}
	
}
