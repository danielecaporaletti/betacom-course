package it.betacom.service;

import java.sql.Connection;
import java.util.List;

import it.betacom.model.libro.*;
import util.*;

public class BookPrintService implements PrintService<Libro> {
	
	Connection connection;
	
	public BookPrintService(Connection connection) {
		this.connection = connection;
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
		
		FileWriters.scriviPDF("libri.pdf", str.toString());
		
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
		
		FileWriters.scriviCSV("libri.csv", header, data);
		
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
		
		FileWriters.scriviTXT("libri.txt", str.toString());
		
	}

	@Override
	public void saveAsPdf(Libro libro) {
		FileWriters.scriviPDF("libro.pdf", libro.toString());
		
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
		
		FileWriters.scriviCSV("libro.csv", header, data);
		
	}

	@Override
	public void saveAsTxt(Libro libro) {
		FileWriters.scriviTXT("libri.txt", libro.toString());
		
	}

}
