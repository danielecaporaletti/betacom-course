package it.betacom.daniele;

//CREARE UNA CLASSE DI TEST CHE TRAMITE METODO OPPORTUNO E (SWITCH) STAMPI A VIDEO IL GIORNO DELLA SETTIMANA TRAMITE CHIAMATA DA MAIN
//
//PER I PRIMI 5 GIORNI DELLA SETTIMANA STAMERà OUTPUT "OGGI è gg.settimana" 
//
//PER GLI ALTRI GIORNI DELLA SETTIMANA STAMPERà "OGGI è UN GIORNO DI FESTA"

public class EnumTest {
	
	DayOfWeek day;
	
	public EnumTest(DayOfWeek day) {
		this.day = day;
	}
	
    public void giorno() {
    	switch (day) {
		case MONDAY: System.out.println("Lunedì");
			break;
		case TUESDAY: System.out.println("Martedì");
			break;
		case WEDNESDAY: System.out.println("Mercoledì");
			break;
		case THURSDAY: System.out.println("Giovedì");
			break;
		case FRIDAY: System.out.println("Venerdì");
			break;
		case SATURDAY: System.out.println("Giorno festivo");
			break;
		case SUNDAY: System.out.println("Giorno festivo");
			break;
		default: System.out.println("nulla");
		}
    }
	
	public static void main(String[] args) {
		
		new EnumTest(DayOfWeek.MONDAY).giorno();
        
		
	}

}
