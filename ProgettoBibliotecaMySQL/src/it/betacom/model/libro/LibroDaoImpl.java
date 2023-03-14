package it.betacom.model.libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDaoImpl implements LibroDAO {
	
	private static final String QUERY_CREATE = "INSERT INTO Libri (titolo) values (?)";
	private static final String QUERY_READ = "SELECT titolo FROM Libri WHERE codiceLibro = ?";
	private static final String QUERY_UPDATE = "UPDATE Libri SET titolo = ? WHERE codiceLibro = ?";
	private static final String QUERY_DELETE = "DELETE FROM Libri WHERE codiceLibri = ?";
	private static final String QUERY_READ_ALL = "SELECT * FROM Libri";
	
	Connection connection;
	
	public LibroDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createLibro(Libro libro) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(QUERY_CREATE)){
			statement.setString(1, libro.getTitolo());
			statement.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public String readLibro(int codiceLibro) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(QUERY_READ)){
			statement.setInt(1, codiceLibro);
			
			ResultSet resultSet = statement.executeQuery();
			return resultSet.getString("descrizione");

		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateLibro(String nuovoLibro, int vecchioLibro) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE)){
			statement.setString(1, nuovoLibro);
			statement.setInt(2, vecchioLibro);
			
			statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public void deleteLibro(int codiceLibro) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(QUERY_DELETE)){
			statement.setInt(1, codiceLibro);
			
			statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public List<Libro> readAllLibro() throws SQLException {
		List<Libro> libri = new ArrayList<Libro>();
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_READ_ALL)){
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
		        int codiceLibro = resultSet.getInt("codiceLibro");
		        int codiceAutore = resultSet.getInt("codiceAutore");
		        int codiceGenere = resultSet.getInt("codiceGenere");
		        int codiceEditore = resultSet.getInt("codiceGenere");
		        String titolo = resultSet.getString("titolo");
		        int numPag = resultSet.getInt("numPag");
		        int anno = resultSet.getInt("anno");
		        libri.add(new Libro(codiceLibro, codiceAutore, codiceGenere, codiceEditore, titolo, numPag, anno));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return libri;
	}

}
