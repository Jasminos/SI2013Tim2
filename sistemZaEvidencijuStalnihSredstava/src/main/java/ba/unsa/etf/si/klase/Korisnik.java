package ba.unsa.etf.si.klase;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;



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
	public static List<Korisnik> SviKorisnici(Session session) throws Exception{
		List<Korisnik> results;
		try
		{
			Query query = session.createQuery("from Korisnik");
			results = (List<Korisnik>) query.list();
		}
		catch(Throwable t)
		{
			throw new Exception("Problem sa povlacenjem Korisnika");
		}
		if(results.isEmpty()) throw new Exception("Nema Korisnika");
		return results;
	}
	public boolean spasi(Session session) throws Exception
	{
		try{
			session.getTransaction().begin();
			session.save(this);
			session.getTransaction().commit();
		}
		catch(Throwable t)
		{
			session.getTransaction().rollback();
			throw new Exception("Spasavanje Korisnika nije uspjelo");
		}
		return true;
	}
	public boolean obrisi(Session session) throws Exception
	{
		try{
			session.getTransaction().begin();
			session.delete(this);
			session.getTransaction().commit();
		}
		catch(Throwable t)
		{
			session.getTransaction().rollback();
			throw new Exception("Brisanje korisnika nije uspjelo");
		}
		return true;
	}
	public boolean izmjeni(Session session) throws Exception
	{
		try{
			session.getTransaction().begin();
			session.update(this);
			session.getTransaction().commit();
		}
		catch(Throwable t)
		{
			session.getTransaction().rollback();
			throw new Exception("Spasavanje Korisnika nije uspjelo");
		}
		return true;
	}
}
