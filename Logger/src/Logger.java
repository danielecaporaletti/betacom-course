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
	private Livello livello;


	public Logger(String path) throws IOException {
		write = new BufferedWriter(new FileWriter(path));
		this.livello = Livello.ERROR;
	}
	
	public Logger(FileWriter file) {
		write = new BufferedWriter(file);
		this.livello = Livello.ERROR;
	}
	
	public Logger(String path, Livello livello) throws IOException {
		write = new BufferedWriter(new FileWriter(path));
		this.livello = livello;
	}
	
	public Logger(FileWriter file, Livello livello) {
		write = new BufferedWriter(file);
		this.livello = livello;
	}
	
	
	
	private void insertToday() throws IOException{
		    Calendar oggi = Calendar.getInstance();
		    SimpleDateFormat format = new SimpleDateFormat();
		    String dataOggi = format.format(oggi.getTime());
			
			write.write(dataOggi + " | ");
			write.flush();

	}
	
	public void insertInfo(String info) throws IOException {
		
		insertToday();
		write.write(info);
		write.newLine();
		write.flush();
		
	}
	
	public void insertError(String error) throws IOException {
		
		insertToday();
		write.write(error);
		write.newLine();
		write.flush();
		
	}
	
	public void insertWarning(String warning) throws IOException {
		
		insertToday();
		write.write(warning);
		write.newLine();
		write.flush();
		
	}
		
	public void close() throws IOException {
			write.close();
	}
	
	// GETTER AND SETTER
	
	public BufferedWriter getWrite() {
		return write;
	}
	
	public Livello getLivello() {
		return livello;
	}

	public void setLivello(Livello livello) {
		this.livello = livello;
	}

}
