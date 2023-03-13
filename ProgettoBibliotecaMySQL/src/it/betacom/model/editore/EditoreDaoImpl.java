package it.betacom.model.editore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditoreDaoImpl implements EditoreDAO {
	
	private static final String QUERY_CREATE = "INSERT INTO Editori (nome) values (?)";
	private static final String QUERY_READ = "SELECT nome FROM Ediotri WHERE codiceEdiotre = ?";
	private static final String QUERY_UPDATE = "UPDATE Editori SET nome = ? WHERE codiceEditore = ?";
	private static final String QUERY_DELETE = "DELETE FROM Editori WHERE codiceEditori = ?";
	private static final String QUERY_READ_ALL = "SELECT * FROM Editori";
	
	Connection connection;
	
	public EditoreDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createEditore(Editore editore) throws SQLException {
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_CREATE)){
			statement.setString(1, editore.getNome());
			statement.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public String readEditore(int codiceEditore) throws SQLException {
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_READ)){
			statement.setInt(1, codiceEditore);
			
			ResultSet resultSet = statement.executeQuery();
			return resultSet.getString("descrizione");

		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public void updateEditore(String nuovoEditore, int vecchioEditore) throws SQLException {
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE)){
			statement.setString(1, nuovoEditore);
			statement.setInt(2, vecchioEditore);
			
			statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEditore(int codiceEditore) throws SQLException {
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_DELETE)){
			statement.setInt(1, codiceEditore);
			
			statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public List<Editore> readAllEditore() throws SQLException {
		
		List<Editore> editori = new ArrayList<Editore>();
		
		try(PreparedStatement statement = connection.prepareStatement(QUERY_READ_ALL)){
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
		        int codiceEditore = resultSet.getInt("codiceGenere");
		        String nome = resultSet.getString("descrizione");
		        editori.add(new Editore(codiceEditore, nome));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return editori;
	}
	

}
