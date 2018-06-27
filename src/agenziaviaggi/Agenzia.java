package agenziaviaggi;

import java.util.*;


public class Agenzia {
	
	
	private List<Cliente> clienti;
	
	private int id;
	Map<Integer, Pratica> pratiche;
	
	
	
	public Agenzia() {
		clienti = new ArrayList<Cliente>();
		pratiche = new TreeMap<Integer, Pratica>();
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
/*
		int tempId = id;
		
		Cliente cliente = cercaCliente(cognome, nome, indirizzo);
		
		praticheDiCliente = cliente.getPratiche();
		
		Pratica pratica = new Pratica(tempId, descrizione, cliente);
		
		
		if(praticheDiCliente.isEmpty() || !praticheDiCliente.containsValue(pratica)) {
			
			praticheDiCliente.put(tempId, pratica);
			
			id++;			
		}
			
		return pratica.getId();     */
		
		int tempId = id;
		Cliente cliente = cercaCliente(cognome, nome, indirizzo);
		Pratica pratica = new Pratica(tempId, descrizione, cliente);
		  
		  		
			
		if(pratiche.isEmpty() || !pratiche.containsValue(pratica)) {
			
			pratiche.put(tempId, pratica);
			
			cliente.getPratiche().put(tempId, pratica);
			
			id++;			
		}
			
			
		return tempId;
		 
		 
	}
	
	public Pratica getPratica(int idPratica) throws EccezionePraticaInesistente{
		
	Pratica pratica = this.pratiche.get(idPratica);
	
	
				
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
		
		
		if(pratiche.isEmpty() || pratica == null)
			throw new EccezionePraticaInesistente();
		
		return pratica;
	}
	
	public void eliminaPratica(int idPratica) throws EccezionePraticaInesistente{
		
		Pratica pratica = this.pratiche.get(idPratica);
		Cliente cliente = pratica.getCliente();
		
		if(pratiche.isEmpty() || pratica == null)
			throw new EccezionePraticaInesistente();
		else {
			pratiche.remove(pratica.getId());
			
			
			Map<Integer, Pratica> praticheDiCliente = cliente.getPratiche();
			
			praticheDiCliente.remove(pratica.getId());
			
		}
		
	}
	
	public Collection<Pratica> elencoPratiche(){
		//non posso ordinare una mappa secondo altri criteri....
		 
			//copio la collezione della Mappa di pratiche
		Collection<Pratica> collectionPratiche = pratiche.values();
		 
		
		//creo una lista e la popolo di valori della collezione
		ArrayList<Pratica> elencoP = new ArrayList<Pratica>();
		elencoP.addAll(collectionPratiche);
		
		//usare l'intefaccia COOMPARABLE per ordinare secondo il criterio migliore richiesto
		Collections.sort(elencoP);
		
		return elencoP;
	}

	public double calcolaImportoPerPeriodo(String da, String a){
		
		double result = 0.0;
		
		for (Pratica pratica : this.pratiche.values()) {
			double importo = pratica.calcolaImportoPerPeriodo(da, a);
			result += importo;
		}
		return result;
	}
	
	
	public Collection<Cliente> elencoClientiSelezionati(double importo){
		
		List<Cliente> resultList = new ArrayList<Cliente>();
		
		
		for(Pratica pratica : pratiche.values()) {
			if(pratica.getImportoTotale()>importo) {
				
				Cliente cliente = pratica.getCliente();
				
				if(!resultList.contains(cliente))
					resultList.add(cliente);
				
			}	
		}
		
		Collections.sort(resultList);
		
		return resultList;
	}
	
	public String getCienti() {
		String result = "";
		for(Cliente c : this.clienti) {
			result += c.toString() + "\n";
		}
		return result;
	}
	
}
