package it.betacom.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class FindEmployee {

    public static void main(String[] args) {

	EntityManagerFactory mFactory = Persistence.createEntityManagerFactory("JPAProject");

	EntityManager em = mFactory.createEntityManager();

	em.getTransaction().begin();

	Employee employee = em.find(Employee.class, 1);

	int eid = employee.getEid();

	String ename = employee.getEname();

	double salary = employee.getSalary();

	String deg = employee.getDeg();

	em.close();

	mFactory.close();

	System.out.println(employee);

	System.out.println(eid + "|" + ename + "|" + salary + "|" + deg + "|");

    }

}