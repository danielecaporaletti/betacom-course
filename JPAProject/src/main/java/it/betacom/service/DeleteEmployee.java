package it.betacom.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class DeleteEmployee {

    public static void main(String[] args) {

	EntityManagerFactory mFactory = Persistence.createEntityManagerFactory("JPAProject");

	EntityManager em = mFactory.createEntityManager();

	em.getTransaction().begin();

	Employee employee = em.find(Employee.class, 1);

	em.remove(employee);

	em.getTransaction().commit();

	System.out.println(employee);

	Employee employee1 = em.find(Employee.class, 1);

	System.out.println(employee1);

	em.close();

	mFactory.close();
    }

}