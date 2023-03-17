package it.betacom.model.libro;

import java.sql.SQLException;
import java.util.List;

public interface LibroDAO {

	public void createLibro(Libro libro);
	
	public String readLibro(int codiceLibro);
	
	public void updateLibro(String nuovoLibro, int vecchioLibro);
	
	public void deleteLibro(int codiceLibro);
	
	public List<Libro> readAllLibro();
	
}
