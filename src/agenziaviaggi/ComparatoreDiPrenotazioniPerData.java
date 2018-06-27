package agenziaviaggi;

import java.util.Comparator;


public class ComparatoreDiPrenotazioniPerData implements Comparator{

	public int compare(Object o1, Object o2) {

		Prenotazione p1 = (Prenotazione) o1;
		Prenotazione p2 = (Prenotazione) o2;
		
		String data1 = "";
		String data2 = "";
		
		if (p1 instanceof PrenotazioneAlbergo)
			data1 =((PrenotazioneAlbergo) p1).getDataCheckIn();
		else if(p1 instanceof PrenotazioneVolo)
			data1 = ((PrenotazioneVolo) p1).getDataPartenza();
		
		if (p2 instanceof PrenotazioneAlbergo) {
			data2 =((PrenotazioneAlbergo) p2).getDataCheckIn();
		} else if (p1 instanceof PrenotazioneVolo){
			data2 = ((PrenotazioneVolo) p2).getDataPartenza();
			}
		return data1.compareTo(data2);
	}

}
