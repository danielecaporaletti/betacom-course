package it.betacom.model.editore;

import java.sql.SQLException;
import java.util.List;

public interface EditoreDAO {
	
	public void createEditore(Editore editore) throws SQLException;
	
	public String readEditore(int codiceEditore) throws SQLException;
	
	public void updateEditore(String nuovoEditore, int vecchioEditore)throws SQLException;
	
	public void deleteEditore(int codiceEditore) throws SQLException;
	
	public List<Editore> readAllEditore() throws SQLException;

}

