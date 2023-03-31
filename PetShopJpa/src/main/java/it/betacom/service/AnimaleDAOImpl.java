package it.betacom.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.betacom.entity.Animale;
import util.JPAUtil;

public class AnimaleDAOImpl implements AnimaleDAO {

	@Override
	public void createAnimale(Animale animale) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(animale);
        em.getTransaction().commit();
        em.close();
	}

	@Override
	public Animale readAnimale(Long matricola) {
        EntityManager em = JPAUtil.getEntityManager();
        Animale animale = em.find(Animale.class, matricola);
        em.close();
        return animale;
	}

	@Override
	public void updateAnimale(Long matricola, Animale updatedAnimale) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Animale animale = em.find(Animale.class, matricola);
        
        if (animale != null) {
            animale.setNome(updatedAnimale.getNome());
            animale.setDataAcquisto(updatedAnimale.getDataAcquisto());
            animale.setPrezzo(updatedAnimale.getPrezzo());
            animale.setTipoAnimale(updatedAnimale.getTipoAnimale());
            animale.setCliente(updatedAnimale.getCliente());
            em.merge(animale);
        }
        
        em.getTransaction().commit();
        em.close();

	}

	@Override
	public void deleteAnimale(Long matricola) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Animale animale = em.find(Animale.class, matricola);
        
        if (animale != null) {
            em.remove(animale);
        }
        
        em.getTransaction().commit();
        em.close();
	}

	@Override
	public List<Animale> readAllAnimali() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Animale> animali = em.createQuery("SELECT a FROM Animale a", Animale.class).getResultList();
        em.close();
        return animali;
	}

}
