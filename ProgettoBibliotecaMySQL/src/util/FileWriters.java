package util;

import java.io.IOException;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * 
 * @author Daniele Caporaletti
 * 
 * Classe di utilità con metodi statici per scrivere file di tipo .txt, .pdf e .csv
 * La classe implementa la libreria di log4j per gli errori e la riuscita dei metodi
 *
 */
@SuppressWarnings("deprecation")
public class FileWriters {
	
	
	
	/**
	 * Crea un file .pdf
	 * 
	 * Questo metodo crea un PDF in un path e inserice del contenuto HTML in esso
	 * 
	 * 
	 * @param path Percorso del file pdf
	 * @param content Contenuto in formato String da scrivere nel file pdf
	 */
	public static void scriviPDF(String path, String content) {
		
		Document document;
		try ( FileOutputStream file = new FileOutputStream(path)){
			
			document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			HTMLWorker htmlWorker = new HTMLWorker(document);
			htmlWorker.parse(new StringReader(content));
			//document.add(new Paragraph(content));
			document.close();
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (DocumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		

	}
		
	
	

}
