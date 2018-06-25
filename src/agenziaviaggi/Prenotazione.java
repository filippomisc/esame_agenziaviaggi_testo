package agenziaviaggi;

public class Prenotazione {
	
	private double importo;

	public Prenotazione(double importo) {
		this.importo = importo;
	}

	public double getImporto(){
		return importo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(importo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Prenotazione other = (Prenotazione) obj;
		if (Double.doubleToLongBits(importo) != Double.doubleToLongBits(other.importo))
			return false;
		return true;
	}
}
