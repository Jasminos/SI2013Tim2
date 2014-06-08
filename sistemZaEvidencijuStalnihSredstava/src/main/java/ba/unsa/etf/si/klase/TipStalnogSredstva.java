package ba.unsa.etf.si.klase;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TipStalnogSredstva implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String naziv;
	
	public  TipStalnogSredstva () {}
	public TipStalnogSredstva (String n)
	{
		naziv = n;		
	}
	
	long getId() {
		return id;
	}
	void setId(long id) {
		this.id = id;
	}
	private String getNaziv() {
		return naziv;
	}
	private void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	@Override public String toString(){
		return getNaziv();
	}
	public static List<TipStalnogSredstva> SviTipovi(Session session) throws Exception{
		List<TipStalnogSredstva> results;
		try
		{
			Query query = session.createQuery("from TipStalnogSredstva");
			results = (List<TipStalnogSredstva>) query.list();
		}
		catch(Throwable t)
		{
			throw new Exception("Problem sa povlacenjem Tipova stalnog sredstva");
		}
		if(results.isEmpty()) throw new Exception("Nema Tipova stalnog sredstva");
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
			throw new Exception("Spasavanje novog tipa nije uspjelo");
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
			throw new Exception("Brisanje novog tipa nije uspjelo");
		}
		return true;
	}
}
