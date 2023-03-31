package it.daniele.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import it.daniele.entity.*;
import it.daniele.repository.*;

class GestioneSistemaScolasticoTest {

    private GestioneSistemaScolastico gestioneSistemaScolastico;
    private StudenteRepository studenteRepository;
    private InsegnanteRepository insegnanteRepository;
    private CorsoRepository corsoRepository;
    private IscrizioneRepository iscrizioneRepository;

    @BeforeEach
    void setUp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projectSistemaScolastico");
        gestioneSistemaScolastico = new GestioneSistemaScolastico(entityManagerFactory);
        studenteRepository = new StudenteRepository(entityManagerFactory);
        insegnanteRepository = new InsegnanteRepository(entityManagerFactory);
        corsoRepository = new CorsoRepository(entityManagerFactory);
        iscrizioneRepository = new IscrizioneRepository(entityManagerFactory);
    }

    @Test
    void testCreaStudente() {
        // Crea un oggetto Studente utilizzando il costruttore
        LocalDate dataDiNascita = LocalDate.of(2000, 1, 1);
        Studente studente = new Studente("Mario", "Rossi", dataDiNascita, "Via Roma 1", "mario.rossi@example.com");

        // Chiama il metodo creaStudente per salvare lo studente nel database
        gestioneSistemaScolastico.creaStudente(studente);

        // Controlla se lo studente è stato salvato correttamente
        assertNotNull(studente.getId());

        // Verifica se lo studente salvato ha gli stessi valori di nome, cognome, data di nascita, indirizzo e email
        Studente studenteSalvato = studenteRepository.trovaStudentePerId(studente.getId());
        assertEquals("Mario", studenteSalvato.getNome());
        assertEquals("Rossi", studenteSalvato.getCognome());
        assertEquals(dataDiNascita, studenteSalvato.getDataDiNascita());
        assertEquals("Via Roma 1", studenteSalvato.getIndirizzo());
        assertEquals("mario.rossi@example.com", studenteSalvato.getEmail());
    }
    
    @Test
    public void testCreaInsegnante() {
        // Crea un oggetto Insegnante
        Insegnante insegnante = new Insegnante();
        insegnante.setNome("Laura");
        insegnante.setCognome("Bianchi");
        insegnante.setMateriaInsegnata("Matematica");

        // Chiama il metodo creaInsegnante per salvare l'insegnante nel database
        gestioneSistemaScolastico.creaInsegnante(insegnante);

        // Controlla se l'insegnante è stato salvato correttamente
        assertNotNull(insegnante.getId());

        // Verifica se l'insegnante salvato ha gli stessi valori di nome, cognome e materia
        Insegnante insegnanteSalvato = insegnanteRepository.trovaInsegnantePerId(insegnante.getId());
        assertEquals("Laura", insegnanteSalvato.getNome());
        assertEquals("Bianchi", insegnanteSalvato.getCognome());
        assertEquals("Matematica", insegnanteSalvato.getMateriaInsegnata());
    }
    
    @Test
    public void testCreaCorso() {
        // Crea un oggetto Corso
        Corso corso = new Corso();
        corso.setTitolo("Programmazione Java");
        corso.setDescrizione("Introduzione alla programmazione con Java");

        // Chiama il metodo creaCorso per salvare il corso nel database
        gestioneSistemaScolastico.creaCorso(corso);

        // Controlla se il corso è stato salvato correttamente
        assertNotNull(corso.getId());

        // Verifica se il corso salvato ha gli stessi valori di nome e descrizione
        Corso corsoSalvato = corsoRepository.trovaCorsoPerId(corso.getId());
        assertEquals("Programmazione Java", corsoSalvato.getTitolo());
        assertEquals("Introduzione alla programmazione con Java", corsoSalvato.getDescrizione());
    }

    @Test
    public void testEliminaStudente() {
        // Crea e salva un nuovo studente
        Studente studente = new Studente();
        studente.setNome("Marco");
        studente.setCognome("Rossi");
        studenteRepository.salvaStudente(studente);
        assertNotNull(studente.getId());

        // Elimina lo studente appena creato
        gestioneSistemaScolastico.eliminaStudente(studente.getId());

        // Verifica se lo studente è stato eliminato correttamente
        Studente studenteEliminato = studenteRepository.trovaStudentePerId(studente.getId());
        assertNull(studenteEliminato);
    }

    @Test
    public void testEliminaInsegnante() {
        // Crea e salva un nuovo insegnante
        Insegnante insegnante = new Insegnante();
        insegnante.setNome("Lucia");
        insegnante.setCognome("Verdi");
        insegnante.setMateriaInsegnata("Fisica");
        insegnanteRepository.salvaInsegnante(insegnante);
        assertNotNull(insegnante.getId());

        // Elimina l'insegnante appena creato
        gestioneSistemaScolastico.eliminaInsegnante(insegnante.getId());

        // Verifica se l'insegnante è stato eliminato correttamente
        Insegnante insegnanteEliminato = insegnanteRepository.trovaInsegnantePerId(insegnante.getId());
        assertNull(insegnanteEliminato);
    }
    
    @Test
    void testEliminaCorso() {
        // Crea un oggetto Corso e salvatelo nel database
        Corso corso = new Corso();
        corso.setTitolo("Matematica");
        corso.setDescrizione("MATE01");
        gestioneSistemaScolastico.creaCorso(corso);

        // Controlla se il corso è stato salvato correttamente
        assertNotNull(corso.getId());

        // Elimina il corso
        gestioneSistemaScolastico.eliminaCorso(corso.getId());

        // Verifica se il corso è stato eliminato correttamente
        Corso corsoEliminato = corsoRepository.trovaCorsoPerId(corso.getId());
        assertNull(corsoEliminato);
    }
    
    @Test
    void testAnnullaIscrizione() {
        // Crea e salva uno studente e un corso nel database
    	LocalDate dataDiNascita = LocalDate.of(2000, 1, 1);
        Studente studente = new Studente("Mario", "Rossi", dataDiNascita, "Via Roma 1", "mario.rossi@example.com");
        Corso corso = new Corso();
        corso.setTitolo("Programmazione Java");
        corso.setDescrizione("Introduzione alla programmazione con Java");
        
        gestioneSistemaScolastico.creaStudente(studente);
        gestioneSistemaScolastico.creaCorso(corso);
        
        // Iscrivi lo studente al corso e salva l'iscrizione
        gestioneSistemaScolastico.iscriviStudenteACorso(studente.getId(), corso.getId());
        Iscrizione iscrizione = gestioneSistemaScolastico.trovaIscrizionePerStudenteECorso(studente.getId(), corso.getId());
        // Controlla se l'iscrizione è stata salvata correttamente
        assertNotNull(iscrizione.getId());

        // Annulla l'iscrizione
        gestioneSistemaScolastico.annullaIscrizione(iscrizione.getId());

        // Verifica se l'iscrizione è stata annullata correttamente
        Iscrizione iscrizioneAnnullata = iscrizioneRepository.trovaIscrizionePerId(iscrizione.getId());
        assertNull(iscrizioneAnnullata);
    }
    
    
}
