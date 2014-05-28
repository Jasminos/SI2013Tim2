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

public class adminMenu extends JFrame {

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
		session = sesija;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Menu za administratora");
		setBounds(100, 100, 279, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDodavanjeKorisnika = new JButton("Dodavanje korisnika");
		btnDodavanjeKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodajKorisnika dk = new DodajKorisnika(session);
				dk.setVisible(true);
			}
		});
		btnDodavanjeKorisnika.setBounds(42, 17, 184, 34);
		contentPane.add(btnDodavanjeKorisnika);

		JButton btnBrisanjeKorisnika = new JButton("Brisanje korisnika");
		btnBrisanjeKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObrisiKorisnika ok = new ObrisiKorisnika(session);
				ok.setVisible(true);
			}
		});
		btnBrisanjeKorisnika.setBounds(42, 107, 184, 34);
		contentPane.add(btnBrisanjeKorisnika);

		JButton btnIzmjenaKorisnika = new JButton("Izmjena korisnika");
		btnIzmjenaKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izmjenaKorisnickihPodataka ikp = new izmjenaKorisnickihPodataka(session);
				ikp.setVisible(true);
			}
		});
		btnIzmjenaKorisnika.setBounds(42, 152, 184, 34);
		contentPane.add(btnIzmjenaKorisnika);

		JButton btnPregledKorisnika = new JButton("Pregled korisnika");
		btnPregledKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pregled p = new pregled(session);
				p.setVisible(true);

			}
		});
		btnPregledKorisnika.setBounds(42, 202, 184, 34);
		contentPane.add(btnPregledKorisnika);

		JButton btnGenerisanjeIzvjetaja = new JButton(
				"Generisanje izvje\u0161taja");
		btnGenerisanjeIzvjetaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerisanjeIzvjestaja gi = new GenerisanjeIzvjestaja(session);
				gi.setVisible(true);
			}
		});
		btnGenerisanjeIzvjetaja.setBounds(42, 292, 185, 34);
		contentPane.add(btnGenerisanjeIzvjetaja);

		JButton btnDodavanjeTipa = new JButton("Dodaj tip stalnog sredstva");
		btnDodavanjeTipa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeTipaSS dt = new DodavanjeTipaSS(session);
				dt.setVisible(true);
			}
		});
		btnDodavanjeTipa.setBounds(42, 247, 184, 34);
		contentPane.add(btnDodavanjeTipa);
		
		JButton btnNewButton = new JButton("Izmjena admin passworda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzmjenaPassAdmin izmjena= new IzmjenaPassAdmin(session);
				izmjena.setVisible(true);
			}
		});
		btnNewButton.setBounds(42, 62, 184, 34);
		contentPane.add(btnNewButton);
	}
}
