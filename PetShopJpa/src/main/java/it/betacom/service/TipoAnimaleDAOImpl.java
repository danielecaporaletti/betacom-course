package it.betacom.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.betacom.entity.TipoAnimale;
import util.JPAUtil;

public class TipoAnimaleDAOImpl implements TipoAnimaleDAO {

	@Override
	public void createTipoAnimale(TipoAnimale tipoAnimale) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(tipoAnimale);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public TipoAnimale readTipoAnimale(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		TipoAnimale tipoAnimale = em.find(TipoAnimale.class, id);
		em.close();
		return tipoAnimale;
	}

	@Override
	public void updateTipoAnimale(Long id, TipoAnimale newTipoAnimale) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		TipoAnimale tipoAnimale = em.find(TipoAnimale.class, id);

		if (tipoAnimale != null) {
			tipoAnimale.setTipo(newTipoAnimale.getTipo());
			em.merge(tipoAnimale);
		}

		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void deleteTipoAnimale(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		TipoAnimale tipoAnimale = em.find(TipoAnimale.class, id);

		if (tipoAnimale != null) {
			em.remove(tipoAnimale);
		}

		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<TipoAnimale> readAllTipoAnimale() {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<TipoAnimale> query = em.createQuery("SELECT t FROM TipoAnimale t", TipoAnimale.class);
		List<TipoAnimale> tipiAnimali = query.getResultList();
		em.close();
		return tipiAnimali;
	}

}
