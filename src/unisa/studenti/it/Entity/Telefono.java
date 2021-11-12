package unisa.studenti.it.Entity;

public class Telefono {
	public String numero;
	public int idCinema;
	public Telefono(String numero,int idCinema) {
		this.idCinema=idCinema;
		this.numero=numero;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getIdCinema() {
		return idCinema;
	}
	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}

}
