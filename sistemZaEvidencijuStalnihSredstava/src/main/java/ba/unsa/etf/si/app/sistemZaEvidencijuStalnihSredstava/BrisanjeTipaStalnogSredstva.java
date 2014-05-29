package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Query;
import org.hibernate.Session;

import ba.unsa.etf.si.klase.TipStalnogSredstva;
import ba.unsa.etf.si.util.HibernateUtil;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class BrisanjeTipaStalnogSredstva extends JFrame {

	private JPanel contentPane;
	private Session session;
	private JComboBox kombo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					BrisanjeTipaStalnogSredstva frame = new BrisanjeTipaStalnogSredstva(sesija);
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
	public List<TipStalnogSredstva> SviTipovi(){
		Query query = session.createQuery("from TipStalnogSredstva");
		List<TipStalnogSredstva> results = (List<TipStalnogSredstva>) query.list();
		return results;
	}
	public BrisanjeTipaStalnogSredstva(Session sesija) {
		session = sesija;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(SviTipovi().toArray());
		comboBox.setBounds(85, 53, 157, 20);
		contentPane.add(comboBox);
		kombo = comboBox;
		
		JLabel lblIzaberiteTipStalnog = new JLabel("Izaberite tip stalnog sredstva:");
		lblIzaberiteTipStalnog.setBounds(69, 27, 171, 14);
		contentPane.add(lblIzaberiteTipStalnog);
		
		JButton btnObrii = new JButton("Obriši");
		btnObrii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				session.getTransaction().begin();
				session.delete((TipStalnogSredstva)kombo.getSelectedItem());
				session.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "Tip sredstva obrisan.");
				dispose();
			}
		});
		btnObrii.setBounds(69, 93, 84, 23);
		contentPane.add(btnObrii);
		
		JButton btnIzai = new JButton("Izađi");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(163, 93, 79, 23);
		contentPane.add(btnIzai);
	}
}
