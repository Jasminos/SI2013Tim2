package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle(" \u03BCDEVELOPERS Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 347, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		lblKorisnikoIme.setBounds(45, 47, 93, 14);
		contentPane.add(lblKorisnikoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setBounds(75, 72, 56, 14);
		contentPane.add(lblLozinka);
		
		textField = new JTextField();
		textField.setDropMode(DropMode.INSERT);
		textField.setToolTipText("");
		textField.setBounds(141, 44, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 69, 133, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBounds(186, 110, 89, 23);
		contentPane.add(btnPotvrdi);
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = textField.getText();
				String pass = textField_1.getText();
			
				if (user.equals("admin") && pass.equals("admin")){
					adminMenu am= new adminMenu();
					am.setVisible(true);
					
				}else if (user.equals("racunovodja") && pass.equals("racunovodja")){
					
					PocetniEkranRacunovodja per= new PocetniEkranRacunovodja ();
					per.setVisible(true);
				}else {
					
					JOptionPane.showMessageDialog(null, "Unesite korisni�ko ime i lozinku!");
				}
				
				dispose();
			}
		});
		
	}

}
