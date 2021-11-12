package unisa.studenti.it.Entity;

public class Attore {
	public int idAttore;
	public String nome;
	public String cognome;
	
	public Attore(int idAttore,String cognome,String nome) {
		this.idAttore=idAttore;
		this.cognome=cognome;
		this.nome=nome;
	}
	public int getIdAttore() {
		return idAttore;
	}
	public void setIdAttore(int idAttore) {
		this.idAttore = idAttore;
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
