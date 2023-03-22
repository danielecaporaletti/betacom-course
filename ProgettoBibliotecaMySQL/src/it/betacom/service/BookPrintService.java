package it.betacom.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import it.betacom.model.libro.*;
import util.*;

public class BookPrintService implements PrintService<Libro> {
	
	Connection connection;
	Properties prop;
	InputStream input;
	
	public BookPrintService(Connection connection) {
		this.connection = connection;
		prop = new Properties();
		
		try {
			File configFile = new File("config.properties");
	        if (!configFile.exists()) {
	            configFile.createNewFile();
	            System.out.println("Il file di configurazione è stato creato con successo. Vai a riempirlo!!!");
	            System.exit(0);
	        }
			input = new FileInputStream("config.properties");
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveListAsPdf() {
		LibroDaoImpl libri = new LibroDaoImpl(connection);
		List<Libro> listLibri = libri.readAllLibro();
		
		StringBuilder str = new StringBuilder();
		
		for (Libro l : listLibri) {
			str.append(l.toString() + ""
					+ "------------------------------------------------------------------------------\n");
		}
		
		FileWriters.scriviPDF(prop.getProperty("pathPDFs"), str.toString());
		
	}

	@Override
	public void saveListAsCsv() {
		LibroDaoImpl libri = new LibroDaoImpl(connection);
		List<Libro> listLibri = libri.readAllLibro();
		
		String[] header = {"CodiceLibero", "Titolo", "Autore", "Genere", "Editore", "Pagine", "Anno"};
		
		String[][] data = new String[listLibri.size()][7];
		
		for(int i = 0; i < listLibri.size(); i++) {
			Libro l = listLibri.get(i);
			data[i][0] = "" + l.getCodiceLibro();
			data[i][1] = l.getTitolo();
			data[i][2] = l.getAutore();
			data[i][3] = l.getGenere();
			data[i][4] = l.getEditore();
			data[i][5] = "" + l.getNumPag();
			data[i][6] = "" + l.getAnno();
		}
		
		FileWriters.scriviCSV(prop.getProperty("pathCSVs"), header, data);
		
	}

	@Override
	public void saveListAsTxt() {
		LibroDaoImpl libri = new LibroDaoImpl(connection);
		List<Libro> listLibri = libri.readAllLibro();
		
		StringBuilder str = new StringBuilder();
		
		for (Libro l : listLibri) {
			str.append(l.toString() + ""
					+ "------------------------------------------------------------------------------\n");
		}
		
		FileWriters.scriviTXT(prop.getProperty("pathTXTs"), str.toString());
		
	}

	@Override
	public void saveAsPdf(Libro libro) {
		
		//DEVO METTERE GetLibro di LibroDaoImpl per poi stamparlo.
		
		FileWriters.scriviPDF(prop.getProperty("pathPDF"), libro.toString());
		
	}

	@Override
	public void saveAsCsv(Libro libro) {
		String[] header = {"CodiceLibero", "Titolo", "Autore", "Genere", "Editore", "Pagine", "Anno"};
		
		String[][] data = new String[1][7];
		
		data[0][0] = "" + libro.getCodiceLibro();
		data[0][1] = libro.getTitolo();
		data[0][2] = libro.getAutore();
		data[0][3] = libro.getGenere();
		data[0][4] = libro.getEditore();
		data[0][5] = "" + libro.getNumPag();
		data[0][6] = "" + libro.getAnno();
		
		FileWriters.scriviCSV(prop.getProperty("pathCSV"), header, data);
		
	}

	@Override
	public void saveAsTxt(Libro libro) {
		FileWriters.scriviTXT(prop.getProperty("pathTXT"), libro.toString());
		
	}
	
	public void closeAll() {
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DBHandler.closeConnection();
	}

}
