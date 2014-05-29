package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import ba.unsa.etf.si.klase.StalnoSredstvo;
import ba.unsa.etf.si.util.HibernateUtil;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;

import org.hibernate.Query;
import org.hibernate.Session;

public class StavljanjeSredstvaUUpotrebu extends JFrame {

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
					StavljanjeSredstvaUUpotrebu frame = new StavljanjeSredstvaUUpotrebu(sesija);
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
	public List<StalnoSredstvo> SvaSredstva(){
		Query query = session.createQuery("from StalnoSredstvo");
		List<StalnoSredstvo> results = (List<StalnoSredstvo>) query.list();
		return results;
	}
	public StavljanjeSredstvaUUpotrebu(Session sesija) {
		session = sesija;
		setTitle("Stavljanje stalnog sredstva u upotrebu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 404, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzaberiteStalnoSredstvo = new JLabel("Izaberite stalno sredstvo:");
		lblIzaberiteStalnoSredstvo.setBounds(75, 26, 148, 14);
		contentPane.add(lblIzaberiteStalnoSredstvo);
		
		JComboBox comboBox = new JComboBox(SvaSredstva().toArray());
		comboBox.setBounds(243, 26, 109, 20);
		contentPane.add(comboBox);
		kombo = comboBox;
		
		JLabel lblDatumStavljanjaSredstva = new JLabel("Datum stavljanja sredstva u upotrebu:");
		lblDatumStavljanjaSredstva.setBounds(11, 61, 222, 14);
		contentPane.add(lblDatumStavljanjaSredstva);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(243, 58, 109, 20);
		contentPane.add(dateChooser);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Amortizacija", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(37, 98, 301, 112);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStopaAmortizacije = new JLabel("Stopa amortizacije:");
		lblStopaAmortizacije.setBounds(37, 31, 109, 14);
		panel.add(lblStopaAmortizacije);
		
		textField = new JTextField();
		textField.setBounds(156, 28, 99, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNaKrajuMjeseca = new JRadioButton("Na kraju mjeseca");
		buttonGroup.add(rdbtnNaKrajuMjeseca);
		rdbtnNaKrajuMjeseca.setBounds(15, 68, 140, 23);
		panel.add(rdbtnNaKrajuMjeseca);
		
		JRadioButton rdbtnNaKrajuGodine = new JRadioButton("Na kraju godine");
		buttonGroup.add(rdbtnNaKrajuGodine);
		rdbtnNaKrajuGodine.setBounds(157, 68, 138, 23);
		panel.add(rdbtnNaKrajuGodine);
		radio1 = rdbtnNaKrajuMjeseca;
		radio2 = rdbtnNaKrajuGodine;
		
		JButton btnStaviUUpotrebu = new JButton("Stavi u upotrebu");
		btnStaviUUpotrebu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				session.getTransaction().begin();	
				StalnoSredstvo ss = (StalnoSredstvo)kombo.getSelectedItem();
				Date datumStavljanja = new Date();
				Double stopa = Double.parseDouble(textField.getText());
				boolean amortGod;
			    if(radio2.isSelected())
				 amortGod = true;
			    else amortGod = false;
			    ss.staviUUpotrebu(stopa, datumStavljanja, amortGod);
			    session.update(ss);
			    session.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "Sredstvo stavljeno u upotrebu.");
				dispose();
			}
		});
		btnStaviUUpotrebu.setBounds(138, 233, 131, 23);
		contentPane.add(btnStaviUUpotrebu);
		
		JButton btnIzai = new JButton("Iza\u0111i");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(277, 233, 89, 23);
		contentPane.add(btnIzai);
	}
}
