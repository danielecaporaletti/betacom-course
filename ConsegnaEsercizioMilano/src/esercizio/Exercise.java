package esercizio;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Exercise {

	public static void main(String[] args) {

		LocalDate nascitaMarco = LocalDate.of(1996, 3, 22);
		LocalDate nascitaMaria = LocalDate.of(1995, 5, 13);
		LocalDate nascitaGiacomo = LocalDate.of(1997, 4, 4);

		LocalDate currentDate = LocalDate.now();

		ArrayList<Studente> studenti = new ArrayList<Studente>();

		studenti.add(new Studente("Marco", "A3567", nascitaMarco));
		studenti.add(new Studente("Maria", "M2344", nascitaMaria));
		studenti.add(new Studente("Giacomo", "G47564", nascitaGiacomo));

		System.out.println("*****************STUDENTI**********************************\n*");
		for (Studente s : studenti) {
			System.out.println("* Nome: " + s.getNome() + " | Matricola: " + s.getMatricola() + " | Data di nascita: "
					+ s.getDataDiNascita().toString());
			Period age = Period.between(s.getDataDiNascita(), currentDate);
			System.out.println("* Età di " + s.getNome() + ": " + age.getYears() + " anni, " + age.getMonths()
					+ " mesi e " + age.getDays() + " giorni");
			System.out.println("* ");
		}

		System.out.println("***********************************************************");

	}

}
