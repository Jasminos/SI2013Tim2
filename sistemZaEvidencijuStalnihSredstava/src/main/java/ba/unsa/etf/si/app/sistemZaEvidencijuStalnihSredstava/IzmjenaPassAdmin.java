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

public class IzmjenaPassAdmin extends JFrame {

	private JPanel contentPane;
	private Session session;
	private JTextField textField;

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
		session = sesija;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novi password:");
		lblNewLabel.setBounds(10, 27, 86, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(99, 24, 99, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Izmijeni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				session.getTransaction().begin();
				Administrator admin = (Administrator)session.get(Administrator.class, (long)1);
				admin.setPassword(HibernateUtil.md5(textField.getText()));
				session.update(admin);
				session.getTransaction().commit();
				JOptionPane.showMessageDialog(null,"Password uspjesno izmijenjen." );
				dispose();
			}
		});
		btnNewButton.setBounds(109, 55, 89, 23);
		contentPane.add(btnNewButton);
	}

}
