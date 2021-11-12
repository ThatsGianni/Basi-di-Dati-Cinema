package unisa.studenti.it.Entity;

public class Programmazione {
	public String giorno;
	public String dataInizio;
	public String dataFine;
	public int codiceSale;
	public int idFilm;
	public double prezzo;

	public Programmazione(String giorno,double prezzo,
			String dataInizio,String dataFine, int codiceSale,int idFilm) {
		
		this.giorno=giorno;
		this.codiceSale=codiceSale;
		this.idFilm=idFilm;
		this.dataInizio=dataInizio;
		this.dataFine=dataFine;
		this.prezzo=prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getGiorno() {
		return giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public int getCodiceSale() {
		return codiceSale;
	}

	public void setCodiceSale(int codiceSale) {
		this.codiceSale = codiceSale;
	}

	public int getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	public double getPrezzo() {
		return prezzo;
	}

}
