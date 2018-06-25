package agenziaviaggi;

import java.util.Collection;

public class Pratica{
	
	private int id;
	private String descrizione;
	private Cliente cliente;
	
	
	public Pratica(int id, String descrizione, Cliente cliente) {
		this.id = id;
		this.descrizione = descrizione;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return descrizione + " - " + cliente;
	}

	public int getId() {
		return id;
	}


	public int getIdPratica(){
		return id;
	}
	
	public String getDescrizione(){
		return descrizione;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void aggiungiPrenotazione(Prenotazione prenotazione){
	}
	
	public double getImportoTotale(){
		return -1.0;
	}
	
	public Collection<Prenotazione> elencoPrenotazioniPerImporto()
	{
		return null;
	}

	public Collection<Prenotazione> elencoPrenotazioniPerData()
	{
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Pratica other = (Pratica) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
