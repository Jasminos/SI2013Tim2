package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPodaci extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPodaci frame = new LoginPodaci();
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
	public LoginPodaci() {
		setTitle("Login podaci");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login podaci za ra\u010Dunovo\u0111u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(27, 143, 224, 108);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Lozinka: ");
		label.setBounds(60, 64, 99, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Korisni\u010Dko ime: ");
		label_1.setBounds(27, 39, 132, 14);
		panel.add(label_1);
		label_1.setForeground(Color.BLACK);
		
		JLabel lblRacunovodja = new JLabel("racunovodja");
		lblRacunovodja.setBounds(121, 39, 81, 14);
		panel.add(lblRacunovodja);
		lblRacunovodja.setForeground(Color.RED);
		
		JLabel lblRacunovodja_1 = new JLabel("racunovodja");
		lblRacunovodja_1.setBounds(121, 64, 81, 14);
		panel.add(lblRacunovodja_1);
		lblRacunovodja_1.setForeground(Color.RED);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login podaci za administratora", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(31, 23, 221, 102);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAdmin_1 = new JLabel("admin");
		lblAdmin_1.setBounds(119, 62, 80, 14);
		panel_1.add(lblAdmin_1);
		lblAdmin_1.setForeground(Color.RED);
		
		JLabel lblAdmin = new JLabel("admin");
		lblAdmin.setBounds(119, 37, 80, 14);
		panel_1.add(lblAdmin);
		lblAdmin.setForeground(Color.RED);
		
		JLabel label_4 = new JLabel("Korisni\u010Dko ime: ");
		label_4.setBounds(30, 37, 132, 14);
		panel_1.add(label_4);
		label_4.setForeground(Color.BLACK);
		
		JLabel label_5 = new JLabel("Lozinka: ");
		label_5.setBounds(63, 62, 99, 14);
		panel_1.add(label_5);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l= new Login();
				l.setVisible(true);
			}
		});
		btnOk.setBounds(90, 270, 89, 23);
		contentPane.add(btnOk);
	}

}
