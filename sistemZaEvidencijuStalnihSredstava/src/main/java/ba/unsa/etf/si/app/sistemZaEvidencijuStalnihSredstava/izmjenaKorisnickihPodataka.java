package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ba.unsa.etf.si.klase.Korisnik;
import ba.unsa.etf.si.util.HibernateUtil;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;

import org.hibernate.Query;
import org.hibernate.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JComboBox;

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
	private JTextField textField_5;
	private Session session;
	private JComboBox kombo;

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
		session = sesija;
		setTitle("Izmjena korisni\u010Dkih podataka");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 297, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPromijeniIme = new JLabel("Novo ime:");
		lblPromijeniIme.setBounds(60, 45, 96, 14);
		contentPane.add(lblPromijeniIme);

		JLabel lblPromijeniPrezime = new JLabel("Novo prezime:");
		lblPromijeniPrezime.setBounds(41, 70, 96, 14);
		contentPane.add(lblPromijeniPrezime);

		JLabel lblNewLabel = new JLabel("Novi broj telefona:");
		lblNewLabel.setBounds(20, 98, 106, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNoviJmbg = new JLabel("Novi JMBG:");
		lblNoviJmbg.setBounds(60, 125, 64, 14);
		contentPane.add(lblNoviJmbg);

		JLabel lblNoviUsername = new JLabel("Novi username:");
		lblNoviUsername.setBounds(41, 150, 96, 14);
		contentPane.add(lblNoviUsername);

		JLabel lblNovaLozinka = new JLabel("Nova lozinka: ");
		lblNovaLozinka.setBounds(51, 175, 86, 14);
		contentPane.add(lblNovaLozinka);

		textField = new JTextField();
		textField.setBounds(137, 42, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 70, 86, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 95, 86, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 122, 86, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(137, 147, 86, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(137, 175, 86, 20);
		contentPane.add(textField_5);

		JButton button = new JButton("Uredu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Korisnik pom = ((Korisnik)kombo.getSelectedItem());
				pom.setIme(textField.getText());
				pom.setPrezime(textField_1.getText());
				pom.setBrTel(textField_2.getText());
				pom.setJmbg(textField_3.getText());
				pom.setUsername(textField_4.getText());
				if(textField.getText().length()!=0)
					pom.setPassword(HibernateUtil.md5(textField_5.getText()));
				try {
					pom.izmjeni(session);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Greska");
					return;
				}
				JOptionPane.showMessageDialog(null,"Korisnik uspjesno izmijenjen");
				//refresh();
			}
		});
		button.setBounds(83, 203, 89, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(182, 203, 89, 23);
		contentPane.add(button_1);
		
		JComboBox comboBox = new JComboBox(KorisniciSvi().toArray());
		comboBox.setBounds(137, 17, 86, 20);
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
		lblKorisnik.setBounds(70, 23, 86, 14);
		contentPane.add(lblKorisnik);

		textField.setText(((Korisnik) kombo.getSelectedItem()).getIme());
		textField_1.setText(((Korisnik) kombo.getSelectedItem()).getPrezime());
		textField_2.setText(((Korisnik) kombo.getSelectedItem()).getBrTel());
		textField_3.setText(((Korisnik) kombo.getSelectedItem()).getJmbg());
		textField_4.setText(((Korisnik) kombo.getSelectedItem()).getUsername());
	}
}
