package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.klase.Korisnik;
import ba.unsa.etf.si.util.HibernateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JTextField;

public class ObrisiKorisnika extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Session session;
	private JComboBox kombo;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					ObrisiKorisnika frame = new ObrisiKorisnika(sesija);
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
	public ObrisiKorisnika(Session sesija) {
		session = sesija;
		setTitle("Brisanje korisnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 302, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblIme = new JLabel("Username:");
		lblIme.setBounds(36, 49, 63, 14);
		contentPane.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Ime:");
		lblPrezime.setBounds(65, 74, 52, 14);
		contentPane.add(lblPrezime);
		
		JLabel lblJmbg = new JLabel("Prezime:");
		lblJmbg.setBounds(47, 99, 52, 14);
		contentPane.add(lblJmbg);
		
		JComboBox comboBox = new JComboBox(KorisniciSvi().toArray());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(((Korisnik) kombo.getSelectedItem()).getPrezime());
				textField.setText(((Korisnik) kombo.getSelectedItem()).getIme());
			}
		});
		kombo = comboBox;
		comboBox.setBounds(109, 46, 132, 20);
		contentPane.add(comboBox);
		
		
		JButton btnObrii = new JButton("Obri\u0161i");
		btnObrii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Korisnik pom = (Korisnik) kombo.getSelectedItem();
				 Transaction t = session.beginTransaction();
				 Query q = session.createQuery("delete Korisnik where ID = :id");
				 q.setParameter("id", pom.getId());
				 q.executeUpdate();
				 t.commit();
				 JOptionPane.showMessageDialog(null,"Korisnik Obrisan");
				 dispose();
				 //JOptionPane.showMessageDialog(null, "Nije implementirano! \nKlikom na ovo dugme korisnik �e biti izbrisan.");
				 
			}
		});
		btnObrii.setBounds(53, 156, 89, 23);
		contentPane.add(btnObrii);
		
		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(152, 156, 89, 23);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(109, 71, 132, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(109, 96, 132, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		//kombo.setSelectedIndex(0);
		textField_1.setText(((Korisnik) kombo.getSelectedItem()).getPrezime());
		textField.setText(((Korisnik) kombo.getSelectedItem()).getIme());
	}
}
