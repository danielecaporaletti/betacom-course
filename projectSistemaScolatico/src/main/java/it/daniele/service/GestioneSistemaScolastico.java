package it.daniele.service;

import it.daniele.entity.Corso;
import it.daniele.entity.Insegnante;
import it.daniele.entity.Iscrizione;
import it.daniele.entity.Studente;
import it.daniele.repository.StudenteRepository;
import it.daniele.repository.InsegnanteRepository;
import it.daniele.repository.CorsoRepository;
import it.daniele.repository.IscrizioneRepository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class GestioneSistemaScolastico {
    private StudenteRepository studenteRepository;
    private InsegnanteRepository insegnanteRepository;
    private CorsoRepository corsoRepository;
    private IscrizioneRepository iscrizioneRepository;
    private EntityManagerFactory entityManagerFactory;

    public GestioneSistemaScolastico(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        this.studenteRepository = new StudenteRepository(entityManagerFactory);
        this.insegnanteRepository = new InsegnanteRepository(entityManagerFactory);
        this.corsoRepository = new CorsoRepository(entityManagerFactory);
        this.iscrizioneRepository = new IscrizioneRepository(entityManagerFactory);
    }
    
    // Crea un nuovo studente
    public void creaStudente(Studente studente) {
        studenteRepository.salvaStudente(studente);
    }

    // Crea un nuovo insegnante
    public void creaInsegnante(Insegnante insegnante) {
        insegnanteRepository.salvaInsegnante(insegnante);
    }

    // Crea un nuovo corso
    public void creaCorso(Corso corso) {
        corsoRepository.salvaCorso(corso);
    }

    // Elimina uno studente
    public void eliminaStudente(Long studenteId) {
        studenteRepository.eliminaStudente(studenteId);
    }

    // Elimina un insegnante
    public void eliminaInsegnante(Long insegnanteId) {
        insegnanteRepository.eliminaInsegnante(insegnanteId);
    }

    // Elimina un corso
    public void eliminaCorso(Long corsoId) {
        corsoRepository.eliminaCorso(corsoId);
    }

    // Annulla l'iscrizione di uno studente a un corso
    public void annullaIscrizione(Long iscrizioneId) {
        iscrizioneRepository.eliminaIscrizione(iscrizioneId);
    }

    // Iscrivi uno studente a un corso
    public void iscriviStudenteACorso(Long studenteId, Long corsoId) {
        Studente studente = studenteRepository.trovaStudentePerId(studenteId);
        Corso corso = corsoRepository.trovaCorsoPerId(corsoId);

        if (studente != null && corso != null) {
            Iscrizione iscrizione = new Iscrizione();
            iscrizione.setStudente(studente);
            iscrizione.setCorso(corso);

            iscrizioneRepository.salvaIscrizione(iscrizione);
        } else {
        	throw new EntityNotFoundException("Studente o corso non trovati con gli ID forniti");
        }
    }

    // Assegna un insegnante a un corso
    public void assegnaInsegnanteACorso(Long insegnanteId, Long corsoId) {
        Insegnante insegnante = insegnanteRepository.trovaInsegnantePerId(insegnanteId);
        Corso corso = corsoRepository.trovaCorsoPerId(corsoId);

        if (insegnante != null && corso != null) {
            corso.setInsegnante(insegnante);
            corsoRepository.aggiornaCorso(corso);
        } else {
        	throw new EntityNotFoundException("Insegnante o corso non trovati con gli ID forniti");
        }
    }
    
    // Trova tutti gli studenti iscritti a un corso specifico
    public List<Studente> trovaStudentiIscrittiAlCorso(Long corsoId) {
        return corsoRepository.trovaStudentiIscrittiAlCorso(corsoId);
    }

    // Calcola la media dei voti per un corso specifico
    public Double calcolaMediaVotiPerCorso(Long corsoId) {
        return corsoRepository.calcolaMediaVotiPerCorso(corsoId);
    }

    // Trova tutti i corsi tenuti da un insegnante specifico
    public List<Corso> trovaCorsiPerInsegnante(Long insegnanteId) {
        return insegnanteRepository.trovaCorsiPerInsegnante(insegnanteId);
    }
    
    // Registra uno studente a più corsi
    public void registraStudenteACorsi(Long studenteId, List<Long> corsiIds) throws Exception {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            Studente studente = studenteRepository.trovaStudentePerId(studenteId);
            if (studente != null) {
                for (Long corsoId : corsiIds) {
                    Corso corso = corsoRepository.trovaCorsoPerId(corsoId);
                    if (corso != null) {
                        Iscrizione iscrizione = new Iscrizione();
                        iscrizione.setStudente(studente);
                        iscrizione.setCorso(corso);
                        em.persist(iscrizione);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
    public void aggiornaVotiStudenteInCorsi(Long studenteId, Map<Long, Integer> votiCorsi) throws Exception {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            Studente studente = studenteRepository.trovaStudentePerId(studenteId);
            if (studente != null) {
                for (Map.Entry<Long, Integer> entry : votiCorsi.entrySet()) {
                    Long corsoId = entry.getKey();
                    Integer voto = entry.getValue();

                    // Trova l'iscrizione dello studente al corso
                    TypedQuery<Iscrizione> query = em.createQuery(
                        "SELECT i FROM Iscrizione i WHERE i.studente.id = :studenteId AND i.corso.id = :corsoId",
                        Iscrizione.class);
                    query.setParameter("studenteId", studenteId);
                    query.setParameter("corsoId", corsoId);
                    Iscrizione iscrizione = query.getSingleResult();

                    if (iscrizione != null) {
                        // Aggiorna il voto dell'iscrizione
                        iscrizione.setVoto(voto);
                        em.merge(iscrizione);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
    public Iscrizione trovaIscrizionePerStudenteECorso(Long studenteId, Long corsoId) {
    	EntityManager em = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Iscrizione> query = em.createQuery(
                "SELECT i FROM Iscrizione i WHERE i.studente.id = :studenteId AND i.corso.id = :corsoId",
                Iscrizione.class);
            query.setParameter("studenteId", studenteId);
            query.setParameter("corsoId", corsoId);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}