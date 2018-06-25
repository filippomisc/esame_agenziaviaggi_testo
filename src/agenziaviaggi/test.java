package agenziaviaggi;

public class test {

	public static void main(String[] args) {

		Agenzia agenzia = new Agenzia();
		
		try {
			agenzia.aggiungiCliente("Miscioscia", "Filippo", "Via Valeggio 7");
			agenzia.aggiungiCliente("Natoli", "Chiara", "Via Vicenza 27");
			agenzia.aggiungiCliente("Miscioscia", "Giuseppe", "Via Bachelet 25");
			agenzia.aggiungiCliente("Miscioscia", "Filippo", "Via De Santis 13");

			

//			agenzia.aggiungiCliente("Miscioscia", "Filippo", "Via Valeggio 7");

		} catch (EccezioneClienteGiaEsistente e) {
			System.err.println("cliente gia presente");
			e.printStackTrace();
		}
		

//		System.out.println(agenzia.getCienti());
		System.out.println(agenzia.elencoClienti().toString());
		
		Cliente c = agenzia.cercaCliente("Miscioscia", "Giuseppe", "Via Bachelet 25");
		System.out.println("Cliente trovato: " + c.toString());
		
		
		agenzia.nuovaPratica("viaggio MIAMI", "Miscioscia", "Giuseppe", "Via Bachelet 25");
		agenzia.nuovaPratica("viaggio NY", "Miscioscia", "Giuseppe", "Via Bachelet 25");
		
				try {
			agenzia.eliminaPratica(1000);
			
		} catch (EccezionePraticaInesistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println(c.getPratiche().toString());
		


	}

}
