package unisa.studenti.it.Entity;

public class Recitazione {
	public int idAttore;
	public int idFilm;
	
public Recitazione(int idAttore,int idFilm) {
		this.idAttore=idAttore;
		this.idFilm=idFilm;
	}
	
	public int getIdAttore() {
		return idAttore;
	}
	public void setIdAttore(int idAttore) {
		this.idAttore = idAttore;
	}
	public int getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}
	

}
