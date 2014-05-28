package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import ba.unsa.etf.si.klase.*;
import ba.unsa.etf.si.util.HibernateUtil;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JRadioButton;

public class DodavanjeNovogSS extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textVrijednost;
	private JComboBox comboBox1;
	private JDateChooser kontrolaDatum;
	private JTextField textLokacija;
	private Session session;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					DodavanjeNovogSS frame = new DodavanjeNovogSS(sesija);
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
	public DodavanjeNovogSS(Session sesija) {
		session = sesija;
		setTitle("Dodavanje stalnog sredstva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naziv stalnog sredstva:");
		lblNewLabel.setBounds(32, 14, 113, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTipSredstva = new JLabel("Tip sredstva:");
		lblTipSredstva.setBounds(82, 39, 63, 14);
		contentPane.add(lblTipSredstva);
		
		JLabel lblVrijednostStalnogSredstva = new JLabel("Vrijednost stalnog sredstva:");
		lblVrijednostStalnogSredstva.setBounds(10, 64, 135, 14);
		contentPane.add(lblVrijednostStalnogSredstva);
		
		JLabel lblLokacija = new JLabel("Lokacija:");
		lblLokacija.setBounds(103, 89, 42, 14);
		contentPane.add(lblLokacija);
		
		textField = new JTextField();
		textField.setBounds(147, 11, 181, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox1 = new JComboBox();
		
		comboBox1.setBounds(147, 36, 181, 20);
		contentPane.add(comboBox1);
		
		textVrijednost = new JTextField();
		textVrijednost.setBounds(147, 61, 181, 20);
		contentPane.add(textVrijednost);
		textVrijednost.setColumns(10);
		
		textLokacija = new JTextField();
		textLokacija.setBounds(147, 86, 181, 20);
		contentPane.add(textLokacija);
		textLokacija.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Transaction t = session.beginTransaction(); 
				
				  String nazivSS = textField.getText();
				  
				  //TipStalnogSredstva tip=(TipStalnogSredstva) comboBox1.getSelectedItem();
				  Double vrijednost = Double.parseDouble(textVrijednost.getText());
				  Date datumNabavke = new Date();
						 
				  String lokacija = textLokacija.getText();
				  StalnoSredstvo s = new StalnoSredstvo(nazivSS, lokacija, vrijednost, datumNabavke, new TipStalnogSredstva("ispravi ovo"));
				  
				  session.save(s);
				  System.out.println("Dodano stalno sredstvo"); 
				  t.commit(); 
				 
			}
		});
		btnDodaj.setBounds(143, 117, 89, 23);
		contentPane.add(btnDodaj);
		
		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(239, 117, 89, 23);
		contentPane.add(button_1);
	}
}
