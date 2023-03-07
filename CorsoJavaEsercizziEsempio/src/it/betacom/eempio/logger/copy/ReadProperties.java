package it.betacom.eempio.logger.copy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	
	public static String readVerbosity(String path, String valore) throws IOException{
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream(path);
		prop.load(input);
		return prop.getProperty(valore);
	}
}
	
