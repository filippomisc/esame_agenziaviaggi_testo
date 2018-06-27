package agenziaviaggi;

import java.util.Comparator;


public class ComparatoreDiPrenotazioniPerImporto implements Comparator{

	public int compare(Object arg0, Object arg1) {

		Prenotazione p1 = (Prenotazione) arg0;
		Prenotazione p2 = (Prenotazione) arg1;
		
		int result = (int) (p1.getImporto()-p2.getImporto());
		return result;
	}

}
