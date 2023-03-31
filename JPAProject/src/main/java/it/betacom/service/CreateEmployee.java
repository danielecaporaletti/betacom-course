package it.betacom.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class CreateEmployee {

    public static void main(String[] args) {

	EntityManagerFactory mFactory = Persistence.createEntityManagerFactory("JPAProject");
	
	EntityManager em = mFactory.createEntityManager();

	em.getTransaction().begin();

	Employee employee = new Employee();

//	employee.setEid(1000);

	employee.setEname("LucaBas");

	employee.setSalary(1500);

	employee.setDeg("Tecnical");

	em.persist(employee);

	Employee employee2 = new Employee();

//	employee.setEid(1000);

	employee2.setEname("Luca");

	employee2.setSalary(1500);

	employee2.setDeg("Tecnical");

	em.persist(employee);

	em.persist(employee2);

	em.getTransaction().commit();

	em.close();

	mFactory.close();

    }

}