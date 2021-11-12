package unisa.studenti.it.Entity;

public class Consultazione {
	public String usernameUtente;
	public int codiceProgrammazione;
	public Consultazione(String usernameUtente,int codiceProgrammazione) {
		this.usernameUtente=usernameUtente;
		this.codiceProgrammazione=codiceProgrammazione;
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

}
