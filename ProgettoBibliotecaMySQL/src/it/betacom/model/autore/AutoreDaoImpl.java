package it.betacom.model.autore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoreDaoImpl implements AutoreDAO {
	
	private static final String QUERY_CREATE = "INSERT INTO Autori (nomeAutore) values (?)";
	private static final String QUERY_READ = "SELECT nomeAutore FROM Autori WHERE codiceAutore = ?";
	private static final String QUERY_UPDATE = "UPDATE Autori SET nomeAutore = ? WHERE codiceAutore = ?";
	private static final String QUERY_DELETE = "DELETE FROM Autori WHERE codiceAutori = ?";
	private static final String QUERY_READ_ALL = "SELECT * FROM Autori";
	
	Connection connection;
	
	public AutoreDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void createAutore(Autore autore) throws SQLException {
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_CREATE)){
			statement.setString(1, autore.getNomeAutore());
			statement.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public String readAutore(int codiceAutore) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(QUERY_READ)){
			statement.setInt(1, codiceAutore);
			
			ResultSet resultSet = statement.executeQuery();
			return resultSet.getString("descrizione");

		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateAutore(String nuovoAutore, int vecchioAutore) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE)){
			statement.setString(1, nuovoAutore);
			statement.setInt(2, vecchioAutore);
			
			statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAutore(int codiceAutore) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(QUERY_DELETE)){
			statement.setInt(1, codiceAutore);
			
			statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public List<Autore> readAllAutore() throws SQLException {
		List<Autore> autori = new ArrayList<Autore>();
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_READ_ALL)){
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
		        int codiceAutore = resultSet.getInt("codiceAutore");
		        String nomeAutore = resultSet.getString("nomeAutore");
		        String annoNascita = resultSet.getString("annoNascita");
		        String annoMorte = resultSet.getString("annoMorte");
		        String sesso = resultSet.getString("sesso");
		        String nazione = resultSet.getString("nazione");
		        autori.add(new Autore(codiceAutore, nomeAutore, annoNascita, annoMorte, sesso, nazione));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return autori;
	}

}
