package it.betacom.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.betacom.entity.Animale;

public class AnimaleDAO {
    private static final String PERSISTENCE_UNIT = "PetShop";

    public Animale create(Animale animale) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(animale);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return animale;
    }

    public Animale read(int matricola) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        Animale animale = em.find(Animale.class, matricola);

        em.close();
        emf.close();

        return animale;
    }

    public Animale update(Animale animale) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        animale = em.merge(animale);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return animale;
    }

    public void delete(int matricola) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        Animale animale = em.find(Animale.class, matricola);

        em.getTransaction().begin();
        em.remove(animale);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public List<Animale> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        TypedQuery<Animale> query = em.createQuery("SELECT a FROM Animale a", Animale.class);
        List<Animale> animali = query.getResultList();

        em.close();
        emf.close();

        return animali;
    }

    public List<Animale> findByCliente(int clienteId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        TypedQuery<Animale> query = em.createQuery("SELECT a FROM Animale a WHERE a.cliente.id = :clienteId", Animale.class);
        query.setParameter("clienteId", clienteId);
        List<Animale> animali = query.getResultList();

        em.close();
        emf.close();

        return animali;
    }
}