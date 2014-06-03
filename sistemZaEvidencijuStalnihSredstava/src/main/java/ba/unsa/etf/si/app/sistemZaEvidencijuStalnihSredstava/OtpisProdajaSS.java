package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import ba.unsa.etf.si.klase.StalnoSredstvo;
import ba.unsa.etf.si.klase.TipStalnogSredstva;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;

import org.hibernate.Query;
import org.hibernate.Session;

import ba.unsa.etf.si.util.HibernateUtil;

import javax.swing.JComboBox;

public class OtpisProdajaSS extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Session session;
	private JComboBox kombo;
	private JRadioButton radio1;
	private JRadioButton radio2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					OtpisProdajaSS frame = new OtpisProdajaSS(sesija);
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
	public List<StalnoSredstvo> SvaSredstvaNeProdano(){
		Query query = session.createQuery("from StalnoSredstvo where PRODANO = false");
		List<StalnoSredstvo> results = (List<StalnoSredstvo>) query.list();
		return results;
	}
	public OtpisProdajaSS(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Otpisivanje/prodaja stalnog sredstva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 407, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnOtpisivanjeStalnogSredstva = new JRadioButton("Otpisivanje stalnog sredstva");
		buttonGroup.add(rdbtnOtpisivanjeStalnogSredstva);
		rdbtnOtpisivanjeStalnogSredstva.setBounds(14, 104, 193, 23);
		contentPane.add(rdbtnOtpisivanjeStalnogSredstva);
		radio1 = rdbtnOtpisivanjeStalnogSredstva;
		
		JRadioButton rdbtnProdajaStalnogSredstva = new JRadioButton("Prodaja stalnog sredstva");
		buttonGroup.add(rdbtnProdajaStalnogSredstva);
		rdbtnProdajaStalnogSredstva.setBounds(209, 104, 182, 23);
		contentPane.add(rdbtnProdajaStalnogSredstva);
		radio2 = rdbtnProdajaStalnogSredstva;
		
		textField = new JTextField();
		textField.setBounds(209, 70, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(335, 73, 46, 14);
		contentPane.add(lblKm);
		
		JButton btnUredu = new JButton("Uredu");
		btnUredu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				session.getTransaction().begin();	
				StalnoSredstvo ss = (StalnoSredstvo)kombo.getSelectedItem();
				Double cijena = Double.parseDouble(textField.getText());
				Date datum = new Date();
				if(radio1.isSelected()){
					if(ss.otpisi(datum)){
						session.update(ss);
					    session.getTransaction().commit();
						JOptionPane.showMessageDialog(null, "Sredstvo uspješno otpisano.");
						dispose();
					}
					else JOptionPane.showMessageDialog(null, "Greška! Pokušajte ponovno.");
				}
				
				if(radio2.isSelected()){
					if(ss.prodaj(datum,cijena)){
						session.update(ss);
					    session.getTransaction().commit();
						JOptionPane.showMessageDialog(null, "Sredstvo uspjesno prodano i otpisano.");
						dispose();
					}
					else JOptionPane.showMessageDialog(null, "Greska! Pokušajte ponovno.");
				}
			}
		});
		btnUredu.setBounds(193, 159, 89, 23);
		contentPane.add(btnUredu);
		
		JButton btnZai = new JButton("Iza\u0111i");
		btnZai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnZai.setBounds(292, 159, 89, 23);
		contentPane.add(btnZai);
		
		JLabel lblPanjaOvomAkcijom = new JLabel("Pa\u017Enja! Ovom akcijom se stalno sredstvo stavlja van upotrebe.");
		lblPanjaOvomAkcijom.setForeground(Color.RED);
		lblPanjaOvomAkcijom.setBounds(24, 134, 360, 14);
		contentPane.add(lblPanjaOvomAkcijom);
		
		JComboBox comboBox = new JComboBox(SvaSredstvaNeProdano().toArray());
		comboBox.setBounds(209, 30, 141, 20);
		contentPane.add(comboBox);
		kombo = comboBox;
		
		JLabel lblNewLabel = new JLabel("Izaberite stalno sredstvo:");
		lblNewLabel.setBounds(60, 33, 171, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCijenaProdaje = new JLabel("Cijena prodaje:");
		lblCijenaProdaje.setBounds(118, 73, 107, 14);
		contentPane.add(lblCijenaProdaje);
	}
}
