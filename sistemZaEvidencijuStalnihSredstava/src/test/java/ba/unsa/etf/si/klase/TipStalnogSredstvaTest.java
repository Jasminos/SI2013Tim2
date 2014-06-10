package ba.unsa.etf.si.klase;

import java.util.Date;

import org.hibernate.Session;

import ba.unsa.etf.si.util.HibernateUtil;
import junit.framework.TestCase;

public class TipStalnogSredstvaTest extends TestCase {
	private Session sesija = HibernateUtil.getSessionFactory().openSession();
	public void testDelete()
	{
		TipStalnogSredstva t = new TipStalnogSredstva("bla");
		
		
		try {
			t.spasi(sesija);
			assertTrue(t.obrisi(sesija));
		} catch (Exception e) {
			fail("Test pao na Brisanju");
		}
	}
	public void testSave()
	{
		TipStalnogSredstva t = new TipStalnogSredstva("bla");
		
		
		try {
			assertTrue(t.spasi(sesija));
		} catch (Exception e) {
			fail("Test pao na Spasavanju");
		}
	}

}
