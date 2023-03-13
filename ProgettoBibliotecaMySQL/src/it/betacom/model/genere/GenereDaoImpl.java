package it.betacom.model.genere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenereDaoImpl implements GenereDAO {
	
	private static final String QUERY_CREATE = "INSERT INTO Generi (descrizione) values (?)";
	private static final String QUERY_READ = "SELECT descrizione FROM Generi WHERE codiceGenere = ?";
	private static final String QUERY_UPDATE = "UPDATE Generi SET descrizione = ? WHERE codiceGenere = ?";
	private static final String QUERY_DELETE = "DELETE FROM Generi WHERE codiceGenere = ?";
	private static final String QUERY_READ_ALL = "SELECT * FROM Generi";
	
	Connection connection;
	
	public GenereDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createGenere(Genere genere) {
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_CREATE)){
			statement.setString(1, genere.getDescrizione());
			statement.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public String readGenere(int codiceGenere) {
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_READ)){
			statement.setInt(1, codiceGenere);
			
			ResultSet resultSet = statement.executeQuery();
			return resultSet.getString("descrizione");

		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateGenere(String nuovoGenere, int vecchioGenere) {
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE)){
			statement.setString(1, nuovoGenere);
			statement.setInt(2, vecchioGenere);
			
			statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}
	
	}

	@Override
	public void deleteGenere(int codiceGenere) {
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_DELETE)){
			statement.setInt(1, codiceGenere);
			
			statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Genere> readAllGenere() {
		
		List<Genere> generi = new ArrayList<Genere>();
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_READ_ALL)){
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
		        int codiceGenere = resultSet.getInt("codiceGenere");
		        String descrizione = resultSet.getString("descrizione");
		        generi.add(new Genere(codiceGenere, descrizione));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return generi;
	}

}
