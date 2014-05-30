package ba.unsa.etf.si.klase;

	import java.util.Date;

	public class StalnoSredstvo implements java.io.Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private long id;
		private String naziv;
		private String lokacija;
		private Double nabavnaVrijednost;
		private Date datumNabavke; 
		private TipStalnogSredstva tip;
						
		// u upotrebi
		private boolean uUpotrebi;
		private double trenutnaVrijednost;
		private double stopaAmortizacije;
		private Date datumStavljanjaUUpotrebu;
		private boolean godisnjaAmort;
		 		
		//otpisano
		private boolean otpisano;
		private Date datumOtpisivanja;

		//prodano
		private boolean prodano;
		private Date datumProdaje;
		private double prodajnaCijena;

		public StalnoSredstvo() {}
		
		public StalnoSredstvo(String naziv, String lok, Double vrijednost, Date datum, TipStalnogSredstva tip)
		{
			this.naziv = naziv;
			lokacija = lok;
			nabavnaVrijednost = vrijednost;
			datumNabavke = datum;
			this.tip = tip;
			uUpotrebi = false;
			trenutnaVrijednost = 0;
			stopaAmortizacije = 0;
			datumStavljanjaUUpotrebu = null;
			godisnjaAmort = false;
			otpisano = false;
			datumOtpisivanja = null;
			prodano = false;
			datumProdaje = null;
			prodajnaCijena = 0;
		}	
		
		public boolean staviUUpotrebu(double stopa, Date stavljanje, boolean amortizacija){
			trenutnaVrijednost = this.nabavnaVrijednost;
			stopaAmortizacije = stopa;
			datumStavljanjaUUpotrebu = stavljanje;
			godisnjaAmort = amortizacija;
			uUpotrebi = true;
			return true;
		}
		public boolean otpisi(Date datum){
			if(uUpotrebi){
				otpisano = true;
				uUpotrebi = false;
				datumOtpisivanja = datum;
				return true;
			}
			return false;			
		}
		public boolean prodaj(Date dateProdaje, double cijena){
			if(uUpotrebi){
				prodano = true;
				datumProdaje = dateProdaje;
				prodajnaCijena = cijena;
			}
			return true;
		}		
		public String getNaziv() {
			return naziv;
		}
		
		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}
		public TipStalnogSredstva getTip() {
			return tip;
		}

		public void setTip(TipStalnogSredstva tip) {
			this.tip = tip;
		}

		public String getLokacija() {
			return lokacija;
		}

		public void setLokacija(String lokacija) {
			this.lokacija = lokacija;
		}
		
		public Double getNabavnaVrijednost() {
			return nabavnaVrijednost;
		}

		void setNabavnaVrijednost(Double nabavnaVrijednost) {
			this.nabavnaVrijednost = nabavnaVrijednost;
		}

		public Date getDatumNabavke() {
			return datumNabavke;
		}

		public void setDatumNabavke(Date datumNabavke) {
			this.datumNabavke = datumNabavke;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
		public boolean isuUpotrebi() {
			return uUpotrebi;
		}

		public void setuUpotrebi(boolean uUpotrebi) {
			this.uUpotrebi = uUpotrebi;
		}

		public double getTrenutnaVrijednost() {
			if(uUpotrebi)return trenutnaVrijednost;
			return nabavnaVrijednost;	
		}

		public void setTrenutnaVrijednost(double trenutnaVrijednost) {
			this.trenutnaVrijednost = trenutnaVrijednost;
		}

		public double getStopaAmortizacije() {
			return stopaAmortizacije;
		}

		public void setStopaAmortizacije(double stopaAmortizacije) {
			this.stopaAmortizacije = stopaAmortizacije;
		}

		public Date getDatumStavljanjaUUpotrebu() {
			return datumStavljanjaUUpotrebu;
		}

		public void setDatumStavljanjaUUpotrebu(Date datumStavljanjaUUpotrebu) {
			this.datumStavljanjaUUpotrebu = datumStavljanjaUUpotrebu;
		}

		public boolean isGodisnjaAmort() {
			return godisnjaAmort;
		}

		public void setGodisnjaAmort(boolean godisnjaAmort) {
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
		public boolean isOtpisano() {
			return otpisano;
		}

		public void setOtpisano(boolean otpisano) {
			this.otpisano = otpisano;
		}

		public Date getDatumOtpisivanja() {
			return datumOtpisivanja;
		}

		public void setDatumOtpisivanja(Date datumOtpisivanja) {
			this.datumOtpisivanja = datumOtpisivanja;
		}
		public boolean isProdano() {
			return prodano;
		}

		public void setProdano(boolean prodano) {
			this.prodano = prodano;
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

		public void setProdajnaCijena(double prodajnaCijena) {
			this.prodajnaCijena = prodajnaCijena;
		}
		@Override public String toString(){
			return getNaziv();
		}
	}
