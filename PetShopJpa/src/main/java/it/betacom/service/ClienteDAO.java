package it.betacom.service;
import java.util.List;

import it.betacom.entity.Cliente;

public interface ClienteDAO {
	
	void createCliente(Cliente cliente);
	Cliente readCliente(Long id);
	void updateCliente(Long id, Cliente newCliente);
	void deleteCliente(Long id);
	List<Cliente> readAllCliente();

}
