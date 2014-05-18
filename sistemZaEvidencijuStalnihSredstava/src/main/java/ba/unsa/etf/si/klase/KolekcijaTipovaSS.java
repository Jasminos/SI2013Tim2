package ba.unsa.etf.si.klase;

import java.util.List;

public class KolekcijaTipovaSS implements java.io.Serializable {
	private List<TipStalnogSredstva> kolekcija;
	
	public KolekcijaTipovaSS(){}
	
	public boolean dodajTip(TipStalnogSredstva ts)
	{
		if(ts!=null)
		{
			kolekcija.add(ts);
			return true;
		}
		return false;
	}
	
	public boolean izbrisiTip(TipStalnogSredstva ts)
	{
		if(ts!=null)
		{
			try
			{
				kolekcija.remove(ts);
			}
			catch(Exception e)
			{
				return false;
			}
			return true;
		}
		return false;
	}
}
