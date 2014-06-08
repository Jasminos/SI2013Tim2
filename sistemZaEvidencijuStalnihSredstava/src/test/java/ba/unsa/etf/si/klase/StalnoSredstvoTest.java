package ba.unsa.etf.si.klase;

import java.util.Date;

import junit.framework.TestCase;

public class StalnoSredstvoTest extends TestCase {
	TipStalnogSredstva t = new TipStalnogSredstva();
	StalnoSredstvo tmp = new StalnoSredstvo("Stolica", "sarajevo", 10.5, new Date(), t);
	
	public void testStaviUUpotrebu() {
		
		assertTrue(tmp.staviUUpotrebu(10.3, new Date(), true));
	}

	public void testOtpisi() {
		assertFalse(tmp.otpisi(new Date()));
	}

	public void testProdaj() {
		tmp.getDatumProdaje();
		assertTrue(tmp.prodaj( tmp.getDatumProdaje(), 100.5));
	}

	/*public void testSpasi() {
		fail("Not yet implemented");
	}

	public void testObrisi() {
		fail("Not yet implemented");
	}

	public void testIzmjeni() {
		fail("Not yet implemented");
	}*/

}
