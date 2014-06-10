package ba.unsa.etf.si.klase;

import java.util.Date;

import junit.framework.TestCase;

public class StalnoSredstvoTest extends TestCase {
	
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
}
