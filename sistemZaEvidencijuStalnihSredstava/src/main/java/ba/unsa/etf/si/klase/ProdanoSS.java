package ba.unsa.etf.si.klase;

import java.util.Date;

public class ProdanoSS extends SSuUpotrebi{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date datumProdaje;
	private double prodajnaCijena;
	
	public ProdanoSS () {}

	private Date getDatumProdaje() {
		return datumProdaje;
	}

	private void setDatumProdaje(Date datumProdaje) {
		this.datumProdaje = datumProdaje;
	}

	private double getProdajnaCijena() {
		return prodajnaCijena;
	}

	private void setProdajnaCijena(double prodajnaCijena) {
		this.prodajnaCijena = prodajnaCijena;
	}
	
	
}
