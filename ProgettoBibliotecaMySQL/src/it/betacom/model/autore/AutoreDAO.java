package it.betacom.model.autore;

import java.sql.SQLException;
import java.util.List;

import it.betacom.model.editore.Editore;

public interface AutoreDAO {
	
	public void createAutore(Autore autore) throws SQLException;
	
	public String readAutore(int codiceAutore) throws SQLException;
	
	public void updateAutore(String nuovoAutore, int vecchioAutore)throws SQLException;
	
	public void deleteAutore(int codiceAutore) throws SQLException;
	
	public List<Autore> readAllAutore() throws SQLException;

}
