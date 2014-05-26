package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import org.hibernate.Session;

import ba.unsa.etf.si.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Login l=new Login (session);
		l.setVisible(true);

	}

}
