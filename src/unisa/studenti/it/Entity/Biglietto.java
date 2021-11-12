package unisa.studenti.it.Entity;

import java.time.LocalDate;

public class Biglietto {
	public int idBiglietto;
	public String dataEmissione;
	public String usernameUtente;
	public int codiceProgrammazione;
	public int codicePosti;
	
	public Biglietto(String dataEmissione,
			String usernameUtente,int codiceProgrammazione, int codicePosti) {
		this.dataEmissione=dataEmissione;
		this.usernameUtente=usernameUtente;
		this.codicePosti=codicePosti;
		this.codiceProgrammazione=codiceProgrammazione;
		
	}
	
	public int getIdBiglietto() {
		return idBiglietto;
	}

	public void setIdBiglietto(int idBiglietto) {
		this.idBiglietto = idBiglietto;
	}

	public String getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(String dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public String getUsernameUtente() {
		return usernameUtente;
	}

	public void setUsernameUtente(String usernameUtente) {
		this.usernameUtente = usernameUtente;
	}

	public int getCodiceProgrammazione() {
		return codiceProgrammazione;
	}

	public void setCodiceProgrammazione(int codiceProgrammazione) {
		this.codiceProgrammazione = codiceProgrammazione;
	}

	public int getCodicePosti() {
		return codicePosti;
	}

	public void setCodicePosti(int codicePosti) {
		this.codicePosti = codicePosti;
	}
	
	
	

}
