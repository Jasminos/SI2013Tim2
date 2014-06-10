package ba.unsa.etf.si.klase;

import java.util.Date;

import org.hibernate.Session;

import ba.unsa.etf.si.util.HibernateUtil;
import junit.framework.TestCase;

public class StalnoSredstvoTest extends TestCase {
	
	
	private Session sesija = HibernateUtil.getSessionFactory().openSession();
	public void testStaviUUpotrebu() {
		TipStalnogSredstva t = new TipStalnogSredstva("ble");
		StalnoSredstvo tmp = new StalnoSredstvo("Stolica", "sarajevo", 10.5, new Date(), t);
		assertTrue(tmp.staviUUpotrebu(10.3, new Date(), true));
	}

	public void testOtpisi() {

		TipStalnogSredstva t = new TipStalnogSredstva("ble");
		StalnoSredstvo tmp = new StalnoSredstvo("Stolica", "sarajevo", 10.5, new Date(), t);
		tmp.staviUUpotrebu(10.3, new Date(), true);
		assertTrue(tmp.otpisi(new Date()));
	}

	public void testProdaj() {

		TipStalnogSredstva t = new TipStalnogSredstva("ble");
		StalnoSredstvo tmp = new StalnoSredstvo("Stolica", "sarajevo", 10.5, new Date(), t);
		tmp.staviUUpotrebu(10.3, new Date(), true);
		assertTrue(tmp.prodaj( new Date(), 100.5));
	}
	public void testSpasi()
	{
		TipStalnogSredstva t = new TipStalnogSredstva("ble");
		StalnoSredstvo tmp = new StalnoSredstvo("Stolica", "sarajevo", 10.5, new Date(), t);
		try {
			t.spasi(sesija);
			assertTrue(tmp.spasi(sesija));
		} catch (Exception e) {
			fail("nije uspio test");
		}
		
	}
	public void testDelete()
	{
		TipStalnogSredstva t = new TipStalnogSredstva("ble");
		StalnoSredstvo tmp = new StalnoSredstvo("Stolica", "sarajevo", 10.5, new Date(), t);
		
		try {
			t.spasi(sesija);
			tmp.spasi(sesija);
			assertTrue(tmp.obrisi(sesija));
		} catch (Exception e) {
			fail("Test pao na deletu");
		}
		
		
	}
}
