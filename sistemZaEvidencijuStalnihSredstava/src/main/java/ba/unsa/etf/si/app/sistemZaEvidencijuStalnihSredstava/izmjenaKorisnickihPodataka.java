package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ba.unsa.etf.si.util.HibernateUtil;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;

import org.hibernate.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField textField_6;
	private Session session;

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
	public izmjenaKorisnickihPodataka(Session sesija) {
		session = sesija;
		setTitle("Izmjena korisni\u010Dkih podataka");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 297, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPromijeniIme = new JLabel("Novo ime:");
		lblPromijeniIme.setBounds(60, 32, 96, 14);
		contentPane.add(lblPromijeniIme);

		JLabel lblPromijeniPrezime = new JLabel("Novo prezime:");
		lblPromijeniPrezime.setBounds(41, 57, 96, 14);
		contentPane.add(lblPromijeniPrezime);

		JLabel lblNewLabel = new JLabel("Novi broj telefona:");
		lblNewLabel.setBounds(20, 85, 106, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNoviJmbg = new JLabel("Novi JMBG:");
		lblNoviJmbg.setBounds(60, 112, 64, 14);
		contentPane.add(lblNoviJmbg);

		JLabel lblNoviUsername = new JLabel("Novi username:");
		lblNoviUsername.setBounds(41, 137, 96, 14);
		contentPane.add(lblNoviUsername);

		JLabel lblNovaLozinka = new JLabel("Nova lozinka: ");
		lblNovaLozinka.setBounds(51, 162, 86, 14);
		contentPane.add(lblNovaLozinka);

		JLabel lblDatumPromjene = new JLabel("Datum promjene:");
		lblDatumPromjene.setBounds(30, 192, 126, 14);
		contentPane.add(lblDatumPromjene);

		JLabel lblVrijemePromjene = new JLabel("Vrijeme promjene:");
		lblVrijemePromjene.setBounds(22, 217, 134, 14);
		contentPane.add(lblVrijemePromjene);

		textField = new JTextField();
		textField.setBounds(137, 29, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 57, 86, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 82, 86, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 109, 86, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(137, 134, 86, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(137, 162, 86, 20);
		contentPane.add(textField_5);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(136, 187, 91, 20);
		contentPane.add(dateChooser);

		textField_6 = new JTextField();
		textField_6.setBounds(137, 214, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JButton button = new JButton("Uredu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								null,
								"Nije implementirano! \nKlikom na ovo dugme novi korisni�ki podaci �e biti spa�eni.");
			}
		});
		button.setBounds(71, 264, 89, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(170, 264, 89, 23);
		contentPane.add(button_1);
	}
}
