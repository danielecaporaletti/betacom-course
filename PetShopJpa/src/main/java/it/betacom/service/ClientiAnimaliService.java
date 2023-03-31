package it.betacom.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.betacom.entity.Animale;
import it.betacom.entity.Cliente;
import util.JPAUtil;

public class ClientiAnimaliService {
	
    public void stampaClientiAnimali() {
        EntityManager em = JPAUtil.getEntityManager();
        
        String query = "SELECT c, a FROM Cliente c JOIN c.animali a";
        TypedQuery<Object[]> typedQuery = em.createQuery(query, Object[].class);
        List<Object[]> results = typedQuery.getResultList();

        System.out.println("Elenco clienti e animali venduti:");
        System.out.println("Cliente\t\t\t\t\t\t\tAnimale");

        for (Object[] result : results) {
            Cliente cliente = (Cliente) result[0];
            Animale animale = (Animale) result[1];
            System.out.println(cliente.getNome() + " " + cliente.getCognome() + "\t\t\t" + animale.getNome());
        }

        em.close();
    }
    
    public void stampaClientiAcquisti() {
        EntityManager em = JPAUtil.getEntityManager();

        TypedQuery<Cliente> queryCliente = em.createQuery("SELECT DISTINCT c FROM Cliente c JOIN FETCH c.animali", Cliente.class);
        List<Cliente> clienti = queryCliente.getResultList();

        System.out.println("Elenco clienti e acquisti dettagliati:");

        for (Cliente cliente : clienti) {
            System.out.println(cliente.getNome() + " " + cliente.getCognome() + ":");
            for (Animale animale : cliente.getAnimali()) {
                System.out.println("- " + animale.getDataAcquisto() + ", " + animale.getMatricola() + ", " + animale.getPrezzo() + ", " + animale.getNome());
            }
        }

        em.close();
    }

    public void stampaAnimaliVenduti() {
        EntityManager em = JPAUtil.getEntityManager();

        TypedQuery<Animale> queryAnimali = em.createQuery("SELECT a FROM Animale a ORDER BY a.dataAcquisto", Animale.class);
        List<Animale> animali = queryAnimali.getResultList();

        System.out.println("Elenco animali venduti ordinati per data di acquisto:");

        for (Animale animale : animali) {
            Cliente cliente = animale.getCliente();
            System.out.println(animale.getDataAcquisto() + " - " + animale.getNome() + " - " + animale.getMatricola() + " - " + cliente.getNome() + " " + cliente.getCognome() + " - " + cliente.getTel());
        }

        em.close();
    }
    
}
