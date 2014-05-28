package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.hibernate.Query;
import org.hibernate.Session;

import ba.unsa.etf.si.util.HibernateUtil;
public class PocetniEkranRacunovodja extends JFrame {

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
					PocetniEkranRacunovodja frame = new PocetniEkranRacunovodja(sesija);
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
	public PocetniEkranRacunovodja(Session sesija) {
		session = sesija;
		setTitle("Menu za ra\u010Dunovo\u0111u");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Dodavanje stalnog sredstva");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeNovogSS dns= new DodavanjeNovogSS (session);
				dns.setVisible(true);
			}
		});
		btnNewButton.setBounds(32, 26, 314, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Stavljanje stalnog sredstva u upotrebu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StavljanjeSredstvaUUpotrebu ssuup= new StavljanjeSredstvaUUpotrebu(session);
				ssuup.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(32, 116, 314, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnPregledStalnihSredstava = new JButton("Pregled stalnih sredstava");
		btnPregledStalnihSredstava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PregledSS pss= new PregledSS(session);
				pss.setVisible(true);
			}
		});
		btnPregledStalnihSredstava.setBounds(32, 71, 314, 34);
		contentPane.add(btnPregledStalnihSredstava);
		
		JButton btnTabelarniPrikazAmortizacije = new JButton("Tabelarni prikaz amortizacije stalnog sredstva");
		btnTabelarniPrikazAmortizacije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelarniPrikazAmortizacije tpa= new TabelarniPrikazAmortizacije (session);
				tpa.setVisible(true);
			}
		});
		btnTabelarniPrikazAmortizacije.setBounds(32, 251, 314, 34);
		contentPane.add(btnTabelarniPrikazAmortizacije);
		
		JButton btnNewButton_2 = new JButton("Izmjena stalnog sredstva");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzmjenaStalnogSredstva iss= new IzmjenaStalnogSredstva(session);
				iss.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(32, 161, 314, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnOtpisprodajaStalnogSredsta = new JButton("Otpis/prodaja stalnog sredsta");
		btnOtpisprodajaStalnogSredsta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OtpisProdajaSS opss= new OtpisProdajaSS(session);
				opss.setVisible(true);
			}
		});
		btnOtpisprodajaStalnogSredsta.setBounds(32, 206, 314, 34);
		contentPane.add(btnOtpisprodajaStalnogSredsta);
	}

}
