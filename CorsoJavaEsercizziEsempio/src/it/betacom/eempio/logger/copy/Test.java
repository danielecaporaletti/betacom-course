package it.betacom.eempio.logger.copy;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	
	//SE L'EVENTO E' ... ALLORA ME LO STAMPI SOLO SE ...
	public static boolean check(Livello logLevel, Livello eventLevel) {
		
		switch (eventLevel) {
		case ERROR:
			return true;
		case ALTO:
			return (logLevel != Livello.ERROR)? true: false;
		case MEDIO:
			return (logLevel == Livello.BASSO ||logLevel  == Livello.MEDIO)? true: false;
		case BASSO:
			return (logLevel == Livello.BASSO)? true: false;
		}
		return false;
	}
	
	public static Livello getLivello(String s) {
	    switch (s) {
		    case "error":
	            return Livello.ERROR;
		    case "exception":
	            return Livello.ALTO;
	        case "warning":
	            return Livello.MEDIO;
	        case "info":
	            return Livello.BASSO;
	        default:
	            throw new IllegalArgumentException("Invalid livello: " + s);
	    }
	}
	

	public static void main(String[] args){
		
		List<Evento> eventi = Stream.of(new Evento(Livello.ALTO),
										new Evento(Livello.ALTO),
										new Evento(Livello.ALTO),
										new Evento(Livello.MEDIO),
										new Evento(Livello.MEDIO),
										new Evento(Livello.MEDIO),
										new Evento(Livello.BASSO),
										new Evento(Livello.BASSO),
										new Evento(Livello.BASSO),
										new Evento(Livello.ERROR),
										new Evento(Livello.ERROR),
										new Evento(Livello.ERROR))
									.collect(Collectors.toList());
		
		Logger log1;
//		Logger log2;
//		Logger log3;
	
		try {
			
			System.out.println("---------- TEST 1 ESEGUITO----------");
			
			log1 = new Logger("C:\\Users\\danie\\tmp\\log1.txt", getLivello(
																			ReadProperties.readVerbosity(
																					"C:\\logger\\config.properties", "logger.level")));
			for (Evento e : eventi) {
			if(check(log1.getLivelloVerbosity(), e.getLivello())) {
				log1.chooseInsert(e);
			}
			Thread.sleep(100);
			}
			log1.close();
			
			
//			System.out.println("---------- TEST 2 ESEGUITO----------");
//			
//			log2 = new Logger("C:\\Users\\danie\\tmp\\log2.txt", Livello.MEDIO);
//			
//			for (Evento e : eventi) {
//				if(check(log2.getLivelloVerbosity(), e.getLivello())) log2.chooseInsert(e);
//				Thread.sleep(100);
//			}
//			log2.close();
//			
//			System.out.println("---------- TEST 3 ESEGUITO----------");
//			
//			log3 = new Logger("C:\\Users\\danie\\tmp\\log3.txt");
//			
//			for (Evento e : eventi) {
//				if(check(log3.getLivelloVerbosity(), e.getLivello())) log3.chooseInsert(e);
//				Thread.sleep(100);
//			}
//			log3.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

}
