package it.betacom.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.betacom.entity.Cliente;
import util.JPAUtil;

public class ClienteDAOImpl implements ClienteDAO {

	@Override
	public void createCliente(Cliente cliente) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Cliente readCliente(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Cliente cliente = em.find(Cliente.class, id);
		em.close();
		return cliente;
	}

	@Override
	public void updateCliente(Long id, Cliente newCliente) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);
		
		if(cliente != null) {
			cliente.setNome(newCliente.getNome());
			cliente.setCognome(newCliente.getCognome());
			cliente.setCitta(newCliente.getCitta());
			cliente.setTel(newCliente.getTel());
			cliente.setIndirizzo(newCliente.getIndirizzo());
			em.merge(cliente);
		}
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void deleteCliente(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);
		
		if(cliente != null) {
			em.remove(cliente);
		}
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Cliente> readAllCliente() {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
		List<Cliente> clienti = query.getResultList();
		em.close();
		return clienti;
	}

}
