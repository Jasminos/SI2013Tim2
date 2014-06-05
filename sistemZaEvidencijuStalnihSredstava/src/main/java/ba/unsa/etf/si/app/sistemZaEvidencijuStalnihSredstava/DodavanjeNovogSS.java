package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;

import ba.unsa.etf.si.klase.*;
import ba.unsa.etf.si.util.HibernateUtil;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JRadioButton;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

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
	private JComboBox kombo;
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
	public List<TipStalnogSredstva> SviTipovi(){
		Query query = session.createQuery("from TipStalnogSredstva");
		List<TipStalnogSredstva> results = (List<TipStalnogSredstva>) query.list();
		return results;
	}
	
	
	public void TrenutniDatum (){

		
	}
	
	public DodavanjeNovogSS(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Dodavanje stalnog sredstva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naziv stalnog sredstva:");
		lblNewLabel.setBounds(48, 36, 152, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTipSredstva = new JLabel("Tip sredstva:");
		lblTipSredstva.setBounds(98, 61, 102, 14);
		contentPane.add(lblTipSredstva);
		
		JLabel lblVrijednostStalnogSredstva = new JLabel("Vrijednost stalnog sredstva:");
		lblVrijednostStalnogSredstva.setBounds(26, 139, 174, 14);
		contentPane.add(lblVrijednostStalnogSredstva);
		
		JLabel lblLokacija = new JLabel("Lokacija:");
		lblLokacija.setBounds(119, 164, 81, 14);
		contentPane.add(lblLokacija);
		
		textField = new JTextField();
		textField.setBounds(200, 33, 181, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox1 = new JComboBox(SviTipovi().toArray());		
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboBox1.setBounds(200, 58, 181, 20);
		contentPane.add(comboBox1);
		
		textVrijednost = new JTextField();
		textVrijednost.setBounds(200, 136, 181, 20);
		contentPane.add(textVrijednost);
		textVrijednost.setColumns(10);
		
		textLokacija = new JTextField();
		textLokacija.setBounds(200, 161, 181, 20);
		contentPane.add(textLokacija);
		textLokacija.setColumns(10);
		
		kombo = comboBox1;
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
				  String nazivSS = textField.getText();
				  
				  Double vrijednost = Double.parseDouble(textVrijednost.getText());
				  Date datumNabavke = new Date();
						 
				  String lokacija = textLokacija.getText();
				  StalnoSredstvo s = new StalnoSredstvo(nazivSS, lokacija, vrijednost, datumNabavke,(TipStalnogSredstva)kombo.getSelectedItem());
				  try {
					s.spasi(session);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Stalno sredstvo nije dodano greska.");
					e1.printStackTrace();
				} 
				  JOptionPane.showMessageDialog(null,"Stalno sredstvo dodano.");
				  dispose();
			}
		});
		btnDodaj.setBounds(188, 213, 89, 23);
		contentPane.add(btnDodaj);
		
		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(291, 213, 89, 23);
		contentPane.add(button_1);
		
		JLabel lblDatumNabavke = new JLabel("Datum nabavke:");
		lblDatumNabavke.setBounds(80, 89, 109, 14);
		contentPane.add(lblDatumNabavke);
		
		Calendar cal = new GregorianCalendar();	
		int mjesec=cal.get(Calendar.MONTH);
		int dan=cal.get(Calendar.DAY_OF_MONTH);
		int godina=cal.get(Calendar.YEAR);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setText(dan+"."+(mjesec+1)+"."+godina);
		lblNewLabel_1.setBounds(200, 89, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblVrijemeNabavke = new JLabel("Vrijeme nabavke:");
		lblVrijemeNabavke.setBounds(74, 114, 126, 14);
		contentPane.add(lblVrijemeNabavke);
		
	
		Calendar cal1 = new GregorianCalendar();	
		int minute=cal1.get(Calendar.MINUTE);
		int sati=cal1.get(Calendar.HOUR);
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setText(sati+":"+minute);
		lblNewLabel_2.setBounds(200, 114, 85, 14);
		contentPane.add(lblNewLabel_2);
		
			
			
			
			
	
		
	}
}
