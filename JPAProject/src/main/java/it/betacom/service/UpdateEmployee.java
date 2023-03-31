package it.betacom.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class UpdateEmployee {

    public static void main(String[] args) {

	EntityManagerFactory mFactory = Persistence.createEntityManagerFactory("JPAProject");

	EntityManager em = mFactory.createEntityManager();

	em.getTransaction().begin();

	Employee employee = em.find(Employee.class, 1);

	System.out.println(employee);

	employee.setSalary(5000);

	em.getTransaction().commit();

	System.out.println(employee);

	em.close();

	mFactory.close();

    }

}