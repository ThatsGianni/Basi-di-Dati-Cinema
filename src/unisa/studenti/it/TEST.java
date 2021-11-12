package unisa.studenti.it;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import unisa.studenti.it.Entity.Attore;
import unisa.studenti.it.Entity.Biglietto_Storico;
import unisa.studenti.it.Entity.Cinema;
import unisa.studenti.it.Entity.Consultazione;
import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Entity.Film;
import unisa.studenti.it.Entity.Programmazione;
import unisa.studenti.it.Entity.Regista;
import unisa.studenti.it.Entity.Utente;
import unisa.studenti.it.GUI.AreaAdminGui;
import unisa.studenti.it.GUI.AreaUtenteGui;
import unisa.studenti.it.GUI.RegistrazioneGui;
import unisa.studenti.it.GUI.VisualizzaCinemaGui;
import unisa.studenti.it.GUI.WelcomeGui;
import unisa.studenti.it.Operazioni.Controll;
import unisa.studenti.it.Operazioni.InsertTable;
import unisa.studenti.it.Operazioni.OperazioniAdmin;
import unisa.studenti.it.Operazioni.OperazioniUtente;

public class TEST {
	public static String username = "root";
	public static String pwd = "Ggtg111014";
	public static void main(String[] args) throws IOException, SQLException {
		DBMCinema.connectionDBM(username, pwd);
		start();
		

		}
	public static void start() throws SQLException, IOException {
		System.out.println("Admin:\n"
				+ "1)Inserimento di una Programmazione\n"
				+ "2)Visualizzazione biglietti acquistati di Programmazioni in Corso\n"
				+ "3)Visualizzazione biglietti acquistati di Programmazioni in Vecchie Programmazioni\n"
				+ "4)Inserimento di nuovi Film,Cinema e Sale\n"
				+ "5)Visualizzare i Registrati alla piattaforma\n"
				+ "Utente:\n"
				+ "1)Registrazione/Login\n"
				+ "2)Prenotazione Biglietto e Scelta dei Posti\n"
				+ "3)Cancellazione Prenotazione\n"
				+ "4)Visualizzazione Programmazione in Corso e Info sui Cinema\n"
				+ "Automatici:\n"
				+ "1)Controllo delle Programmazioni con relativa cancellazione se Necessario"
				+ "2)Salvataggio dei Biglietti scaduti\n"
				+ "3)Cancellazione di Biglietti di Programmazioni scadute\n"
				+ "Premere 1 per Continuare");
		
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		if(x==1) {
			WelcomeGui window = new WelcomeGui();
			window.open();
			Controll.controllProgrammazioni();
			
		}
		
		
				
				
				
				
				
				
				
				
				
			
	}
}

