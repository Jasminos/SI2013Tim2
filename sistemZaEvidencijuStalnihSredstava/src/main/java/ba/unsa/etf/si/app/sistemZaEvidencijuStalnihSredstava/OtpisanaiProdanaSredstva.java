package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;

import ba.unsa.etf.si.util.HibernateUtil;

import com.toedter.calendar.JDateChooser;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import org.hibernate.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class OtpisanaiProdanaSredstva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					OtpisanaiProdanaSredstva frame = new OtpisanaiProdanaSredstva(sesija);
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
	public OtpisanaiProdanaSredstva(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Otpisana/prodana stalna sredstva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 543, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("Datum nabavke");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum nabavke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 22, 241, 101);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Gornja granica: ");
		label.setBounds(27, 34, 97, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Donja granica: ");
		label_1.setBounds(27, 65, 97, 14);
		panel.add(label_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(134, 28, 91, 20);
		panel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(134, 59, 91, 20);
		panel.add(dateChooser_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vrijednost sredstva na datum nabavke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(268, 22, 246, 101);
		contentPane.add(panel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(148, 31, 60, 20);
		panel_1.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(148, 56, 60, 20);
		panel_1.add(spinner_1);
		
		JLabel label_2 = new JLabel("Gornja granica: ");
		label_2.setBounds(41, 31, 97, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Donja granica: ");
		label_3.setBounds(41, 59, 97, 14);
		panel_1.add(label_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum stavljanja sredstva u upotrebu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 140, 241, 101);
		contentPane.add(panel_2);
		
		JLabel label_4 = new JLabel("Gornja granica: ");
		label_4.setBounds(20, 33, 97, 14);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Donja granica: ");
		label_5.setBounds(20, 64, 97, 14);
		panel_2.add(label_5);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(127, 58, 91, 20);
		panel_2.add(dateChooser_2);
		
		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setBounds(127, 27, 91, 20);
		panel_2.add(dateChooser_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Stopa amortizacije sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(268, 140, 246, 101);
		contentPane.add(panel_3);
		
		JLabel label_6 = new JLabel("Gornja granica: ");
		label_6.setBounds(31, 32, 97, 14);
		panel_3.add(label_6);
		
		JLabel label_7 = new JLabel("Donja granica: ");
		label_7.setBounds(31, 60, 97, 14);
		panel_3.add(label_7);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(138, 32, 60, 20);
		panel_3.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(138, 57, 60, 20);
		panel_3.add(spinner_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum otpisivanja sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 259, 241, 95);
		contentPane.add(panel_4);
		
		JLabel label_8 = new JLabel("Gornja granica: ");
		label_8.setBounds(20, 33, 97, 14);
		panel_4.add(label_8);
		
		JLabel label_9 = new JLabel("Donja granica: ");
		label_9.setBounds(20, 64, 97, 14);
		panel_4.add(label_9);
		
		JDateChooser dateChooser_4 = new JDateChooser();
		dateChooser_4.setBounds(127, 27, 91, 20);
		panel_4.add(dateChooser_4);
		
		JDateChooser dateChooser_5 = new JDateChooser();
		dateChooser_5.setBounds(127, 58, 91, 20);
		panel_4.add(dateChooser_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dodatno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(268, 259, 241, 95);
		contentPane.add(panel_5);
		
		JLabel label_10 = new JLabel("Lokacija:");
		label_10.setBounds(25, 28, 68, 14);
		panel_5.add(label_10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(113, 22, 91, 20);
		panel_5.add(textField);
		
		JLabel label_12 = new JLabel("Grupa:");
		label_12.setBounds(35, 56, 47, 14);
		panel_5.add(label_12);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(113, 53, 91, 20);
		panel_5.add(comboBox);
		
		JButton button = new JButton("Uredu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	/*try {
					
					Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"C:\\Users\\User\\Desktop\\SI projekat\\Sistem za evidenciju stalnih sredstava\\otpisanaSredstva.pdf");
					
					
				}catch (Exception e1){
					
					
					JOptionPane.showMessageDialog(null, "Error");
				}*/
				
				String path=System.getProperty("user.dir");
				JOptionPane.showMessageDialog(null, path+="\\otpisanaSredstva.pdf");
				try {
					Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + path);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(326, 393, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(425, 393, 89, 23);
		contentPane.add(button_1);
	}

}
