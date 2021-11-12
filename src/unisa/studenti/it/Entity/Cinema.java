package unisa.studenti.it.Entity;

public class Cinema {
	public int idCinema;
	public String nome;
	public String indirizzo;
	public String città;
	public String nazione;
	public int numeroSale;
	
	public Cinema( int idCinema,String nome,String indirizzo,String città,String nazione,int numeroSale) {
		this.idCinema=idCinema;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.nazione = nazione;
		this.numeroSale = numeroSale;
		this.città = città;
	}
	
	public int getIdCinema() {
		return idCinema;
	}
	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCittà() {
		return città;
	}
	public void setCittà(String città) {
		this.città = città;
	}
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	public int getNumeroSale() {
		return numeroSale;
	}
	public void setNumeroSale(int numeroSale) {
		this.numeroSale = numeroSale;
	}
	

}
