package it.betacom.model.genere;

import java.sql.Connection;

import util.DBHandler;

//a .chiamiamo il metodo 4: stampiamo la lista dei generi presenti su Db
//b .chiamiamo il metodo 5: stampiamo i dati del genere  richiesto
//c .chiamiamo il metodo 6: stampiamo l'esito dell'inserimento e stampiamo la lista 
//d .chiamiamo il metodo 7: stampiamo l'esito dell'aggiornamento (es: cambiare descrizone romanzi in romanzo) stampiamo la lista
//e .chiamiamo il metodo 8: stampiamo l'esito del delete e stampare la lista

public class TestGenere {
	
	public static void main(String[] args) {
		
		DBHandler.getInstance();
		
		Connection connection = DBHandler.getConnection();
		
		GenereDaoImpl generi = new GenereDaoImpl(connection);
		
		//System.out.println(generi.readAllGenere().toString());
		
		//System.out.println(generi.readGenere(2));
		
		
	}

}
