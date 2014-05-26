package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;
import org.hibernate.Query;
import org.hibernate.Session;




import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DropMode;

import java.util.List;




import ba.unsa.etf.si.klase.Administrator;
import ba.unsa.etf.si.klase.Korisnik;
import ba.unsa.etf.si.util.HibernateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private JPanel contentPane;
	private JTextField textField;
	private Session session;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					Login frame = new Login(sesija);
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
	public Login(Session sesija) {
		this.session = sesija;
		setTitle(" \u03BCDEVELOPERS Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 347, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		lblKorisnikoIme.setBounds(45, 47, 93, 14);
		contentPane.add(lblKorisnikoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setBounds(75, 72, 56, 14);
		contentPane.add(lblLozinka);
		
		textField = new JTextField();
		textField.setDropMode(DropMode.INSERT);
		textField.setToolTipText("");
		textField.setBounds(141, 44, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBounds(186, 110, 89, 23);
		contentPane.add(btnPotvrdi);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 69, 133, 20);
		contentPane.add(passwordField);
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = textField.getText();
				String pass = passwordField.getText();
			
				/*if (user.equals("admin") && pass.equals("admin")){
					adminMenu am= new adminMenu();
					am.setVisible(true);
					dispose();
					
				}else if (user.equals("racunovodja") && pass.equals("racunovodja")){
					
					PocetniEkranRacunovodja per= new PocetniEkranRacunovodja ();
					per.setVisible(true);
				}else {
					
					JOptionPane.showMessageDialog(null, "Unesite korisni�ko ime i lozinku!");
				}*/
				if(user.equals("Administrator"))
				{
					Administrator a = (Administrator) session.get(Administrator.class, (long) 1);
					if(pass.equals(a.getPassword()))
					{
						adminMenu am= new adminMenu(session);
						am.setVisible(true);
						dispose();
					}
				}
				else 
				{
					Query query = session.createQuery("from Korisnik where USERNAME = :username ");
					query.setParameter("username", user);
					List<?> results = query.list();
					Korisnik korisnik = (Korisnik) results.get(0);
					
					if(HibernateUtil.md5(pass).equals(korisnik.getPassword()))
					{
						PocetniEkranRacunovodja per= new PocetniEkranRacunovodja (session);
						per.setVisible(true);
						dispose();
					}
				}
				
			}
		});
		
	}
}
