package ba.unsa.etf.si.klase;

import java.util.Date;
import java.util.List;

public class KolekcijaStalnihSredstava implements java.io.Serializable {

	private List<StalnaSredstva> kolekcija;
	
	public KolekcijaStalnihSredstava(){}
	
	
	//metode nisu implementovane:
	public boolean StaviSSUUpotrebu(StalnaSredstva ss, Double stopa, boolean godisnjaAmort)
	{
		return false;
	}
	
	public void otpisiSSautomatski(SSuUpotrebi ss)
	{
		
	}
	
	public boolean otpisiSS(SSuUpotrebi ss)
	{
		return false;
	}
	
	public Date IzracunajKadaCeBitiOtpisano(SSuUpotrebi ss)
	{
		return new Date();		
	}
}
