package connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class testConnectionMySQL {
	
	public static void main(String[] args) {
		
		System.out.println("Test di connessione a mySQL!");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql.jdbc.Driver non trovato");
		}
		System.out.println("MySQL Driver registrato correttamente");
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betacom", "root", "Dacatti9961-");
			System.out.println("Connessione stabilita");
		} catch (Exception e) {
			System.out.println("connessione fallita" + e.getMessage());
			return;
		} finally {
			try {
				if (connection != null) connection.close();
				System.out.println("Connessione chiusa");
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	}

}
