package unisa.studenti.it.Operazioni;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Entity.Regista;

public class OperazioniAdmin {

	public OperazioniAdmin() {
		
	}
	public static int getIDFilm(String Film) {
	int idf = 0;
	try{
		String Queryfilm = "SELECT idf FROM film where nome ='"+Film+"';";
		java.sql.Statement query = DBMCinema.getConn().createStatement();	
		ResultSet film = query.executeQuery(Queryfilm);
		while(film.next()) {
			idf = film.getInt("idf");
		}
		System.out.println(idf);
		}catch (Exception e ) {
			if(idf==0) {
				System.out.println("Error...");
			}
		}
	return idf;
	}
	public static  ArrayList<String> visualizzaBigliettiStorici() throws SQLException {

		boolean result = false;
		ResultSet biglietto = null;
		ArrayList<String> bigliettoStorico = new ArrayList<String>();
		String query="SELECT nome,cognome,email,codst,film,giorno,cinema,numsala,numfila,numcol,dataemiss FROM utenti join biglietti_storico on biglietti_storico.username=utenti.username;";
		java.sql.Statement stmt = DBMCinema.getConn().createStatement();
		biglietto = stmt.executeQuery(query);
		
		while(biglietto.next()) {
			String prg = "Nome: "+biglietto.getString("nome")+", Cognome: "+biglietto.getString("cognome")+", Email: "+biglietto.getString("email")+", Codice Biglietto: "+biglietto.getString("codst")+", Film: "+
						  biglietto.getString("film")+", Giorno: "+biglietto.getString("giorno")+", Cinema: "+biglietto.getString("cinema")+
						  ", Numero Sala:"+biglietto.getString("numsala")+"Fila/Colonna: "+biglietto.getString("numfila")+"/"
						  +biglietto.getString("numcol")+", Data Emissione: "+biglietto.getString("dataemiss");
			bigliettoStorico.add(prg);
		}
		
		if(bigliettoStorico!=null) {
			result=true;
		}
		if(!result) {
			System.out.println("Error");
		}
		return bigliettoStorico;
	} 
	public static int getIDCinema(String nome) {
		int idCin = 0;
		try{
			String Queryfilm = "SELECT idcin from cinema where nome='"+nome+"';";
			java.sql.Statement query = DBMCinema.getConn().createStatement();	
			ResultSet film = query.executeQuery(Queryfilm);
			while(film.next()) {
				idCin = film.getInt("idcin");
			}
			}catch (Exception e ) {
				if(idCin==0) {
					System.out.println("Error...");
				}
			}
		return idCin;
		}
	public static int getCodSale(int nums,int idcin) {
		int codsale = 0;
		try{
			String Queryfilm = "SELECT codsale from sale where nums='"+nums+ "' && idcin='"+idcin+"';";
			System.out.println(Queryfilm);
			java.sql.Statement query = DBMCinema.getConn().createStatement();	
			ResultSet film = query.executeQuery(Queryfilm);
			while(film.next()) {
				codsale = film.getInt("codsale");
			}
			
			}catch (Exception e ) {
				if(codsale==0) {
					System.out.println("Error...");
				}
			}
		return codsale;
		}
	public static ArrayList<String> visualizzaAcquisti() throws SQLException{
		boolean result = false;
		ResultSet biglietti = null;
		ArrayList<String> acquisti = new ArrayList<String>();
		String query="SELECT username,idb,dataemiss,giorno,film,numfila,numcol from posti join bigliettiacquistati on bigliettiacquistati.codpos=posti.codpos;";
		java.sql.Statement stmt = DBMCinema.getConn().createStatement();
		biglietti = stmt.executeQuery(query);
		while(biglietti.next()) {
			acquisti.add("Data di acquisto: "+biglietti.getString("dataemiss")+", Username:"+biglietti.getString("username")+", Giorno di proiezione: "+biglietti.getString("GIORNO")+", Film: "+biglietti.getString("FILM")+", Numero Biglietto: "+biglietti.getString("idb")
			+", Posto: "+biglietti.getString("numfila")+"/"+biglietti.getString("numcol"));
		}
		
		if(acquisti!=null) {
			result=true;
		}
		if(!result) {
			System.out.println("Error");
		}
		return acquisti;
		
	}
	public static ArrayList<String> getUtenti() throws SQLException{
		boolean result = false;
		ResultSet utente = null;
		ArrayList<String> utenti = new ArrayList<String>();
		String query="SELECT * FROM utenti;";
		java.sql.Statement stmt = DBMCinema.getConn().createStatement();
		utente = stmt.executeQuery(query);
		while(utente.next()) {
			utenti.add("Email: "+utente.getString("email")+", Username:"+utente.getString("username")+", Nome: "+utente.getString("nome")+", Cognome: "+utente.getString("cognome")+", Password: "+utente.getString("password"));
		}
		
		if(utenti!=null) {
			result=true;
		}
		if(!result) {
			System.out.println("Error");
		}
		return utenti;
	}
	public static int getIDReg(String nome,String cognome) throws IOException {
	int idReg = 0;
	try{
		String Queryfilm = "SELECT idreg from registi where nome='"+nome+"' && cognome='"+cognome+"';";
		java.sql.Statement query = DBMCinema.getConn().createStatement();	
		ResultSet regista = query.executeQuery(Queryfilm);
		while(regista.next()) {
			idReg = regista.getInt("idreg");
		}
		
		}catch (Exception e ) {
			System.out.println("Error");
		}
	return idReg;
	}
	public static boolean createRegista(String nome, String cognome) throws IOException {
		boolean result = false;
		Regista reg = new Regista(nome,cognome,0);
		result=InsertTable.regista(reg);
		return result;
	}
}
