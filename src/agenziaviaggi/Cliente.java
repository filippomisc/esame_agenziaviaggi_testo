package agenziaviaggi;

import java.util.*;

public class Cliente implements Comparable{
	
	private int codice;
	private String cognome;
	private String nome;
	private String indirizzo;
	
	private List<String> contatti;
	private Map<Integer, Pratica> pratiche;
	
	
	
//	public Cliente(int codice, String cognome, String nome, String indirizzo) {
//		this.cognome = cognome;
//		this.nome = nome;
//		this.indirizzo = indirizzo;
//	}

	public Cliente(String cognome, String nome, String indirizzo) {
	this.cognome = cognome;
	this.nome = nome;
	this.indirizzo = indirizzo;
	this.contatti = new ArrayList<String>();
	this.pratiche = new TreeMap<Integer, Pratica>();
	
}	
	
	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return cognome + " - " + nome + " - " + indirizzo;
	}

	public String getCognome(){
		return cognome;
	}
	


	public String getNome(){
		return nome;
	}
	
	public String getIndirizzo(){
		return indirizzo;
	}

	public void aggiungiContatto(String contatto){
		
		if (!contatti.contains(contatto)) 
			contatti.add(contatto);
		
	}

	public Collection<String> elencoContatti(){
		return contatti;
	}

	public Collection<Pratica> elencoPratiche(){
		return pratiche.values();
	}

	public int compareTo(Object obj) {
		
		Cliente altro = (Cliente) obj;
		
		//ordino per cognome
		int result = this.cognome.compareTo(altro.cognome);
		
		if(result == 0)//se i cognomi sono uguali ordino per nome 
			result = this.nome.compareTo(altro.nome);
		
		if(result == 0)//se i nomi sono uguali ordino per indirizzo 
			result = this.indirizzo.compareTo(altro.indirizzo);
		
		return result;
	}

	public Pratica controlloEsistenzaPratica(int idPratica) {
		
		Pratica pratica = null;
		
		if(pratiche.containsKey(idPratica)){
			pratica = pratiche.get(idPratica);
		}
		
		return pratica;
	}

	public void rimuoviPratica(int idPratica) {

		if(pratiche.containsKey(idPratica))
			pratiche.remove(idPratica);
	}
	
}
