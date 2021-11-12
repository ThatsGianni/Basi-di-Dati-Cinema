package unisa.studenti.it.Entity;

public class Utente {
	public String username;
	public String nome;
	public String cognome;
	public String email;
	public String password;
	public Utente(String username,String nome,String cognome,String email,String password) {
		this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.username=username;
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
