package unisa.studenti.it.Entity;

public class Biglietto_Storico {
	public int idBiglietto;
	public String dataEmissione;
	public String usernameUtente;
	public String giorno;
	public String cinema;
	public int numsala;
	public int numfila;
	public int numcolonna;
	public String Film;
	
	public Biglietto_Storico(int idBiglietto,
			String usernameUtente,String Film,String giorno, String cinema,int numsala, 
			int numfila, int numcolonna,String dataEmissione) {
		this.idBiglietto=idBiglietto;
		this.dataEmissione=dataEmissione;
		this.usernameUtente=usernameUtente;
		this.numsala=numsala;
		this.numfila=numfila;
		this.numcolonna=numcolonna;
		this.Film=Film;
		this.cinema=cinema;
		this.giorno=giorno;
	}
	
	public String getGiorno() {
		return giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}

	public String getCinema() {
		return cinema;
	}

	public void setCinema(String cinema) {
		this.cinema = cinema;
	}

	public int getNumsala() {
		return numsala;
	}

	public void setNumsala(int numsala) {
		this.numsala = numsala;
	}

	public int getNumfila() {
		return numfila;
	}

	public void setNumfila(int numfila) {
		this.numfila = numfila;
	}

	public int getNumcolonna() {
		return numcolonna;
	}

	public void setNumcolonna(int numcolonna) {
		this.numcolonna = numcolonna;
	}

	public String getFilm() {
		return Film;
	}

	public void setFilm(String film) {
		Film = film;
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



}
