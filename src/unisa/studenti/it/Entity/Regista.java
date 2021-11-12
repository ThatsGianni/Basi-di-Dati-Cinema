package unisa.studenti.it.Entity;

public class Regista {
	public int idRegista;
	public String nome;
	public String cognome;
	public int getIdRegista() {
		return idRegista;
	}
	public Regista(String nome,String cognome,int idRegista) {
	 this.idRegista=idRegista;	
	 this.nome=nome;
	 this.cognome=cognome;
	}

	public void setIdRegista(int idRegista) {
		this.idRegista = idRegista;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
}
