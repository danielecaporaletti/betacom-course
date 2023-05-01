package it.betacom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.betacom.model.Student;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("avvio");
		Student student = (Student) context.getBean("student");
		 
	      student.getAge();
	      student.getName();
	      //Lancio dell'exception
	      student.printThrowException();
	     
	}

}
