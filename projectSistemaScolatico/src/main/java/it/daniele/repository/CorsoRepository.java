package it.daniele.repository;

import it.daniele.entity.Corso;
import it.daniele.entity.Studente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class CorsoRepository {
    private EntityManagerFactory entityManagerFactory;

    public CorsoRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    // Create (aggiungere un nuovo corso)
    public void salvaCorso(Corso corso) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(corso);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // Read (ricerca un corso per ID)
    public Corso trovaCorsoPerId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Corso corso = entityManager.find(Corso.class, id);
        entityManager.close();
        return corso;
    }

    // Update (aggiorna i dettagli di un corso)
    public void aggiornaCorso(Corso corso) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(corso);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // Delete (elimina un corso)
    public void eliminaCorso(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Corso corso = entityManager.find(Corso.class, id);
        if (corso != null) {
            entityManager.remove(corso);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    //Trova studenti iscritti al corso
    public List<Studente> trovaStudentiIscrittiAlCorso(Long corsoId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Studente> query = em.createQuery(
                "SELECT i.studente FROM Iscrizione i WHERE i.corso.id = :corsoId",
                Studente.class);
            query.setParameter("corsoId", corsoId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    //Calcola media voti per corso
    public Double calcolaMediaVotiPerCorso(Long corsoId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Double> query = em.createQuery(
                "SELECT AVG(i.voto) FROM Iscrizione i WHERE i.corso.id = :corsoId",
                Double.class);
            query.setParameter("corsoId", corsoId);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }
}