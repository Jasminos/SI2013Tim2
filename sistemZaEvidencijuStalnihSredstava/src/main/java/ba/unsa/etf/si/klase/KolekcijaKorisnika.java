package ba.unsa.etf.si.klase;

import java.util.ArrayList;
import java.util.List;



public class KolekcijaKorisnika implements java.io.Serializable {
	private long id;
	
	private List<Korisnik> korisnici;
	
	KolekcijaKorisnika()
	{
		korisnici= new ArrayList<Korisnik>();
	}
	public List<Korisnik> getKorisnici()
	{
		return korisnici;
	}
	public void setKorisnici(List<Korisnik> k)
	{
		korisnici=k;
	}
	private long getId()
	{
		return id;
	}
	private void setId(long id)
	{
		this.id=id;
	}
	public boolean kreirajKorisnika(Korisnik k)
	{
		if(k!=null)
		{
			korisnici.add(k);
			return true;
		}
		return false;
	}
	public boolean izbrisiKorisnika(Korisnik k)
	{
		if(k!=null)
		{
			return korisnici.remove(k);
		}
		return false;
	}
	public  boolean promjeniImeKorisnika(Korisnik k,String ime)
	{
		if(k!=null && ime != null)
		{
			int ind = korisnici.lastIndexOf(k);
			if(ind== -1) return false;
			korisnici.get(ind).setIme(ime);
			return true;
		}
		return false;
	}
	public  boolean promjeniJMBKorisnika(Korisnik k,String jmb)
	{
		if(k!=null && jmb != null)
		{
			int ind = korisnici.lastIndexOf(k);
			if(ind== -1) return false;
			korisnici.get(ind).setJmbg(jmb);
			return true;
		}
		return false;
	}
}
