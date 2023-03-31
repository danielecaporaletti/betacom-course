package it.daniele.repository;

import it.daniele.entity.Iscrizione;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class IscrizioneRepository {
    private EntityManagerFactory entityManagerFactory;

    public IscrizioneRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    // Create (aggiungere una nuova iscrizione)
    public void salvaIscrizione(Iscrizione iscrizione) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(iscrizione);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // Read (ricerca un'iscrizione per ID)
    public Iscrizione trovaIscrizionePerId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Iscrizione iscrizione = entityManager.find(Iscrizione.class, id);
        entityManager.close();
        return iscrizione;
    }

    // Update (aggiorna i dettagli di un'iscrizione)
    public void aggiornaIscrizione(Iscrizione iscrizione) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(iscrizione);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // Delete (elimina un'iscrizione)
    public void eliminaIscrizione(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Iscrizione iscrizione = entityManager.find(Iscrizione.class, id);
        if (iscrizione != null) {
            entityManager.remove(iscrizione);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}