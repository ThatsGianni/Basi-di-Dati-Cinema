package unisa.studenti.it.Operazioni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.mysql.cj.x.protobuf.MysqlxSession.Reset;
import com.mysql.cj.xdevapi.Statement;

import unisa.studenti.it.Entity.Biglietto;
import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Entity.Utente;




public class OperazioniUtente {
	private static Utente user;

	public static boolean registrazioneUtente(String username,String nome,String cognome,String email,String password) throws IOException{
		boolean inserito = false;
		boolean result = false;
		boolean emailValidation = false;
		
			emailValidation=validationEmail(email);
				
			if(!emailValidation) {
			System.out.println("Formato email sbagliato");
			return emailValidation;
			}
			user = new Utente(username,nome,cognome,email,password);
			inserito = InsertTable.utente(user);
			if(!inserito) {
				System.out.println("Inserimento fallito");
			}
			String query = "CREATE USER ? IDENTIFIED BY ?";
			try(PreparedStatement statement = DBMCinema.getConn().prepareStatement(query)){
				statement.setString(1,user.getUsername());
				statement.setString(2,user.getPassword());
				result = statement.execute();
				}catch (Exception e) {
					if(!result) {
						System.out.println("Qualcosa è andato storto");
					}
				}
			return inserito;
				}
		
	public static boolean validationEmail(String s) {

		if(s.indexOf("@") != -1)
        {
			return true;
        }
		return false;
		
	}
	
	public static boolean loginUtente(String username,String password) throws SQLException {
		boolean result = false;
	    String SQL = "SELECT username FROM utenti WHERE username ='"+username+"' && password ='"+password+"';";
	    String user1 = null;
	    java.sql.Statement stmt = DBMCinema.getConn().createStatement();
	    ResultSet user= stmt.executeQuery(SQL);
	    while(user.next()) {
	    	user1 = user.getString("username");
	    }
	    if(user1!=null) {
	    	result = true;
	    	System.out.println("Login Effettuato");
	    }
	    if(!result) {
	    	System.out.println("L'utente non è registrato");
	    }
		return result;
	    
	    
		
	}
	
	public static void acquistoBiglietto(String username,String Film,int codpos) throws SQLException{
				try {
				int codprog = getCodProg(Film);
				LocalDate todaysDate = LocalDate.now();
				System.out.println(codpos);
				Biglietto biglietto = new Biglietto(""+todaysDate,username,codprog,codpos);
				InsertTable.biglietti(biglietto);
		}catch(Exception e) {
			System.out.println("Il Film non è in programmazione");
		}
		
}

