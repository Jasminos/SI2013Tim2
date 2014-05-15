package ba.unsa.etf.si.klase;

import java.util.Date;



public class Korisnik implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1460549682791065209L;

	/**
	 * 
	 */

	private long id;
	private String ime;
	private String prezime;
	private String jmbg;
	private String brTel;
	private String username;
	private String password;
	private Date datumKreiranja;
	
	
	public Korisnik() {}
	
	public Korisnik(int id,String ime, String prezime, String jmbg, String brTel, String username, String password, Date datumKreiranja) {
		
		this.setId(id);
		this.ime=ime;
		this.prezime=prezime;
		this.jmbg=jmbg;
		this.brTel=brTel;
		this.username=username;
		this.password=password;
		this.datumKreiranja=datumKreiranja;
		
		
	}
	
	String getIme() {
		return ime;
	}
	void setIme(String ime) {
		this.ime = ime;
	}
	String getPrezime() {
		return prezime;
	}
	void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	String getJmbg() {
		return jmbg;
	}
	void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	String getBrTel() {
		return brTel;
	}
	void setBrTel(String brTel) {
		this.brTel = brTel;
	}
	String getUsername() {
		return username;
	}
	void setUsername(String username) {
		this.username = username;
	}
	String getPassword() {
		return password;
	}
	void setPassword(String password) {
		this.password = password;
	}
	Date getDatumKreiranja() {
		return datumKreiranja;
	}
	void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
		
	}

	private long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}


	
}
