package it.betacom.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;

import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 * 
 * @author Daniele Caporaletti
 * 
 * Classe di utilità con metodi statici per scrivere file di tipo .txt, .pdf e .csv
 * La classe implementa la libreria di log4j per gli errori e la riuscita dei metodi
 *
 */
public class FileWriters {
	
	private static Logger loggerWriters = Logger.getLogger(FileWriters.class.getName());
	
	/**
	 * Crea una file .txt
	 * 
	 * Questo metodo crea un TXT partendo dal path e inserice del contenuto di tipo string in esso
	 *  
	 * @param a Nome della classe di riferiemnto, utile solo ai fini del log
	 * @param path Percorso del file txt
	 * @param content Contenuto in formato String da scrivere nel file txt
	 */
	public static void scriviTXT(Object a, String path, String content) {
		
		try ( BufferedWriter write = new BufferedWriter(new FileWriter(path)) ){
			
			write.write(content);
			write.flush();
			
		} catch (IOException e) {
			loggerWriters.error(e);
		}
		
		loggerWriters.info("Scrittura su TXT eseguita correttamente, nome classe: " + a.getClass().getName());
		
	}
	
	/**
	 * Crea un file .pdf
	 * 
	 * Questo metodo crea un PDF partendo dal path e inserice del contenuto di tipo string in esso
	 * 
	 * @param a Nome della classe di riferiemnto, utile solo ai fini del log
	 * @param path Percorso del file pdf
	 * @param content Contenuto in formato String da scrivere nel file pdf
	 */
	public static void scriviPDF(Object a, String path, String content) {
		
		Document document;
		try ( FileOutputStream file = new FileOutputStream(path)){
			
			document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			document.add(new Paragraph(content));
			document.close();
			
		} catch (IOException e) {
			loggerWriters.error(e);
		} catch (DocumentException e) {
			loggerWriters.error(e);
		}
		
		loggerWriters.info("Scrittura su PDF eseguita correttamente, nome classe: " + a.getClass().getName());

	}

	/**
	 * Crea un file .csv
	 * 
	 * Questo metodo crea un CSV partendo dal path e inserice prima l'header e poi la tbella con i dati
	 * 
	 * @param a Nome della classe di riferiemnto, utile solo ai fini del log
	 * @param path Percorso del file csv
	 * @param header Vettore di tipo stringa per l'header della tabella
	 * @param data Tabella di tipo stringa per i dati 
	 */
	public static void scriviCSV(Object a, String path, String[] header, String[][] data) {
		
		boolean fileEsiste = new File(path).exists();
		
		try ( FileWriter writer = new FileWriter(path, true);
			  CSVWriter csvWriter = new CSVWriter(writer); ){
			
			if(!fileEsiste) {
				csvWriter.writeNext(header);
				loggerWriters.info("Creazione del file CSV eseguita");
			}
	        
	        for (String[] row : data) {
	            csvWriter.writeNext(row);
	        }
			
		} catch (IOException e) {
			loggerWriters.error(e);
		}
		
		loggerWriters.info("Scrittura su CSV eseguita correttamente, nome classe: " + a.getClass().getName());
		
	}
	

}
