package it.betacom.service;

import it.betacom.entity.PetShopUser;
import it.betacom.entity.PetShopUser.UseRole;
import it.betacom.entity.PetShopUser.UseStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

public class PetShopUserDAO {

    private static final String PERSISTENCE_UNIT = "PetShop";

    public PetShopUser create(PetShopUser petShopUser) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(petShopUser);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return petShopUser;
    }

    public PetShopUser read(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        PetShopUser petShopUser = em.find(PetShopUser.class, id);

        em.close();
        emf.close();

        return petShopUser;
    }

    public PetShopUser update(PetShopUser petShopUser) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        petShopUser = em.merge(petShopUser);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return petShopUser;
    }

    public void delete(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        PetShopUser petShopUser = em.find(PetShopUser.class, id);

        em.getTransaction().begin();
        em.remove(petShopUser);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public List<PetShopUser> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        TypedQuery<PetShopUser> query = em.createQuery("SELECT a FROM PetShopUser a", PetShopUser.class);
        List<PetShopUser> petShopUserList = query.getResultList();

        em.close();
        emf.close();

        return petShopUserList;
    }
    
    public void setActive(int id) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        PetShopUser petShopUser = em.find(PetShopUser.class, id);
        petShopUser.setStatus(UseStatus.ACTIVE);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    public void setDisable(int id) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        PetShopUser petShopUser = em.find(PetShopUser.class, id);
        petShopUser.setStatus(UseStatus.DISABLE);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
   
    
    public void setManager(int id) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        PetShopUser petShopUser = em.find(PetShopUser.class, id);
        petShopUser.setRole(UseRole.MANAGER);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    public void setGuest(int id) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        PetShopUser petShopUser = em.find(PetShopUser.class, id);
        petShopUser.setRole(UseRole.GUEST);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }


    public PetShopUser findUserByUsernameAndPasswordAndStatus(String username, String password) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	    EntityManager em = emf.createEntityManager();
	
	    try {
	        TypedQuery<PetShopUser> query = em.createQuery("SELECT u FROM PetShopUser u WHERE u.username = :username AND u.password = :password", PetShopUser.class);
	        query.setParameter("username", username);
	        query.setParameter("password", password);
	        List<PetShopUser> resultList = query.getResultList();
	
	        if (!resultList.isEmpty()) {
	            PetShopUser user = resultList.get(0);
	            if (user.getStatus() == UseStatus.DISABLE) {
	                user.setId(-1); // Impostiamo l'ID su -1 per indicare che l'utente è disabilitato
	            }
	            return user;
	        } else {
	            return null;
	        }
	    } catch (NoResultException nre) {
	        return null;
	    } finally {
	        em.close();
	        emf.close();
	    }
    }
    
    public void checkAndDisableUser(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        PetShopUser petShopUser = em.find(PetShopUser.class, id);
        if (petShopUser.getAccessCount() == 3) {
            petShopUser.setStatus(UseStatus.DISABLE);
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void incrementAccessCount(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        PetShopUser petShopUser = em.find(PetShopUser.class, id);
        petShopUser.setAccessCount(petShopUser.getAccessCount() + 1);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
    

    public void resetAccessCount(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        PetShopUser petShopUser = em.find(PetShopUser.class, id);
        petShopUser.setAccessCount(0);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
    
    public PetShopUser findUserByUsername(String username) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<PetShopUser> query = em.createQuery("SELECT u FROM PetShopUser u WHERE u.username = :username", PetShopUser.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public PetShopUser findById(int userId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();

        PetShopUser petShopUser = null;
        try {
            petShopUser = em.find(PetShopUser.class, userId);
        } catch (NoResultException nre) {
        	nre.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

        return petShopUser;
    }

}
