package it.betacom;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.betacom.model.Student;
import it.betacom.template.StudentJDBCTemplate;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		
//		studentJDBCTemplate.create("Gino", 27);
//		studentJDBCTemplate.create("Pino", 24);
//		studentJDBCTemplate.create("Tino", 21);
		
		List<Student> students = studentJDBCTemplate.listStudents();
		for (Student s : students)
			System.out.println(s.getId() + " - " + s.getName() + ", " + s.getAge());
		
//		studentJDBCTemplate.update(2, 32);
		
//		studentJDBCTemplate.delete(4);
	}

}
