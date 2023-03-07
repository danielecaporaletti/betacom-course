package it.betacom.eempio.logger.copy;

//CREARE UNA SEMPLICE CLASSE LOGGER CHE SIMULI UN LOGGER
//
//(CON ATTRIBUTO DI CLASSE :BUFFERWRITER)
//
//2 COSTRUTTORI, UNO CON PARAMETRO STRING E L'ALTRO CON PARAMETRO FILE
//
//METHOD LOG SCRIVE SU FILE LE INFORMAZIONI IN INGRESSO CON LA DATA CORRENTE
//
//
//CLASSE MAIN
//
//ISTANZA IL LOGGER E PASSA LE INFORMAZIONI DA LOGGARE E CHIUDE IL LOGGER.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
	
	private BufferedWriter write;
	private Livello livelloVerbosity;


	public Logger(String path) throws IOException {
		write = new BufferedWriter(new FileWriter(path));
		this.livelloVerbosity = Livello.ERROR;
	}
	
	public Logger(FileWriter file) {
		write = new BufferedWriter(file);
		this.livelloVerbosity = Livello.ERROR;
	}
	
	public Logger(String path, Livello livello) throws IOException {
		write = new BufferedWriter(new FileWriter(path));
		this.livelloVerbosity = livello;
	}
	
	public Logger(FileWriter file, Livello livello) {
		write = new BufferedWriter(file);
		this.livelloVerbosity = livello;
	}
	
	
	
	private void insertToday() throws IOException{
		    Calendar oggi = Calendar.getInstance();
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String dataOggi = format.format(oggi.getTime());
			
			write.write(dataOggi + " | ");
			write.flush();

	}
	
	private void insertInfo(String s) throws IOException {
		
		insertToday();
		write.write("INFORMAZIONE: " + s);
		write.newLine();
		write.flush();
		
	}
	
	private void insertWarning(String s) throws IOException {
		
		insertToday();
		write.write("WARNING: " + s);
		write.newLine();
		write.flush();
		
	}
	
	private void insertError(String s) throws IOException {
		
		insertToday();
		write.write("ERRORE: " + s);
		write.newLine();
		write.flush();
		
	}
	
	private void insertCriticalError(String s) throws IOException {
		
		insertToday();
		write.write("CRITICAL ERROR: " + s);
		write.newLine();
		write.flush();
		
	}
	
	public void chooseInsert(Evento e) throws IOException {
		switch (e.getLivello()) {
		case ERROR:
			insertCriticalError(e.getDescrizione());
			break;
		case ALTO:
			insertError(e.getDescrizione());
			break;
		case MEDIO:
			insertWarning(e.getDescrizione());
			break;
		case BASSO:
			insertInfo(e.getDescrizione());
			break;
		}
	}

		
	public void close() throws IOException {
			write.close();
	}
	
	// GETTER AND SETTER
	
	public BufferedWriter getWrite() {
		return write;
	}
	
	public Livello getLivelloVerbosity() {
		return livelloVerbosity;
	}

	public void setLivelloVerbosity(Livello livello) {
		this.livelloVerbosity = livello;
	}

}
