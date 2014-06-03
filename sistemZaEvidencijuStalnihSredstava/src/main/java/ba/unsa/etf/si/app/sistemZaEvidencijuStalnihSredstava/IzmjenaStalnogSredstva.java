package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;

import org.hibernate.Query;
import org.hibernate.Session;

import ba.unsa.etf.si.klase.StalnoSredstvo;
import ba.unsa.etf.si.klase.TipStalnogSredstva;
import ba.unsa.etf.si.util.HibernateUtil;

import javax.swing.JComboBox;

import java.awt.Color;
import java.util.List;

public class IzmjenaStalnogSredstva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textNaziv;
	private JTextField textLokacija;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Session session;
	private JComboBox komboTipovi;
	private JComboBox komboSredstva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory()
							.openSession();
					IzmjenaStalnogSredstva frame = new IzmjenaStalnogSredstva(
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
	public List<TipStalnogSredstva> SviTipovi(){
		Query query = session.createQuery("from TipStalnogSredstva");
		List<TipStalnogSredstva> results = (List<TipStalnogSredstva>) query.list();
		return results;
	}
	public List<StalnoSredstvo> SvaSredstva(){
		Query query = session.createQuery("from StalnoSredstvo where UUPOTREBI = false");
		List<StalnoSredstvo> results = (List<StalnoSredstvo>) query.list();
		return results;
	}
	private void popuni(){
		if (komboSredstva.getSelectedItem()!=null) {
			textNaziv
					.setText(((StalnoSredstvo) komboSredstva.getSelectedItem())
							.getNaziv());
			textLokacija.setText(((StalnoSredstvo) komboSredstva
					.getSelectedItem()).getLokacija());
		}
	}
	public IzmjenaStalnogSredstva(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Izmjena stalnog sredstva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNoviNazivStalnog = new JLabel("Novi naziv stalnog sredstva:");
		lblNoviNazivStalnog.setBounds(43, 75, 172, 14);
		contentPane.add(lblNoviNazivStalnog);

		JLabel lblNoviTipStalnog = new JLabel("Novi tip stalnog sredstva:");
		lblNoviTipStalnog.setBounds(56, 100, 153, 14);
		contentPane.add(lblNoviTipStalnog);

		JLabel lblNovaLokacijaStalnog = new JLabel(
				"Nova lokacija stalnog sredstva:");
		lblNovaLokacijaStalnog.setBounds(28, 125, 179, 14);
		contentPane.add(lblNovaLokacijaStalnog);

		textField = new JTextField();
		textField.setBounds(207, 72, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textNaziv = textField;

		textField_2 = new JTextField();
		textField_2.setBounds(207, 122, 134, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textLokacija = textField_2;

		JButton btnUredu = new JButton("Izmijeni");
		btnUredu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					StalnoSredstvo ss = (StalnoSredstvo)komboSredstva.getSelectedItem();
					TipStalnogSredstva tip = (TipStalnogSredstva)komboTipovi.getSelectedItem();
					
						session.getTransaction().begin();
						ss.setTip(tip);
						ss.setNaziv(textNaziv.getText());
						ss.setLokacija(textLokacija.getText());
						session.update(ss);
						session.getTransaction().commit();
						JOptionPane.showMessageDialog(null, "Sredstvo uspješno izmijenjeno.");
						dispose();
					}
		});
		btnUredu.setBounds(153, 165, 89, 23);
		contentPane.add(btnUredu);

		JButton btnIzai = new JButton("Iza\u0111i");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(252, 165, 89, 23);
		contentPane.add(btnIzai);
		
		JComboBox comboBox = new JComboBox(SviTipovi().toArray());
		comboBox.setBounds(207, 97, 134, 20);
		contentPane.add(comboBox);
		komboTipovi = comboBox;
		
		JLabel lblNewLabel = new JLabel("Može se mijenjati samo sredstvo koje nije u upotrebi!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 11, 321, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIzaberiteStalnoSredstvo = new JLabel("Izaberite stalno sredstvo:");
		lblIzaberiteStalnoSredstvo.setBounds(56, 52, 153, 14);
		contentPane.add(lblIzaberiteStalnoSredstvo);
		
		JComboBox comboBox_1 = new JComboBox(SvaSredstva().toArray());
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				popuni();
			}
		});
		comboBox_1.setBounds(207, 49, 134, 20);
		contentPane.add(comboBox_1);
		komboSredstva = comboBox_1;
		popuni();
	}

}
