package unisa.studenti.it.Entity;

public class Sale {
	public int codiceSala;
	public int numeroSala;
	public double superficie;
	public int capienza;
	public int idCinema;
	
	public Sale(int codiceSala,int numeroSala, double superficie,int capienza,int idCinema) {
		this.codiceSala=codiceSala;
		this.numeroSala=numeroSala;
		this.superficie=superficie;
		this.capienza=capienza;
		this.idCinema=idCinema;
	}
	
	public int getCodiceSala() {
		return codiceSala;
	}
	public void setCodiceSala(int codiceSala) {
		this.codiceSala = codiceSala;
	}
	public int getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public int getCapienza() {
		return capienza;
	}
	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	public int getIdCinema() {
		return idCinema;
	}
	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}
	

}
