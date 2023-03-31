package it.daniele.repository;

import it.daniele.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class StudenteRepository {
    private EntityManagerFactory entityManagerFactory;

    public StudenteRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    // Create (aggiungere un nuovo studente)
    public void salvaStudente(Studente studente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(studente);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // Read (ricerca uno studente per ID)
    public Studente trovaStudentePerId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Studente studente = entityManager.find(Studente.class, id);
        entityManager.close();
        return studente;
    }

    // Update (aggiorna i dettagli di uno studente)
    public void aggiornaStudente(Studente studente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(studente);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // Delete (elimina uno studente)
    public void eliminaStudente(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Studente studente = entityManager.find(Studente.class, id);
        if (studente != null) {
            entityManager.remove(studente);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}