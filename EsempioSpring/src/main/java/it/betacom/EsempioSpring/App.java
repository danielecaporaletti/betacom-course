package it.betacom.EsempioSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.betacom.model.Auto;
import it.betacom.model.Cliente;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("model.xml");
        Cliente c = (Cliente) context.getBean("cliente");
        c.setNome("Daniele");
        c.setCognome("Rossi");
       
        Cliente c2 = (Cliente) context.getBean("cliente");
        c2.setNome("Carlo");
        c2.setCognome("Bianchi");
        c2.getRuolo();
        System.out.println(c);
        System.out.println(c2);
        
        Auto auto = (Auto) context.getBean("auto");
        auto.avviaAuto();
        
        
        
        ((ConfigurableApplicationContext) context).close();
        
        
       
        
        
        
    }
}
