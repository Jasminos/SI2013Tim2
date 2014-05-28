package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;
import org.hibernate.Query;
import org.hibernate.Session;

import ba.unsa.etf.si.util.HibernateUtil;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminMenu extends  JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Session session;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					adminMenu frame = new adminMenu(sesija);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adminMenu(Session sesija) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Menu za administratora");
		setBounds(100, 100, 277, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDodavanjeKorisnika = new JButton("Dodavanje korisnika");
		btnDodavanjeKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodajKorisnika dk= new DodajKorisnika (session);
				dk.setVisible(true);
			}
		});
		btnDodavanjeKorisnika.setBounds(38, 27, 184, 34);
		contentPane.add(btnDodavanjeKorisnika);
		
		JButton btnBrisanjeKorisnika = new JButton("Brisanje korisnika");
		btnBrisanjeKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObrisiKorisnika ok= new ObrisiKorisnika ();
				ok.setVisible(true);
			}
		});
		btnBrisanjeKorisnika.setBounds(38, 72, 184, 34);
		contentPane.add(btnBrisanjeKorisnika);
		
		JButton btnIzmjenaKorisnika = new JButton("Izmjena korisnika");
		btnIzmjenaKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izmjenaKorisnickihPodataka ikp= new izmjenaKorisnickihPodataka ();
				ikp.setVisible(true);
			}
		});
		btnIzmjenaKorisnika.setBounds(38, 117, 184, 34);
		contentPane.add(btnIzmjenaKorisnika);
		
		JButton btnPregledKorisnika = new JButton("Pregled korisnika");
		btnPregledKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			pregled p= new pregled ();
			p.setVisible(true);
			
			}
		});
		btnPregledKorisnika.setBounds(38, 167, 184, 34);
		contentPane.add(btnPregledKorisnika);
		
		JButton btnGenerisanjeIzvjetaja = new JButton("Generisanje izvje\u0161taja");
		btnGenerisanjeIzvjetaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerisanjeIzvjestaja gi= new GenerisanjeIzvjestaja();
				gi.setVisible(true);
			}
		});
		btnGenerisanjeIzvjetaja.setBounds(38, 257, 185, 34);
		contentPane.add(btnGenerisanjeIzvjetaja);
		
		JButton btnDodavanjeTipa = new JButton("Dodaj tip stalnog sredstva");
		btnDodavanjeTipa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeTipaSS dt= new DodavanjeTipaSS ();
				dt.setVisible(true);
			}
		});
		btnDodavanjeTipa.setBounds(38, 212, 184, 34);
		contentPane.add(btnDodavanjeTipa);
	}
}
