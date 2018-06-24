package agenziaviaggi;

import java.util.*;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Agenzia {
	
	
	private List<Cliente> clienti;
	private int id;
	
	public Agenzia() {
		clienti = new ArrayList<Cliente>();
		id = 1000;
		
	}


	public Cliente aggiungiCliente(String cognome, String nome, String indirizzo) throws EccezioneClienteGiaEsistente {
		
//		Cliente cliente = new Cliente(id, cognome, nome, indirizzo);
		Cliente cliente = new Cliente(cognome, nome, indirizzo);

		if (clienti.contains(cliente)) {
			throw new EccezioneClienteGiaEsistente();
		}
		//ALTERNATIVA MENO SNELLA
//		for (Cliente c : clienti) {
//			if(c.equals(cliente)) {
//				throw new EccezioneClienteGiaEsistente();
//			}
//		}
		
		this.clienti.add(cliente);//si potrebbe usare un id per identificare
		
//		id++;
		
		return cliente;
	}
	
	public Collection<Cliente> elencoClienti(){
		Collections.sort(clienti);
		return clienti;
	}
	
	public Cliente cercaCliente(String cognome, String nome, String indirizzo){
		
		Cliente cliente = new Cliente(cognome, nome, indirizzo);
		
		for (Cliente c : this.clienti) {
			if(c.equals(cliente))
				return c;	
		}
		return null;
	}
	
	public Cliente cercaCliente(String ricerca){
		
		StringBuilder sb = new StringBuilder(ricerca);
		
		for (Cliente c : this.clienti) {
			if(c.getCognome().contains(sb) || c.getNome().contains(sb) || c.getIndirizzo().contains(sb)) {
				return c;	
			}
		}
		return null;
	}
	
	public int nuovaPratica(String descrizione, String cognome, String nome, String indirizzo){

		int tempId = id;
		
		
		Cliente cliente = new Cliente(cognome, nome, indirizzo);
		Collection<Pratica> praticheDiCliente = cliente.elencoPratiche();
		Pratica pratica = new Pratica(tempId, descrizione, cliente);
		
		
		if(!praticheDiCliente.contains(pratica)) {
			
			
			List<Pratica> p = (List<Pratica>) cliente.elencoPratiche();
			
			p.add(pratica);
			
			id++;
			
			return tempId;
		}else
			return pratica.getId();
	}
	
	public Pratica getPratica(int idPratica) throws EccezionePraticaInesistente{
		
		Pratica pratica = null; 
		
		for (Cliente c : clienti) {
			
			 pratica = c.controlloEsistenzaPratica(idPratica);
				
//				
//			
//			List<Pratica> praticheDiCliente = (List<Pratica>) c.elencoPratiche();
//			
//			for(Pratica p : praticheDiCliente) {
//				if(p.getId()==idPratica) 
//					return p;
//				throw new EccezionePraticaInesistente();
//			
//			}
		}
		
		if(pratica == null)
			throw new EccezionePraticaInesistente();
		
		return pratica;
	}
	
	public void eliminaPratica(int idPratica) throws EccezionePraticaInesistente{
		
		Pratica pratica = null;
		for (Cliente cliente : clienti) {
			pratica = cliente.controlloEsistenzaPratica(idPratica);
			 }
		
		if (pratica != null) {
			for (Cliente cliente : clienti)
				cliente.rimuoviPratica(idPratica);
		}else
			throw new EccezionePraticaInesistente();
		
	}
	
	public Collection<Pratica> elencoPratiche(){
		return null;
	}

	public double calcolaImportoPerPeriodo(String da, String a){
		return -1.0;
	}
	
	public Collection<Cliente> elencoClientiSelezionati(double importo){
		return null;
	}
	
	public String getCienti() {
		String result = "";
		for(Cliente c : this.clienti) {
			result += c.toString() + "\n";
		}
		return result;
	}
	
}
