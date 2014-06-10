package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ba.unsa.etf.si.klase.Administrator;
import ba.unsa.etf.si.klase.Korisnik;
import ba.unsa.etf.si.util.HibernateUtil;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;

import org.hibernate.Query;
import org.hibernate.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class izmjenaKorisnickihPodataka extends JFrame {

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
	private Session session;
	private JComboBox kombo;
	private JPasswordField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory()
							.openSession();
					izmjenaKorisnickihPodataka frame = new izmjenaKorisnickihPodataka(
							sesija);
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
	public List<Korisnik> KorisniciSvi()
	{
		Query query = session.createQuery("from Korisnik");
		List<Korisnik> results = (List<Korisnik>) query.list();
		return results;
	}
	public izmjenaKorisnickihPodataka(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Izmjena korisni\u010Dkih podataka");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 364, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPromijeniIme = new JLabel("Novo ime:");
		lblPromijeniIme.setBounds(60, 42, 96, 14);
		contentPane.add(lblPromijeniIme);

		JLabel lblPromijeniPrezime = new JLabel("Novo prezime:");
		lblPromijeniPrezime.setBounds(41, 70, 115, 14);
		contentPane.add(lblPromijeniPrezime);

		JLabel lblNewLabel = new JLabel("Novi broj telefona:");
		lblNewLabel.setBounds(21, 95, 135, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNoviJmbg = new JLabel("Novi JMBG:");
		lblNoviJmbg.setBounds(60, 125, 77, 14);
		contentPane.add(lblNoviJmbg);

		JLabel lblNoviUsername = new JLabel("Novi username:");
		lblNoviUsername.setBounds(41, 150, 96, 14);
		contentPane.add(lblNoviUsername);

		JLabel lblNovaLozinka = new JLabel("Nova lozinka: ");
		lblNovaLozinka.setBounds(51, 175, 86, 14);
		contentPane.add(lblNovaLozinka);

		textField = new JTextField();
		textField.setBounds(158, 39, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 67, 149, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(158, 92, 149, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(158, 119, 149, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(158, 144, 149, 20);
		contentPane.add(textField_4);

		JButton button = new JButton("Uredu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Korisnik pom = ((Korisnik)kombo.getSelectedItem());
				
				if(textField.getText().isEmpty() || textField_1.getText().isEmpty() 
						|| textField_2.getText().isEmpty() || textField_3.getText().isEmpty() || textField_4.getText().isEmpty())
				{		
					JOptionPane.showMessageDialog(null, "Nisu dozvoljena prazna polja.");
					return;
				}
				
				String tel = textField_2.getText();
				
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
								
				String jmbg = textField_3.getText();
				
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
				
				if(!provjeriJMBG(jmbg))
				{
					JOptionPane.showMessageDialog(null, "Neispravan JMBG.");
					return;
				}
				
				String ime = textField.getText();
				
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
				
				String prezime = textField_1.getText();
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
				
				String username = textField_4.getText();
				if(username.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Unesite username.");
					return;
				}
				for(int i=1; i<username.length(); i++)
				{
					int ascii = (int) username.charAt(i);
					if((ascii < 65 && ascii > 57) || ascii<48 || (ascii > 90 && ascii < 97) || ascii>122)
					{
						JOptionPane.showMessageDialog(null, "Username može sadržavati samo slova (engleskog alfabeta) i cifre");
						return;
					}   
				}
				
				/*
				//stari kod
				pom.setIme(textField.getText());
				pom.setPrezime(textField_1.getText());
				pom.setBrTel(textField_2.getText());
				pom.setJmbg(textField_3.getText());
				pom.setUsername(textField_4.getText());
				*/
				
				
				if(pom.getIme().equals(ime) && pom.getPrezime().equals(prezime) && pom.getBrTel().equals(tel) && pom.getJmbg().equals(jmbg) && pom.getUsername().equals(username) && textField_5.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Svi uneseni podaci su isti kao i podaci prije promjene.\nNišta nije promijenjeno.");
					return;
				}
				
				session.getTransaction().begin();
				Korisnik k = (Korisnik)session.get(Korisnik.class, pom.getId());
				
				k.setIme(ime);
				k.setPrezime(prezime);
				k.setBrTel(tel);
				k.setJmbg(jmbg);
				k.setUsername(username);
				
				if(!textField_5.getText().isEmpty())
					k.setPassword(HibernateUtil.md5(textField_5.getText()));
				session.update(k);
				session.getTransaction().commit();
				
				JOptionPane.showMessageDialog(null,"Korisnik uspjesno izmijenjen");
				//refresh();
			}
		});
		button.setBounds(154, 200, 89, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(253, 200, 89, 23);
		contentPane.add(button_1);
		
		JComboBox comboBox = new JComboBox(KorisniciSvi().toArray());
		comboBox.setBounds(158, 14, 149, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kombo.getItemCount()!=0)
				{
					textField.setText(((Korisnik) kombo.getSelectedItem()).getIme());
					textField_1.setText(((Korisnik) kombo.getSelectedItem()).getPrezime());
					textField_2.setText(((Korisnik) kombo.getSelectedItem()).getBrTel());
					textField_3.setText(((Korisnik) kombo.getSelectedItem()).getJmbg());
					textField_4.setText(((Korisnik) kombo.getSelectedItem()).getUsername());
				}
			}
		});
		contentPane.add(comboBox);
		kombo = comboBox;
		
		JLabel lblKorisnik = new JLabel("Korisnik:");
		lblKorisnik.setBounds(70, 20, 86, 14);
		contentPane.add(lblKorisnik);

		textField.setText(((Korisnik) kombo.getSelectedItem()).getIme());
		textField_1.setText(((Korisnik) kombo.getSelectedItem()).getPrezime());
		textField_2.setText(((Korisnik) kombo.getSelectedItem()).getBrTel());
		textField_3.setText(((Korisnik) kombo.getSelectedItem()).getJmbg());
		textField_4.setText(((Korisnik) kombo.getSelectedItem()).getUsername());
		
		textField_5 = new JPasswordField();
		textField_5.setBounds(158, 169, 149, 20);
		contentPane.add(textField_5);
	}
	
	private boolean provjeriJMBG(String JMBG){
		
		Boolean ispravno;
        List<Integer> JMBG_N = new ArrayList<Integer>();
		
		for (char c : JMBG.toCharArray()) 
			JMBG_N.add(Character.getNumericValue(c));
		
			double eval = 0;
			
			for(int i = 0; i < 6; i++)
				eval += (7 - i) * (JMBG_N.get(i) + JMBG_N.get(i + 6));
			
			ispravno=JMBG_N.get(12) == 11 - eval % 11;
        
		return ispravno;
        
	}
}
