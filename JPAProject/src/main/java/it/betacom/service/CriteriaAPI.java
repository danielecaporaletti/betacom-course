package it.betacom.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.betacom.entity.Employee;

public class CriteriaAPI {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		
		Root<Employee> from = criteriaQuery.from(Employee.class);
		
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		
		TypedQuery<Object> typedQuery = em.createQuery(select);
		
		List<Object> lista = typedQuery.getResultList();
		
		lista.forEach(System.out::println);
		
		//Esempio 2
		CriteriaQuery<Object> select2 = criteriaQuery.select(from);
		select2.orderBy(criteriaBuilder.asc(from.get("name")));
		
		TypedQuery<Object> typedQuery2 = em.createQuery(select);
		
		List<Object> lista2 = typedQuery.getResultList();
		
		lista.forEach(System.out::println);
		
		
		
		
		em.close();
		emf.close();

	}

}
