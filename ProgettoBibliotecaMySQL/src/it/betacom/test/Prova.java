package it.betacom.test;

import java.sql.Connection;

import it.betacom.service.BookPrintService;
import util.DBHandler;


public class Prova {

	public static void main(String[] args) {
		
		DBHandler.getInstance();
		Connection connection = DBHandler.getConnection();
		
		BookPrintService prova = new BookPrintService(connection);
		
		//prova.saveListAsPdf();
		
		//prova.saveListAsCsv();
		
		//prova.saveListAsTxt();
		
		//saveAsPdf()
		
		//saveAsCsv
		
		//saveAsTxt
		
		
		

		prova.closeAll();

	}

}
