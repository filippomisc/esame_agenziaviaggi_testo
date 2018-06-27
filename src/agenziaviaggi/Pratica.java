package agenziaviaggi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Pratica implements Comparable{
	
	private int id;
	private String descrizione;
	private Cliente cliente;
	private List<Prenotazione> prenotazioni;
	
	
	public Pratica(int id, String descrizione, Cliente cliente) {
		this.id = id;
		this.descrizione = descrizione;
		this.cliente = cliente;
		prenotazioni = new ArrayList<Prenotazione>();
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
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
		if(prenotazioni.isEmpty() || !prenotazioni.contains(prenotazione))
			prenotazioni.add(prenotazione);
			
	}
	
	public double getImportoTotale(){
		double result = 0.0;
		for (Prenotazione prenotazione : prenotazioni) {
			double importoIesimo = prenotazione.getImporto();
			result += importoIesimo;
			
		}
		return result;
	}
	
	
	public double calcolaImportoPerPeriodo(String da, String a) {
		
		double result = 0.0;
		
//		String dataI = "";
//		String dataF = "";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		for(Prenotazione prenotazione : this.prenotazioni) {
			
			if(prenotazione instanceof PrenotazioneAlbergo) {
				
				if(((PrenotazioneAlbergo) prenotazione).getDataCheckIn().compareTo(da)>=0 && ((PrenotazioneAlbergo) prenotazione).getDataCheckIn().compareTo(a)<=0) {
					
					double importoIesimo = prenotazione.getImporto();
					result += importoIesimo;
				}
					
			}else if(prenotazione instanceof PrenotazioneVolo) {
				

				if(((PrenotazioneVolo) prenotazione).getDataArrivo().compareTo(da)>=0 && ((PrenotazioneVolo) prenotazione).getDataArrivo().compareTo(a)<=0) {
					
					double importoIesimo = prenotazione.getImporto();
					result += importoIesimo;
				}
			
//			double importoIesimo = prenotazione.getImporto();
//			result += importoIesimo;
			
			}
			
//		return result;
		}
		return result;
	}
	
	public Collection<Prenotazione> elencoPrenotazioniPerImporto(){

		List<Prenotazione> temp = this.prenotazioni;
		Collections.sort(temp, new ComparatoreDiPrenotazioniPerImporto());
		
		return temp;
	}

	public Collection<Prenotazione> elencoPrenotazioniPerData() {
		
		List<Prenotazione> temp = this.prenotazioni;
		Collections.sort(temp, new ComparatoreDiPrenotazioniPerData());
		
		return temp;
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


	public int compareTo(Object o) {
		Pratica altra = (Pratica) o;
		return (int) -(this.getImportoTotale()-altra.getImportoTotale());

	}


}
