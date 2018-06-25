package agenziaviaggi;

public class PrenotazioneAlbergo extends Prenotazione{
	
	private String hotel;
	private String dataCheckIn;
	private int numNotti;


	public PrenotazioneAlbergo(String hotel, String dataCheckIn, int numNotti, double importo) {
		super(importo);
		this.hotel = hotel;
		this.dataCheckIn = dataCheckIn;
		this.numNotti = numNotti;
	}

	public String getHotel(){
		return hotel;
	}
	
	public String getDataCheckIn(){
		return dataCheckIn;
	}
	
	public int getNumNotti(){
		return numNotti;
	}

	@Override
	public double getImporto() {
		return super.getImporto();
	}

	@Override
	public String toString() {
		return "PrenotazioneAlbergo [hotel=" + hotel + ", dataCheckIn=" + dataCheckIn + ", numNotti=" + numNotti
				+ ", importo()=" + getImporto() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataCheckIn == null) ? 0 : dataCheckIn.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + numNotti;
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
		PrenotazioneAlbergo other = (PrenotazioneAlbergo) obj;
		if (dataCheckIn == null) {
			if (other.dataCheckIn != null)
				return false;
		} else if (!dataCheckIn.equals(other.dataCheckIn))
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (numNotti != other.numNotti)
			return false;
		return true;
	}
	
	
}
