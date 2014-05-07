package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodavanjeNovogSS extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeNovogSS frame = new DodavanjeNovogSS();
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
	public DodavanjeNovogSS() {
		setTitle("Dodavanje stalnog sredstva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naziv stalnog sredstva:");
		lblNewLabel.setBounds(46, 30, 131, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTipSredstva = new JLabel("Tip sredstva:");
		lblTipSredstva.setBounds(95, 55, 97, 14);
		contentPane.add(lblTipSredstva);
		
		JLabel lblVrijednostStalnogSredstva = new JLabel("Vrijednost stalnog sredstva:");
		lblVrijednostStalnogSredstva.setBounds(20, 80, 190, 14);
		contentPane.add(lblVrijednostStalnogSredstva);
		
		JLabel lblDatumNabavke = new JLabel("Datum nabavke:");
		lblDatumNabavke.setBounds(75, 102, 102, 14);
		contentPane.add(lblDatumNabavke);
		
		JLabel lblVrijemeNabavke = new JLabel("Vrijeme nabavke:");
		lblVrijemeNabavke.setBounds(75, 127, 117, 14);
		contentPane.add(lblVrijemeNabavke);
		
		JLabel lblLokacija = new JLabel("Lokacija:");
		lblLokacija.setBounds(114, 149, 68, 14);
		contentPane.add(lblLokacija);
		
		textField = new JTextField();
		textField.setBounds(194, 30, 104, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(194, 55, 104, 20);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 80, 104, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(194, 102, 104, 20);
		contentPane.add(dateChooser);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 127, 104, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(194, 152, 104, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JOptionPane.showMessageDialog(null, "Nije implementirano! \nKlikom na ovo dugme bit �e dodano novo stalno sredstvo.");
			}
		});
		btnDodaj.setBounds(114, 200, 89, 23);
		contentPane.add(btnDodaj);
		
		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(213, 200, 89, 23);
		contentPane.add(button_1);
	}
}