	public static ArrayList<String> visuallizzaProgrammazione(int x,String s) throws SQLException {
		boolean result = false;
		ResultSet film = null;
		ArrayList<String> filmProgrammazione = new ArrayList<String>();
		String query="SELECT*from registi join film_programmazione on film_programmazione.idreg=registi.idreg where idcin="+x+";";
		java.sql.Statement stmt = DBMCinema.getConn().createStatement();
		film = stmt.executeQuery(query);
		
		while(film.next()) {
			String prg = film.getString("FILM");
			filmProgrammazione.add(prg);
			
		}
		
		if(filmProgrammazione!=null) {
			result=true;
		}
		if(!result) {
			System.out.println("Error");
		}
		return filmProgrammazione;
	}
	public static ArrayList<String> visuallizzaProgrammazione(int x) throws SQLException {
		boolean result = false;
		ResultSet film = null;
		ArrayList<String> filmProgrammazione = new ArrayList<String>();
		String query="SELECT*from registi join film_programmazione on film_programmazione.idreg=registi.idreg where idcin="+x+";";
		java.sql.Statement stmt = DBMCinema.getConn().createStatement();
		film = stmt.executeQuery(query);
		
		while(film.next()) {
			String prg = "'"+film.getString("FILM")+"'  Data: "+film.getString("giorno")+"  Prezzo: "+film.getString("prezzo")+"$ "+"Regista: "+film.getString("nome")+" "+film.getString("cognome");
			filmProgrammazione.add(prg);
		}
		if(filmProgrammazione!=null) {
			result=true;
		}
		if(!result) {
			System.out.println("Error");
		}
		return filmProgrammazione;
	}
	public static boolean visualizzaPosti() throws SQLException {
		boolean result = false;
		ResultSet posto = null;
		ArrayList<Integer> postoLiberi = new ArrayList<Integer>();
		String query = "SELECT `prog_posl`.`CODPROG`,`prog_posl`.`NUMFILA`,`prog_posl`.`NUMCOL`,`prog_posl`.`CODPOS`FROM `progetto`.`prog_posl`;";
		java.sql.Statement stmt = DBMCinema.getConn().createStatement();
		posto = stmt.executeQuery(query);
		while(posto.next()) {
			postoLiberi.add(posto.getInt("NUMFILA"));
			postoLiberi.add(posto.getInt("COLONNA"));
		}
		if(postoLiberi!= null) {
			result=false;
		}
		return result;
	}
	public static int getCinema(String Cinema) throws SQLException {
		ResultSet cinema = null;
		int codCin = 0;
		String query="SELECT idcin FROM cinema where nome='"+Cinema+"';";
		java.sql.Statement stmt = DBMCinema.getConn().createStatement();
		cinema = stmt.executeQuery(query);
		while(cinema.next()) {
			codCin = cinema.getInt("idcin");
		}
		if(codCin==0) {
			System.out.println("Error...");
		}
		return codCin;
		
		
	}
	public static ArrayList<String> getNomeCinema() throws SQLException {
		boolean result = false;
		ResultSet cinema = null;
		String nomeCinema = null;
		ArrayList<String> nomiCinema = new ArrayList<String>();
		String query="SELECT nome FROM cinema;";
		java.sql.Statement stmt = DBMCinema.getConn().createStatement();
		cinema = stmt.executeQuery(query);
		while(cinema.next()) {
			nomeCinema = cinema.getString("nome");
			nomiCinema.add(nomeCinema);
		}
		if(nomiCinema!=null) {
			result=true;
		}
		if(!result) {
			System.out.println("Error");
		}
		return nomiCinema;
	}
	public static  ArrayList<String> visualizzaAcquisto(String username) throws SQLException {
		boolean result = false;
		ResultSet biglietti = null;
		ArrayList<String> acquisti = new ArrayList<String>();
		String query="SELECT idb,dataemiss,giorno,film,numfila,numcol from posti join bigliettiacquistati on bigliettiacquistati.codpos=posti.codpos where username='"+username+"';";
		java.sql.Statement stmt = DBMCinema.getConn().createStatement();
		biglietti = stmt.executeQuery(query);
		while(biglietti.next()) {
			acquisti.add("Data di acquisto: "+biglietti.getString("dataemiss")+", Giorno di proiezione: "+biglietti.getString("GIORNO")+", Film: "+biglietti.getString("FILM")+", Numero Biglietto: "+biglietti.getString("idb")
			+", Posto: "+biglietti.getString("numfila")+"/"+biglietti.getString("numcol"));
			System.out.println(acquisti.toString());
		}
		
		if(acquisti!=null) {
			result=true;
		}
		if(!result) {
			System.out.println("Error");
		}
		return acquisti;
		
	}
	public static ArrayList<Integer>  getIdBiglietto(String username) throws SQLException {
			String queryBiglietto = "SELECT idb from biglietti where username='"+username+"';";
			ArrayList<Integer> idBiglietto=new ArrayList<Integer>();
			java.sql.Statement query = DBMCinema.getConn().createStatement();	
			ResultSet idB = query.executeQuery(queryBiglietto);
			while(idB.next()) {
				idBiglietto.add(idB.getInt("idB"));
			}
			if(idBiglietto==null) {
				System.out.println("Error...");
			}
		return idBiglietto;
	
	}
	public static int cancellaAcquisto(String idb) throws SQLException {
		int result = 1;
		String cancella = "delete from biglietti where idb='"+idb+"';";
		PreparedStatement stmt= DBMCinema.getConn().prepareStatement(cancella);
		result=stmt.executeUpdate();
		
		if(result==0) {
			System.out.println("Error...");
		}
		return result;
	}
	public static  ArrayList<String> visualizzaCinema() throws SQLException {
		boolean result = false;
		ResultSet cinema = null;
		String getCinema=null;
		ArrayList<String> cinemaLista = new ArrayList<String>();
		String query="SELECT nome,indirizzo,nazione,città,numero from cinema join telefoni on telefoni.idcin=cinema.idcin";
		java.sql.Statement stmt = DBMCinema.getConn().createStatement();
		cinema = stmt.executeQuery(query);
		while(cinema.next()) {
			getCinema = "Nome: "+cinema.getString("nome")+", Indirizzo: "+cinema.getString("indirizzo")+"/"+
					cinema.getString("nazione")+"/"+cinema.getString("città")+", Telefono: "+cinema.getString("numero");
			cinemaLista.add(getCinema);
		}
		if(cinemaLista!=null) {
			result=true;
		}
		if(!result) {
			System.out.println("Error");
		}
		return cinemaLista;
		
	}
	public static ArrayList<String> getPostiLiberi(String Film) throws SQLException{
		int codprog = getCodProg(Film);
		String query = "SELECT NUMFILA, NUMCOL from PROG_POSL where codprog="+codprog+";";
		ArrayList<String> posti=new ArrayList<String>();
		java.sql.Statement pquery = DBMCinema.getConn().createStatement();	
		ResultSet postiLiberi = pquery.executeQuery(query);
		while(postiLiberi.next()) {
			posti.add(""+postiLiberi.getString("NUMFILA")+""+postiLiberi.getString("NUMCOL"));
		}
		if(posti==null) {
			System.out.println("Error...");
		}
	return posti;
	}
	public static int getCodProg(String film) throws SQLException {
		int idf = getIdFilm(film);
		int codprog=0;
		String QueryCodprog = "SELECT codprog from programmazioni p JOIN Film f on p.idf=f.idf where f.idf='"+idf+"';";
		java.sql.Statement query2 = DBMCinema.getConn().createStatement();	
		ResultSet programmazione = query2.executeQuery(QueryCodprog);
		while(programmazione.next()) {
			codprog = programmazione.getInt("codprog");
		}
		if(codprog==0) {
			System.out.println("Error...");	
		}
		return codprog;
	}
	public static int getIdFilm(String Film) throws SQLException {
			String Queryfilm = "SELECT idf FROM film where nome ='"+Film+"';";
			int idf = 0;
			int codprog=0;
			java.sql.Statement query = DBMCinema.getConn().createStatement();	
			ResultSet film = query.executeQuery(Queryfilm);
			while(film.next()) {
				idf = film.getInt("idf");
			}
			if(idf==0){
			System.out.println("Error...");	
			}
			return idf;
	}
	public static int getCodPosto(String x,String y,int codprog) throws SQLException {
		String query = "SELECT * FROM PROG_POSL WHERE NUMFILA="+x+ "&& NUMCOL="+y+" && CODPROG="+codprog;
		int codpos=0;
		java.sql.Statement pquery = DBMCinema.getConn().createStatement();	
		ResultSet posto = pquery.executeQuery(query);
		while(posto.next()) {
			codpos = posto.getInt("CODPOS");
		}
		if(codpos==0){
		System.out.println("Error...");	
		}
		return codpos;
}
		
	}

