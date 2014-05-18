package ba.unsa.etf.si.klase;

import java.util.Date;

public class OtpisanoSS extends SSuUpotrebi {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date datumOtpisivanja;
	
	public OtpisanoSS () {}

	private Date getDatumOtpisivanja() {
		return datumOtpisivanja;
	}

	private void setDatumOtpisivanja(Date datumOtpisivanja) {
		this.datumOtpisivanja = datumOtpisivanja;
	}
	
	@Override
	public Double trenutnaVrijednost()
	{
		return 0.0;
	}
	
	@Override
	public void setGodisnjaAmort(boolean godisnjaAmort)
	{
		//ostaviti prazno!
	}

}
