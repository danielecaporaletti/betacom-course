package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHandler {
	
	private static DBHandler instance = null;
	private static Connection connection = null;

	private DBHandler() {
		
		try {
			Class.forName("jdbc:mysql://localhost:3306/betacom");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Database non trovato: " + e.getMessage());
		}
		
	}
	
	public static DBHandler getInstance() {
		if(instance == null) {
			return new DBHandler();
		}
		return instance;
			
	}
	
	public static Connection getConnection() {
			
			try {
				
				Properties prop = new Properties();
				InputStream input = new FileInputStream("config.properties");
				prop.load(input);
;
				connection = DriverManager.getConnection(prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				System.out.println("connessione stabilita");
				
			} catch (SQLException e) {
				System.out.println("Database non trovato: " + e.getMessage());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			return connection;
		
	}
	
	public static void closeConnection() {
		try {
			
			connection.close();
			System.out.println("Connessione chiusa");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

//public static void creaConfigFIle() {
//	Properties prop = new Properties();
//	
//	
//	try (OutputStream output = new FileOutputStream("config.properties");)
//	{
//		prop.setProperty("database", "jdbc:mysql://localhost:3306/betacom");
//		prop.setProperty("dbuser", "root");
//        prop.setProperty("dbpassword", PWD);
//        
//        prop.store(output, null);
//        
//        System.out.println("File di configurazione creato con successo!");
//        
//	} catch (FileNotFoundException e) {
//		System.out.println("File di configurazione non è stato creato: " + e.getMessage());
//	} catch (IOException e) {
//		System.out.println("File non salvato: " + e.getMessage());
//	}
//}
