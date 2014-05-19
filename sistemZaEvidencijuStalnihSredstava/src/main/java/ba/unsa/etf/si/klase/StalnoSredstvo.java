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

		
		public StalnoSredstvo() {}
		
		public StalnoSredstvo(String naziv, String lok, Double vrijednost, Date datum, TipStalnogSredstva tip)
		{
			this.naziv = naziv;
			lokacija = lok;
			nabavnaVrijednost = vrijednost;
			datumNabavke = datum;
			this.tip = tip;
		}		
		
		public String getNaziv() {
			return naziv;
		}

		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}

		public String getLokacija() {
			return lokacija;
		}

		public void setLokacija(String lokacija) {
			this.lokacija = lokacija;
		}

		//metodu moraju implementovati klase koje nasljedjuju ( za svaku razlicito ! )
		public Double trenutnaVrijednost()
		{
			return nabavnaVrijednost;			
		}
		
		/*Double getNabavnaVrijednost() {
			return nabavnaVrijednost;
		}

		void setNabavnaVrijednost(Double nabavnaVrijednost) {
			this.nabavnaVrijednost = nabavnaVrijednost;
		}*/

		public Date getDatumNabavke() {
			return datumNabavke;
		}

		public void setDatumNabavke(Date datumNabavke) {
			this.datumNabavke = datumNabavke;
		}
		
		public TipStalnogSredstva getTip()
		{
			return tip;
		}
		

		private long getId() {
			return id;
		}

		private void setId(long id) {
			this.id = id;
		}

		






	

	}
