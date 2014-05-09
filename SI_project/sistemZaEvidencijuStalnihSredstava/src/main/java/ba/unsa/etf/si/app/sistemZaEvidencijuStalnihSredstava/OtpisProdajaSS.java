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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class OtpisProdajaSS extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtpisProdajaSS frame = new OtpisProdajaSS();
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
	public OtpisProdajaSS() {
		setTitle("Otpisivanje/prodaja stalnog sredstva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 407, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnOtpisivanjeStalnogSredstva = new JRadioButton("Otpisivanje stalnog sredstva");
		buttonGroup.add(rdbtnOtpisivanjeStalnogSredstva);
		rdbtnOtpisivanjeStalnogSredstva.setBounds(22, 29, 193, 23);
		contentPane.add(rdbtnOtpisivanjeStalnogSredstva);
		
		JRadioButton rdbtnProdajaStalnogSredstva = new JRadioButton("Prodaja stalnog sredstva");
		buttonGroup.add(rdbtnProdajaStalnogSredstva);
		rdbtnProdajaStalnogSredstva.setBounds(25, 69, 182, 23);
		contentPane.add(rdbtnProdajaStalnogSredstva);
		
		textField = new JTextField();
		textField.setBounds(211, 70, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(299, 73, 46, 14);
		contentPane.add(lblKm);
		
		JButton btnUredu = new JButton("Uredu");
		btnUredu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Nije implementirano! \nKlikom na ovo dugme sredstvo �e biti otpisano ili prodano.");
			}
		});
		btnUredu.setBounds(155, 159, 89, 23);
		contentPane.add(btnUredu);
		
		JButton btnZai = new JButton("Iza\u0111i");
		btnZai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnZai.setBounds(254, 159, 89, 23);
		contentPane.add(btnZai);
		
		JLabel lblPanjaOvomAkcijom = new JLabel("Pa\u017Enja! Ovom akcijom se stalno sredstvo stavlja van upotrebe.");
		lblPanjaOvomAkcijom.setForeground(Color.RED);
		lblPanjaOvomAkcijom.setBounds(21, 118, 360, 14);
		contentPane.add(lblPanjaOvomAkcijom);
	}

}
