package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class StalnaSredstvaUUpotrebi1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StalnaSredstvaUUpotrebi1 frame = new StalnaSredstvaUUpotrebi1();
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
	public StalnaSredstvaUUpotrebi1() {
		setTitle("Stalna sredstva stavljena u upotrebu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 565, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Datum nabavke");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum nabavke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 22, 241, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblGornjaGranica = new JLabel("Gornja granica: ");
		lblGornjaGranica.setBounds(27, 34, 97, 14);
		panel.add(lblGornjaGranica);
		
		JLabel lblDonjaGranica = new JLabel("Donja granica: ");
		lblDonjaGranica.setBounds(27, 65, 97, 14);
		panel.add(lblDonjaGranica);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(134, 28, 91, 20);
		panel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(134, 59, 91, 20);
		panel.add(dateChooser_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vrijednost stalnog sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(274, 14, 257, 244);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 36, 246, 101);
		panel_3.add(panel_1);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Na datum nabavke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(148, 31, 60, 20);
		panel_1.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(148, 56, 60, 20);
		panel_1.add(spinner_1);
		
		JLabel label = new JLabel("Gornja granica: ");
		label.setBounds(41, 31, 97, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Donja granica: ");
		label_1.setBounds(41, 59, 97, 14);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 138, 246, 99);
		panel_3.add(panel_2);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Trenutna vrijednost ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("Gornja granica: ");
		label_2.setBounds(44, 32, 97, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Donja granica: ");
		label_3.setBounds(44, 60, 97, 14);
		panel_2.add(label_3);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(151, 32, 60, 20);
		panel_2.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(151, 57, 60, 20);
		panel_2.add(spinner_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum stavljanja sredstva u upotrebu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 134, 241, 101);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_4 = new JLabel("Gornja granica: ");
		label_4.setBounds(20, 33, 97, 14);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("Donja granica: ");
		label_5.setBounds(20, 64, 97, 14);
		panel_4.add(label_5);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(127, 58, 91, 20);
		panel_4.add(dateChooser_2);
		
		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setBounds(127, 27, 91, 20);
		panel_4.add(dateChooser_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Stopa amortizacije sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 246, 241, 101);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_6 = new JLabel("Gornja granica: ");
		label_6.setBounds(31, 32, 97, 14);
		panel_5.add(label_6);
		
		JLabel label_7 = new JLabel("Donja granica: ");
		label_7.setBounds(31, 60, 97, 14);
		panel_5.add(label_7);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(138, 32, 60, 20);
		panel_5.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(138, 57, 60, 20);
		panel_5.add(spinner_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum otpisivanja sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(278, 269, 248, 95);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_8 = new JLabel("Gornja granica: ");
		label_8.setBounds(20, 33, 97, 14);
		panel_6.add(label_8);
		
		JLabel label_9 = new JLabel("Donja granica: ");
		label_9.setBounds(20, 64, 97, 14);
		panel_6.add(label_9);
		
		JDateChooser dateChooser_4 = new JDateChooser();
		dateChooser_4.setBounds(127, 27, 91, 20);
		panel_6.add(dateChooser_4);
		
		JDateChooser dateChooser_5 = new JDateChooser();
		dateChooser_5.setBounds(127, 58, 91, 20);
		panel_6.add(dateChooser_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dodatno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(10, 355, 241, 111);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_10 = new JLabel("Lokacija:");
		label_10.setBounds(26, 35, 68, 14);
		panel_7.add(label_10);
		
		textField = new JTextField();
		textField.setBounds(114, 29, 91, 20);
		panel_7.add(textField);
		textField.setColumns(10);
		
		JLabel label_12 = new JLabel("Grupa:");
		label_12.setBounds(36, 63, 47, 14);
		panel_7.add(label_12);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(114, 60, 91, 20);
		panel_7.add(comboBox);
		
		JButton button = new JButton("Uredu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					String path=System.getProperty("user.dir");
					JOptionPane.showMessageDialog(null, path+="\\StalnaSredstvaUUpotrebi.pdf");
					try {
						Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + path);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		button.setBounds(334, 490, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(433, 490, 89, 23);
		contentPane.add(button_1);
	}
}
