package ba.unsa.etf.si.klase;

import java.util.Date;

public interface Report {
	public void kreirajIzvjestajSS(Date datum1, Date datum2,
			double vrijednost1, double vrijednost2, String lokacija,
			TipStalnogSredstva tipSredstva);

	public void kreirajIzvjestajSSUpotrebi(Date datum1, Date datum2,
			double vrijednost1, double vrijednost2, double vrijednost3,
			double vrijednost4, Date datum3, Date datum4, Date datum5,
			double vrijednost5, double vrijednost6, Date datum6, Date datum7,
			String tekst1, TipStalnogSredstva tip);

	public void kreirajIzvjestajOtpisanaProdana(Date datum1, Date datum2,
			double vrijednost1, double vrijednost2, Date datum3, Date datum4,
			double vrijednost3, double vrijednost4, Date datum5, Date datum6,
			String tekst1, TipStalnogSredstva tip);
}
