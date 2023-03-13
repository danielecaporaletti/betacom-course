package it.betacom.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

import util.DBHandler;

public class TestChiamataProcedureListaLibriIta {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection connection = DBHandler.getConnection();
		CallableStatement stmt = connection.prepareCall("{CALL getLista_libri_autori_italiani()}");
		ResultSet risultato = stmt.executeQuery();
		
		while (risultato.next()) {
			System.out.println("" + risultato.getString("nomeAutore"));
		}
		
		stmt.close();
		DBHandler.closeConnection();
		
	}

}
