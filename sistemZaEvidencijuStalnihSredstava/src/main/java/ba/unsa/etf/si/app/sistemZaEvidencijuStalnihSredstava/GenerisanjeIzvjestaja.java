package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

import org.hibernate.Session;

import ba.unsa.etf.si.util.HibernateUtil;

public class GenerisanjeIzvjestaja extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Session session;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					GenerisanjeIzvjestaja frame = new GenerisanjeIzvjestaja(sesija);
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
	public GenerisanjeIzvjestaja(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Generisanje izvje\u0161taja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 328, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnIzai = new JButton("Iza\u0111i");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(162, 190, 89, 23);
		contentPane.add(btnIzai);
		
		JLabel lblVrstaIzvjetaja = new JLabel("Vrsta izvje\u0161taja:");
		lblVrstaIzvjetaja.setBounds(37, 31, 106, 14);
		contentPane.add(lblVrstaIzvjetaja);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Nabavljena stalna sredstva");
		buttonGroup.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setBounds(35, 64, 216, 23);
		contentPane.add(chckbxNewCheckBox);
		
		
		final JCheckBox chckbxStalnaSredstvaStavljena = new JCheckBox("Stalna sredstva stavljena u upotrebu");
		buttonGroup.add(chckbxStalnaSredstvaStavljena);
		chckbxStalnaSredstvaStavljena.setBounds(37, 99, 242, 23);
		contentPane.add(chckbxStalnaSredstvaStavljena);
		
		
		
		final JCheckBox chckbxOtpisanaprodanaStalnaSredstva = new JCheckBox("Otpisana/prodana stalna sredstva");
		buttonGroup.add(chckbxOtpisanaprodanaStalnaSredstva);
		chckbxOtpisanaprodanaStalnaSredstva.setBounds(37, 132, 242, 23);
		contentPane.add(chckbxOtpisanaprodanaStalnaSredstva);
		
		JButton btnKreiraj = new JButton("Kreiraj");
		btnKreiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (chckbxNewCheckBox.isSelected()){
					
					NabavljenaSredstva ns= new NabavljenaSredstva(session);
					ns.setVisible(true);
					
				}
				
				else if (chckbxStalnaSredstvaStavljena.isSelected()){
					
					StalnaSredstvaUUpotrebi1 ssuu= new StalnaSredstvaUUpotrebi1 (session);
					ssuu.setVisible(true);
				}
				else if (chckbxOtpisanaprodanaStalnaSredstva.isSelected()){
					
					OtpisanaiProdanaSredstva ops= new OtpisanaiProdanaSredstva(session);
					ops.setVisible(true);
					}
				else
					JOptionPane.showMessageDialog(null,"Izaberite vrstu izvještaja.");
				
			}
		});
		btnKreiraj.setBounds(63, 190, 89, 23);
		contentPane.add(btnKreiraj);
		
		
		
	}
}
