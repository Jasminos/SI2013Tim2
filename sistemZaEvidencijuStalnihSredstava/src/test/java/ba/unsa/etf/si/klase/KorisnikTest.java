package ba.unsa.etf.si.klase;

import java.util.Date;

import org.hibernate.Session;

import ba.unsa.etf.si.util.HibernateUtil;
import junit.framework.TestCase;

public class KorisnikTest extends TestCase {
	private Session sesija = HibernateUtil.getSessionFactory().openSession();
	public void testDelete()
	{
		Korisnik t = new Korisnik();
		t.setIme("Glavonja");
		t.setBrTel("225883");
		t.setDatumKreiranja(new Date());
		t.setJmbg("1801992170022");
		t.setPassword(HibernateUtil.md5("KitaOdOvce"));
		t.setPrezime("Glavica");
		t.setUsername("Glava");
		
		
		try {
			t.spasi(sesija);
			assertTrue(t.obrisi(sesija));
		} catch (Exception e) {
			fail("Test pao na Brisanju");
		}
	}
	public void testSave()
	{
		Korisnik t = new Korisnik();
		t.setIme("Glavonja");
		t.setBrTel("225883");
		t.setDatumKreiranja(new Date());
		t.setJmbg("1801992170022");
		t.setPassword(HibernateUtil.md5("KitaOdOvce"));
		t.setPrezime("Glavica");
		t.setUsername("Glava");
		
		
		try {
			assertTrue(t.spasi(sesija));
		} catch (Exception e) {
			fail("Test pao na Spasavanju");
		}
	}
	public void testUpdate()
	{
		Korisnik t = new Korisnik();
		t.setIme("Glavonja");
		t.setBrTel("225883");
		t.setDatumKreiranja(new Date());
		t.setJmbg("1801992170022");
		t.setPassword(HibernateUtil.md5("KitaOdOvce"));
		t.setPrezime("Glavica");
		t.setUsername("Glava");
		
		
		try {
			t.spasi(sesija);
			t.setBrTel("02580258");
			assertTrue(t.izmjeni(sesija));
		} catch (Exception e) {
			fail("Test pao na Spasavanju");
		}
	}

}
