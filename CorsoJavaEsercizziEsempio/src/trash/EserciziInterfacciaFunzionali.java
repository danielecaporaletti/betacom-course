package trash;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class EserciziInterfacciaFunzionali {
	
	public static Predicate<String> hasLegthOf10 = new Predicate<String>() {
		public boolean test(String t) {
			return t.length() > 10;
		}
	};

	public static void main(String[] args) {
		
		System.out.println("ES1---------------------------");
		//Esercizio1
		
		//Voglio verificare tramite 2 oggetti di tipo predicate 
		//se la stringa nome contiene la lettera A o ho lunghezza > 10
		
		String nome = "Andrea";
		
		Predicate<String> containsA = s -> s.contains("A");
		Predicate<String> isLongerThan10 = hasLegthOf10;
		
		if (containsA.or(isLongerThan10).test(nome)) {
		    System.out.println("true");
		} else {
		    System.out.println("false");
		}
		
		System.out.println();
		System.out.println("ES2---------------------------");
		//Esercizio2
		
		//Creare una classe User con due proprieta’ nome e  ruolo.  Costruttore , getter e setter e  metodo toString
		//Creare lista users con 5 user due con ruolo “admin “ e tre con ruolo “member”
		//Voglio creare due liste una con gli admin e l’altra con i member
		//Stampare a video il loro contenuto

		
		List<User> userList = Arrays.asList(
			    new User("Mario", "Member"),
			    new User("Luigi", "Member"),
			    new User("Marco", "Admin"),
			    new User("Beppe", "Admin"),
			    new User("Maria", "Member")
			);

		
		for (User u : userList) {
			System.out.println(u.toString());
		}
		
		System.out.println();
		
		List<User> memberList = userList.stream()
                .filter(u -> u.getRuolo().equals("Member"))
                .collect(Collectors.toList());

		List<User> adminList = userList.stream()
               .filter(u -> u.getRuolo().equals("Admin"))
               .collect(Collectors.toList());
		
		for (User u : memberList) {
			System.out.println(u.toString());
		}
		
		System.out.println();
		
		for (User u : adminList) {
			System.out.println(u.toString());
		}
		
		
		
	    List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
	    System.out.println();
	    System.out.println("ES3---------------------------");
	    //Esercizio3
	    
	    //Dato una lista di interi  ottenere una sottolista di interi il cui valore e’ maggiore di 5 e minore di 10
		
	    List<Integer> sottolista1 = numeri.stream()
	                                    .filter(numero -> numero >= 5 && numero <= 10)
	                                    .collect(Collectors.toList());
	    System.out.println(sottolista1);
		
	    System.out.println();
	    System.out.println("ES4---------------------------");
	    //Esercizio4
	    
	    //Dato una lista di interi  ottenere una lista di interi corrispondenti il cui valore e’ moltiplicato per 3

	
	    List<Integer> sottolista2 = numeri.stream()
	    								.map(x -> x*3)
	    								.collect(Collectors.toList());
	    
	    System.out.println(sottolista2);

	    System.out.println();
	    System.out.println("ES5---------------------------");
	    //Esercizio5
	    
	    //Dato una lista di interi  ottenere una sottolista contenete i numeri pari
	    
	    List<Integer> sottolista3 = numeri.stream()
	    								.filter(x -> (x%2 == 0))
	    								.collect(Collectors.toList());
	
	    System.out.println(sottolista3);

	    System.out.println();
	    System.out.println("ES6---------------------------");
	    //Esercizio6
	    
	    //Dato una lista di interi ottenere la loro somma 
	    
	    int somma = numeri.stream().reduce(0, (x, y) -> x + y);
	    System.out.println("La somma è: " + somma);
	
	
	}
		
	

}
