package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.klase.TipStalnogSredstva;
import ba.unsa.etf.si.util.HibernateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodavanjeTipaSS extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Session session;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					DodavanjeTipaSS frame = new DodavanjeTipaSS(sesija);
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
	public DodavanjeTipaSS(Session sesija) {
		session = sesija;
		setTitle("Dodavanje tipa stalnog sredstva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naziv tipa:");
		lblNewLabel.setBounds(35, 11, 63, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnUredu = new JButton("Uredu");
		btnUredu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Session session = HibernateUtil.getSessionFactory()
						.openSession();
				Transaction t = session.beginTransaction();

				String naziv = textField.getText();
				

				TipStalnogSredstva k = new TipStalnogSredstva(naziv);

				session.save(k);
				System.out.println("Dodan TipSS");
				t.commit();
				
		        JOptionPane.showMessageDialog(null, "Tip dodan.");
		        dispose();
			}
		});
		btnUredu.setBounds(146, 52, 89, 23);
		contentPane.add(btnUredu);
		
		JButton btnIzai = new JButton("Izađi");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(245, 52, 89, 23);
		contentPane.add(btnIzai);
		
		textField = new JTextField();
		textField.setBounds(108, 14, 197, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
