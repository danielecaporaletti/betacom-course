package it.betacom.model.libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDaoImpl implements LibroDAO {
	
	private static final String QUERY_CREATE = "INSERT INTO Libri (titolo) values (?)";
	private static final String QUERY_READ = "SELECT l.codiceLibro, l.titolo, a.nomeAutore, g.descrizione AS genere, e.nome as editore, l.numPag, l.anno\r\n"
													+ "FROM Libri l \r\n"
													+ "NATURAL JOIN Autori a\r\n"
													+ "NATURAL JOIN Editori e \r\n"
													+ "NATURAL JOIN Generi g"
													+ "WHERE codiceLibro = ?";
	private static final String QUERY_UPDATE = "UPDATE Libri SET titolo = ? WHERE codiceLibro = ?";
	private static final String QUERY_DELETE = "DELETE FROM Libri WHERE codiceLibri = ?";
	private static final String QUERY_READ_ALL = "SELECT l.codiceLibro, l.titolo, a.nomeAutore, g.descrizione AS genere, e.nome as editore, l.numPag, l.anno\r\n"
													+ "FROM Libri l \r\n"
													+ "NATURAL JOIN Autori a\r\n"
													+ "NATURAL JOIN Editori e \r\n"
													+ "NATURAL JOIN Generi g;";
	
	Connection connection;
	
	public LibroDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createLibro(Libro libro) {
		try(PreparedStatement statement = connection.prepareStatement(QUERY_CREATE)){
			statement.setString(1, libro.getTitolo());
			statement.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public String readLibro(int codiceLibro) {
		try(PreparedStatement statement = connection.prepareStatement(QUERY_READ)){
			statement.setInt(1, codiceLibro);
			
			ResultSet resultSet = statement.executeQuery();
			return resultSet.getString("descrizione");

		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Libro getLibro(int codiceLibro) {
		try(PreparedStatement statement = connection.prepareStatement(QUERY_READ)){
			statement.setInt(1, codiceLibro);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
		        String titolo = resultSet.getString("titolo");
		        String autore = resultSet.getString("nomeAutore");
		        String genere = resultSet.getString("genere");
		        String editore = resultSet.getString("editore");
		        int numPag = resultSet.getInt("numPag");
		        int anno = resultSet.getInt("anno");
		        return new Libro(codiceLibro, autore, genere, editore, titolo, numPag, anno);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateLibro(String nuovoLibro, int vecchioLibro){
		try(PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE)){
			statement.setString(1, nuovoLibro);
			statement.setInt(2, vecchioLibro);
			
			statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public void deleteLibro(int codiceLibro) {
		try(PreparedStatement statement = connection.prepareStatement(QUERY_DELETE)){
			statement.setInt(1, codiceLibro);
			
			statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public List<Libro> readAllLibro() {
		List<Libro> libri = new ArrayList<Libro>();
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_READ_ALL)){
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
		        int codiceLibro = resultSet.getInt("codiceLibro");
		        String titolo = resultSet.getString("titolo");
		        String autore = resultSet.getString("nomeAutore");
		        String genere = resultSet.getString("genere");
		        String editore = resultSet.getString("editore");
		        int numPag = resultSet.getInt("numPag");
		        int anno = resultSet.getInt("anno");
		        libri.add(new Libro(codiceLibro, autore, genere, editore, titolo, numPag, anno));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return libri;
	}

}
