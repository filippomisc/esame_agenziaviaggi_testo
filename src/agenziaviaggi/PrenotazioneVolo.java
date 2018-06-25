package agenziaviaggi;

public class PrenotazioneVolo extends Prenotazione{
	
	private String sigla;
	private String origine;
	private String destinazione;
	private String dataPartenza;
	private String dataArrivo;
	
public PrenotazioneVolo(String sigla, String origine, String destinazione, String dataPartenza,
			String dataArrivo, double importo) {
		super(importo);
		this.sigla = sigla;
		this.origine = origine;
		this.destinazione = destinazione;
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataArrivo;
	}

	
	
	@Override
	public double getImporto() {
		return super.getImporto();
	}

	public String getSigla(){
		return sigla;
	}
	
	public String getOrigine(){
		return origine;
	}
	
	public String getDestinazione(){
		return destinazione;
	}
	
	public String getDataPartenza(){
		return dataPartenza;
	}
	
	public String getDataArrivo(){
		return dataArrivo;
	}


	@Override
	public String toString() {
		return "PrenotazioneVolo [sigla=" + sigla + ", origine=" + origine + ", destinazione=" + destinazione
				+ ", dataPartenza=" + dataPartenza + ", dataArrivo=" + dataArrivo + ", importo=" + getImporto()
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataArrivo == null) ? 0 : dataArrivo.hashCode());
		result = prime * result + ((dataPartenza == null) ? 0 : dataPartenza.hashCode());
		result = prime * result + ((destinazione == null) ? 0 : destinazione.hashCode());
		result = prime * result + ((origine == null) ? 0 : origine.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrenotazioneVolo other = (PrenotazioneVolo) obj;
		if (dataArrivo == null) {
			if (other.dataArrivo != null)
				return false;
		} else if (!dataArrivo.equals(other.dataArrivo))
			return false;
		if (dataPartenza == null) {
			if (other.dataPartenza != null)
				return false;
		} else if (!dataPartenza.equals(other.dataPartenza))
			return false;
		if (destinazione == null) {
			if (other.destinazione != null)
				return false;
		} else if (!destinazione.equals(other.destinazione))
			return false;
		if (origine == null) {
			if (other.origine != null)
				return false;
		} else if (!origine.equals(other.origine))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}


	
	
}
