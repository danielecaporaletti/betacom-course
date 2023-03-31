package test;

import java.time.LocalDate;

import it.betacom.entity.Animale;
import it.betacom.entity.Cliente;
import it.betacom.entity.TipoAnimale;
import it.betacom.service.AnimaleDAO;
import it.betacom.service.AnimaleDAOImpl;
import it.betacom.service.ClienteDAO;
import it.betacom.service.ClienteDAOImpl;
import it.betacom.service.ClientiAnimaliService;
import it.betacom.service.TipoAnimaleDAO;
import it.betacom.service.TipoAnimaleDAOImpl;

public class Test {

	public static void main(String[] args) {

		ClienteDAO clienteDAO = new ClienteDAOImpl();
		
		Cliente cliente1 = new Cliente("Marco", "Rossi", "Milano", "33498756", "via roma 34");
		Cliente cliente2 = new Cliente("Francesco", "Bianchi", "Roma", "33500099", "via milano 55");
		Cliente cliente3 = new Cliente("Pietro", "Verdi", "Torino", "33356777", "via cantore 3");
		Cliente cliente4 = new Cliente("Giorgio", "Rossi", "Bari", "33467788", "Piazza Italia  4");
		
		clienteDAO.createCliente(cliente1);
		clienteDAO.createCliente(cliente2);
		clienteDAO.createCliente(cliente3);
		clienteDAO.createCliente(cliente4);
		        TipoAnimaleDAO tipoAnimaleDAO = new TipoAnimaleDAOImpl();		        TipoAnimale gatto = new TipoAnimale("Gatto");        TipoAnimale criceto = new TipoAnimale("Criceto");        TipoAnimale cane = new TipoAnimale("Cane");        TipoAnimale pesce = new TipoAnimale("Pesce");                tipoAnimaleDAO.createTipoAnimale(gatto);        tipoAnimaleDAO.createTipoAnimale(criceto);        tipoAnimaleDAO.createTipoAnimale(cane);
        tipoAnimaleDAO.createTipoAnimale(pesce);
		
		AnimaleDAO animaleDAO = new AnimaleDAOImpl();
		
		Animale animale1 = new Animale(345432L, "Luna", LocalDate.of(2023, 3, 1), 50.0, gatto, cliente1);
		Animale animale2 = new Animale(455555L, "Billy", LocalDate.of(2022, 1, 3), 20.0, criceto, cliente1);
		Animale animale3 = new Animale(456666L, "Pluto", LocalDate.of(2022, 1, 4), 100.0, cane, cliente1);
		Animale animale4 = new Animale(233344L, null, LocalDate.of(2022, 1, 5), 45.0, gatto, cliente2);
		Animale animale5 = new Animale(233345L, null, LocalDate.of(2022, 1, 6), 10.0, pesce, cliente2);
		Animale animale6 = new Animale(356777L, null, LocalDate.of(2022, 1, 7), 15.0, criceto, cliente3);
		Animale animale7 = new Animale(546777L, "Stella", LocalDate.of(2022, 1, 8), 65.0, gatto, cliente4);
		Animale animale8 = new Animale(345439L, "Luna", LocalDate.of(2022, 1, 19), 50.0, gatto, cliente4);
		
		animaleDAO.createAnimale(animale1);
		animaleDAO.createAnimale(animale2);
		animaleDAO.createAnimale(animale3);
		animaleDAO.createAnimale(animale4);
		animaleDAO.createAnimale(animale5);
		animaleDAO.createAnimale(animale6);
		animaleDAO.createAnimale(animale7);
		animaleDAO.createAnimale(animale8);
		
        ClientiAnimaliService service = new ClientiAnimaliService();
        service.stampaClientiAnimali();
        
        System.out.println("----------------------------------------------------------------------------------------");
        
        service.stampaClientiAcquisti();
        
        System.out.println("----------------------------------------------------------------------------------------");
        
        service.stampaAnimaliVenduti();
	}

}
