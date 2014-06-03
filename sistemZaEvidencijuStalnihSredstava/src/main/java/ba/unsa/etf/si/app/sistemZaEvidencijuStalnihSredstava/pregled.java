package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.awt.Choice;
import java.awt.Label;
import java.awt.Button;

import javax.swing.JTextField;

import org.hibernate.Query;
import org.hibernate.Session;

import ba.unsa.etf.si.klase.Korisnik;
import ba.unsa.etf.si.util.HibernateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class pregled extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
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
					pregled frame = new pregled(sesija);
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
	void refreshList(String ness)
	{
		DefaultTableModel t = new DefaultTableModel(
				new String[] {
					"Ime", "Prezime", "JMBG", "Telefon", "Username"},0
			);
			Query query = session.createQuery("from Korisnik");
			List<Korisnik> korisnici = (List<Korisnik>) query.list();
			for (int i = 0; i < korisnici.size(); i++) {
	            Korisnik kor = korisnici.get(i);

	            String[] data = new String[5];

	            data[0] = kor.getIme();
	            data[1] = kor.getPrezime();
	            data[2] = kor.getJmbg();
	            data[3] = kor.getBrTel();
	            data[4] = kor.getUsername();
	            if(data[0].contains(ness) || data[1].contains(ness) || data[2].contains(ness) || data[3].contains(ness) || data[4].contains(ness))
	            {
	            	t.addRow(data);
	            }
	        }
			table.setModel(t);
	}
	public pregled(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Pregled korisnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 511, 245);
		contentPane.add(scrollPane);
		
		table = new JTable();
		refreshList("");
		scrollPane.setViewportView(table);
		
		Label label_1 = new Label("Pretra\u017Ei:");
		label_1.setBounds(24, 26, 62, 22);
		contentPane.add(label_1);
		
		Button button = new Button("Iza\u0111i");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(432, 310, 70, 22);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshList(textField.getText());
			}
		});
		textField.setBounds(85, 28, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
