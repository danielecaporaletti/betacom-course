package it.betacom.model.libro;

import java.sql.SQLException;
import java.util.List;

public interface LibroDAO {

	public void createLibro(Libro libro) throws SQLException;
	
	public String readLibro(int codiceLibro) throws SQLException;
	
	public void updateLibro(String nuovoLibro, int vecchioLibro)throws SQLException;
	
	public void deleteLibro(int codiceLibro) throws SQLException;
	
	public List<Libro> readAllLibro() throws SQLException;
	
}
