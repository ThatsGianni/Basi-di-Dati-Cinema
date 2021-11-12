package unisa.studenti.it.Entity;

public class Posto {
	@Override
	public String toString() {
		return "Posto [codicePosto=" + codicePosto + ", numeroFila=" + numeroFila + ", numeroColonna=" + numeroColonna
				+ ", codiceSala=" + codiceSala + "]";
	}

	public int codicePosto;
	public int numeroFila;
	public int numeroColonna;
	public int codiceSala;
	
	public Posto(int codicePosto,int numeroFila,int numeroColonna,int codiceSala) {
		this.codicePosto=codicePosto;
		this.codiceSala=codiceSala;
		this.numeroColonna=numeroColonna;
		this.numeroFila=numeroFila;
		
	}

	public int getCodicePosto() {
		return codicePosto;
	}

	public void setCodicePosto(int codicePosto) {
		this.codicePosto = codicePosto;
	}

	public int getNumeroFila() {
		return numeroFila;
	}

	public void setNumeroFila(int numeroFila) {
		this.numeroFila = numeroFila;
	}

	public int getNumeroColonna() {
		return numeroColonna;
	}

	public void setNumeroColonna(int numeroColonna) {
		this.numeroColonna = numeroColonna;
	}

	public int getCodiceSala() {
		return codiceSala;
	}

	public void setCodiceSala(int codiceSala) {
		this.codiceSala = codiceSala;
	}

}
