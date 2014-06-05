package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;

import ba.unsa.etf.si.klase.Administrator;
import ba.unsa.etf.si.util.HibernateUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class IzmjenaPassAdmin extends JFrame {

	private JPanel contentPane;
	private Session session;
	private JPasswordField textField;
	private JPasswordField passwordPonovo;
	private JPasswordField passwordStari;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					IzmjenaPassAdmin frame = new IzmjenaPassAdmin(sesija);
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
	public IzmjenaPassAdmin(Session sesija) {
		setResizable(false);
		session = sesija;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 366, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novi password:");
		lblNewLabel.setBounds(38, 56, 140, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Izmijeni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty() && !passwordStari.getText().isEmpty() && !passwordPonovo.getText().isEmpty())
				{
					String ponovo = passwordPonovo.getText();
					if(!textField.getText().equals(ponovo))
					{
						JOptionPane.showMessageDialog(null, "Ukucani passwordi moraju biti isti!");
						return;
					}
					
					
					session.getTransaction().begin();
					Administrator admin = (Administrator)session.get(Administrator.class, (long)1);
					
					String stari = admin.getPassword();
					
					if(!passwordStari.getText().equals(stari))
					{
						JOptionPane.showMessageDialog(null, "Pogrešan stari password ste unijeli!");
						return;
					}
					
					admin.setPassword(HibernateUtil.md5(textField.getText()));
					session.update(admin);
					session.getTransaction().commit();
					JOptionPane.showMessageDialog(null,"Password uspjesno izmijenjen." );
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Unesite sva potrebna polja.");
			}
		});
		btnNewButton.setBounds(139, 116, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JPasswordField();
		textField.setBounds(178, 50, 146, 20);
		contentPane.add(textField);
		
		JLabel lblStariPassword = new JLabel("Stari password:");
		lblStariPassword.setBounds(38, 31, 140, 14);
		contentPane.add(lblStariPassword);
		
		JLabel lblPonovoNoviPassword = new JLabel("Ponovo novi password:");
		lblPonovoNoviPassword.setBounds(38, 81, 140, 14);
		contentPane.add(lblPonovoNoviPassword);
		
		passwordPonovo = new JPasswordField();
		passwordPonovo.setBounds(178, 75, 146, 20);
		contentPane.add(passwordPonovo);
		
		passwordStari = new JPasswordField();
		passwordStari.setBounds(178, 25, 146, 20);
		contentPane.add(passwordStari);
		
		JButton btnNewButton_1 = new JButton("Odustani");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(238, 116, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
