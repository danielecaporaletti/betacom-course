package it.betacom.model.genere;

import java.sql.SQLException;
import java.util.List;

public interface GenereDAO {
	
	public void createGenere(Genere genere) throws SQLException;
	
	public String readGenere(int codiceGenere) throws SQLException;
	
	public void updateGenere(String nuovoGenere, int vecchioGenere)throws SQLException;
	
	public void deleteGenere(int codiceGenere) throws SQLException;
	
	public List<Genere> readAllGenere() throws SQLException;

}
