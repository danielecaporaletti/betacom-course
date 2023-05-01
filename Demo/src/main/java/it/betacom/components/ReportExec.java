package it.betacom.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportExec {
    
    @Autowired
    private List<String> studentsList;

    public void execute(){
        System.out.println("I nostri studenti sono");

        for(String student : studentsList){
            System.out.println("Nome:"+student);

        }
    }
}
