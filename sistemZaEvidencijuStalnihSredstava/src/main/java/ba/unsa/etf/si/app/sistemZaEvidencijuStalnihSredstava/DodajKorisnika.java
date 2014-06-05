package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;

import ba.unsa.etf.si.klase.Administrator;
import ba.unsa.etf.si.klase.Korisnik;
import ba.unsa.etf.si.klase.TipStalnogSredstva;
import ba.unsa.etf.si.korisnik.*;
import ba.unsa.etf.si.util.HibernateUtil;

import javax.swing.JPasswordField;

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
	private JPasswordField passwordField;
	private Session session;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					DodajKorisnika frame = new DodajKorisnika(sesija);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void refresh()
	{
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		passwordField.setText("");
	}
	/**
	 * Create the frame.
	 */
	
	public DodajKorisnika(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Dodavanje korisnika");
		setBounds(100, 100, 341, 269);
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

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ime = textField.getText();
				String prezime = textField_1.getText();
				String jmbg = textField_2.getText();
				String tel = textField_3.getText();
				String username = textField_4.getText();
				String password = passwordField.getText();
				
								
				if( username.length() == 1 || ime.length() == 1 || prezime.length() == 1)
				{
					JOptionPane.showMessageDialog(null, "Nisu dozvoljene vrijednosti od jednog simbola");
					return;
				}
				
				if(username.isEmpty() || password.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Unesite username i password.");
					return;
				}
				if(ime.isEmpty() || prezime.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Unesite ime i prezime korisnika");
					return;
				}
				if(jmbg.length() != 13)
				{
					JOptionPane.showMessageDialog(null, "JMBG mora imati 13 cifara");
					return;
				}
				for(int i=0; i<jmbg.length(); i++)
				{
					int ascii = (int) jmbg.charAt(i);
					if(ascii < 48 || ascii > 57)
					{
						JOptionPane.showMessageDialog(null, "Unesite ispravan JMBG");
						return;
					}
				}
				if(tel.length() != 9)
				{
					JOptionPane.showMessageDialog(null, "Broj telefona mora imati 9 cifara");
					return;
				}
				for(int i=0; i<tel.length(); i++)
				{
					int ascii = (int) tel.charAt(i);
					if(ascii < 48 || ascii > 57)
					{
						JOptionPane.showMessageDialog(null, "Unesite ispravan broj telefona");
						return;
					}
				}
				
				//validiranje username, imena i prezimena:
				
				for(int i=1; i<username.length(); i++)
				{
					int ascii = (int) username.charAt(i);
					if((ascii < 65 && ascii > 57) || ascii<48 || (ascii > 90 && ascii < 97) || ascii>122)
					{
						JOptionPane.showMessageDialog(null, "Username može sadržavati samo slova engleskog alfabeta i cifre");
						return;
					}   
				}
				
				int c = (int)ime.charAt(0);
				if(c<65 || c>90)
				{
					JOptionPane.showMessageDialog(null, "Ime mora početi velikim slovom");
					return;
				}
				
				for(int i=1; i<ime.length(); i++)
				{
					int ascii = (int) ime.charAt(i);
					if((ascii < 65  && ascii!=32 && ascii!=45) || (ascii > 90 && ascii < 97) || ascii>122)
					{ 
						JOptionPane.showMessageDialog(null, "Ime može sadržavati samo velika, mala slova (engleskog alfabeta) i razmak");
						return;
					}   
				}
				
				c = (int)prezime.charAt(0);
				if(c<65 || c>90)
				{
					JOptionPane.showMessageDialog(null, "Prezime mora početi velikim slovom");
					return;
				}
				
				for(int i=1; i<prezime.length(); i++)
				{
					int ascii = (int) prezime.charAt(i);
					if((ascii < 65  && ascii!=32 && ascii!=45) || (ascii > 90 && ascii < 97) || ascii>122)
					{ 
						JOptionPane.showMessageDialog(null, "Prezime može sadržavati samo velika, mala slova (engleskog alfabeta), razmak i -");
						return;
					}   
				}
				
				/*provjera postojanja username-a u bazi*/
				
				Query query = session.createQuery("from Korisnik");
				List<Korisnik> rezultat = (List<Korisnik>) query.list();
				for(int i=0; i<rezultat.size(); i++)
				{
					String priv = rezultat.get(i).getUsername();
					if(priv.equals(username))
					{
						JOptionPane.showMessageDialog(null, "Korisnik sa istim username-om već postoji.");
						return;
					}
				}
				
				if(username.equals("Administrator"))
				{
					JOptionPane.showMessageDialog(null, "Korisnik ne smije imati username 'Administrator'!");
					return;
				}
				
				// Date datum=(Date) dateChooser.getDate();
				Korisnik k = new Korisnik(6, ime, prezime, jmbg, tel, username,
						HibernateUtil.md5(password), new Date());
				// Administrator k = new Administrator();
				//System.out.println("Dodan korisnik");
				try {
					k.spasi(session);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Greska u komunikaciji" );
					return;
				}
				JOptionPane.showMessageDialog(null,"Korisnik uspjesno dodan." );
				//JOptionPane.showMessageDialog(null, "Korisnik dodan.");
				refresh();

			}

		});
		btnDodaj.setBounds(114, 194, 89, 23);
		contentPane.add(btnDodaj);

		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(213, 194, 89, 23);
		contentPane.add(button_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(129, 153, 156, 20);
		contentPane.add(passwordField);
	}
}
