package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import it.betacom.components.ReportExec;

@SpringBootApplication
public class DemoApplication implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired
	ReportExec reportExec;
	
	@Bean
	List<String> studentList(){
	  List<String> students = new ArrayList<>();
	  students.add("Daniele");
	  students.add("Andrea");
	  
	  return students;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Start");
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		reportExec.execute();
		
	}

}
