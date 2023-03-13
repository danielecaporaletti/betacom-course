package it.betacom.test;

import java.sql.*;
import java.util.ArrayList;

import it.betacom.model.Libro;
import tmp.passw.passw;
import util.FileWriters;

public class TestSelectAll {
	
	public static final String QUERY = "select l.titolo, a.nomeAutore, g.descrizione, e.nome, l.numPag, l.anno "
											+ "from libri l "
											+ "natural join autori a "
											+ "natural join editori e "
											+ "natural join generi g;";
	
	public static void main(String[] args) {
		
		ArrayList<Libro> listaLibri = new ArrayList<Libro>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL driver registrato correttamente.");
		} catch (ClassNotFoundException e) {
			System.out.println("com.mysql non è stato trovato. " + e.getMessage());
		}
		
		
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betacom", "root", passw.PASSWORD);
			PreparedStatement statement = connection.prepareStatement(QUERY);
			ResultSet resultSet = statement.executeQuery();
			){
			
			while(resultSet.next()) {
				listaLibri.add(new Libro(
											resultSet.getString("l.titolo"),
											resultSet.getString("a.nomeAutore"),
											resultSet.getString("g.descrizione"),
											resultSet.getString("e.nome"),
											resultSet.getInt("l.numPag"),
											resultSet.getInt("l.anno")
											));
			}
			
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		}
		
		System.out.println(listaLibri.toString());
		
		FileWriters.scriviPDF("./listaLibri.pdf", listaLibri.toString());
		
	}

}
