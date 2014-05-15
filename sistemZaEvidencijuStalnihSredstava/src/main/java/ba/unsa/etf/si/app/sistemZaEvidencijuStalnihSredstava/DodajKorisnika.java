package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import ba.unsa.etf.si.klase.Korisnik;
import ba.unsa.etf.si.korisnik.*;
import ba.unsa.etf.si.util.HibernateUtil;

public class DodajKorisnika extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajKorisnika frame = new DodajKorisnika();
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
	public DodajKorisnika() {
		setTitle("Dodavanje korisnika");
		setBounds(100, 100, 340, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(78, 27, 46, 14);
		contentPane.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(60, 55, 64, 14);
		contentPane.add(lblPrezime);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBounds(70, 80, 46, 14);
		contentPane.add(lblJmbg);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona:");
		lblBrojTelefona.setBounds(34, 106, 90, 14);
		contentPane.add(lblBrojTelefona);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(46, 131, 96, 14);
		contentPane.add(lblUsername);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setBounds(60, 156, 64, 14);
		contentPane.add(lblLozinka);
		
		JLabel lblDatumKreiranja = new JLabel("Datum kreiranja:");
		lblDatumKreiranja.setBounds(23, 181, 119, 14);
		contentPane.add(lblDatumKreiranja);
		
		textField = new JTextField();
		textField.setBounds(129, 24, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 52, 156, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(129, 77, 156, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(129, 103, 156, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(129, 128, 156, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(129, 153, 156, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(129, 179, 156, 20);
		contentPane.add(dateChooser);
		
		
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction(); 
				
				  String ime = textField.getText();
				  String prezime=textField_1.getText();
				  String jmbg=textField_2.getText();
				  String tel=textField_3.getText();
				  String username=textField_3.getText();
				  String password=textField_4.getText();
				  Date datum=(Date) dateChooser.getDate();
				  
				  Korisnik k=new Korisnik(6,ime,prezime,jmbg,tel,username,password,datum);
				  session.save(k);
				  System.out.println("Dodan korisnik"); 
				  t.commit(); 
			 
			     
			}
			
		});
		btnDodaj.setBounds(114, 226, 89, 23);
		contentPane.add(btnDodaj);
		
		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(213, 226, 89, 23);
		contentPane.add(button_1);
	}
}
