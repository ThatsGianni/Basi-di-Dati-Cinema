package unisa.studenti.it.Operazioni;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.GregorianCalendar;

import unisa.studenti.it.Entity.Attore;
import unisa.studenti.it.Entity.Biglietto;
import unisa.studenti.it.Entity.Biglietto_Storico;
import unisa.studenti.it.Entity.Cinema;
import unisa.studenti.it.Entity.Consultazione;
import unisa.studenti.it.Entity.Film;
import unisa.studenti.it.Entity.Posto;
import unisa.studenti.it.Entity.Programmazione;
import unisa.studenti.it.Entity.Recitazione;
import unisa.studenti.it.Entity.Regista;
import unisa.studenti.it.Entity.Sale;
import unisa.studenti.it.Entity.Telefono;
import unisa.studenti.it.Entity.Utente;
import unisa.studenti.it.Entity.DBMCinema;

public class InsertTable {
	public static String insertBiglietti = "INSERT INTO `biglietti` (`idb`,`dataemiss`, `username`, `codprog`, `codpos`) VALUES (? ,?, ?, ?, ?);" ;
	public static String insertFilm = "INSERT INTO `film` (`idf`, `nome`, `anno`, `durata`, `recensione`, `distributore`, `genere`, `paese`, `idreg`) VALUES (?,?,?,?,?,?,?,?,?);";
	public static String insertTel = "INSERT INTO `telefoni` (`numero`, `idcin`) VALUES (? ,?);";
	public static String insertSale = "INSERT INTO `sale` (`codsale`, `nums`, `superficie`, `capienza`, `idcin`) VALUES (?, ?, ?, ?, ?);";
	public static String insertReg = "INSERT INTO `registi`(`idreg`, `nome`, `cognome`) VALUES (?,?,?);";
	public static String insertRecit = "INSERT INTO `recitazioni` (`idatt`, `idf`) VALUES (?, ?);";
	public static String insertProg = "INSERT INTO `programmazioni` VALUES (?,?, ?, ?, ?, ?, ?);";
	public static String insertPosto = "INSERT INTO `posti` (`codpos`, `numfila`, `numcol`, `codsale`) VALUES (?, ?, ?, ?);";
	public static String insertUtente = "INSERT INTO `utenti` (`username`, `cognome`, `nome`, `email`,`password` ) VALUES (?, ?, ?, ?,?);";
	public static String insertBigliettoStorico = "INSERT INTO `biglietti_storico` (`codst`, `username`, `film`, `giorno`, `cinema`, `numsala`, `numfila`, `numcol`, `dataemiss`) VALUES (?, ?, ?, ?, ?,?,?,?,?);";
	public static String insertAttore = "INSERT INTO `attori` (`idatt`, `nome`, `cognome`) VALUES (?,?,?);";
	public static String insertConsultazione = "INSERT INTO `consultazioni` (`username`, `codprog`) VALUES (?,?);";
	public static String insertCinema = "INSERT INTO `cinema` (`idcin`, `nome`, `indirizzo`, `città`, `nazione`, `numsale`) VALUES (?, ?, ?,?,?,?);";
	public static boolean attore(Attore attore) throws IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertAttore)) {
			query.setLong(1,attore.getIdAttore());
			query.setString(2,attore.getNome());
			query.setString(3,attore.getCognome());
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
	}
	
	public static boolean consultazione(Consultazione consultazione) throws IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertConsultazione)) {
			query.setString(1,consultazione.getUsernameUtente());
			query.setLong(2,consultazione.getCodiceProgrammazione());
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
	}
	
	public static boolean cinema(Cinema cinema) throws IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertCinema)) {
			query.setLong(1,cinema.getIdCinema());
			query.setString(2,cinema.getNome());
			query.setString(3,cinema.getIndirizzo());
			query.setString(4,cinema.getCittà());
			query.setString(5,cinema.getNazione());
			query.setLong(6,cinema.getNumeroSale());
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
			
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
	}
		
	public static boolean biglietti(Biglietto biglietto) throws IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertBiglietti)) {
			query.setLong(1,0);
			query.setString(2,biglietto.getDataEmissione());
			query.setString(3,biglietto.getUsernameUtente());
			query.setLong(4,biglietto.getCodiceProgrammazione());
			query.setLong(5,biglietto.getCodicePosti());
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
	}
	
	public static boolean film(Film film) throws SQLException, IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertFilm)) {
			query.setLong(1,0);
			query.setString(2,film.getNome());
			query.setLong(3,film.getAnno());
			query.setString(4,film.getDurata());
			query.setString(5,film.getRecensione());
			query.setString(6,film.getDistributore());
			query.setString(7,film.getGenere());
			query.setString(8,film.getPaese());
			query.setLong(9,film.getIdRegista());
			
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
	}

	public static boolean telefono(Telefono tel) throws IOException {

		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertTel)) {
			query.setString(1,tel.getNumero());
			query.setLong(2,tel.getIdCinema());
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
		
	}
	
	public static boolean sale(Sale sale) throws IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertSale)) {
			query.setLong(1,sale.getCodiceSala());
			query.setLong(2,sale.getNumeroSala());
			query.setString(3,""+sale.superficie+"cm2");
			query.setLong(4,sale.getCapienza());
			query.setLong(5,sale.getIdCinema());
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
		
	}
	
	public static boolean regista(Regista reg) throws IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertReg)) {
			query.setLong(1,reg.getIdRegista());
			query.setString(2,reg.getNome());
			query.setString(3,reg.getCognome());
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
		
	}
	
	public static boolean recitazione(Recitazione recit) throws IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertRecit)) {
			query.setLong(1,recit.getIdAttore());
			query.setLong(2,recit.getIdFilm());
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
		
	}
	
	public static boolean programmazione(Programmazione prog) throws IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertProg)) {
			query.setLong(1,0);
			query.setString(2,prog.getGiorno());
			query.setString(3,""+prog.getPrezzo());
			query.setLong(4,prog.getIdFilm());
			query.setLong(5,prog.getCodiceSale());
			query.setString(6,prog.getDataInizio());
			query.setString(7,prog.getDataFine());
			
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
		}
	
	public static boolean posto(Posto posto) throws IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertPosto)) {
			query.setLong(1,posto.getCodicePosto());
			query.setLong(2,posto.getNumeroFila());
			query.setLong(3,posto.getNumeroColonna());
			query.setLong(4,posto.getCodiceSala());
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
		
	}
	public static boolean utente(Utente user) throws IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertUtente)) {
			query.setString(1,user.getUsername());
			query.setString(2,user.getCognome());
			query.setString(3,user.getNome());
			query.setString(4,user.getEmail());
			query.setString(5,user.getPassword());
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
		
	}
	
	public static boolean bigliettoStorico(Biglietto_Storico biglietto) throws IOException {
		boolean result = false;
		try(PreparedStatement query = DBMCinema.getConn().prepareStatement(insertBigliettoStorico)) {
			query.setLong(1,biglietto.getIdBiglietto());
			query.setString(2,biglietto.getUsernameUtente());
			query.setString(3,biglietto.getFilm());
			query.setString(4,biglietto.getGiorno());
			query.setString(5, biglietto.getCinema());
			query.setLong(6,biglietto.getNumsala());
			query.setLong(7,biglietto.getNumfila());
			query.setLong(8,biglietto.getNumcolonna());
			query.setString(9,biglietto.getDataEmissione());
			result = query.executeUpdate() == 1;
			if(result) {
				System.out.println("Inserito");
			}
		} catch (Exception e) {
			if(!result)
				throw new IOException("Errore nell'inserimento");
			}
		return result;
		
	}
	
	}
	
	

	


