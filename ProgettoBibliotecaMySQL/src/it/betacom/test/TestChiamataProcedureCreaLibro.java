package it.betacom.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

import it.betacom.model.Libro;
import util.DBHandler;


public class TestChiamataProcedureCreaLibro {
	
	private static final String QUERY = "select l.titolo, a.nomeAutore, g.descrizione, e.nome, l.numPag, l.anno "
			+ "from libri l "
			+ "natural join autori a "
			+ "natural join editori e "
			+ "natural join generi g";

	public static void main(String[] args) throws SQLException, IOException{
		
		Libro nuovoLibro = new Libro("Odi 6", "Manzoni", "Romanzi", "Rizzoli", 267, 1997);
		
		Connection connection = DBHandler.getConnection();
		
		CallableStatement stmt = connection.prepareCall("{call betacom.update_book(?, ?, ?, ?, ?, ?)}");
		
		stmt.setString(1, nuovoLibro.getTitolo());
		stmt.setString(2, nuovoLibro.getAutore());
		stmt.setString(3, nuovoLibro.getGenere());
		stmt.setString(4, nuovoLibro.getEditore());
		stmt.setInt(5, nuovoLibro.getNumPag());
		stmt.setInt(6, nuovoLibro.getAnno());
				
		stmt.execute();
		stmt.close();
		
		PreparedStatement statement = connection.prepareStatement(QUERY);
		ResultSet resultSet = statement.executeQuery();
		try{
		
		while(resultSet.next()) {
			System.out.println("" + 
										resultSet.getString("l.titolo") + " | " + 
										resultSet.getString("a.nomeAutore") + " | " +
										resultSet.getString("g.descrizione") + " | " +
										resultSet.getString("e.nome") + " | " +
										resultSet.getInt("l.numPag") + " | " +
										resultSet.getInt("l.anno")
										);
		}
		
	} catch (SQLException e) {
		System.out.println("Errore: " + e.getMessage());
	}
        
		DBHandler.closeConnection();
        

	}

}
