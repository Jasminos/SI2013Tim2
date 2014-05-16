package ba.unsa.etf.si.klase;

	import java.util.Date;

	public class StalnaSredstva implements java.io.Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private long id;
		private String naziv;
		private String lokacija;
		private Double nabavnaVrijednost;
		private Date datumNabavke; 
		

		
		
		public StalnaSredstva() {}







		String getNaziv() {
			return naziv;
		}







		void setNaziv(String naziv) {
			this.naziv = naziv;
		}







		String getLokacija() {
			return lokacija;
		}







		void setLokacija(String lokacija) {
			this.lokacija = lokacija;
		}







		Double getNabavnaVrijednost() {
			return nabavnaVrijednost;
		}







		void setNabavnaVrijednost(Double nabavnaVrijednost) {
			this.nabavnaVrijednost = nabavnaVrijednost;
		}







		Date getDatumNabavke() {
			return datumNabavke;
		}







		void setDatumNabavke(Date datumNabavke) {
			this.datumNabavke = datumNabavke;
		}







		private long getId() {
			return id;
		}







		private void setId(long id) {
			this.id = id;
		}







	

	}
