package it.betacom.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.betacom.entity.Cliente;

public class ClienteDAO {
	
	private static final String PERSISTENCE_UNIT = "PetShop";

    public Cliente create(Cliente cliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return cliente;
    }

    public Cliente read(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        Cliente cliente = em.find(Cliente.class, id);

        em.close();
        emf.close();

        return cliente;
    }

    public Cliente update(Cliente cliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        cliente = em.merge(cliente);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return cliente;
    }

    public void delete(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        Cliente cliente = em.find(Cliente.class, id);

        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public List<Cliente> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        List<Cliente> clienti = query.getResultList();

        em.close();
        emf.close();

        return clienti;
    }

}
