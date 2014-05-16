package ba.unsa.etf.si.klase;

import java.util.Date;


public class SSuUpotrebi extends StalnaSredstva{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double trenutnaVrijednost;
	private double stopaAmortizacije;
	private Date datumStavljanjaUUpotrebu;
	private boolean godisnjaAmort;
	
	public SSuUpotrebi() {}

	private double getTrenutnaVrijednost() {
		return trenutnaVrijednost;
	}

	private void setTrenutnaVrijednost(double trenutnaVrijednost) {
		this.trenutnaVrijednost = trenutnaVrijednost;
	}

	private double getStopaAmortizacije() {
		return stopaAmortizacije;
	}

	private void setStopaAmortizacije(double stopaAmortizacije) {
		this.stopaAmortizacije = stopaAmortizacije;
	}

	private Date getDatumStavljanjaUUpotrebu() {
		return datumStavljanjaUUpotrebu;
	}

	private void setDatumStavljanjaUUpotrebu(Date datumStavljanjaUUpotrebu) {
		this.datumStavljanjaUUpotrebu = datumStavljanjaUUpotrebu;
	}

	private boolean isGodisnjaAmort() {
		return godisnjaAmort;
	}

	private void setGodisnjaAmort(boolean godisnjaAmort) {
		this.godisnjaAmort = godisnjaAmort;
	}
	
		
}

