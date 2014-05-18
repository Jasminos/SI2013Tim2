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
	
	
	public ProdanoSS(OtpisanoSS ss) {
		//public SSuUpotrebi(StalnaSredstva ss, Double stopa, boolean godisnja)
		super();
		
	}

	public Date getDatumProdaje() {
		return datumProdaje;
	}

	public void setDatumProdaje(Date datumProdaje) {
		this.datumProdaje = datumProdaje;
	}

	public double getProdajnaCijena() {
		return prodajnaCijena;
	}

	/*//atribut prodajna cijena je read only.
	public void setProdajnaCijena(double prodajnaCijena) {
		this.prodajnaCijena = prodajnaCijena;
	}
	*/
	
	@Override
	public void setGodisnjaAmort(boolean godisnjaAmort)
	{
		//ostaviti prazno!!
	}
	
	@Override
	public Double trenutnaVrijednost()
	{
		return 0.0;
	}
}
