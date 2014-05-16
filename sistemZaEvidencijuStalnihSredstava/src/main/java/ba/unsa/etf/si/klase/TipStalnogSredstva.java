package ba.unsa.etf.si.klase;

public class TipStalnogSredstva implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String naziv;
	
	public TipStalnogSredstva () {}
	
	long getId() {
		return id;
	}
	void setId(long id) {
		this.id = id;
	}
	private String getNaziv() {
		return naziv;
	}
	private void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
