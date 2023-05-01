package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import it.betacom.entity.Animale;
import it.betacom.entity.Cliente;
import it.betacom.entity.PetShopUser;
import it.betacom.service.AnimaleDAO;
import it.betacom.service.PetShopUserDAO;
import it.betacom.service.ClienteDAO;
import it.betacom.entity.Cliente;

public class main {

	public static void main(String[] args) {
		
		//Creiamo due user
//		PetShopUserDAO petShopUserDAO = new PetShopUserDAO();
//		PetShopUser user1 = new PetShopUser("user1", "password1");
//		petShopUserDAO.create(user1);
//		PetShopUser user2 = new PetShopUser("user2", "password2");
//		petShopUserDAO.create(user2);
		
//		//creiamo due utenti
//		ClienteDAO clienteDao = new ClienteDAO();
//		Cliente cliente1 = new Cliente("Marco", "Totti", null, null, null);
//		clienteDao.create(cliente1);
//		Cliente cliente2 = new Cliente("Giulio", "Preso", null, null, null);
//		clienteDao.create(cliente2);
//		
//		//L'acquisto è associato a questi animali
//		AnimaleDAO animaleDao = new AnimaleDAO();
//		Animale animale1 = new Animale(1432, "Giraffa", "Smeralda", LocalDate.now(), 100, cliente1);
//		animaleDao.create(animale1);
//		Animale animale2 = new Animale(2432, "Gatto", "Giulia", LocalDate.now(), 10, cliente2);
//		animaleDao.create(animale2);
		
		ClienteDAO clienteDao = new ClienteDAO();
		List<Cliente> clienti = clienteDao.findAll();
		for (Cliente c : clienti) {
			System.out.println(c.getNome() + "\n");
		}

		
	}

}
