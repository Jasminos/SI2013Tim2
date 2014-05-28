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
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getBrTel() {
		return brTel;
	}
	public void setBrTel(String brTel) {
		this.brTel = brTel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
		
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}
	@Override public String toString(){
		return getUsername();
	}
	
}
