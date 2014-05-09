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

public class IzmjenaStalnogSredstva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzmjenaStalnogSredstva frame = new IzmjenaStalnogSredstva();
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
	public IzmjenaStalnogSredstva() {
		setTitle("Izmjena stalnog sredstva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 369, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNoviNazivStalnog = new JLabel("Novi naziv stalnog sredstva:");
		lblNoviNazivStalnog.setBounds(37, 41, 160, 14);
		contentPane.add(lblNoviNazivStalnog);
		
		JLabel lblNoviTipStalnog = new JLabel("Novi tip stalnog sredstva:");
		lblNoviTipStalnog.setBounds(47, 66, 153, 14);
		contentPane.add(lblNoviTipStalnog);
		
		JLabel lblNovaLokacijaStalnog = new JLabel("Nova lokacija stalnog sredstva:");
		lblNovaLokacijaStalnog.setBounds(20, 91, 190, 14);
		contentPane.add(lblNovaLokacijaStalnog);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Amortizacija", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(47, 139, 261, 92);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDatumKadaSe = new JLabel("Datum kada se amortizuje:");
		lblDatumKadaSe.setBounds(10, 41, 160, 14);
		panel.add(lblDatumKadaSe);
		
		JRadioButton rdbtnGodinje = new JRadioButton("Godi\u0161nje");
		buttonGroup.add(rdbtnGodinje);
		rdbtnGodinje.setBounds(163, 24, 109, 23);
		panel.add(rdbtnGodinje);
		
		JRadioButton rdbtnMjeseno = new JRadioButton("Mjese\u010Dno");
		buttonGroup.add(rdbtnMjeseno);
		rdbtnMjeseno.setBounds(163, 51, 109, 23);
		panel.add(rdbtnMjeseno);
		
		textField = new JTextField();
		textField.setBounds(207, 38, 113, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(207, 63, 113, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(207, 88, 113, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnUredu = new JButton("Uredu");
		btnUredu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null, "Nije implementirano! \nKlikom na ovo dugme stalno sredstvo �e biti izmijenjeno.");
			}
		});
		btnUredu.setBounds(143, 250, 89, 23);
		contentPane.add(btnUredu);
		
		JButton btnIzai = new JButton("Iza\u0111i");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(242, 250, 89, 23);
		contentPane.add(btnIzai);
	}

}
