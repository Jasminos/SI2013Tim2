package ba.unsa.etf.si.klase;

import java.util.Date;


public class SSuUpotrebi extends StalnoSredstvo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double trenutnaVrijednost;
	private double stopaAmortizacije;
	private Date datumStavljanjaUUpotrebu;
	private boolean godisnjaAmort;
	
	public SSuUpotrebi() {}
	
	public SSuUpotrebi(StalnoSredstvo ss, Double stopa, boolean godisnja)
	{
		//public StalnaSredstva(String naziv, String lok, Double vrijednost, Date datum, TipStalnogSredstva tip)
		super(ss.getNaziv(), ss.getLokacija(), ss.trenutnaVrijednost(), ss.getDatumNabavke(), ss.getTip());
		
		trenutnaVrijednost = ss.trenutnaVrijednost();
		stopaAmortizacije = stopa;
		godisnjaAmort = godisnja;
	}

	public double getTrenutnaVrijednost() {
		return trenutnaVrijednost;
	}

	public void setTrenutnaVrijednost(double trenutnaVrijednost) {
		this.trenutnaVrijednost = trenutnaVrijednost;
	}

	public double getStopaAmortizacije() {
		return stopaAmortizacije;
	}
/*
	private void setStopaAmortizacije(double stopaAmortizacije) {
		this.stopaAmortizacije = stopaAmortizacije;
	}
*/
	public Date getDatumStavljanjaUUpotrebu() {
		return datumStavljanjaUUpotrebu;
	}

	public void setDatumStavljanjaUUpotrebu(Date datumStavljanjaUUpotrebu) {
		this.datumStavljanjaUUpotrebu = datumStavljanjaUUpotrebu;
	}

	public boolean isGodisnjaAmort() {
		return godisnjaAmort;
	}

	//"throws Exception" dodano radi klasa koje je nasljedjuju.
	public void setGodisnjaAmort(boolean godisnjaAmort) throws Exception {
		if(this.godisnjaAmort == godisnjaAmort)
			return;
		if(this.godisnjaAmort == true)
		{
			this.godisnjaAmort = false;
			stopaAmortizacije /= 12;
		}
		else
		{
			this.godisnjaAmort = true;
			stopaAmortizacije *= 12;
		}
		
	}
	
		
}

