package unisa.studenti.it.Entity;

public class Film {
	public int idFilm;
	public String nome;
	public String distributore;
	public String genere;
	public String paese;
	public String recensione;
	public String durata;
	public int idRegista;
	public int anno;
	public Film(String nome,String distributore,String genere, 
			String paese, String recensione, String durata, int idRegista,int idFilm,int anno) {
		this.nome=nome;
		this.anno=anno;
		this.distributore=distributore;
		this.paese=paese;
		this.recensione=recensione;
		this.durata=durata;
		this.genere=genere;
		this.idRegista=idRegista;
		this.idFilm=idFilm;
		}
	
	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nome=" + nome + ", distributore=" + distributore + ", genere=" + genere
				+ ", paese=" + paese + ", recensione=" + recensione + ", durata=" + durata + ", idRegista=" + idRegista
				+ ", anno=" + anno + "]";
	}

	public int getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDistributore() {
		return distributore;
	}
	public void setDistributore(String distributore) {
		this.distributore = distributore;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getPaese() {
		return paese;
	}
	public void setPaese(String paese) {
		this.paese = paese;
	}
	public String getRecensione() {
		return recensione;
	}
	public void setRecensione(String recensione) {
		this.recensione = recensione;
	}
	public String getDurata() {
		return durata;
	}
	public void setDurata(String durata) {
		this.durata = durata;
	}
	public int getIdRegista() {
		return idRegista;
	}
	public void setIdRegista(int idRegista) {
		this.idRegista = idRegista;
	}

}
