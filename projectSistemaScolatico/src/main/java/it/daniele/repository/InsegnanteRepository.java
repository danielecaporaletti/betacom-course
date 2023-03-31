package it.daniele.repository;

import it.daniele.entity.Corso;
import it.daniele.entity.Insegnante;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class InsegnanteRepository {
    private EntityManagerFactory entityManagerFactory;

    public InsegnanteRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    // Create (aggiungere un nuovo insegnante)
    public void salvaInsegnante(Insegnante insegnante) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(insegnante);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // Read (ricerca un insegnante per ID)
    public Insegnante trovaInsegnantePerId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Insegnante insegnante = entityManager.find(Insegnante.class, id);
        entityManager.close();
        return insegnante;
    }

    // Update (aggiorna i dettagli di un insegnante)
    public void aggiornaInsegnante(Insegnante insegnante) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(insegnante);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // Delete (elimina un insegnante)
    public void eliminaInsegnante(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Insegnante insegnante = entityManager.find(Insegnante.class, id);
        if (insegnante != null) {
            entityManager.remove(insegnante);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    //Trova corsi per insegannte
    public List<Corso> trovaCorsiPerInsegnante(Long insegnanteId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Corso> query = em.createQuery(
                "SELECT c FROM Corso c WHERE c.insegnante.id = :insegnanteId",
                Corso.class);
            query.setParameter("insegnanteId", insegnanteId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}