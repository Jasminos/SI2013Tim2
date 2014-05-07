package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class NabavljenaSredstva extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NabavljenaSredstva frame = new NabavljenaSredstva();
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
	public NabavljenaSredstva() {
		setTitle("Nabavljena stalna sredstva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 522, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUredu = new JButton("Uredu");
		btnUredu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
					String path=System.getProperty("user.dir");
					JOptionPane.showMessageDialog(null, path+="\\nabavljenaStalnaSredstva.pdf");
					try {
						Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + path);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
			}
		});
		btnUredu.setBounds(308, 252, 89, 23);
		contentPane.add(btnUredu);
		
		JButton btnIzai = new JButton("Iza\u0111i");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(407, 252, 89, 23);
		contentPane.add(btnIzai);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("Datum nabavke");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum nabavke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 21, 241, 101);
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
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vrijednost nabavljenog sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 133, 246, 99);
		contentPane.add(panel_1);
		
		JLabel label_2 = new JLabel("Gornja granica: ");
		label_2.setBounds(44, 32, 97, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Donja granica: ");
		label_3.setBounds(44, 60, 97, 14);
		panel_1.add(label_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(151, 32, 60, 20);
		panel_1.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(151, 57, 60, 20);
		panel_1.add(spinner_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dodatno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(261, 21, 241, 101);
		contentPane.add(panel_2);
		
		JLabel label_4 = new JLabel("Lokacija:");
		label_4.setBounds(26, 35, 68, 14);
		panel_2.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(114, 29, 91, 20);
		panel_2.add(textField);
		
		JLabel label_5 = new JLabel("Grupa:");
		label_5.setBounds(36, 63, 47, 14);
		panel_2.add(label_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(114, 60, 91, 20);
		panel_2.add(comboBox);
	}
}
