package unisa.studenti.it.Entity;

public class Cinema {
	public int idCinema;
	public String nome;
	public String indirizzo;
	public String citt�;
	public String nazione;
	public int numeroSale;
	
	public Cinema( int idCinema,String nome,String indirizzo,String citt�,String nazione,int numeroSale) {
		this.idCinema=idCinema;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.nazione = nazione;
		this.numeroSale = numeroSale;
		this.citt� = citt�;
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
	public String getCitt�() {
		return citt�;
	}
	public void setCitt�(String citt�) {
		this.citt� = citt�;
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
